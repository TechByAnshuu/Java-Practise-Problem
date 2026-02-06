import java.util.Scanner;
public class Practice {
    // public static void main(String[] args){
    //     Scanner sc = new Scanner(System.in);
    //     System.out.println("Enterd the name: " );
    //     String name = sc.nextLine();
    //     System.out.println("enterse name: " + name);


    // }
    // public static void main(String[] args){
    //     Scanner sc = new Scanner(System.in);
    //     float b = sc.nextFloat();
    //     float a = sc.nextFloat();
    //     System.out.println("Enter the number1: " + b);
    //     System.out.println("Enter the number2: " + a);
    //     // float a = 1.4f;
    //     // float b = 7.5f;
    //     float p = a*b;

    //     System.out.println(" multiplied number: " + p  );

    //     sc.close();
    // }

    //     public static void main(String[] args){
    //     Scanner sc = new Scanner(System.in);
    //     int a = 9;
    //     int b= 5;
    //     int swap = sc.nextInt();
    //     if(a>b){
    //         System.out.println(b = a);
    //     }else{
    //         System.out.println(a = b);
    //     }

    //     
    // sc.close();
    // }


    // public static void main(String[] args){
    //     Scanner sc = new Scanner(System.in);
    //     int a=sc.nextInt();
    //     for(int i =0; i<a; i++){
    //         System.out.println("The number is: " + i);
    //         if(i%2 == 0){
    //             System.out.print("Even number: " + i);
    //         }else{
    //             System.out.print("Odd number: " + i);
    //     }
    //     }
    //     sc.close();
        


    // }

    // public static void main(String[] args){
    //     Scanner sc  = new Scanner(System.in);
    //     int n = sc.nextInt();

    //     System.out.print("Even = ");
    //     for(int i = 0;i<n;i++){
    //         if( i % 2==0 ){
    //             System.out.print(" " + i);
    //         }
    //     }
    //     System.out.print("odd");
    //     for(int i = 0;i<n;i++){
    //         if( i % 2 != 0){
    //             System.out.print(" " + i);
    //         }
    //     }
    //     sc.close();
    // }


    // taking bitwise and of n with 1 USING Bitwise AND Operator - O(1) Time and O(1) Space
//     public static boolean isEven(int n)
//     {
         
//         if ((n & 1) == 0)
//             return true;
//         else
//             return false;
//     }
    
//     public static void main(String[] args)
//     {
//         int n = 12;
//         if (isEven(n) == true)
//             System.out.print("true");
//         else
//             System.out.print("false");
//     }
// }

    // import java.util.Scanner;

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }

    static Node insertAtPosition(Node head, int pos, int d) {
        Node newNode = new Node(d);

        if (pos == 1) {
            newNode.next = head;
            return newNode;
        }

        Node temp = head;

        for (int i = 1; i < pos - 1 && temp != null; i++) {
            temp = temp.next;
        }

        if (temp == null) return head;

        newNode.next = temp.next;
        temp.next = newNode;

        return head;
    }

    static void print(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Node head = null;

        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            int val = sc.nextInt();
            int pos = sc.nextInt();
            head = insertAtPosition(head, pos, val);
        }

        print(head);
        sc.close();
    }
}


    
}



 