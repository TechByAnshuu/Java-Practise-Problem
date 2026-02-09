// Every line of code that runs in Java must be inside a class. The class name should always start with an uppercase first letter. 
// In our example, we named the class Main.

// Note: Java is case-sensitive. MyClass and myclass would be treated as two completely different names.

// The main Method

// The main() method is required in every Java application. It is the entry point of any Java program. When the program is executed, the statements inside the main() method are executed.

public static void main(String[] args)


// *System.out.println()* Inside the main() method, we can use the println() method to print a line of text to the screen:

public static void main(String[] args) {
  System.out.println("Hello World");
}

// Note: The curly braces {} mark the beginning and the end of a block of code.

// System.out.println() may look long, but you can think of it as a single command that means: "Send this text to the screen."

// Here's what each part means (you will learn the details later):

// System - built-in Java class.
// out is a member of System, short for "output".
// println() is a method, short for "print line".
// Finally, remember that each Java statement must end with a semicolon (;).


// Java Comments
// Comments can be used to explain Java code, and to make it more readable. It can also be used to prevent execution when testing alternative code.

// Single-line Comments
// Single-line comments start with two forward slashes (//).
    // This is a comment
    System.out.println("Hello World");

// Java Multi-line Comments
// Multi-line comments start with /* and ends with */.

// Any text between /* and */ will be ignored by Java.
    /* This is a
       multi-line comment */
    System.out.println("Hello World");    


//     Java Variables
// Variables are containers for storing data values.

// In Java, there are different types of variables, for example:

// String - stores text, such as "Hello". String values are surrounded by double quotes
// int - stores integers (whole numbers), without decimals, such as 123 or -123
// float - stores floating point numbers, with decimals, such as 19.99 or -19.99
// char - stores single characters, such as 'a' or 'B'. Char values are surrounded by single quotes
// boolean - stores values with two states: true or false

// Example String
// Create a variable called name of type String and assign it the value "John".
// Then we use println() to print the name variable:

String name = "John";
System.out.println(name);

To create a variable that should store a number, you can use int:

// Example INT
// Create a variable called myNum of type int and assign it the value 15:

int myNum = 15;
System.out.println(myNum);


// java variables example

String studentName = "Ramesh";
int studentId = 5678; 
int studentAge = 21;
float studentFee = 44.4f;
char studentGrade = 'B';
boolean studentPass = true;

System.out.println( "Student name:" + studentName);
System.out.println("Student Id:" + studentId);
System.out.println("Student age:" + studentAge);
System.out.println("Student fee:" + studentFee);
System.out.println("Student Grade:" + StudentGrade);


// Java Data Types
// Primitive data types -: 
// includes byte, short, int, long, float, double, boolean and char
// Non-primitive data types -: 
// such as String, Arrays and Classes 

Data Type    Description
byte      -  stores whole numbers from -128 to 127
short     -             "              -32768 to 32,767
int       -             "              -2,147,483,648 to 2,147,483,647
long      -             "              -9,223,372,036,854,775,808 to 9,223,372,036,854,775,807
float     -   Stores fractional numbers. Sufficient for storing 6 to 7 decimal digits
double    -   Stores fractional numbers. Sufficient for storing 15 to 16 decimal digits
boolean   -   Stores true or false values
char	  -   Stores a single character/letter or ASCII values


// POINTS ->> The last bit of all odd numbers is always 1, while for even numbers its 0. So, 
//          when performing bitwise AND operation with 1, odd numbers give 1, and even numbers give 0.

// Note: Bitwise operators are extremely fast and efficient because they operate directly at the binary level, making them significantly faster than arithmetic or logical operations.