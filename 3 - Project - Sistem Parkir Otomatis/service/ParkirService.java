package service;

import java.time.format.DateTimeFormatter;
import model.*;
import java.util.*;
import java.time.LocalTime;

public class ParkirService {
    private DateTimeFormatter formatJam = DateTimeFormatter.ofPattern("HH:mm");
    private ArrayList<Kendaraan> daftar = new ArrayList<>();
    private ArrayDeque<Kendaraan> antrian = new ArrayDeque<>();

    private int totalMasuk = 0;
    private int totalKeluar = 0;
    private int totalPendapatan = 0;
    private int counterTiket = 1;

    private String generateTiket() {
        return "TK" + String.format("%03d", counterTiket++);
    }

    // MASUK (user ambil tiket)
    public void kendaraanMasuk(String plat, int jenis) {
        String tiket = generateTiket();
        LocalTime jamMasuk = LocalTime.now();

        Kendaraan k = (jenis == 1)
                ? new Mobil(tiket, plat, jamMasuk)
                : new Motor(tiket, plat, jamMasuk);

        daftar.add(k);
        antrian.add(k);
        totalMasuk++;

        System.out.println("\n===== TIKET PARKIR =====");
        System.out.println("Tiket      : " + tiket);
        System.out.println("Jam Masuk  : " + jamMasuk.format(formatJam));
        System.out.println("========================");
    }

    // KELUAR + PEMBAYARAN (pakai tiket)
    public void kendaraanKeluar(String tiketInput, int metodeBayar) {
        Kendaraan k = null;

        for (Kendaraan x : daftar) {
            if (x.getTiket().equalsIgnoreCase(tiketInput)) {
                k = x;
                break;
            }
        }

        if (k == null) {
            System.out.println("Tiket tidak ditemukan!");
            return;
        }

        LocalTime jamKeluar = LocalTime.now();
        int biaya = k.hitungBiaya(jamKeluar);

        // Pilih metode pembayaran 
        Pembayaran bayar = (metodeBayar == 1) ? new Cash() : new QRIS();
        bayar.prosesPembayaran(biaya);

        totalKeluar++;
        totalPendapatan += biaya;

        daftar.remove(k);
        antrian.remove(k);

        System.out.println("\n========== STRUK PARKIR ==========");
        System.out.println("Tiket        : " + k.getTiket());
        System.out.println("Plat         : " + k.getPlat());
        System.out.println("Jam Masuk    : " + k.getJamMasuk().format(formatJam));
        System.out.println("Jam Keluar   : " + jamKeluar.format(formatJam));
        System.out.println("Total Biaya  : Rp" + String.format("%,d", biaya));
        System.out.println("==================================");
    }

    // ADMIN
    public void tampilkanRingkasan() {
        System.out.println("\n========== RINGKASAN PARKIR ==========");
        System.out.println("Jumlah Masuk       : " + totalMasuk);
        System.out.println("Jumlah Keluar      : " + totalKeluar);
        System.out.println("Masih Parkir       : " + (totalMasuk - totalKeluar));
        System.out.println("Total Pendapatan   : Rp" + String.format("%,d", totalPendapatan));
        System.out.println("=======================================");
    }
}