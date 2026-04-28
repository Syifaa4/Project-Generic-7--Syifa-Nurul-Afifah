import java.util.ArrayList;

public class ArrayListParkir {
    public static void main(String[] args) {

        System.out.println("=== ARRAYLIST ===");

        ArrayList<String> daftarNama = new ArrayList<>();

        // Tambah data
        daftarNama.add("Syifa");
        daftarNama.add("Alya");
        daftarNama.add("Rizky");

        // Tampilkan data
        System.out.println("Data awal:");
        for (String nama : daftarNama) {
            System.out.println(nama);
        }

        // Hapus data
        daftarNama.remove("Syifa");

        // Tampilkan setelah dihapus
        System.out.println("Setelah dihapus:");
        for (String nama : daftarNama) {
            System.out.println(nama);
        }
    }
}