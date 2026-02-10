import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;
public class Practice {
    // public static void main(String[] args){
    //     Scanner sc = new Scanner(System.in);
    //     System.out.println("Enterd the name: " );
    //     String name = sc.nextLine();
    //     System.out.println("enterse name: " + name);


    // }
    // public static void main(String[] args){
    //     float a = 1.5f;

    //     float b = 2.5f;
    //     System.out.println("Enter the number1: " + a);
    //     System.out.println("Enter the number2: " + b);
    //     // float a = 1.4f;
    //     // float b = 7.5f;
    //     float p = a*b;

    //     System.out.println(" multiplied number: " + p  );

    // }


    public static void main(String[] args) {
        int[] arr = {4, 8, 2, 5, 1, 2};
        int n = arr.length;

        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {

            // remove smaller or equal elements
            while (!stack.isEmpty() && stack.peek() <= arr[i]) {
                stack.pop();
            }

            // if stack empty → no greater element
            result[i] = stack.isEmpty() ? -1 : stack.peek();

            // push current element
            stack.push(arr[i]);
        }

        System.out.println(Arrays.toString(result));
    }

// another method do with suppose the array are reolace to th  -1 and then compre with the values of array with 

import java.util.*;

public class Main {
    public static void main(String[] args) {

        int[] arr = {4, 8, 2, 5, 1, 2};
        int n = arr.length;

        int[] result = new int[n];

        // Step 1: fill with -1
        Arrays.fill(result, -1);

        // Step 2: compare with right side
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (arr[j] > arr[i]) {
                    result[i] = arr[j];
                    break; // stop at first greater
                }
            }
        }

        System.out.println(Arrays.toString(result));
    }
}




}




