package org.example;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

public class Lab2 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

//        1.Write a program to find all of the longest word in a given dictionary.

        String [] array = { "cat", "dog", "red", "is", "am" };
        System.out.println("Original Array: " + Arrays.toString(array));

         longestWord(array);



        System.out.println("\n------------------------");

//        2. Write a program that displays the number of occurrences of an element in the array.

        int[] arrNums1 = {1, 1, 1, 3, 3, 5};
        System.out.println("Original Array: " + Arrays.toString(arrNums1));

        System.out.println("Enter any number to check how many times this number occurrences in the array: ");
        int userNumber = scanner.nextInt();
        scanner.nextLine();

        int count= 0;
        for(int i = 0; i < arrNums1.length; i++){

           if(arrNums1[i] == userNumber) {
               count++;
           }
        }
        System.out.println(userNumber + " occurs " + count + " times.");


        System.out.println("------------------------");
//
//        3.Write a program to find the k largest elements in a given array. Elements in the array can be in
//        any order.

        Integer [] arrNums2 = {1, 4, 17, 7, 25, 3, 100};
        System.out.println("Original Array: " + Arrays.toString(arrNums2));

        System.out.println("Enter the value of K: ");
        int k = scanner.nextInt();
        scanner.nextLine();

        Arrays.sort(arrNums2, Collections.reverseOrder());

        System.out.println(k + " largest elements of the said array are:");
        for(int i = 0; i < k; i++){
            System.out.print(arrNums2[i] + " ");
        }

        System.out.println("\n------------------------");


        //  4. Create a method to reverse an array of integers. Implement the method without creating a new array.

        int[] arrNums3 = {5, 4, 3, 2, 1};
        System.out.println("Original Array: " + Arrays.toString(arrNums3));

        System.out.println("Reversed Array: " + Arrays.toString(revArray(arrNums3)));


        System.out.println("------------------------");

  //      5. Write a menu driven Java program with following option:
//
//        1. Accept elements of an array
//        2. Display elements of an array
//        3. Search the element within array
//        4. Sort the array  5. To Stop the size of the array should be
//        entered by the user.

        System.out.println("Enter size of array: ");
        int size = scanner.nextInt();
        int [] arrNums4 = new int [size];
        boolean isFilled = false;

        while(true) {
            System.out.println("Menu: ");
            System.out.println("1. Accept elements of an array");
            System.out.println("2. Display elements of an array");
            System.out.println("3. Search the element within array");
            System.out.println("4. Sort the array");
            System.out.println("5. To Stop");

            System.out.println("Please, choose one of these options: ");

            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    System.out.println("Please, fill the array with elements: ");
                    for (int i = 0; i < size; i++) {
                        arrNums4[i] = scanner.nextInt();
                    }
                    System.out.println("Array is now filled with elements!");
                    isFilled = true;
                    break;

                case 2:
                    if (isFilled) {
                        for (int number : arrNums4) {
                            System.out.print(number + " ");
                        }
                    } else {
                        System.out.println("Please, enter the elements first");
                    }
                    break;

                case 3:
                    System.out.println("Enter the element to search for it: ");
                    if(isFilled) {
                        int element = scanner.nextInt();
                        for (int i = 0; i < size; i++) {

                            if (arrNums4[i] == element) {
                                System.out.println("The element " + element + " appears in the index " + i);
                            } else {
                                System.out.println("Sorry!, the element you are search for it is not found in this array");
                            }

                        }
                    }else System.out.println("You must fill the array with elements!");

                    break;

                case 4:
                    System.out.println("Array before sort: " + Arrays.toString(arrNums4));

                    Arrays.sort(arrNums4);
                    System.out.println("Array after sort: " + Arrays.toString(arrNums4));
                    break;


                case 5:
                    System.out.println("You are stopped the program, good bye!");
                    break;

                default:
                    System.out.println("Please, enter a correct option from 1 - 5");
            }
            if (option == 5) {
                break;
            }
        }

        System.out.println("--------------------------------------");

//        6. Create a method that generates a random number within a given range. Allow the user to
//        specify the range and call the method to display random numbers.

        System.out.print("Enter the minimum value of the range: ");
        int min = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter the maximum value of the range: ");
        int max = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter the number of random numbers to generate: ");
        int randNum = scanner.nextInt();
        scanner.nextLine();

        System.out.println("numbers within the specified range: ");

        for (int i = 0; i < randNum; i++) {
            System.out.print(generateRandom(min, max) + " ");
        }



        System.out.println("\n------------------------");

//        7. Write a program that checks the strength of a password. Create a method that evaluates a
//        password based on criteria like length, inclusion of special characters, and
//        uppercase/lowercase letters.

        System.out.println("Enter a password to check if it is a strong or weak: ");
        String pass = scanner.nextLine();
        scanner.nextLine();

        int lengthPoints = checkLength(pass);


        int charPoints = checkSpecialCharacters(pass);


        int lettersPoints = checkUpperCaseLowerCase(pass);


        int totalScore = lengthPoints + charPoints + lettersPoints;

        if(totalScore >= 8){
            System.out.println("Password is strong.");

        }else if(totalScore >= 5 && totalScore < 8){
            System.out.println("Password is moderate.");

        }else System.out.println("Password is weak.");


        System.out.println("------------------------");

//        8. Create a method that generates the Fibonacci sequence up to a specified number of terms.
//                Hint: The Fibonacci sequence is a mathematical sequence of numbers that starts with 0 and 1,
//                and each subsequent number in the sequence is the sum of the two preceding ones.


        System.out.print("Enter the number of Fibonacci terms to generate: ");
        int numF = scanner.nextInt();
        scanner.nextLine();

        Fibonacci(numF);


        System.out.println("\n------------------------");




    }




////////////////////////////////////////////////////////////////////////

    public static void longestWord(String [] arr){

        int longest = Integer.MIN_VALUE;

        for(int i = 0; i < arr.length; i++){

         if(arr[i].length() > longest)
             longest = arr[i].length();

        }
        for(String word : arr){

            if(word.length() == longest){
                System.out.print(word + " ");
            }
        }


     }


    ////////////////////////////////////////////////////////////////////////

    public static int[] revArray(int[] array) {


        for (int i =0; i < array.length / 2; i++) {

            int store = array[0];
            array[0] = array[array.length - 1];
            array[array.length - 1] = store;

        }

        return array;
    }
////////////////////////////////////////////////////////////////////////

    public static int generateRandom(int min, int max) {

        Random random = new Random();

        return random.nextInt(max - min) + min;

    }

    ////////////////////////////////////////////////////////////////////////

    public static int checkLength(String pass) {

        int points = 0;

        if (pass.length() <= 5) {
            points = 0;

        } else if (pass.length() >= 6 && pass.length() <= 7) {
            points += 2;

        } else {
            points += 3;
        }

        return points;
    }

    ////////////////////////////////////////////////////////////////////////


    public static int checkSpecialCharacters(String pass) {

        Pattern charPatt = Pattern.compile("[a-zA-Z0-9]*");
        Matcher matchPass = charPatt.matcher(pass);

        int points = 0;

        if (!matchPass.matches()) {
            points += 2;

        } else {
            points += 0;
        }
        return points;
    }

    ////////////////////////////////////////////////////////////////////////


    public static int checkUpperCaseLowerCase(String pass) {

        int points = 0;
        boolean contUpper = false;
        boolean contLower = false;

            for (int i = 0; i < pass.length(); i++) {

                char ch = pass.charAt(i);
                if(Character.isUpperCase(ch)){
                    contUpper = true;

                }else {
                    contLower = true;
                }
            }
            if(contUpper && contLower)
                return points +=3;


            return 0;
    }


    ////////////////////////////////////////////////////////////////////////

    public static void Fibonacci(int num){

        int num1 = 0;
        int num2 = 1;

        for(int n = 0; n < num; n++){

            System.out.print(num1 + " ");

            int num3 = num2 + num1;
            num1 = num2;
            num2 = num3;
        }


    }









}