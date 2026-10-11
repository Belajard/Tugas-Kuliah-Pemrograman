import java.util.Scanner;

class Menu {
    String nama;
    int harga;
    String kategori;

    public Menu(String nama, int harga, String kategori) {
        this.nama = nama;
        this.harga = harga;
        this.kategori = kategori;
    }

    public String getNama() {
        return nama;
    }

    public int getHarga() {
        return harga;
    }

    public String getKategori() {
        return kategori;
    }
}

public class Tugas1PemrogramanBerbasisDesktop {
    
    public static void main(String[] args) {
        // Membuat array menu dengan minimal 4 makanan dan 4 minuman
        Menu[] menus = new Menu[8];
        menus[0] = new Menu("Nasi Padang", 25000, "makanan");
        menus[1] = new Menu("Ayam Goreng", 20000, "makanan");
        menus[2] = new Menu("Sate Ayam", 30000, "makanan");
        menus[3] = new Menu("Bakso", 15000, "makanan");
        menus[4] = new Menu("Es Teh", 5000, "minuman");
        menus[5] = new Menu("Jus Jeruk", 10000, "minuman");
        menus[6] = new Menu("Kopi", 8000, "minuman");
        menus[7] = new Menu("Air Mineral", 3000, "minuman");

        // Menampilkan daftar menu
        displayMenu(menus);

        try (// Menerima pesanan (maksimal 4)
        Scanner sc = new Scanner(System.in)) {
            String[] pesanan = new String[4];
            int[] jumlah = new int[4];
            int countPesanan = 0;

            System.out.println("Masukkan pesanan (format: Nama Menu = Jumlah). Maksimal 4 pesanan. Tekan Enter tanpa input untuk selesai:");
            pesanan[0] = sc.nextLine();
            if (!pesanan[0].isEmpty()) {
                countPesanan++;
                pesanan[1] = sc.nextLine();
                if (!pesanan[1].isEmpty()) {
                    countPesanan++;
                    pesanan[2] = sc.nextLine();
                    if (!pesanan[2].isEmpty()) {
                        countPesanan++;
                        pesanan[3] = sc.nextLine();
                        if (!pesanan[3].isEmpty()) {
                            countPesanan++;
                        }
                    }
                }
            }

            // Mengolah pesanan dan menghitung total
            double subtotal = 0;
            int totalMinuman = 0;
            String[] namaPesanan = new String[4];
            int[] hargaPesanan = new int[4];
            int[] totalHargaPesanan = new int[4];

            // Proses pesanan pertama
            if (countPesanan >= 1) {
                String[] parts = pesanan[0].split(" = ");
                namaPesanan[0] = parts[0];
                jumlah[0] = Integer.parseInt(parts[1]);
                Menu menu = findMenu(menus, namaPesanan[0]);
                if (menu != null) {
                    hargaPesanan[0] = menu.getHarga();
                    totalHargaPesanan[0] = hargaPesanan[0] * jumlah[0];
                    subtotal += totalHargaPesanan[0];
                    if (menu.getKategori().equals("minuman")) {
                        totalMinuman += jumlah[0];
                    }
                }
            }

            // Proses pesanan kedua
            if (countPesanan >= 2) {
                String[] parts = pesanan[1].split(" = ");
                namaPesanan[1] = parts[0];
                jumlah[1] = Integer.parseInt(parts[1]);
                Menu menu = findMenu(menus, namaPesanan[1]);
                if (menu != null) {
                    hargaPesanan[1] = menu.getHarga();
                    totalHargaPesanan[1] = hargaPesanan[1] * jumlah[1];
                    subtotal += totalHargaPesanan[1];
                    if (menu.getKategori().equals("minuman")) {
                        totalMinuman += jumlah[1];
                    }
                }
            }

            // Proses pesanan ketiga
            if (countPesanan >= 3) {
                String[] parts = pesanan[2].split(" = ");
                namaPesanan[2] = parts[0];
                jumlah[2] = Integer.parseInt(parts[1]);
                Menu menu = findMenu(menus, namaPesanan[2]);
                if (menu != null) {
                    hargaPesanan[2] = menu.getHarga();
                    totalHargaPesanan[2] = hargaPesanan[2] * jumlah[2];
                    subtotal += totalHargaPesanan[2];
                    if (menu.getKategori().equals("minuman")) {
                        totalMinuman += jumlah[2];
                    }
                }
            }

            // Proses pesanan keempat
            if (countPesanan >= 4) {
                String[] parts = pesanan[3].split(" = ");
                namaPesanan[3] = parts[0];
                jumlah[3] = Integer.parseInt(parts[1]);
                Menu menu = findMenu(menus, namaPesanan[3]);
                if (menu != null) {
                    hargaPesanan[3] = menu.getHarga();
                    totalHargaPesanan[3] = hargaPesanan[3] * jumlah[3];
                    subtotal += totalHargaPesanan[3];
                    if (menu.getKategori().equals("minuman")) {
                        totalMinuman += jumlah[3];
                    }
                }
            }

            // Hitung diskon dan penawaran
            double diskon = 0;
            double penawaranMinuman = 0; // Deklarasikan sebagai double untuk nilai diskon
            boolean adaPenawaranMinuman = false;
            if (subtotal > 100000) {
                diskon = subtotal * 0.1;
            }
            if (subtotal > 50000 && totalMinuman > 0) {
                adaPenawaranMinuman = true;
                int hargaMinumanTermurah = Integer.MAX_VALUE;
                boolean adaMinuman = false;
                if (countPesanan >= 1 && findMenu(menus, namaPesanan[0]) != null && findMenu(menus, namaPesanan[0]).getKategori().equals("minuman")) {
                    hargaMinumanTermurah = Math.min(hargaMinumanTermurah, hargaPesanan[0]);
                    adaMinuman = true;
                }
                if (countPesanan >= 2 && findMenu(menus, namaPesanan[1]) != null && findMenu(menus, namaPesanan[1]).getKategori().equals("minuman")) {
                    hargaMinumanTermurah = Math.min(hargaMinumanTermurah, hargaPesanan[1]);
                    adaMinuman = true;
                }
                if (countPesanan >= 3 && findMenu(menus, namaPesanan[2]) != null && findMenu(menus, namaPesanan[2]).getKategori().equals("minuman")) {
                    hargaMinumanTermurah = Math.min(hargaMinumanTermurah, hargaPesanan[2]);
                    adaMinuman = true;
                }
                if (countPesanan >= 4 && findMenu(menus, namaPesanan[3]) != null && findMenu(menus, namaPesanan[3]).getKategori().equals("minuman")) {
                    hargaMinumanTermurah = Math.min(hargaMinumanTermurah, hargaPesanan[3]);
                    adaMinuman = true;
                }
                if (adaMinuman) {
                    int minumanGratis = totalMinuman / 2; // Jumlah gratis (misal 4 minuman -> 2 gratis)
                    penawaranMinuman = (double) hargaMinumanTermurah * minumanGratis; 
                } else {
                    penawaranMinuman = 0; // Jika tidak ada minuman, set 0
                }
            }

            double totalSebelumPajak = subtotal - diskon - penawaranMinuman; // Gunakan penawaranMinuman (double)
            double pajak = totalSebelumPajak * 0.1;
            double biayaPelayanan = 20000;
            double totalAkhir = totalSebelumPajak + pajak + biayaPelayanan;

            // Cetak struk
            printStruk(namaPesanan, jumlah, hargaPesanan, totalHargaPesanan, countPesanan, subtotal, diskon, penawaranMinuman, adaPenawaranMinuman, pajak, biayaPelayanan, totalAkhir);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }

    static void displayMenu(Menu[] menus) {
        System.out.println("=== DAFTAR MENU RESTORAN ===");
        System.out.println("Makanan:");
        System.out.println("1. " + menus[0].getNama() + " - Rp " + menus[0].getHarga());
        System.out.println("2. " + menus[1].getNama() + " - Rp " + menus[1].getHarga());
        System.out.println("3. " + menus[2].getNama() + " - Rp " + menus[2].getHarga());
        System.out.println("4. " + menus[3].getNama() + " - Rp " + menus[3].getHarga());
        System.out.println("Minuman:");
        System.out.println("1. " + menus[4].getNama() + " - Rp " + menus[4].getHarga());
        System.out.println("2. " + menus[5].getNama() + " - Rp " + menus[5].getHarga());
        System.out.println("3. " + menus[6].getNama() + " - Rp " + menus[6].getHarga());
        System.out.println("4. " + menus[7].getNama() + " - Rp " + menus[7].getHarga());
    }

    static Menu findMenu(Menu[] menus, String nama) {
        if (nama.equals(menus[0].getNama())) return menus[0];
        if (nama.equals(menus[1].getNama())) return menus[1];
        if (nama.equals(menus[2].getNama())) return menus[2];
        if (nama.equals(menus[3].getNama())) return menus[3];
        if (nama.equals(menus[4].getNama())) return menus[4];
        if (nama.equals(menus[5].getNama())) return menus[5];
        if (nama.equals(menus[6].getNama())) return menus[6];
        if (nama.equals(menus[7].getNama())) return menus[7];
        return null;
    }

    static void printStruk(String[] namaPesanan, int[] jumlah, int[] hargaPesanan, int[] totalHargaPesanan, int count, double subtotal, double diskon, double penawaranMinuman, boolean adaPenawaranMinuman, double pajak, double biayaPelayanan, double totalAkhir) {
        System.out.println("\n=== STRUK PESANAN ===");
        if (count >= 1) {
            System.out.println(namaPesanan[0] + " x" + jumlah[0] + " - Rp " + hargaPesanan[0] + " = Rp " + totalHargaPesanan[0]);
        }
        if (count >= 2) {
            System.out.println(namaPesanan[1] + " x" + jumlah[1] + " - Rp " + hargaPesanan[1] + " = Rp " + totalHargaPesanan[1]);
        }
        if (count >= 3) {
            System.out.println(namaPesanan[2] + " x" + jumlah[2] + " - Rp " + hargaPesanan[2] + " = Rp " + totalHargaPesanan[2]);
        }
        if (count >= 4) {
            System.out.println(namaPesanan[3] + " x" + jumlah[3] + " - Rp " + hargaPesanan[3] + " = Rp " + totalHargaPesanan[3]);
        }
        System.out.println("Subtotal: Rp " + subtotal);
        if (diskon > 0) {
            System.out.println("Diskon 10%: Rp " + diskon);
        }
        if (adaPenawaranMinuman) {
            System.out.println("Penawaran: Beli 1 Gratis 1 Minuman (Diskon: Rp " + penawaranMinuman + ")");
        }
        System.out.println("Pajak 10%: Rp " + pajak);
        System.out.println("Biaya Pelayanan: Rp " + biayaPelayanan);
        System.out.println("Total Akhir: Rp " + totalAkhir);
    }
}