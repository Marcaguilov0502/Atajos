import java.util.Scanner;

public abstract class Input {

    public static Scanner input = new Scanner(System.in);

    public static byte getByte() {
        byte sysIn = input.nextByte();
        String aux = input.nextLine();
        return sysIn;
    }

    public static short getShort() {
        short sysIn = input.nextShort();
        String aux = input.nextLine();
        return sysIn;
    }

    public static int getInt() {
        int sysIn = input.nextInt();
        String aux = input.nextLine();
        return sysIn;
    }

    public static long getLong() {
        long sysIn = input.nextLong();
        String aux = input.nextLine();
        return sysIn;
    }

    public static float getFloat() {
        float sysIn = input.nextFloat();
        String aux = input.nextLine();
        return sysIn;
    }

    public static double getDouble() {
        Double sysIn = input.nextDouble();
        String aux = input.nextLine();
        return sysIn;
    }

    public static String getString() {
        String sysIn = input.nextLine();
        return sysIn;
    }

}
