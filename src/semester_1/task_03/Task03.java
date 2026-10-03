package semester_1.task_03;

import java.util.Scanner;

public class Task03 {
    public static void main(String[] args) {
        
        // 1. bagian input
        Scanner input = new Scanner(System.in);

        System.out.println("Daftar Golongan Gaji: ");
        System.out.println("Golongan A = Rp. 5.000.000");
        System.out.println("Golongan B = Rp. 6.500.000");
        System.out.println("Golongan C = Rp. 9.500.000");
        System.out.println();

        System.out.print("Masukkan Golongan (A/B/C): ");
        String golongan = input.nextLine().toUpperCase();
        System.out.print("Masukkan Jam Lembur: ");
        int jamLembur = input.nextInt();

        //bagian 2 penentuan gaji pokok berdasarkan golongan
        long gajiPokok;
        double persenLembur;

        switch (golongan) {
            case "A":
                gajiPokok = 5000000;
                break;
            case "B":
                gajiPokok = 6500000;
                break;
            case "C":
                gajiPokok = 9500000;
                break;
            default:
                System.out.println("Golongan tidak valid!");
                return;
        }

        //bagian 3 menghitung persentase lembur
        double[] persen = {0.30, 0.32, 0.34, 0.36, 0.38};

        if (jamLembur == 1) {
            persenLembur = persen[0];
        } else if (jamLembur == 2) {
            persenLembur = persen[1];
        } else if (jamLembur == 3) {
            persenLembur = persen[2];
        } else if (jamLembur == 4) {
            persenLembur = persen[3];
        } else if (jamLembur >= 5) {
            persenLembur = persen[4];
        } else {
            persenLembur = 0;
        }

        // bagian 4 perhitungan gaji lembur dan total gaji
        double gajiLembur = gajiPokok * persenLembur;
        double total = gajiPokok + gajiLembur;

        // bagian 5 output program
        System.out.println("=====================================");
        System.out.println("Gaji Pokok     : Rp " + String.format("%,d", gajiPokok));
        System.out.println("Persen Lembur  : " + String.format("%,.0f", persenLembur * 100) + "%");
        System.out.println("Gaji Lembur    : Rp " + String.format("%,.0f", gajiLembur));
        System.out.println("Total Gaji     : Rp " + String.format("%,.0f", total));
    }
}
