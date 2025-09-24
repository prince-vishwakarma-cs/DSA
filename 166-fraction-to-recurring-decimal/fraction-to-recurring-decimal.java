class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) return "0";
        StringBuilder result = new StringBuilder();

        if ((numerator < 0) ^ (denominator < 0)) {
            result.append("-");
        }
        long num = Math.abs((long) numerator);
        long den = Math.abs((long) denominator);
        // Adding integer part
        result.append(num / den);
        long remainder = num % den;
        if (remainder == 0) return result.toString();

        // Decimal Part
        result.append(".");
        // Map to store the indices in string for previous calculated answers for a remainder
        Map<Long, Integer> map = new HashMap<>();
        while (remainder != 0) {
            if (map.containsKey(remainder)) {
                int idx = map.get(remainder);
                result.insert(idx, "(");
                result.append(")");
                break;
            }
            map.put(remainder, result.length());

            remainder *= 10;
            result.append(remainder / den);
            remainder %= den;
        }

        return result.toString();
    }
}