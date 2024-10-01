package Chapter25;

import java.util.Scanner;

public class Question2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a string: ");


        //to find the time it took to run the program
        String s = input.next();
        long start = System.nanoTime();

        //call and print the maxSubstr
        System.out.println(maxSubstr(s));
        long end = System.nanoTime();

        System.out.println("Time " + (end - start) / 1.0e6 + " ms ");
    }
    public static String maxSubstr(String s) {
        int[] max = new int[s.length()];
        int[] pre = new int[s.length()];
        for(int i = 0; i < s.length(); i++) {
            pre[i] = -1;
            for(int j = i - 1; j >= 0; j--) {
                if (s.charAt(i) > s.charAt(j) && max[i] < max[j] + 1) {
                    max[i] = max[j] + 1;
                    pre[i] = j;
                }
            }
        }
        int maxL = max[0];
        int index = 0;
        for(int i = 0; i < s.length(); i++) {
            if (maxL < max[i])
            {
                maxL = max[i];
                index = i;
            }
        }
        char[] chars = new char[maxL + 1];//
        int i = maxL;
        while (index != -1) {
            chars[i] = s.charAt(index);
            i--;
            index = pre[index];
        }
        return new String(chars);
    }
}



