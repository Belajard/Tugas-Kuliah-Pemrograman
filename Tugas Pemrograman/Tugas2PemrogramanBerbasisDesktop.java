import java.util.ArrayList;
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
}

public class Tugas2PemrogramanBerbasisDesktop {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Menu> menus = new ArrayList<>();
        menus.add(new Menu("Nasi Padang", 25000, "makanan"));
        menus.add(new Menu("Ayam Goreng", 20000, "makanan"));
        menus.add(new Menu("Sate Ayam", 30000, "makanan"));
        menus.add(new Menu("Bakso", 15000, "makanan"));
        menus.add(new Menu("Es Teh", 5000, "minuman"));
        menus.add(new Menu("Jus Jeruk", 10000, "minuman"));
        menus.add(new Menu("Kopi", 8000, "minuman"));
        menus.add(new Menu("Air Mineral", 3000, "minuman"));

        boolean running = true;
        while (running) {
            System.out.println("\n=== MENU UTAMA ===");
            System.out.println("1. Pesan");
            System.out.println("2. Kelola Menu");
            System.out.println("3. Keluar");
            System.out.print("Pilih: ");
            String pilih = sc.nextLine();

            switch (pilih) {
                case "1": pesan(sc, menus); break;
                case "2": kelolaMenu(sc, menus); break;
                case "3": running = false; break;
                default: System.out.println("Pilihan tidak valid!");
            }
        }
        sc.close();
    }

    static void displayMenu(ArrayList<Menu> menus) {
        System.out.println("\n=== DAFTAR MENU ===");
        for (int i = 0; i < menus.size(); i++) {
            Menu m = menus.get(i);
            System.out.println((i + 1) + ". " + m.nama + " - Rp " + m.harga);
        }
    }

    static Menu findMenu(ArrayList<Menu> menus, String nama) {
        for (Menu m : menus) if (m.nama.equalsIgnoreCase(nama)) return m;
        return null;
    }

    static void pesan(Scanner sc, ArrayList<Menu> menus) {
        displayMenu(menus);
        ArrayList<String> namaPesan = new ArrayList<>();
        ArrayList<Integer> jumlahPesan = new ArrayList<>();

        System.out.println("Masukkan pesanan (Nama = Jumlah), ketik 'selesai' jika selesai:");
        while (true) {
            String line = sc.nextLine();
            if (line.equalsIgnoreCase("selesai") || line.isEmpty()) break;

            String[] parts = line.split("=");
            if (parts.length != 2) { System.out.println("Format salah!"); continue; }
            String nama = parts[0].trim();
            int jumlah;
            try { jumlah = Integer.parseInt(parts[1].trim()); }
            catch (Exception e) { System.out.println("Jumlah harus angka!"); continue; }

            if (findMenu(menus, nama) == null) { System.out.println("Menu tidak ada!"); continue; }
            namaPesan.add(nama);
            jumlahPesan.add(jumlah);
        }

        double subtotal = 0, totalMinuman = 0;
        ArrayList<Integer> hargaPesan = new ArrayList<>();
        ArrayList<Integer> totalHargaPesan = new ArrayList<>();

        for (int i = 0; i < namaPesan.size(); i++) {
            Menu m = findMenu(menus, namaPesan.get(i));
            int total = m.harga * jumlahPesan.get(i);
            subtotal += total;
            if (m.kategori.equals("minuman")) totalMinuman += jumlahPesan.get(i);
            hargaPesan.add(m.harga);
            totalHargaPesan.add(total);
        }

        double diskon = subtotal > 100000 ? subtotal * 0.1 : 0;
        double penawaran = 0;
        boolean adaPromo = subtotal > 50000 && totalMinuman > 0;

        if (adaPromo) {
            int minHargaMinuman = Integer.MAX_VALUE;
            for (int i = 0; i < namaPesan.size(); i++) {
                Menu m = findMenu(menus, namaPesan.get(i));
                if (m.kategori.equals("minuman")) minHargaMinuman = Math.min(minHargaMinuman, hargaPesan.get(i));
            }
            penawaran = minHargaMinuman * (int)(totalMinuman/2);
        }

        double totalSblmPajak = subtotal - diskon - penawaran;
        double pajak = totalSblmPajak * 0.1;
        double biayaPel = 20000;
        double totalAkhir = totalSblmPajak + pajak + biayaPel;

        // Cetak struk
        System.out.println("\n=== STRUK PESANAN ===");
        for (int i = 0; i < namaPesan.size(); i++)
            System.out.println(namaPesan.get(i) + " x" + jumlahPesan.get(i) + " = Rp " + totalHargaPesan.get(i));
        System.out.println("Subtotal: Rp " + (int)subtotal);
        if (diskon>0) System.out.println("Diskon: Rp " + (int)diskon);
        if (adaPromo) System.out.println("Promo Beli 1 Gratis 1 Minuman: Rp " + (int)penawaran);
        System.out.println("Pajak 10%: Rp " + (int)pajak);
        System.out.println("Biaya Pelayanan: Rp " + (int)biayaPel);
        System.out.println("Total Akhir: Rp " + (int)totalAkhir);
    }

    static void kelolaMenu(Scanner sc, ArrayList<Menu> menus) {
        boolean kelola = true;
        while (kelola) {
            System.out.println("\n=== KELOLA MENU ===");
            System.out.println("1. Tambah Menu");
            System.out.println("2. Ubah Menu");
            System.out.println("3. Hapus Menu");
            System.out.println("4. Kembali");
            System.out.print("Pilih: ");
            String pilih = sc.nextLine();
            switch(pilih) {
                case "1":
                    System.out.print("Nama: "); String n = sc.nextLine();
                    System.out.print("Harga: "); int h = Integer.parseInt(sc.nextLine());
                    System.out.print("Kategori: "); String k = sc.nextLine();
                    menus.add(new Menu(n,h,k));
                    System.out.println("Menu ditambahkan!");
                    break;
                case "2":
                    displayMenu(menus);
                    System.out.print("Nomor menu diubah: "); int idxU = Integer.parseInt(sc.nextLine())-1;
                    if(idxU<0 || idxU>=menus.size()) { System.out.println("Nomor salah!"); break; }
                    System.out.print("Ubah menu ini? (Ya/Tidak): "); String konU = sc.nextLine();
                    if(konU.equalsIgnoreCase("Ya")) {
                        System.out.print("Nama baru: "); menus.get(idxU).nama = sc.nextLine();
                        System.out.print("Harga baru: "); menus.get(idxU).harga = Integer.parseInt(sc.nextLine());
                        System.out.print("Kategori baru: "); menus.get(idxU).kategori = sc.nextLine();
                        System.out.println("Menu berhasil diubah!");
                    }
                    break;
                case "3":
                    displayMenu(menus);
                    System.out.print("Nomor menu dihapus: "); int idxH = Integer.parseInt(sc.nextLine())-1;
                    if(idxH<0 || idxH>=menus.size()) { System.out.println("Nomor salah!"); break; }
                    System.out.print("Hapus menu ini? (Ya/Tidak): "); String konH = sc.nextLine();
                    if(konH.equalsIgnoreCase("Ya")) { menus.remove(idxH); System.out.println("Menu dihapus!"); }
                    break;
                case "4": kelola=false; break;
                default: System.out.println("Pilihan tidak valid!");
            }
        }
    }
}