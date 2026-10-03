package semester_2.task_02;

import java.util.LinkedList;
import java.util.Queue;

public class QueueDemo {
    public static void main(String[] args) {
        // 10, 20, 30, 40, 50, 60, 70, 80

        Queue<Integer> queue = new LinkedList<>();

        //enqueue data
        queue.add(10);
        queue.add(20);
        queue.add(30);
        queue.add(40);
        queue.add(50);
        queue.add(60);
        queue.add(70);
        queue.add(80);

        System.out.println("Isi queue setelah enqueue:");
        System.out.println(queue);

        // Dequeue data
        System.out.println("\nData yang di-dequeue: " + queue.remove());

        System.out.println("\nIsi queue setelah dequeue:");
        System.out.println(queue);
    }
}
