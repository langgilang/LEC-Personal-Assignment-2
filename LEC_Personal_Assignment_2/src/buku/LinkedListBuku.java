package buku;

public class LinkedListBuku {
    private Node head;
    private int jumlahBuku;

    public LinkedListBuku() {
        this.head = null;
        this.jumlahBuku = 0;
    }

    // Menambahkan buku baru di akhir daftar (push)
    public boolean tambahBuku(String kodeBuku, String judul, String penulis) {
        // Validasi: kodeBuku maksimal 5 karakter
        if (kodeBuku.length() > 5) {
            System.out.println("Gagal! Kode Buku maksimal 5 karakter.");
            return false;
        }

        Node baru = new Node(kodeBuku, judul, penulis);

        if (head == null) {
            head = baru;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = baru;
        }
        jumlahBuku++;
        System.out.println("Data berhasil ditambahkan!");
        return true;
    }

    // Menghapus data buku terakhir dari daftar (pop)
    public void hapusBuku() {
        if (head == null) {
            System.out.println("Tidak ada data untuk dihapus.");
            return;
        }

        if (head.next == null) {
            // Hanya ada satu node
            System.out.println("Buku '" + head.judul + "' berhasil dihapus.");
            head = null;
        } else {
            Node current = head;
            while (current.next.next != null) {
                current = current.next;
            }
            System.out.println("Buku '" + current.next.judul + "' berhasil dihapus.");
            current.next = null;
        }
        jumlahBuku--;
    }

    // Mencari buku berdasarkan kodeBuku
    public void cariBuku(String kodeBuku) {
        Node current = head;
        while (current != null) {
            if (current.kodeBuku.equalsIgnoreCase(kodeBuku)) {
                System.out.println("Buku ditemukan!");
                System.out.println("Kode: " + current.kodeBuku +
                        " | Judul: " + current.judul +
                        " | Penulis: " + current.penulis);
                return;
            }
            current = current.next;
        }
        System.out.println("Buku tidak ditemukan.");
    }

    // Menampilkan seluruh data buku sesuai urutan input
    public void tampilkanSemuaBuku() {
        if (head == null) {
            System.out.println("Belum ada data buku.");
            return;
        }

        System.out.println("Daftar Buku:");
        Node current = head;
        while (current != null) {
            System.out.println("Kode: " + current.kodeBuku +
                    " | Judul: " + current.judul +
                    " | Penulis: " + current.penulis);
            current = current.next;
        }
        System.out.println("Total Buku: " + jumlahBuku);
    }

    public int getJumlahBuku() {
        return jumlahBuku;
    }
}
