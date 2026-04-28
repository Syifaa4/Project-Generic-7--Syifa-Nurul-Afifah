package model;

import java.time.LocalTime;
import java.time.Duration;

public abstract class Kendaraan {
    protected String tiket;
    protected String plat;
    protected LocalTime jamMasuk;

    public Kendaraan(String tiket, String plat, LocalTime jamMasuk) {
        this.tiket = tiket;
        this.plat = plat;
        this.jamMasuk = jamMasuk;
    }

    public String getTiket() { return tiket; }
    public String getPlat() { return plat; }
    public LocalTime getJamMasuk() { return jamMasuk; }

    protected int hitungDurasi(LocalTime jamKeluar) {
        long menit = Duration.between(jamMasuk, jamKeluar).toMinutes();
        return (int) Math.ceil(menit / 60.0);
    }

    public abstract int hitungBiaya(LocalTime jamKeluar);
}