import java.util.LinkedList;
import java.util.Queue;

public class tiket {

    public static void main(String[] args) {
        // Membuat antrean menggunakan LinkedList
        // Antrean ini digunakan untuk menyimpan nama-nama pembeli tiket
        Queue<String> ticketQueue = new LinkedList<>();

        // Menambahkan orang-orang ke dalam antrean
        ticketQueue.add("Ali");   // Ali masuk antrean
        ticketQueue.add("Budi");  // Budi masuk antrean
        ticketQueue.add("Citra"); // Citra masuk antrean

        // Menampilkan antrean saat ini
        System.out.println("Antrean saat ini: " + ticketQueue);

        // Melayani pembeli tiket satu per satu
        while (!ticketQueue.isEmpty()) { // Selama antrean tidak kosong
            // Mengambil dan menghapus elemen pertama dalam antrean
            String currentCustomer = ticketQueue.poll();
            // Menampilkan siapa yang sedang membeli tiket
            System.out.println(currentCustomer + " sedang membeli tiket.");
            // Menampilkan sisa antrean setelah satu orang dilayani
            System.out.println("Antrean tersisa: " + ticketQueue);
        }

        // Semua orang dalam antrean telah dilayani
        System.out.println("Semua orang telah membeli tiket.");
    }
}
