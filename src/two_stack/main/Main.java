package two_stack.main;

import two_stack.util.StackID;
import two_stack.util.TwoStack;

import java.util.Iterator;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the Size of the stack: ");
        int size = scanner.nextInt();
        TwoStack<Integer> twoStack = new TwoStack<>(size);
        twoStack.push(StackID.ONE, 1);
        twoStack.push(StackID.ONE, 2);
        System.out.println(twoStack.isEmpty(StackID.TWO));
        twoStack.push(StackID.ONE, 3);
        twoStack.push(StackID.TWO, 5);
        System.out.println(twoStack.push(StackID.TWO, 6));
        twoStack.pop(StackID.ONE);
        System.out.println(twoStack.isEmpty(StackID.ONE));
        System.out.println(twoStack.size(StackID.ONE));
        System.out.println(twoStack.size(StackID.TWO));
        System.out.println(twoStack.peek(StackID.ONE));
        System.out.println(twoStack.peek(StackID.TWO));
        Iterator<Integer> iterator = twoStack.iterator(StackID.ONE);
        System.out.println("Stack One: ");
        while (iterator.hasNext())
            System.out.println(iterator.next());
        iterator = twoStack.iterator(StackID.TWO);
        System.out.println("Stack Two: ");
        while (iterator.hasNext())
            System.out.println(iterator.next());

    }
}


