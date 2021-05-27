import java.util.ArrayList;

public class Menu {


    //Attributes


    private String name;
    private ArrayList<String> optionList;
    private String question;
    private String exit;
    private int size;


    //Constructors


    //Empty
    public Menu() {
    }

    //Basic
    public Menu(String name, ArrayList<String> optionList) {
        setName(name);
        setOptionList(optionList);
        setQuestion("Que accion deseas realizar?");
        setExit("Salir");
        setSize();
    }

    //With parameters
    public Menu(String name, ArrayList<String> optionList, String question, String exit) {
        setName(name);
        setOptionList(optionList);
        setQuestion(question);
        setExit(exit);
        setSize();
    }

    //Copy
    public Menu(Menu original) {
        setName(original.getName());
        setOptionList(original.getOptionList());
        setQuestion(original.getQuestion());
        setExit(original.getExit());
        setSize();
    }


    //Getters and Setters


    public String getName() {
        return name.toUpperCase();
    }

    public void setName(String name) {
        this.name = name.toUpperCase();
    }
    public ArrayList<String> getOptionList() {
        return optionList;
    }

    public void setOptionList(ArrayList<String> optionList) {
        this.optionList = optionList;
    }
    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }
    public String getExit() {
        return exit;
    }

    public void setExit(String exit) {
        this.exit = exit;
    }
    public int getSize() {
        return size;
    }

    public void setSize() {

        int[] lengthsList = new int[optionList.size() + 3];

        lengthsList[0] = name.length();
        lengthsList[1] = question.length();
        lengthsList[2] = exit.length() + 1;
        for (int i = 3; i < (optionList.size() + 3); i++) {
            lengthsList[i] = optionList.get(i-3).length() + Misc.numberOfDigits(i);
        }

        this.size = Misc.max(lengthsList) + 10;
    }


    //ToString


    @Override
    public String toString() {

        String string = "";

        string = string.concat("┌" + horitzonalLine() +                              "┐\n");
        string = string.concat("│ " + name + relativeSpace(name) +            "       │\n");
        string = string.concat("├" + horitzonalLine() +                              "┤\n");
        string = string.concat("│ " + question + relativeSpace(question) +    "       │\n");
        string = string.concat("│ " + relativeSpace("") +                 "       │\n");
        for (int i = 0; i < optionList.size(); i++) {
            string = string.concat(printOption(optionList.get(i), i));
        }
        string = string.concat("│ " + relativeSpace("") +                 "       │\n");
        string = string.concat("│   [0] - " + exit + relativeSpace(exit,1)  +  "│\n");
        string = string.concat("│ " + relativeSpace("") +                 "       │\n");
        string = string.concat("└" + horitzonalLine() +                              "┘");
        return string;
    }


    //Methods


    public int execute() {

        System.out.println(this);

        int nOpciones = optionList.size();

        System.out.print("Escribe el numero: ");

        int option = Input.getInt();
        while (option > nOpciones || option < 0) {
            System.out.println("\nEsa opcion no existe");
            System.out.print("Escribe una opcion que exista: ");
            option = Input.getInt();
        }
        return option;
    }

    public String relativeSpace(String str) {
        return " ".repeat(size - str.length());
    }

    public String relativeSpace(String str, int index) {
        int a = size;
        int b = str.length();
        int c = Misc.numberOfDigits(index+1);
        int x = a - (b + c);
        return " ".repeat(x);
    }

    public String horitzonalLine() {
        return "─".repeat(size + 8);
    }

    public String printOption(String option, int index) {
        return ("│   [" + (index + 1) + "] - " + option + relativeSpace(option, index) + "│\n");
    }
}
/*
public abstract class Menu {


    //Attributes (options of each menu)


    public static ArrayList<String> mainMenu = new ArrayList<>(Arrays.asList(
            "Insertar jugador",
            "Crear alineacion",
            "Consultar alineacion"
    ));
    public static ArrayList<String> testMenu = new ArrayList<>(Arrays.asList("Hello", "Bye"));


    //Methods


    //Menu printer
    @Deprecated
    public static void print(ArrayList<String> opciones) {

        System.out.println("\n".repeat(10));

        String m = "\uD835\uDDE0\uD835\uDDD8\uD835\uDDE1\uD835\uDDE8 ";

        System.out.println("┌─────────────────────────────────────────────────┐");
        System.out.println("│ " + m + "                                           │");
        System.out.println("├─────────────────────────────────────────────────┤");
        System.out.println("│ Que accion desea realizar?                      │");
        System.out.println("│                                                 │");
        for (int i = 0; i < opciones.size(); i++) {
            System.out.println("│   [" + (i + 1) + "] - " + opciones.get(i) + " ".repeat(41 - (opciones.get(i).length() + String.valueOf(i).length())) + "│");
        }
        System.out.println("│                                                 │");
        System.out.println("│   [0] - Salir                                   │");
        System.out.println("│                                                 │");
        System.out.println("└─────────────────────────────────────────────────┘");

    }

    //Asks for a int between 0 and Array.length
    public static int chooseOption(ArrayList<String> opciones) {

        int nOpciones = opciones.size();

        System.out.print("Escribe el numero: ");

        int opcion = Input.getInt();
        while (opcion > nOpciones || opcion < 0) {
            System.out.println("\nEsa opcion no existe");
            System.out.print("Escribe una opcion que exista: ");
            opcion = Input.getInt();
        }
        return opcion;
    }

    public static void ejecutarMenu(ArrayList<String> menu) throws SQLException {

        if (menu == mainMenu) {
            mainMenu();
        } else if (menu == testMenu) {
            testMenu();
        }
    }


    //Specific menu methods

    public static void mainMenu() {
        print(mainMenu);
    }
}*/