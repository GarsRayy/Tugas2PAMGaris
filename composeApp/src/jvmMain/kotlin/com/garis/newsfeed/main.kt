package com.garis.newsfeed

import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*

data class Berita(
    val id: Int,
    val judul: String,
    val kategori: String,
    val ringkasan: String
)

class PengelolaBerita {
    private val _jumlahDibaca = MutableStateFlow(0)
    val jumlahDibaca: StateFlow<Int> = _jumlahDibaca.asStateFlow()

    fun tambahHitungan() {
        _jumlahDibaca.value += 1
    }
}

fun sumberBerita(): Flow<Berita> = flow {
    var penghitung = 1
    val daftarKategori = listOf("Teknologi", "Olahraga", "Politik")

    while (true) {
        delay(2000)

        if (penghitung == 10) {
            throw RuntimeException("Koneksi Server Terputus!")
        }

        val kategoriAcak = daftarKategori.random()
        val dataBerita = Berita(
            id = penghitung,
            judul = "Isu $kategoriAcak Terkini #$penghitung",
            kategori = kategoriAcak,
            ringkasan = "Ringkasan informasi $kategoriAcak..."
        )

        emit(dataBerita)
        penghitung++
    }
}

suspend fun ambilDetail(id: Int): String {
    delay(1000)
    return "Detail lengkap untuk berita #$id..."
}

fun main() = runBlocking {
    val pengelola = PengelolaBerita()

    println("=== SIMULASI NEWS FEED ===")
    println("Menunggu berita kategori Teknologi...")

    launch {
        pengelola.jumlahDibaca.collect { total ->
            if (total > 0) {
                println(">>> Total Berita Teknologi Dibaca: $total")
            }
        }
    }

    val jobBerita = launch {
        sumberBerita()
            .filter { it.kategori == "Teknologi" }
            .map {
                "[${it.kategori.uppercase()}] ${it.judul}" to it.id
            }

            .catch { e ->
                println("\n TERJADI ERROR: ${e.message}")
                println("   Mengaktifkan mode offline...")
                emit("[OFFLINE] Berita Darurat" to 0)
            }

            .collect { (judulFormat, id) ->
                println("\nDITEMUKAN: $judulFormat")

                if (id != 0) {
                    print("   Mengambil detail...")
                    val detail = ambilDetail(id)
                    println(" SELESAI!")
                    println("   $detail")
                    pengelola.tambahHitungan()
                } else {
                    println("   Silakan cek koneksi internet anda.")
                }
            }
    }

    delay(25000)
    println("\n=== WAKTU HABIS, STOP SIMULASI ===")
    jobBerita.cancel()
}