public class QueueImpl {
    private int capacity; // Kapasitas maksimum antrean
    int queueArr[]; // Array untuk menyimpan elemen antrean
    int front = 0; // Indeks elemen pertama dalam antrean
    int rear = -1; // Indeks elemen terakhir dalam antrean
    int currentSize = 0; // Jumlah elemen saat ini dalam antrean

    // Konstruktor untuk membuat antrean dengan ukuran tertentu
    public QueueImpl(int queueSize) {
        this.capacity = queueSize; // Menyimpan kapasitas antrean
        queueArr = new int[this.capacity]; // Inisialisasi array untuk antrean
    }

    /**
     * Metode untuk menambahkan elemen di akhir antrean
     * @param item Elemen yang akan ditambahkan ke antrean
     */
    public void enqueue(int item) {
        if (isQueueFull()) { // Periksa apakah antrean penuh
            System.out.println("Overflow! Unable to add element: " + item); // Pesan jika penuh
        } else {
            rear++; // Pindahkan indeks `rear` ke posisi berikutnya
            if (rear == capacity) { // Jika mencapai akhir array, kembali ke awal (circular queue)
                rear = 0;
            }
            queueArr[rear] = item; // Tambahkan elemen ke posisi `rear`
            currentSize++; // Tambahkan ukuran antrean
            System.out.println("Element " + item + " is pushed to Queue!"); // Konfirmasi elemen ditambahkan
        }
    }

    /**
     * Metode untuk menghapus elemen dari awal antrean
     */
    public void dequeue() {
        if (isQueueEmpty()) { // Periksa apakah antrean kosong
            System.out.println("Underflow! Unable to remove element from Queue"); // Pesan jika kosong
        } else {
            System.out.println("Pop operation done! Removed: " + queueArr[front]); // Elemen yang dihapus
            front++; // Pindahkan indeks `front` ke posisi berikutnya
            if (front == capacity) { // Jika mencapai akhir array, kembali ke awal (circular queue)
                front = 0;
            }
            currentSize--; // Kurangi ukuran antrean
        }
    }

    /**
     * Metode untuk memeriksa apakah antrean penuh
     * @return boolean True jika penuh, False jika tidak
     */
    public boolean isQueueFull() {
        return currentSize == capacity; // Return true jika ukuran antrean sama dengan kapasitas
    }

    /**
     * Metode untuk memeriksa apakah antrean kosong
     * @return boolean True jika kosong, False jika tidak
     */
    public boolean isQueueEmpty() {
        return currentSize == 0; // Return true jika ukuran antrean adalah 0
    }

    public static void main(String a[]) {
        QueueImpl queue = new QueueImpl(4); // Membuat antrean dengan kapasitas 4

        queue.enqueue(4); // Tambahkan elemen 4
        queue.dequeue(); // Hapus elemen pertama
        queue.enqueue(56); // Tambahkan elemen 56
        queue.enqueue(2); // Tambahkan elemen 2
        queue.enqueue(67); // Tambahkan elemen 67
        queue.dequeue(); // Hapus elemen pertama
        queue.dequeue(); // Hapus elemen pertama
        queue.enqueue(24); // Tambahkan elemen 24
        queue.dequeue(); // Hapus elemen pertama
        queue.enqueue(98); // Tambahkan elemen 98
        queue.enqueue(45); // Tambahkan elemen 45
        queue.enqueue(23); // Tambahkan elemen 23
        queue.enqueue(435); // Coba tambahkan elemen 435 (antrean penuh)
    }
}
