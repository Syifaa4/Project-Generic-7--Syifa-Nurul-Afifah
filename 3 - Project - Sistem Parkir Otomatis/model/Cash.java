package model;

public class Cash implements Pembayaran {

    @Override
    public void prosesPembayaran(int jumlah) {
        System.out.println("Metode Pembayaran : CASH");
        System.out.println("Jumlah Dibayar    : Rp" + String.format("%,d", jumlah));
        System.out.println("Status            : LUNAS");
    }
}