package org.example;

import java.util.Scanner;
/**
 * Клас, що представляє число Фібоначчі з його індексом та значенням.
 */
class FibonacciNumber{
    /** Індекс числа Фібоначчі (починаючи з 1) */
    private int index;
    /** Значення числа Фібоначчі */
    private long value;
    /**
     * Конструктор для створення числа Фібоначчі.
     *
     * @param index Індекс числа у послідовності Фібоначчі.
     * @param value Значення числа Фібоначчі.
     */
    public FibonacciNumber(int index, long value){
        this.index = index;
        this.value = value;
    }
    /**
     * Повертає індекс числа Фібоначчі.
     *
     * @return Індекс числа.
     */
    public int getIndex() {
        return index;
    }
    /**
     * Повертає значення числа Фібоначчі.
     *
     * @return Значення числа.
     */
    public long getValue() {
        return value;
    }
    /**
     * Перевіряє, чи можна представити число Фібоначчі у вигляді w^3 + 1.
     *
     * @return true, якщо число можна записати як куб плюс одиниця, інакше false.
     */
    public boolean cubePlusOne() {
        long w= Math.round(Math.cbrt(value - 1));
        return w * w * w+1==value;
    }

}
/**
 * Головний клас програми для роботи з числами Фібоначчі.
 */
public class Main {

    /**
     * Основний метод, що запускає програму.
     * Програма:
     * 1. Зчитує кількість чисел Фібоначчі з клавіатури.
     * 2. Генерує масив об'єктів FibonacciNumber.
     * 3. Виводить усі числа Фібоначчі.
     * 4. Виводить числа Фібоначчі, що можна представити як w^3 + 1.
     *
     * @param args Аргументи командного рядка (не використовуються).
     */
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Введіть кількість чисел Фібоначчі: ");
        int n = sc.nextInt();
        FibonacciNumber[] numbers = new FibonacciNumber[n];
        int a=1, b=1;
        // Генерація чисел Фібоначчі
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
        // Вивід усіх чисел Фібоначчі
        System.out.println("Числа Фібоначі:");
        for(FibonacciNumber num : numbers){
            System.out.println("["+num.getIndex()+"]="+num.getValue());
        }
        // Вивід чисел виду w^3 + 1
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