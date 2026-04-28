package model;

public class QRIS implements Pembayaran {

    @Override
    public void prosesPembayaran(int jumlah) {
        System.out.println("Metode Pembayaran : QRIS");
        System.out.println("Scan QR untuk bayar...");
        System.out.println("Jumlah            : Rp" + String.format("%,d", jumlah));
        System.out.println("Status            : BERHASIL");
    }
}  
