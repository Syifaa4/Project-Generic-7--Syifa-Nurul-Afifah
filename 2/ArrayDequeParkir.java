import java.util.ArrayDeque;

public class ArrayDequeParkir {
    public static void main(String[] args) {

        System.out.println("=== ARRAYDEQUE (ANTRIAN) ===");

        ArrayDeque<String> antrian = new ArrayDeque<>();

        // Tambah antrian
        antrian.add("Mobil A");
        antrian.add("Mobil B");
        antrian.add("Mobil C");

        // Tampilkan isi antrian
        System.out.println("Isi antrian:");
        for (String kendaraan : antrian) {
            System.out.println(kendaraan);
        }

        // Kendaraan keluar (FIFO)
        System.out.println("Keluar: " + antrian.poll());

        // Sisa antrian
        System.out.println("Sisa antrian:");
        for (String kendaraan : antrian) {
            System.out.println(kendaraan);
        }
    }
}