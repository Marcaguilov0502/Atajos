import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        ArrayList<String> testMenu = new ArrayList<>(Arrays.asList(""));
        Menu test1 = new Menu("0", testMenu, "".repeat(50), "");
        Menu test2 = new Menu("1", testMenu, "x".repeat(50), "");
        Menu test3 = new Menu("00", testMenu, "".repeat(50), "");
        Menu test4 = new Menu("11", testMenu, "x".repeat(50), "");
        System.out.println(test1.header());
        System.out.println(test2.header());
        System.out.println(test3.header());
        System.out.println(test4.header());

    }

}
