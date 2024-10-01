package Chapter4;

public class ComparisonMethodsInStringClass {
    public static void main(String[] args) {
        String s1 = "apple";
        String s2 = "apple";
        String s3 = "APPLE";
        String s4 = "applesauce";

        System.out.println(s1.equals(s2)); // cannot use the == operator to compare strings bc it only checks if referring to same object
        System.out.println(s1.equalsIgnoreCase(s3));
        System.out.println(s1.compareTo(s4)); //compares in terms of unicode ordering, good for putting things in alphabetical ordering
        System.out.println(s1.compareToIgnoreCase(s3));
        System.out.println(s4.startsWith("app"));
        System.out.println(s4.endsWith("uce"));
        System.out.println(s4.contains(s1));
        System.out.println(s1.equals("apple") + " answer");

        String message = "Welcome to Java";
        //message = message.substring(0,11) + "HTML";
        System.out.println(message.substring(0,11) + "HTML");
        System.out.println(message.substring(11));

    }
}
