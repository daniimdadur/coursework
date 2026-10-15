package semester_3.task_02.pbd;

import java.util.Scanner;

public class Main {
    static Scanner input = new Scanner(System.in);

    static Menu[] daftarMenu = new Menu[100];
    static int jumlahMenu = 0;

    static final double PAJAK = 0.10;
    static final double BIAYA_PELAYANAN = 20000;
    static final double BATAS_DISKON = 100000;
    static final double BATAS_PROMO = 50000;

    public static void main(String[] args) {
        isiMenuAwal();
        menuUtama();
    }

    // Mengisi menu awal restoran
    static void isiMenuAwal() {
        tambahMenuAwal("Nasi Goreng", 25000, "Makanan");
        tambahMenuAwal("Mie Goreng", 22000, "Makanan");
        tambahMenuAwal("Ayam Bakar", 30000, "Makanan");
        tambahMenuAwal("Sate Ayam", 28000, "Makanan");

        tambahMenuAwal("Es Teh", 8000, "Minuman");
        tambahMenuAwal("Es Jeruk", 10000, "Minuman");
        tambahMenuAwal("Jus Alpukat", 18000, "Minuman");
        tambahMenuAwal("Kopi Susu", 15000, "Minuman");
    }

    static void tambahMenuAwal(
            String nama, double harga, String kategori) {
        daftarMenu[jumlahMenu] =
                new Menu(nama, harga, kategori);
        jumlahMenu++;
    }

    // Membaca input angka dengan validasi
    static int bacaAngka(String pesan) {
        while (true) {
            System.out.print(pesan);
            String teks = input.nextLine().trim();

            try {
                return Integer.parseInt(teks);
            } catch (NumberFormatException e) {
                System.out.println(
                        "Input harus berupa angka. Coba lagi.");
            }
        }
    }

    // Membaca input harga
    static double bacaHarga(String pesan) {
        while (true) {
            System.out.print(pesan);
            String teks = input.nextLine().trim();

            try {
                double harga = Double.parseDouble(teks);

                if (harga > 0) {
                    return harga;
                } else {
                    System.out.println(
                            "Harga harus lebih dari nol.");
                }
            } catch (NumberFormatException e) {
                System.out.println(
                        "Harga tidak valid. Masukkan angka.");
            }
        }
    }

    // Menu utama
    static void menuUtama() {
        int pilihan;

        do {
            System.out.println("\n===== RESTORAN =====");
            System.out.println("1. Menu Pelanggan");
            System.out.println("2. Manajemen Menu");
            System.out.println("0. Keluar");

            pilihan = bacaAngka("Pilih menu: ");

            switch (pilihan) {
                case 1:
                    menuPelanggan();
                    break;

                case 2:
                    menuManajemen();
                    break;

                case 0:
                    System.out.println(
                            "Terima kasih telah menggunakan program.");
                    break;

                default:
                    System.out.println(
                            "Pilihan tidak tersedia. Coba lagi.");
            }
        } while (pilihan != 0);
    }

    // Menampilkan menu berdasarkan kategori
    static void tampilkanMenu() {
        System.out.println("\n===== DAFTAR MENU RESTORAN =====");

        String[] kategori = {"Makanan", "Minuman"};

        for (String jenis : kategori) {
            System.out.println("\n--- " + jenis.toUpperCase() + " ---");

            boolean ditemukan = false;

            for (int i = 0; i < jumlahMenu; i++) {
                if (daftarMenu[i].getKategori()
                        .equalsIgnoreCase(jenis)) {

                    System.out.printf(
                            "%d. %s - Rp %,.0f%n",
                            i + 1,
                            daftarMenu[i].getNama(),
                            daftarMenu[i].getHarga());

                    ditemukan = true;
                }
            }

            if (!ditemukan) {
                System.out.println("Belum ada menu.");
            }
        }
    }

    // Menu pelanggan
    static void menuPelanggan() {
        int[] nomorPesanan = new int[100];
        int[] jumlahPesanan = new int[100];
        int jumlahJenisPesanan = 0;

        tampilkanMenu();

        System.out.println(
                "\nKetik nama menu untuk memesan.");
        System.out.println(
                "Ketik 'selesai' jika pesanan sudah lengkap.");

        while (true) {
            System.out.print("\nNama menu: ");
            String nama = input.nextLine().trim();

            if (nama.equalsIgnoreCase("selesai")) {
                break;
            }

            int indeks = cariMenu(nama);

            if (indeks == -1) {
                System.out.println(
                        "Menu tidak tersedia. Silakan pilih menu yang ada.");
                continue;
            }

            int jumlah = bacaAngka("Jumlah pesanan: ");

            if (jumlah <= 0) {
                System.out.println(
                        "Jumlah harus lebih dari nol.");
                continue;
            }

            int posisi = -1;

            for (int i = 0; i < jumlahJenisPesanan; i++) {
                if (nomorPesanan[i] == indeks) {
                    posisi = i;
                    break;
                }
            }

            if (posisi != -1) {
                jumlahPesanan[posisi] += jumlah;
            } else if (jumlahJenisPesanan < nomorPesanan.length) {
                nomorPesanan[jumlahJenisPesanan] = indeks;
                jumlahPesanan[jumlahJenisPesanan] = jumlah;
                jumlahJenisPesanan++;
            } else {
                System.out.println(
                        "Kapasitas jenis pesanan sudah penuh.");
                continue;
            }

            System.out.println("Pesanan berhasil ditambahkan.");
        }

        if (jumlahJenisPesanan == 0) {
            System.out.println("Tidak ada pesanan.");
            return;
        }

        cetakStruk(
                nomorPesanan,
                jumlahPesanan,
                jumlahJenisPesanan);
    }

    // Mencari menu berdasarkan nama
    static int cariMenu(String nama) {
        for (int i = 0; i < jumlahMenu; i++) {
            if (daftarMenu[i].getNama()
                    .equalsIgnoreCase(nama)) {
                return i;
            }
        }

        return -1;
    }

    // Menghitung subtotal pesanan
    static double hitungSubtotal(
            int[] nomorPesanan,
            int[] jumlahPesanan,
            int jumlahJenisPesanan) {

        double subtotal = 0;

        for (int i = 0; i < jumlahJenisPesanan; i++) {
            Menu menu = daftarMenu[nomorPesanan[i]];

            subtotal += menu.getHarga() * jumlahPesanan[i];
        }

        return subtotal;
    }

    // Mencetak struk dan menghitung pembayaran
    static void cetakStruk(
            int[] nomorPesanan,
            int[] jumlahPesanan,
            int jumlahJenisPesanan) {

        double subtotal = hitungSubtotal(
                nomorPesanan,
                jumlahPesanan,
                jumlahJenisPesanan);

        double diskon = 0;
        double pajak;
        double total;

        boolean mendapatPromo = false;
        int jumlahGratis = 0;

        // Diskon 10% jika subtotal lebih dari Rp100.000
        if (subtotal > BATAS_DISKON) {
            diskon = subtotal * 0.10;
        }

        double setelahDiskon = subtotal - diskon;

        // Pajak dihitung dari subtotal setelah diskon
        pajak = setelahDiskon * PAJAK;

        // Promo beli satu gratis satu untuk Jus Alpukat
        if (subtotal > BATAS_PROMO) {
            for (int i = 0; i < jumlahJenisPesanan; i++) {
                Menu menu = daftarMenu[nomorPesanan[i]];

                if (menu.getNama().equalsIgnoreCase("Jus Alpukat")
                        && menu.getKategori()
                        .equalsIgnoreCase("Minuman")) {

                    mendapatPromo = true;
                    jumlahGratis += jumlahPesanan[i];
                }
            }
        }

        total = setelahDiskon + pajak + BIAYA_PELAYANAN;

        System.out.println("\n========== STRUK PEMBAYARAN ==========");

        for (int i = 0; i < jumlahJenisPesanan; i++) {
            Menu menu = daftarMenu[nomorPesanan[i]];

            double hargaTotal =
                    menu.getHarga() * jumlahPesanan[i];

            System.out.printf(
                    "%s (%d x Rp %,.0f) = Rp %,.0f%n",
                    menu.getNama(),
                    jumlahPesanan[i],
                    menu.getHarga(),
                    hargaTotal);
        }

        System.out.println("--------------------------------------");
        System.out.printf("Subtotal          : Rp %,.0f%n", subtotal);
        System.out.printf("Diskon            : Rp %,.0f%n", diskon);
        System.out.printf(
                "Setelah diskon    : Rp %,.0f%n",
                setelahDiskon);
        System.out.printf(
                "Pajak (10%%)       : Rp %,.0f%n", pajak);
        System.out.printf(
                "Biaya pelayanan   : Rp %,.0f%n",
                BIAYA_PELAYANAN);

        // Menampilkan informasi promo
        if (mendapatPromo) {
            System.out.println(
                    "Promo: Beli 1 gratis 1 Jus Alpukat");
            System.out.println(
                    "Jumlah Jus Alpukat gratis: " + jumlahGratis);
        } else if (subtotal > BATAS_PROMO) {
            System.out.println(
                    "Promo minuman tidak berlaku karena "
                            + "Jus Alpukat tidak dipesan.");
        } else {
            System.out.println(
                    "Promo minuman berlaku jika subtotal "
                            + "lebih dari Rp 50.000.");
        }

        if (diskon > 0) {
            System.out.println(
                    "Diskon 10% berhasil diterapkan.");
        } else {
            System.out.println(
                    "Diskon 10% tidak berlaku.");
        }

        System.out.println("--------------------------------------");
        System.out.printf("TOTAL BAYAR       : Rp %,.0f%n", total);
        System.out.println("======================================");
    }

    // Menu pengelolaan restoran
    static void menuManajemen() {
        int pilihan;

        do {
            System.out.println("\n===== MANAJEMEN MENU =====");
            System.out.println("1. Tampilkan Menu");
            System.out.println("2. Tambah Menu");
            System.out.println("3. Ubah Harga Menu");
            System.out.println("4. Hapus Menu");
            System.out.println("0. Kembali ke Menu Utama");

            pilihan = bacaAngka("Pilih menu: ");

            switch (pilihan) {
                case 1:
                    tampilkanMenu();
                    break;

                case 2:
                    tambahMenu();
                    break;

                case 3:
                    ubahHargaMenu();
                    break;

                case 4:
                    hapusMenu();
                    break;

                case 0:
                    System.out.println(
                            "Kembali ke menu utama.");
                    break;

                default:
                    System.out.println(
                            "Pilihan tidak tersedia. Coba lagi.");
            }
        } while (pilihan != 0);
    }

    // Menambah satu atau beberapa menu
    static void tambahMenu() {
        if (jumlahMenu >= daftarMenu.length) {
            System.out.println("Kapasitas menu sudah penuh.");
            return;
        }

        int banyak = bacaAngka(
                "Berapa menu yang ingin ditambahkan? ");

        if (banyak <= 0) {
            System.out.println(
                    "Jumlah menu harus lebih dari nol.");
            return;
        }

        for (int i = 0; i < banyak; i++) {
            if (jumlahMenu >= daftarMenu.length) {
                System.out.println(
                        "Kapasitas menu sudah penuh.");
                break;
            }

            System.out.println(
                    "\nData menu ke-" + (i + 1));

            System.out.print("Nama menu: ");
            String nama = input.nextLine().trim();

            if (nama.isEmpty() || cariMenu(nama) != -1) {
                System.out.println(
                        "Nama kosong atau sudah tersedia. "
                                + "Menu ini dilewati.");
                continue;
            }

            double harga = bacaHarga("Harga menu: ");

            String kategori;

            while (true) {
                System.out.print(
                        "Kategori (Makanan/Minuman): ");
                kategori = input.nextLine().trim();

                if (kategori.equalsIgnoreCase("Makanan")) {
                    kategori = "Makanan";
                    break;
                } else if (kategori.equalsIgnoreCase("Minuman")) {
                    kategori = "Minuman";
                    break;
                } else {
                    System.out.println(
                            "Kategori harus Makanan atau Minuman.");
                }
            }

            daftarMenu[jumlahMenu] =
                    new Menu(nama, harga, kategori);

            jumlahMenu++;

            System.out.println(
                    "Menu berhasil ditambahkan.");
        }
    }

    // Mengubah harga menu dengan konfirmasi
    static void ubahHargaMenu() {
        tampilkanMenu();

        int nomor = bacaAngka(
                "\nMasukkan nomor menu yang ingin diubah: ");

        if (nomor < 1 || nomor > jumlahMenu) {
            System.out.println("Nomor menu tidak valid.");
            return;
        }

        Menu menu = daftarMenu[nomor - 1];

        System.out.println(
                "Menu dipilih: " + menu.getNama());
        System.out.printf(
                "Harga lama: Rp %,.0f%n", menu.getHarga());

        System.out.print(
                "Yakin ingin mengubah harga? (Ya/Tidak): ");
        String konfirmasi = input.nextLine().trim();

        if (konfirmasi.equalsIgnoreCase("Ya")) {
            double hargaBaru = bacaHarga("Harga baru: ");
            menu.setHarga(hargaBaru);

            System.out.println(
                    "Harga menu berhasil diubah.");
        } else {
            System.out.println(
                    "Perubahan dibatalkan.");
        }
    }

    // Menghapus menu dengan konfirmasi
    static void hapusMenu() {
        tampilkanMenu();

        int nomor = bacaAngka(
                "\nMasukkan nomor menu yang ingin dihapus: ");

        if (nomor < 1 || nomor > jumlahMenu) {
            System.out.println("Nomor menu tidak valid.");
            return;
        }

        Menu menu = daftarMenu[nomor - 1];

        System.out.println(
                "Menu yang dipilih: " + menu.getNama());

        System.out.print(
                "Yakin ingin menghapus menu? (Ya/Tidak): ");
        String konfirmasi = input.nextLine().trim();

        if (konfirmasi.equalsIgnoreCase("Ya")) {
            for (int i = nomor - 1; i < jumlahMenu - 1; i++) {
                daftarMenu[i] = daftarMenu[i + 1];
            }

            jumlahMenu--;
            daftarMenu[jumlahMenu] = null;

            System.out.println(
                    "Menu berhasil dihapus.");
        } else {
            System.out.println(
                    "Penghapusan dibatalkan.");
        }
    }
}
