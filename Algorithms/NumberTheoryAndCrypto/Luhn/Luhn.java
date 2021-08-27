import java.util.*;

public class Luhn {
    public static void main(String[] args) {
        String valid = "5103071501535807";
        String invalid = "3534932892389328";

        System.out.println(checkLuhn(valid));
        System.out.println(checkLuhn(invalid));
    }

    private static boolean checkLuhn(String purportedCC) {
        int length = purportedCC.length();
        int sum = purportedCC.charAt(length - 1) - '0';
        int parity = length % 2;

        for (int i = 0; i < length - 1; i++) {
            int digit = purportedCC.charAt(i) - '0';
            
            if (i % 2 == parity) {
                digit *= 2;
            }
            
            if (digit > 9) {
                digit -= 9;
            }
            
            sum += digit;
        }

        return sum % 10 == 0;
    }
}
