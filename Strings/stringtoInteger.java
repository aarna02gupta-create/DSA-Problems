public class stringtoInteger {
    public static int myAtoi(String s) {
        int i = 0;
        int n = s.length();
        int sign = 1;
        int num = 0; // plain int now

        // Phase 1: skip spaces
        while (i < n && s.charAt(i) == ' ') {
            i++;
        }

        // Phase 2: read sign
        if (i < n && (s.charAt(i) == '+' || s.charAt(i) == '-')) {
            sign = (s.charAt(i) == '-') ? -1 : 1;
            i++;
        }

        // Phase 3: read digits
        while (i < n && Character.isDigit(s.charAt(i))) {
            int digit = s.charAt(i) - '0';

            // Phase 4: check BEFORE multiplying
            if (num > Integer.MAX_VALUE / 10 ||
                    (num == Integer.MAX_VALUE / 10 && digit > 7)) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }

            num = num * 10 + digit;
            i++;
        }

        return sign * num;
    }

    public static void main(String[] args) {
        String[] tests = {
                "42",
                "   -42",
                "4193 with words",
                "words and 987",
                "-91283472332",
                "2147483648",
                "-2147483648",
                "   ",
                "+1",
                "00123"
        };

        for (String t : tests) {
            System.out.println("\"" + t + "\" -> " + myAtoi(t));
        }
    }
}