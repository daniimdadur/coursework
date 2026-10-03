package semester_3.task_01;

import java.util.Scanner;

public class Main {
    // Array menu restoran
    static Menu[] daftarMenu = {
            // Makanan
            new Menu("Nasi Padang", 25000, "Makanan"),
            new Menu("Ayam Geprek", 20000, "Makanan"),
            new Menu("Mie Goreng", 18000, "Makanan"),
            new Menu("Sate Ayam", 22000, "Makanan"),

            // Minuman
            new Menu("Es Teh", 8000, "Minuman"),
            new Menu("Es Jeruk", 10000, "Minuman"),
            new Menu("Kopi", 12000, "Minuman"),
            new Menu("Jus Alpukat", 15000, "Minuman")
    };

    // Method untuk menampilkan daftar menu
    public static void tampilkanMenu() {
        System.out.println("========== MENU RESTORAN ==========");

        System.out.println("\n--- MAKANAN ---");
        daftarMenu[0].tampilkanMenu();
        daftarMenu[1].tampilkanMenu();
        daftarMenu[2].tampilkanMenu();
        daftarMenu[3].tampilkanMenu();

        System.out.println("\n--- MINUMAN ---");
        daftarMenu[4].tampilkanMenu();
        daftarMenu[5].tampilkanMenu();
        daftarMenu[6].tampilkanMenu();
        daftarMenu[7].tampilkanMenu();

        System.out.println("===================================");
    }

    // Method untuk mencari menu berdasarkan nama
    public static Menu cariMenu(String nama) {

        Menu hasil = null;

        if (nama.equalsIgnoreCase(daftarMenu[0].nama)) {
            hasil = daftarMenu[0];
        } else if (nama.equalsIgnoreCase(daftarMenu[1].nama)) {
            hasil = daftarMenu[1];
        } else if (nama.equalsIgnoreCase(daftarMenu[2].nama)) {
            hasil = daftarMenu[2];
        } else if (nama.equalsIgnoreCase(daftarMenu[3].nama)) {
            hasil = daftarMenu[3];
        } else if (nama.equalsIgnoreCase(daftarMenu[4].nama)) {
            hasil = daftarMenu[4];
        } else if (nama.equalsIgnoreCase(daftarMenu[5].nama)) {
            hasil = daftarMenu[5];
        } else if (nama.equalsIgnoreCase(daftarMenu[6].nama)) {
            hasil = daftarMenu[6];
        } else if (nama.equalsIgnoreCase(daftarMenu[7].nama)) {
            hasil = daftarMenu[7];
        }

        return hasil;
    }

    // Method untuk menentukan kategori menu menggunakan switch-case
    public static String cekKategori(Menu menu) {

        String kategori = "";

        if (menu != null) {
            switch (menu.kategori) {
                case "Makanan":
                    kategori = "Makanan";
                    break;

                case "Minuman":
                    kategori = "Minuman";
                    break;

                default:
                    kategori = "Kategori tidak diketahui";
            }
        }

        return kategori;
    }

    // Method untuk menghitung total satu item
    public static double hitungItem(Menu menu, int jumlah) {

        double total = 0;

        if (menu != null) {
            total = menu.harga * jumlah;
        }

        return total;
    }

    // Method menentukan jumlah Jus Alpukat gratis
    public static int hitungPromoMinuman(
            double total,
            Menu menu1,
            Menu menu2,
            Menu menu3,
            Menu menu4) {

        int promo = 0;

        // Syarat pertama: total pesanan lebih dari Rp50.000
        if (total > 50000) {

            // Syarat kedua: customer membeli Jus Alpukat
            if (menu1 != null && menu1.nama.equalsIgnoreCase("Jus Alpukat")) {
                promo = 1;
            } else if (menu2 != null && menu2.nama.equalsIgnoreCase("Jus Alpukat")) {
                promo = 1;
            } else if (menu3 != null && menu3.nama.equalsIgnoreCase("Jus Alpukat")) {
                promo = 1;
            } else if (menu4 != null && menu4.nama.equalsIgnoreCase("Jus Alpukat")) {
                promo = 1;
            }
        }

        return promo;
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        // Menampilkan menu
        tampilkanMenu();

        // bagian pemesanan
        System.out.println("\n========== PEMESANAN ==========");

        // Pesanan 1
        System.out.print("Masukkan menu 1: ");
        String nama1 = input.nextLine();

        System.out.print("Jumlah: ");
        int jumlah1 = input.nextInt();
        input.nextLine();

        // Pesanan 2
        System.out.print("\nMasukkan menu 2: ");
        String nama2 = input.nextLine();

        System.out.print("Jumlah: ");
        int jumlah2 = input.nextInt();
        input.nextLine();

        // Pesanan 3
        System.out.print("\nMasukkan menu 3: ");
        String nama3 = input.nextLine();

        System.out.print("Jumlah: ");
        int jumlah3 = input.nextInt();
        input.nextLine();

        // Pesanan 4
        System.out.print("\nMasukkan menu 4: ");
        String nama4 = input.nextLine();

        System.out.print("Jumlah: ");
        int jumlah4 = input.nextInt();

        // Mencari menu
        Menu menu1 = cariMenu(nama1);
        Menu menu2 = cariMenu(nama2);
        Menu menu3 = cariMenu(nama3);
        Menu menu4 = cariMenu(nama4);

        // Menghitung total masing-masing item
        double total1 = hitungItem(menu1, jumlah1);
        double total2 = hitungItem(menu2, jumlah2);
        double total3 = hitungItem(menu3, jumlah3);
        double total4 = hitungItem(menu4, jumlah4);

        // Total keseluruhan sebelum pajak dan diskon
        double totalPesanan = total1 + total2 + total3 + total4;

        // Diskon
        double diskon;

        if (totalPesanan > 100000) {
            diskon = totalPesanan * 0.10;
        } else {
            diskon = 0;
        }

        // Total setelah diskon
        double totalSetelahDiskon = totalPesanan - diskon;

        // Pajak 10%
        double pajak = totalSetelahDiskon * 0.10;

        // Biaya pelayanan
        double biayaPelayanan = 20000;

        // Penawaran beli satu gratis satu untuk minuman
        int promoMinuman = hitungPromoMinuman(
                totalPesanan,
                menu1,
                menu2,
                menu3,
                menu4
        );

        // Total akhir
        double totalBayar =
                totalSetelahDiskon
                        + pajak
                        + biayaPelayanan;

        // Mencetak struk
        System.out.println("\n\n========== STRUK PEMBAYARAN ==========");

        System.out.println("Pesanan 1:");
        if (menu1 != null) {
            System.out.println(menu1.nama
                    + " (" + cekKategori(menu1) + ")"
                    + " x " + jumlah1
                    + " = Rp " + total1);
        } else {
            System.out.println("Menu tidak ditemukan");
        }

        System.out.println("\nPesanan 2:");
        if (menu2 != null) {
            System.out.println(menu2.nama
                    + " (" + cekKategori(menu2) + ")"
                    + " x " + jumlah2
                    + " = Rp " + total2);
        } else {
            System.out.println("Menu tidak ditemukan");
        }

        System.out.println("\nPesanan 3:");
        if (menu3 != null) {
            System.out.println(menu3.nama
                    + " (" + cekKategori(menu3) + ")"
                    + " x " + jumlah3
                    + " = Rp " + total3);
        } else {
            System.out.println("Menu tidak ditemukan");
        }

        System.out.println("\nPesanan 4:");
        if (menu4 != null) {
            System.out.println(menu4.nama
                    + " (" + cekKategori(menu4) + ")"
                    + " x " + jumlah4
                    + " = Rp " + total4);
        } else {
            System.out.println("Menu tidak ditemukan");
        }

        System.out.println("---------------------------------------");
        System.out.println("Total Pesanan       : Rp " + totalPesanan);
        System.out.println("Diskon 10%          : Rp " + diskon);
        System.out.println("Total Setelah Diskon: Rp " + totalSetelahDiskon);
        System.out.println("Pajak 10%           : Rp " + pajak);
        System.out.println("Biaya Pelayanan     : Rp " + biayaPelayanan);

        if (promoMinuman > 0) {
            System.out.println(
                    "Promo B1G1 Jus Alpukat : "
                            + promoMinuman
                            + " Jus Alpukat Gratis"
            );
        } else {
            System.out.println(
                    "Promo B1G1 Jus Alpukat : Tidak ada"
            );
        }

        System.out.println("---------------------------------------");
        System.out.println("TOTAL BAYAR         : Rp " + totalBayar);
        System.out.println("=======================================");

        input.close();
    }
}
