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
    public boolean CubeplusOne() {
        long w= Math.round(Math.cbrt(value - 1));
        return w * w * w+1==value;
    }
}
public class Main {

    public static void main(String[] args){
        System.out.println("\n\t");

    }

}