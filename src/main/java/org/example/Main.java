package org.example;

import java.util.Scanner;

class FibonacciNumber{
    private int index;
    private long value;
    public FibonacciNumber(int index, long value){
        this.index = index;
        this.value = value;
    }
    public int getIndex() {
        return index;
    }
    public long getValue() {
        return value;
    }
    public boolean cubePlusOne() {
        long w= Math.round(Math.cbrt(value - 1));
        return w * w * w+1==value;
    }

}

public class Main {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Введіть кількість чисел Фібоначчі: ");
        int n = sc.nextInt();
        FibonacciNumber[] numbers = new FibonacciNumber[n];
        int a=1, b=1;
        for(int i=0;i<n;i++){
            if(i==0 || i==1){
                numbers[i] = new FibonacciNumber(i+ 1, 1);
            }
            else{
                int c = a + b;
                numbers[i]= new FibonacciNumber(i+1, c);
                a=b;
                b=c;
            }
        }
        System.out.println("Числа Фібоначі:");
        for(FibonacciNumber num : numbers){
            System.out.println("["+num.getIndex()+"]="+num.getValue());
        }
        System.out.println("\nЧисла Фібоначчі виду w^3+1:");
        boolean found = false;
        for (FibonacciNumber num : numbers) {
            if (num.cubePlusOne()) {
                System.out.println("[" + num.getIndex() + "] = " + num.getValue());
                found = true;
            }
        }
        if (!found) {
            System.out.println("Немає таких чисел серед перших " + n + " чисел Фібоначчі.");
        }

    }

}