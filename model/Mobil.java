package model;

import java.time.LocalTime;

public class Mobil extends Kendaraan {

    public Mobil(String tiket, String plat, LocalTime jamMasuk) {
        super(tiket, plat, jamMasuk);
    }

    @Override
    public int hitungBiaya(LocalTime jamKeluar) {
        return hitungDurasi(jamKeluar) * 5000;
    }
}