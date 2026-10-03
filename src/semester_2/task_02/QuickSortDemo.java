package semester_2.task_02;

import java.util.Arrays;

public class QuickSortDemo {
    static void quickSort(int[] arr, int low, int high) {
        if (low < high) {

            int pi = partition(arr, low, high);

            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    static int partition(int[] arr, int low, int high) {

        int pivot = arr[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {

            if (arr[j] < pivot) {
                i++;

                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    public static void main(String[] args) {

        int[] data = {80, 30, 10, 70, 50, 20, 60, 40};

        System.out.println("Data sebelum diurutkan:");
        System.out.println(Arrays.toString(data));

        quickSort(data, 0, data.length - 1);

        System.out.println("\nData setelah diurutkan:");
        System.out.println(Arrays.toString(data));
    }
}
