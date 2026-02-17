# Tugas 2: News Feed Simulator (Kotlin Multiplatform)

**Identitas Mahasiswa:**
* **Nama:** Garis Rayya Rabbani
* **NIM:** 123140018
* **Program Studi:** Teknik Informatika ITERA
* **Mata Kuliah:** Pengembangan Aplikasi Mobile RB

---

## 📝 Deskripsi Tugas
Aplikasi simulasi "News Feed" berbasis CLI (Command Line Interface) yang dibangun menggunakan **Kotlin Multiplatform**. Proyek ini mendemonstrasikan penerapan konsep *Asynchronous Programming* menggunakan Coroutines dan Flow.

## ✨ Fitur Utama
Aplikasi ini memenuhi seluruh kriteria penilaian tugas:
1.  **News Ticker (Flow):** Mengenerate berita simulasi secara otomatis setiap 2 detik.
2.  **Filter Kategori:** Hanya menampilkan berita kategori **Teknologi** (Filter Operator).
3.  **Transformasi Data:** Memformat judul berita agar lebih rapi (Map Operator).
4.  **Real-time Counter (StateFlow):** Menghitung jumlah berita yang sudah dibaca secara reaktif.
5.  **Simulasi Network (Coroutines):** Menggunakan `suspend function` untuk mensimulasikan *delay* saat mengambil detail berita.

## 🌟 Fitur Bonus (Error Handling)
* **Resilience System:** Menggunakan operator `.catch` untuk menangkap simulasi *server crash* pada berita ke-10.
* **Offline Mode:** Program tidak *force close*, melainkan otomatis beralih ke mode offline dan memberikan pesan peringatan yang ramah pengguna.

---

## 🚀 Cara Menjalankan (How to Run)

### Prasyarat
* JDK 17 atau lebih baru.
* Android Studio / IntelliJ IDEA (Recomended).

### Langkah-langkah
1.  **Clone Repository ini:**
    ```bash
    git clone [https://github.com/USERNAME_KAMU/Tugas2-NewsFeed-Garis.git](https://github.com/USERNAME_KAMU/Tugas2-NewsFeed-Garis.git)
    ```
2.  **Buka di Android Studio:**
    * Pilih menu **Open**, lalu arahkan ke folder hasil clone.
    * Tunggu proses *Gradle Sync* selesai.

3.  **Jalankan via IDE (Paling Mudah):**
    * Buka file: `composeApp/src/jvmMain/kotlin/Main.kt` (atau `NewsFeedSimulator.kt`).
    * Cari tanda **Panah Hijau (▶)** di samping fungsi `main()`.
    * Klik **Run 'MainKt'**.

4.  **Jalankan via Terminal:**
    Alternatif menggunakan terminal di dalam folder proyek:
    ```bash
    ./gradlew :composeApp:run
    ```

---

## 📸 Screenshot Output
Berikut adalah bukti program berjalan dengan fitur Bonus Error Handling:<br>
<img width="478" height="526" alt="Cuplikan layar 2026-02-17 113431" src="https://github.com/user-attachments/assets/e05abe8b-8f21-479c-8516-fe56e6f3dfe4" />
