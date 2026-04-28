package model;

import java.time.LocalTime;

public class Motor extends Kendaraan {

    public Motor(String tiket, String plat, LocalTime jamMasuk) {
        super(tiket, plat, jamMasuk);
    }

    @Override
    public int hitungBiaya(LocalTime jamKeluar) {
        return hitungDurasi(jamKeluar) * 2000;
    }
}