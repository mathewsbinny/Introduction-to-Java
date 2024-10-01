package Chapter4;

public class SubstringMethodsInStringClass {
    public static void main(String[] args) {
        String message = "Welcome to Java";
        //message = message.substring(0,11) + "HTML";
        System.out.println(message.substring(0,11) + "HTML");
        System.out.println(message.substring(11));
        System.out.println(message.indexOf('e'));
        System.out.println(message.indexOf('e',2));
        System.out.println(message.indexOf("Java"));
        System.out.println(message.lastIndexOf('e'));
        System.out.println(message.lastIndexOf("ome"));
    }
}
