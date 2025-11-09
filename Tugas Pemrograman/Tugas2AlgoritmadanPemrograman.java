import java.util.Scanner;

public class Tugas2AlgoritmadanPemrograman {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Input Golongan
        System.out.print("Masukkan Golongan (A/B/C): ");
        String golongan = input.next().toUpperCase();

        // Input Jam Lembur
        System.out.print("Masukkan Jumlah Jam Lembur: ");
        int jamLembur = input.nextInt();

        int gajiPokok = 0;
        double persenLembur = 0.0;

        // Menentukan gaji pokok berdasarkan golongan
        if (golongan.equals("A")) {
            gajiPokok = 5000000;
        } else if (golongan.equals("B")) {
            gajiPokok = 6500000;
        } else if (golongan.equals("C")) {
            gajiPokok = 9500000;
        } else {
            System.out.println("Golongan tidak valid!");
            System.exit(0);
        }

        // Menentukan persentase lembur
        if (jamLembur == 1) {
            persenLembur = 0.30;
        } else if (jamLembur == 2) {
            persenLembur = 0.32;
        } else if (jamLembur == 3) {
            persenLembur = 0.34;
        } else if (jamLembur == 4) {
            persenLembur = 0.36;
        } else if (jamLembur >= 5) {
            persenLembur = 0.38;
        } else {
            persenLembur = 0.0; // Tidak lembur
        }

        // Hitung gaji lembur dan total penghasilan
        double gajiLembur = gajiPokok * persenLembur * jamLembur;
        double totalGaji = gajiPokok + gajiLembur;

        // Format output agar hasil menjadi bilangan ribuan
        System.out.println();
        System.out.printf("Gaji Pokok       : Rp %,d\n", gajiPokok);
        System.out.printf("Gaji Lembur      : Rp %,d\n", (int) gajiLembur);
        System.out.printf("Total Penghasilan: Rp %,d\n", (int) totalGaji);
        System.out.println();
        input.close();
    }
}