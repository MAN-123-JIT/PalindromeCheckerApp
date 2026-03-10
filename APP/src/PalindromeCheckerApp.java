import java.util.Scanner;
import java.util.Stack;

public class PalindromeCheckerApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("String:");
        String input = scanner.nextLine();
        System.out.println("Palindrome?:");
        PalindromeChecker checker = new PalindromeChecker();
        System.out.println(checker.checkPalindrome(input));
        scanner.close();
    }
}

class PalindromeChecker {
    public boolean checkPalindrome(String input) {
        Stack<Character> stack = new Stack<>();
        for (char c : input.toCharArray()) {
            stack.push(c);
        }

        for (char c : input.toCharArray()) {
            if (c != stack.pop()) {
                return false;
            }
        }

        return true;
    }
}//UC11