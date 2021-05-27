import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        ArrayList<String> testMenu = new ArrayList<>(Arrays.asList("1234567891", "Comer", "Dormir", "Correr", "Saltar", "Crear", "Borrar", "Pelear", "Gritar", "Bailar", "Estornuda"));
        Menu test = new Menu("main menu", testMenu, "12345678910", "Exit");
        test.execute();

    }

}
