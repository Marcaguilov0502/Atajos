import java.util.InputMismatchException;
import java.util.Scanner;

public abstract class Input {

    public static Scanner input = new Scanner(System.in);

    public static byte getByte() {
        try {
            byte sysIn = input.nextByte();
            String aux = input.nextLine();
            return sysIn;
        } catch (InputMismatchException ime) {
            String aux = input.nextLine();
            System.out.println("Valor introducido incorrecto");
            System.out.println("Escribe un numero valido: ");
            return getByte();
        }
    }

    public static short getShort() {
        try {
            short sysIn = input.nextShort();
            String aux = input.nextLine();
            return sysIn;
        } catch (InputMismatchException ime) {
            String aux = input.nextLine();
            System.out.println("Valor introducido incorrecto");
            System.out.println("Escribe un numero valido: ");
            return getShort();
        }
    }

    public static int getInt() {
        try {
            int sysIn = input.nextInt();
            String aux = input.nextLine();
            return sysIn;
        } catch (InputMismatchException ime) {
            String aux = input.nextLine();
            System.out.println("Valor introducido incorrecto");
            System.out.println("Escribe un numero valido: ");
            return getInt();
        }
    }

    public static long getLong() {
        try {
            long sysIn = input.nextLong();
            String aux = input.nextLine();
            return sysIn;
        } catch (InputMismatchException ime) {
            String aux = input.nextLine();
            System.out.println("Valor introducido incorrecto");
            System.out.println("Escribe un numero valido: ");
            return getLong();
        }
    }

    public static float getFloat() {
        try {
            String aux = input.nextLine();
            aux = aux.replace(",",".");
            float f = Float.parseFloat(aux);
            if (f > Float.MAX_VALUE) {throw new NumberFormatException();}
            return f;
        } catch (NumberFormatException ime) {
            System.out.println("Valor introducido incorrecto");
            System.out.println("Escribe un numero valido: ");
            return getFloat();
        }
    }

    public static double getDouble() {
        try {
            String aux = input.nextLine();
            aux = aux.replace(",",".");
            double d = Double.parseDouble(aux);
            if (d > Double.MAX_VALUE) {throw new NumberFormatException();}
            return d;
        } catch (NumberFormatException ime) {
            System.out.println("Valor introducido incorrecto");
            System.out.println("Escribe un numero valido: ");
            return getDouble();
        }
    }

    public static String getString() {
        try {
            String sysIn = input.nextLine();
            return sysIn;
        } catch (InputMismatchException ime) {
            System.out.println("Valor introducido incorrecto");
            System.out.println("Escribe un texto valido: ");
            return getString();
        }
    }

    public static char getChar() {
        try {
            String sysIn = input.nextLine();
            if (sysIn.length() != 1) {
                throw new  InputMismatchException();
            }
            else {
                return sysIn.charAt(0);
            }
        } catch (InputMismatchException ime) {
            System.out.println("Valor introducido incorrecto");
            System.out.println("Escribe un caracter valido: ");
            return getChar();
        }
    }

}
