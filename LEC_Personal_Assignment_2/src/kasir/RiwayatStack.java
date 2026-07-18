package kasir;

/**
 * RiwayatStack mengimplementasikan struktur data Stack (LIFO)
 * untuk menyimpan riwayat transaksi pelanggan yang sudah dilayani.
 * Transaksi terbaru berada paling atas (ditampilkan pertama).
 */
public class RiwayatStack {
    private NodePelanggan top;
    private int jumlahTransaksi;

    public RiwayatStack() {
        this.top = null;
        this.jumlahTransaksi = 0;
    }

    // Menyimpan data transaksi pelanggan yang baru selesai dilayani (push)
    public void push(NodePelanggan pelanggan) {
        pelanggan.next = top;
        top = pelanggan;
        jumlahTransaksi++;
        System.out.println("Transaksi disimpan ke riwayat.");
    }

    // Menampilkan riwayat transaksi dari yang terbaru ke yang paling lama
    public void tampilkanRiwayat() {
        if (top == null) {
            System.out.println("Belum ada riwayat transaksi.");
            return;
        }

        System.out.println("Riwayat Transaksi (terbaru ke lama):");
        NodePelanggan current = top;
        while (current != null) {
            System.out.println("No: " + current.nomorAntrian +
                    " | Nama: " + current.namaPelanggan +
                    " | Total: Rp" + current.totalBelanja);
            current = current.next;
        }
        System.out.println("Total Transaksi: " + jumlahTransaksi);
    }
}
