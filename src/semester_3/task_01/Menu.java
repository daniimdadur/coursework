package semester_3.task_01;

public class Menu {
    // Atribut
    String nama;
    double harga;
    String kategori;

    // Constructor
    public Menu(String nama, double harga, String kategori) {
        this.nama = nama;
        this.harga = harga;
        this.kategori = kategori;
    }

    // Method untuk menampilkan informasi menu
    public void tampilkanMenu() {
        System.out.println(nama + " - Rp " + harga + " - " + kategori);
    }
}
