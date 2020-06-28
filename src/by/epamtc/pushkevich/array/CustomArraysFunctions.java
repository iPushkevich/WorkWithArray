package by.epamtc.pushkevich.array;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class CustomArraysFunctions {
    public static void main(String[] args) {
        int[] a = new int[]{6, 3, 2, 4, 44};
        System.out.println(getSumFromMaxEvenAndMinOdd(a));
    }

    private static long getPalindromeElementsMaxSum(int[] array) {
        long maxSum = 0;
        long tmpSum;
        int lastElementIndex = array.length - 1;

        for (int i = 0; i < array.length / 2; i++) {
            tmpSum = array[i] + array[lastElementIndex - i];

            if (tmpSum > maxSum) {
                maxSum = tmpSum;
            }
        }

        return maxSum;
    }

    private static int[] getArrayWithoutMinElement(int[] array) {
        int minElement = array[0];
        int arrayLengthWithoutMin = 0;

        for (int i = 1; i < array.length; i++) {
            if (array[i] < minElement) {
                minElement = array[i];
            }
        }

        for (int element : array) {
            if (element != minElement) {
                arrayLengthWithoutMin++;
            }
        }

        int[] newArray = new int[arrayLengthWithoutMin];
        int newArrayPosition = 0;

        for (int element : array) {
            if (element != minElement) {
                newArray[newArrayPosition] = element;
                newArrayPosition++;
            }
        }

        return newArray;
    }

    private static void printSuperLockSolution() {
        Random random = new Random();
        int[] lock = new int[10];

        int firstKeyPosition = random.nextInt(10);
        int secondKeyPosition = firstKeyPosition;

        // Избегаем попадания в один индекс
        while (secondKeyPosition == firstKeyPosition) {
            secondKeyPosition = random.nextInt(10);
        }

        lock[firstKeyPosition] = (random.nextInt(6) + 1);
        lock[secondKeyPosition] = (random.nextInt(6) + 1);

        Scanner scanner = new Scanner(System.in);

        System.out.println("Input 8 numbers (range 1 - 6):");

        for (int i = 0; i < lock.length; i++) {
            if (lock[i] == 0) {
                lock[i] = scanner.nextInt();
            }
        }

        int lastElementIndex = lock.length - 1;
        boolean isKey = false;

        for (int i = 0; i < lock.length / 2; i++) {
            int firstSum = lock[i] + lock[i + 1] + lock[i + 2];
            int secondSum = lock[lastElementIndex - i] + lock[lastElementIndex - i - 1] + lock[lastElementIndex - i - 2];

            if (firstSum == 10 || secondSum == 10) {
                isKey = true;
                break;
            }
        }

        if (isKey) {
            System.out.println("Congrats! The lock is open! The key is:");
            System.out.println(Arrays.toString(lock));
        } else {
            System.out.println("Invalid key!");
        }
    }

    private static int getMinMostRepeatableElement(int[] array) {
        int mostRepeatableElement = array[0];
        int countOfMostRepeatableElements = 0;
        int tmpElement;
        int tmpCount = 0;

        Arrays.sort(array);

        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] == array[i + 1]) {
                tmpCount++;
                tmpElement = array[i];

                if (tmpCount > countOfMostRepeatableElements) {
                    countOfMostRepeatableElements = tmpCount;
                    mostRepeatableElement = tmpElement;
                }
            } else {
                tmpCount = 0;
            }
        }

        return mostRepeatableElement;
    }

    private static long getSumFromMaxEvenAndMinOdd(int[] array) {
        int maxEven = array[1];
        int minOdd = array[0];

        for (int i = 2; i < array.length; i++) {
            if (i % 2 == 0 && array[i] < minOdd) {
                minOdd = array[i];
            }
            if (i % 2 != 0 && array[i] > maxEven) {
                maxEven = array[i];
            }
        }

        return maxEven + minOdd;
    }
}


