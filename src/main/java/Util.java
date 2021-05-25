public class Util {

    //Methods

    public static String uppercaseFirst(String str) {

        str = str.substring(0, 1).toUpperCase() + str.substring(1);

        return str;
    }
}
