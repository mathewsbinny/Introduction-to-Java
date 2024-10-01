package Chapter4;
import java.util.*;


public class SimpleMethodsInStringClass {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String message = "Welcome to Java.";
        String exclamation = "You are learning a lot!";
        String joined = message.concat(exclamation);
        String joined2 = message + " " + exclamation;

        System.out.println("The length of " + message + " is " + message.length());
        System.out.println("The character at index 5 in message is " + message.charAt(5));
        System.out.println(joined + "\n" + joined2);

        message += "You have just begun.";
        System.out.println(message);

        System.out.println(message.toLowerCase());
        System.out.println(message.toUpperCase());

        String whitespace = "     Haiii      ";
        System.out.println(whitespace.trim());

        //System.out.println("Enter 2 words separated by spaces: ");
        //String s1 = input.next();
        //String s2 = input.next();
        //System.out.println("String s1 is: " + s1 + "\nString s2 is: " + s2);

        System.out.println("Enter a line: ");
        String line = input.nextLine();
        System.out.println("String line is: " + line);
    }
}
