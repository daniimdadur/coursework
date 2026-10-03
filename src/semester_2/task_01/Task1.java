package semester_2.task_01;

import java.util.LinkedList;

public class Task1 {
    public static void main(String[] args) {
        float strukturBaris;

        String susunanKataBaru = "Pemrograman Struktur Data Java";
        System.out.println(susunanKataBaru);

        int[] delapanAngka = {10, 12, 18, 23, 33, 58, 67, 82};
        System.out.println(delapanAngka[0]);

        String[][] duaAngka = {
                {"2", "4", "6"},
                {"8", "10", "12"},
                {"14", "16", "18"}
        };
        System.out.println(duaAngka[0][0]);
        System.out.println(duaAngka[0][1]);

        LinkedList<Integer> urutanListAngka = new LinkedList<>();
        urutanListAngka.add(15);
        urutanListAngka.add(28);
        urutanListAngka.add(33);
        urutanListAngka.add(37);
        urutanListAngka.add(47);
        urutanListAngka.add(59);

    }
}
