package main;

import util.MovingAverage;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the Window Size: ");
        int windowSize = scanner.nextInt();
        MovingAverage<Float> slidingWindow = new MovingAverage<>(windowSize);
        while (true) {
            System.out.print("Enter Value: ");
            float value = scanner.nextFloat();
            slidingWindow.add(value);
            if (slidingWindow.size() >= windowSize) {
                System.out.println("Average is = " + slidingWindow.mean());
            }
        }
    }
}