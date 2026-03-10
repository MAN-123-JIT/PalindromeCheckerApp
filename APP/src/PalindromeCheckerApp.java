public class PalindromeCheckerApp {

    public static void main(String[] args) {

        String input = "level";

        PalindromeStrategy stackStrategy = new StackStrategy();
        PalindromeStrategy reverseStrategy = new ReverseStrategy();

        long start1 = System.nanoTime();
        boolean result1 = stackStrategy.check(input);
        long end1 = System.nanoTime();

        long start2 = System.nanoTime();
        boolean result2 = reverseStrategy.check(input);
        long end2 = System.nanoTime();

        System.out.println("Input : " + input);

        System.out.println("\nStack Strategy:");
        System.out.println("Is Palindrome? : " + result1);
        System.out.println("Execution Time : " + (end1 - start1) + " ns");

        System.out.println("\nReverse Strategy:");
        System.out.println("Is Palindrome? : " + result2);
        System.out.println("Execution Time : " + (end2 - start2) + " ns");
    }
}

interface PalindromeStrategy {
    boolean check(String input);
}

class StackStrategy implements PalindromeStrategy {

    public boolean check(String input) {

        if (input == null) return false;

        java.util.Stack<Character> stack = new java.util.Stack<>();

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
}

class ReverseStrategy implements PalindromeStrategy {

    public boolean check(String input) {

        if (input == null) return false;

        String reversed = new StringBuilder(input).reverse().toString();

        return input.equals(reversed);
    }
}