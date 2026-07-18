package kasir;

/**
 * NodePelanggan menyimpan data satu pelanggan (kode, nama, total belanja)
 * dan digunakan baik oleh struktur Queue (antrian) maupun Stack (riwayat).
 */
public class NodePelanggan {
    String nomorAntrian;
    String namaPelanggan;
    double totalBelanja;
    NodePelanggan next;

    public NodePelanggan(String nomorAntrian, String namaPelanggan, double totalBelanja) {
        this.nomorAntrian = nomorAntrian;
        this.namaPelanggan = namaPelanggan;
        this.totalBelanja = totalBelanja;
        this.next = null;
    }
}
