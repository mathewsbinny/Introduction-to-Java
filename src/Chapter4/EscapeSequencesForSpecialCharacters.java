package Chapter4;

public class EscapeSequencesForSpecialCharacters {
    public static void main(String[] args) {
        //using an escape sequence \ to notate special characters. \u03b1 for example would notate a Unicode character.
        System.out.println("He said \"Java is fun\"");
        System.out.println("He said \b\b\b\b\b You are lame."); // /b is for the backspace
        System.out.println("He said \t You are mad."); // tab
        System.out.println("He said \n You are sad."); // linefeed, move one line forward
        System.out.println("He said \f You are blue."); // formfeed, page/section separator
        System.out.println("He said \r You are cool."); // carriage return
        // backslash denoted by \\
        // double quote in string denoted by \"
    }
}
