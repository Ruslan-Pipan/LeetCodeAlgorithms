package com.leetCode.algorithms.easy;

public class FizzBuzz {
    public static void withIf(){
        for (int i = 1; i <= 100; i++) {

            if ( i%3 == 0){
                System.out.print("Fizz");
            }

            if (i%5 == 0){
                System.out.print("Buzz");
            }

            if (i%5 != 0 && i%3 != 0){
                System.out.print(i);
            }

            System.out.print(",");
        }
    }

    public static void main(String[] args) {
        withIf();
    }
}
