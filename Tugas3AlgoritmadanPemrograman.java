import java.util.Scanner;

public class Tugas3AlgoritmadanPemrograman {
    public static void main(String[] args) {
        
        // Array gaji pokok per golongan: A, B, C
        int[] gaji = {5000000, 6500000, 9500000};
        
        // Array persen lembur
        int[] persenLembur = {30, 32, 34, 36, 38};

        Scanner input = new Scanner(System.in);

        // Input golongan karyawan
        System.out.print("Masukkan Golongan (A/B/C): ");
        String gol = input.next().toUpperCase(); 

        // Input jumlah jam lembur
        System.out.print("Masukkan Jumlah Jam Lembur: ");
        int jam = input.nextInt();

        int indexGolongan = -1;

        // Menentukan index array berdasarkan golongan
        if (gol.equals("A")) {
            indexGolongan = 0;
        } else if (gol.equals("B")) {
            indexGolongan = 1;
        } else if (gol.equals("C")) {
            indexGolongan = 2;
        } else {
            System.out.println("Golongan tidak valid!");
            return; // hentikan program jika input salah
        }

        // Mengambil gaji pokok dari array berdasarkan golongan
        int gajiPokok = gaji[indexGolongan];

        // Menentukan persen lembur berdasarkan jumlah jam lembur
        int persen = 0;
        if (jam == 1) persen = persenLembur[0];
        else if (jam == 2) persen = persenLembur[1];
        else if (jam == 3) persen = persenLembur[2];
        else if (jam == 4) persen = persenLembur[3];
        else if (jam >= 5) persen = persenLembur[4];

        // Menghitung gaji lembur dari persen * gaji pokok
        double gajiLembur = gajiPokok * persen / 100.0;

        // Total gaji = gaji pokok + gaji lembur
        double totalGaji = gajiPokok + gajiLembur;

        // Menampilkan hasil perhitungan dengan format angka ribuan
        System.out.println("\n===== RINCIAN GAJI =====");
        System.out.printf("Golongan         : %s\n", gol);
        System.out.printf("Gaji Pokok       : Rp %,d\n", gajiPokok);
        System.out.printf("Jam Lembur       : %d Jam\n", jam);
        System.out.printf("Gaji Lembur      : Rp %,d\n", (int) gajiLembur);
        System.out.printf("Total Gaji       : Rp %,d\n", (int) totalGaji);
    }
}