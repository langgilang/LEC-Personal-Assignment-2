package buku;

import java.util.Scanner;

public class MainBuku {
    public static void main(String[] args) {
        LinkedListBuku daftarBuku = new LinkedListBuku();
        Scanner scanner = new Scanner(System.in);
        int pilihan;

        do {
            System.out.println("\n===== SISTEM DATA BUKU =====");
            System.out.println("1. Tambah Buku");
            System.out.println("2. Hapus Buku");
            System.out.println("3. Cari Buku");
            System.out.println("4. Lihat Semua Buku");
            System.out.println("5. Keluar");
            System.out.print("Pilih menu: ");

            while (!scanner.hasNextInt()) {
                System.out.print("Input tidak valid, masukkan angka menu: ");
                scanner.next();
            }
            pilihan = scanner.nextInt();
            scanner.nextLine(); // buang newline

            switch (pilihan) {
                case 1:
                    System.out.print("Masukkan Kode Buku: ");
                    String kode = scanner.nextLine();
                    System.out.print("Masukkan Judul: ");
                    String judul = scanner.nextLine();
                    System.out.print("Masukkan Penulis: ");
                    String penulis = scanner.nextLine();
                    daftarBuku.tambahBuku(kode, judul, penulis);
                    break;

                case 2:
                    daftarBuku.hapusBuku();
                    break;

                case 3:
                    System.out.print("Masukkan Kode Buku: ");
                    String cariKode = scanner.nextLine();
                    daftarBuku.cariBuku(cariKode);
                    break;

                case 4:
                    daftarBuku.tampilkanSemuaBuku();
                    break;

                case 5:
                    System.out.println("Keluar dari program. Sampai jumpa!");
                    break;

                default:
                    System.out.println("Menu tidak valid, silakan coba lagi.");
            }
        } while (pilihan != 5);

        scanner.close();
    }
}
