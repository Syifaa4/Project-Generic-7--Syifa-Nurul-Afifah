package main;

import service.ParkirService;
import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        ParkirService parkir = new ParkirService();

        int pilih;

        do {
            System.out.println("\n===== SISTEM PARKIR =====");
            System.out.println("1. Ambil Tiket (Masuk)");
            System.out.println("2. Bayar & Keluar");
            System.out.println("3. Lihat Ringkasan (Admin)");
            System.out.println("0. Keluar Program");
            System.out.print("Pilih: ");

            while (!input.hasNextInt()) {
                System.out.print("Masukkan angka! Pilih: ");
                input.next();
            }
            pilih = input.nextInt();

            switch (pilih) {

                case 1:
                    input.nextLine(); // clear buffer

                    System.out.print("Plat Nomor (kosongkan jika tidak ada): ");
                    String plat = input.nextLine();

                    // handling no-plat
                    if (plat.isEmpty()) {
                        plat = "NO-PLAT";
                    }

                    System.out.print("Jenis (1 = Mobil | 2 = Motor): ");
                    int jenis = input.nextInt();

                    // validasi jenis
                    while (jenis != 1 && jenis != 2) {
                        System.out.print("Pilih 1 atau 2: ");
                        jenis = input.nextInt();
                    }

                    parkir.kendaraanMasuk(plat, jenis);
                    break;

                case 2:
                    input.nextLine(); // clear buffer

                    System.out.print("Masukkan Tiket: ");
                    String tiket = input.nextLine();

                    System.out.println("Metode Pembayaran:");
                    System.out.println("1. Cash");
                    System.out.println("2. QRIS");
                    System.out.print("Pilih: ");
                    int metode = input.nextInt();

                    // validasi metode bayar
                    while (metode != 1 && metode != 2) {
                        System.out.print("Pilih 1 atau 2: ");
                        metode = input.nextInt();
                    }

                    parkir.kendaraanKeluar(tiket, metode);
                    break;

                case 3:
                    parkir.tampilkanRingkasan();
                    break;

                case 0:
                    System.out.println("Program selesai.");
                    break;

                default:
                    System.out.println("Pilihan salah!");
            }

        } while (pilih != 0);

        input.close();
    }
}