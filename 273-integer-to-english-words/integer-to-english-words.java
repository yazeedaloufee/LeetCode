class Solution {
    String[] ones = new String[] {
        "Zero",
        "One",
        "Two",
        "Three",
        "Four",
        "Five",
        "Six",
        "Seven",
        "Eight",
        "Nine",
        "Ten",
        "Eleven",
        "Twelve",
        "Thirteen",
        "Fourteen",
        "Fifteen",
        "Sixteen",
        "Seventeen",
        "Eighteen",
        "Nineteen"
    };
    String[] tens = new String[] {
        "",
        "",
        "Twenty",
        "Thirty",
        "Forty",
        "Fifty",
        "Sixty",
        "Seventy",
        "Eighty",
        "Ninety"
    };

    public String numberToWords(int num) {
        StringBuilder sb = new StringBuilder();

        if (num >= 1000000000) {
            int temp = num / 1000000000;
            sb.append(ones[temp] + " Billion");
            String s = numberToWords(num % 1000000000);
            if (s.length() != 0 && !s.equals("Zero"))
                sb.append(" " + s);
        } else if (num >= 1000000) {
            int temp = num / 1000000;
            sb.append(numberToWords(temp) + " Million");

            String s = numberToWords(num % 1000000);
            if (s.length() != 0 && !s.equals("Zero"))
                sb.append(" " + s);
        } else if (num >= 1000) {
            int temp = num / 1000;
            sb.append(numberToWords(temp) + " Thousand");
            String s = numberToWords(num % 1000);
            if (s.length() != 0 && !s.equals("Zero"))
                sb.append(" " + s);
        } else if (num >= 100) {
            int temp = num / 100;
            sb.append(numberToWords(temp) + " Hundred");
            String s = numberToWords(num % 100);
            if (s.length() != 0 && !s.equals("Zero"))
                sb.append(" " + s);
        } else if (num >= 20) {
            int temp = num / 10;
            sb.append(tens[temp]);
            String s = numberToWords(num % 10);
            if (s.length() != 0 && !s.equals("Zero"))
                sb.append(" " + s);

        } else if (num >= 0) {
            sb.append(ones[num]);
        } else {
            return "";
        }
        return sb.toString();
    }

}