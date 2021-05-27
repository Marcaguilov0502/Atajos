public abstract class Misc {

    //Methods

    public static String uppercaseFirst(String str) {

        str = str.substring(0, 1).toUpperCase() + str.substring(1);

        return str;
    }

    public static int numberOfDigits(long number) {
        int digits = Long.toString(Math.abs(number)).length();
        return digits;
    }

    public static int max(int[] numbers) {
        int max = 0;
        for (int n : numbers) {
            max = Integer.max(max, n);
        }
        return max;
    }
}
