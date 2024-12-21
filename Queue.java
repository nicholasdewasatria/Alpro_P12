public class Queue {
    private int[] queue; // Array untuk antrean yang akan menyimpan elemen-elemen antrean
    private int front = 0, rear = -1, size = 0, capacity; // Variabel untuk indeks depan, belakang, ukuran antrean, dan kapasitas antrean

    // Konstruktor untuk membuat antrean dengan kapasitas tertentu
    public Queue(int capacity) {
        this.capacity = capacity; // Menyimpan kapasitas antrean
        queue = new int[capacity]; // Menginisialisasi array dengan kapasitas yang ditentukan
    }

    // Metode untuk menambahkan elemen ke akhir antrean
    public void enqueue(int item) {
        // Jika antrean sudah penuh, tampilkan pesan dan hentikan eksekusi
        if (size == capacity) {
            System.out.println("Queue full! Cannot add " + item);
            return;
        }

        // Pindahkan indeks belakang (rear) ke posisi berikutnya dengan modulus kapasitas (circular queue)
        rear = (rear + 1) % capacity; 
        queue[rear] = item; // Menambahkan elemen ke posisi rear
        size++; // Tambahkan ukuran antrean
        System.out.println("Added: " + item); // Menampilkan elemen yang berhasil ditambahkan
    }

    // Metode untuk menghapus elemen dari depan antrean
    public void dequeue() {
        // Jika antrean kosong, tampilkan pesan dan hentikan eksekusi
        if (size == 0) {
            System.out.println("Queue empty! Cannot remove.");
            return;
        }

        // Tampilkan elemen yang dihapus dan pindahkan indeks depan (front) ke posisi berikutnya
        System.out.println("Removed: " + queue[front]);
        front = (front + 1) % capacity; // Circular queue: Jika mencapai kapasitas, kembali ke posisi awal
        size--; // Kurangi ukuran antrean
    }

    // Metode untuk mengecek apakah antrean sudah penuh
    public boolean isFull() {
        return size == capacity; // Mengembalikan true jika ukuran antrean sama dengan kapasitas
    }

    // Metode untuk mengecek apakah antrean kosong
    public boolean isEmpty() {
        return size == 0; // Mengembalikan true jika ukuran antrean adalah 0
    }

    // Metode utama untuk menjalankan contoh antrean
    public static void main(String[] args) {
        Queue queue = new Queue(3); // Membuat antrean dengan kapasitas 3

        queue.enqueue(10); // Menambahkan elemen 10
        queue.enqueue(20); // Menambahkan elemen 20
        queue.enqueue(30); // Menambahkan elemen 30
        queue.enqueue(40); // Mencoba menambahkan elemen 40, tetapi antrean penuh

        queue.dequeue(); // Menghapus elemen pertama (10)
        queue.enqueue(50); // Menambahkan elemen 50
        queue.dequeue(); // Menghapus elemen pertama (20)
        queue.dequeue(); // Menghapus elemen pertama (30)
        queue.dequeue(); // Mencoba menghapus elemen dari antrean yang sudah kosong
    }
}
