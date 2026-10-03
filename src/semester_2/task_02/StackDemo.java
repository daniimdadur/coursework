package semester_2.task_02;

import java.util.Stack;

public class StackDemo {
    public static void main(String[] args) {
        // 10, 20, 30, 40, 50, 60, 70, 80

        Stack<Integer> stack = new Stack<>();

        //push data
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);
        stack.push(50);
        stack.push(60);
        stack.push(70);
        stack.push(80);

        System.out.println("Isi stack setelah push:");
        System.out.println(stack);

        //pop data
        System.out.println("\nData yang di-pop: " + stack.pop());

        System.out.println("\nIsi stack setelah pop:");
        System.out.println(stack);
    }
}
