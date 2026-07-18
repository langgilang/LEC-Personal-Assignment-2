package kasir;

/**
 * AntrianQueue mengimplementasikan struktur data Queue (FIFO)
 * untuk mengelola antrian pelanggan di kasir toko.
 * Menggunakan linked node, dengan front sebagai pelanggan yang dilayani
 * lebih dulu dan rear sebagai pelanggan yang baru masuk antrian.
 */
public class AntrianQueue {
    private NodePelanggan front;
    private NodePelanggan rear;
    private int jumlahAntrian;
    private static final int MAKS_DATA = 5;

    public AntrianQueue() {
        this.front = null;
        this.rear = null;
        this.jumlahAntrian = 0;
    }

    // Menambahkan pelanggan baru ke akhir antrian
    public boolean enqueue(String nomorAntrian, String namaPelanggan, double totalBelanja) {
        if (jumlahAntrian >= MAKS_DATA) {
            System.out.println("Antrian penuh! Maksimal " + MAKS_DATA + " pelanggan.");
            return false;
        }

        NodePelanggan baru = new NodePelanggan(nomorAntrian, namaPelanggan, totalBelanja);
        if (rear == null) {
            front = baru;
            rear = baru;
        } else {
            rear.next = baru;
            rear = baru;
        }
        jumlahAntrian++;
        System.out.println("Data pelanggan ditambahkan ke antrian!");
        return true;
    }

    // Mengeluarkan pelanggan paling depan dari antrian untuk dilayani
    public NodePelanggan dequeue() {
        if (front == null) {
            System.out.println("Antrian kosong, tidak ada pelanggan untuk dilayani.");
            return null;
        }

        NodePelanggan dilayani = front;
        front = front.next;
        if (front == null) {
            rear = null;
        }
        jumlahAntrian--;
        return dilayani;
    }

    // Menampilkan seluruh antrian saat ini
    public void tampilkanAntrian() {
        if (front == null) {
            System.out.println("Antrian kosong.");
            return;
        }

        System.out.println("Antrian Pelanggan Saat Ini:");
        NodePelanggan current = front;
        while (current != null) {
            System.out.println("No: " + current.nomorAntrian +
                    " | Nama: " + current.namaPelanggan +
                    " | Total: Rp" + current.totalBelanja);
            current = current.next;
        }
    }

    public boolean isEmpty() {
        return front == null;
    }
}
