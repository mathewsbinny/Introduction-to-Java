package Chapter4;

public class ConversionBetweenStringsAndNumbers {
    public static void main(String[] args) {
        String intString = "6";
        String doubleString = "9022.44";
        int random = 88;
        int intValue = Integer.parseInt(intString);
        double doubleValue = Double.parseDouble(doubleString);
        String s = random + "";
        System.out.println(intValue);
        System.out.println(doubleValue);
        System.out.println(s);
    }
}
