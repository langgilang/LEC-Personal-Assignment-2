package kasir;

import java.util.Scanner;

public class MainKasir {
    public static void main(String[] args) {
        AntrianQueue antrian = new AntrianQueue();
        RiwayatStack riwayat = new RiwayatStack();
        Scanner scanner = new Scanner(System.in);
        int pilihan;

        do {
            System.out.println("\n=== SISTEM KASIR TOKO ===");
            System.out.println("1. Tambah Antrian");
            System.out.println("2. Layani Pelanggan");
            System.out.println("3. Tampilkan Antrian");
            System.out.println("4. Lihat Riwayat Transaksi");
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
                    System.out.print("Masukkan Nomor Antrian: ");
                    String noAntrian = scanner.nextLine();
                    System.out.print("Masukkan Nama Pelanggan: ");
                    String nama = scanner.nextLine();
                    System.out.print("Masukkan Total Belanja: ");
                    double total = Double.parseDouble(scanner.nextLine());
                    antrian.enqueue(noAntrian, nama, total);
                    break;

                case 2:
                    NodePelanggan dilayani = antrian.dequeue();
                    if (dilayani != null) {
                        System.out.println("Melayani pelanggan " + dilayani.nomorAntrian +
                                " (" + dilayani.namaPelanggan + ")");
                        riwayat.push(dilayani);
                    }
                    break;

                case 3:
                    antrian.tampilkanAntrian();
                    break;

                case 4:
                    riwayat.tampilkanRiwayat();
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
