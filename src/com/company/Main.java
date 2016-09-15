package com.company;
import java.util.Arrays;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
	// write your code here

        Random intGenerator = new Random();
           int add1 = intGenerator.nextInt(10);
           int add2= intGenerator.nextInt(10);
           int max = (add1>add2)? add1:add2;
           int sum = add1+add2;
           print("Add the following numbers");
           print( add1 + " + "+ add2 + " = ? ");

           int[] ints = new Random().ints(max, 18).distinct().limit(4).toArray();
           System.out.println(Arrays.toString(ints));

           // Check if the randomly generated array with 4 ints contains the result or the addition.
           //If the array doesn't contain the result then add the result by over writing element 0 and then shuffle the array.
           if (!contains(ints, sum)){
           ints[0] = sum;
           RandomizeArray(ints);
       }
        System.out.println(Arrays.toString(ints));
        printMC(ints);

// Subtraction
        int sub1 = intGenerator.nextInt(10);
        int sub2= intGenerator.nextInt(10);
        if (sub1<sub2){
            int temp= sub1;
            sub1=sub2;
            sub2=temp;
        }

        int sub = sub1 - sub2;
        print("==============================");
        print("Subtract the following numbers");
        print( sub1+ " - "+ sub2 + " = ? ");

        int[] subInts = new Random().ints(0, sub1).distinct().limit(4).toArray();
        System.out.println(Arrays.toString(subInts));

        if (!contains(subInts, sub)){
            subInts[0] = sub;
            RandomizeArray(subInts);
        }
        System.out.println(Arrays.toString(subInts));
        printMC(subInts);
    }

    private static void printMC(int[] ints){
        print("A." + ints[0]);
        print("B." + ints[1]);
        print("C." + ints[2]);
        print("D." + ints[3]);
    }

    private static void print(String message){
        System.out.println(message);
    }

    private static boolean contains(int[] array, final int key) {
        for (final int i : array) {
            if (i == key) {
                return true;
            }
        }
        return false;
    }

    private static int[] RandomizeArray(int[] array){
        Random rgen = new Random();  // Random number generator

        for (int i=0; i<array.length; i++) {
            int randomPosition = rgen.nextInt(array.length);
            int temp = array[i];
            array[i] = array[randomPosition];
            array[randomPosition] = temp;
        }
        return array;
    }
}
