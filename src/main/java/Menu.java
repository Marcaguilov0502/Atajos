import java.util.ArrayList;

public class Menu {


    //Attributes


    private String name;                    /**Name of the menu*/
    private ArrayList<String> optionList;   /**List of the options that the menu has*/
    private String question;                /**The question that the menu will ask*/
    private String exit;                    /**The text that will be shown as the "[0] - Exit" option*/
    private int size;                       /**The width of the menu; will be calculated automatically in the setter*/

    private static String optionSelector = "Write the number: ";
    public static String optionDoNotExist = "There is no option with that number.\n" +
                                            "Write the number of an existing option: ";


    //Constructors


    /**
     * Creates a menu with a predefined question and exit.
     * Only need a name an a list of options.
     *
     * @param name
     * @param optionList
     */
    //Basic
    public Menu(String name, ArrayList<String> optionList) {
        setName(name);
        setOptionList(optionList);
        setQuestion("Que accion deseas realizar?");
        setExit("Salir");
        setSize();
    }


    /**
     * Creates a menu with a name, a list of option, a question and a name for the exit option
     *
     * @param name
     * @param optionList
     * @param question
     * @param exit
     */
    //With all parameters
    public Menu(String name, ArrayList<String> optionList, String question, String exit) {
        setName(name);
        setOptionList(optionList);
        setQuestion(question);
        setExit(exit);
        setSize();
    }

    /**
     * Creates a menu copying another menu
     *
     * @param original
     */
    //Copy
    public Menu(Menu original) {
        setName(original.getName());
        setOptionList(original.getOptionList());
        setQuestion(original.getQuestion());
        setExit(original.getExit());
        setSize();
    }


    //Getters and Setters


    /**Retruns the name uppercased
     * @return
     */
    public String getName() {
        return name.toUpperCase();
    }

    /**Sets the name uppercased
     * @param name
     */
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

    /**This setter has no params.
     * Calculates and sets the size of the menu depending on the longest field of the menu
     * */
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


    /**The method returns the a String that is the menu box with everything in it
     *
     * @return
     */
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
        string = string.concat("└" + horitzonalLine() +                              "┘\n");
        string = string.concat(optionSelector);
        return string;
    }


    //Methods

    /**Prints the menu and returns the number of the option the user selected
     *
     * @return
     */
    public int execute() {

        System.out.print(this);

        int optionAmount = optionList.size();

        int option = Input.getInt();
        while (option > optionAmount || option < 0) {
            System.out.print(optionDoNotExist);
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

    /** Returns a String param into a box to print it as a header
     *
     * @param name
     * @return
     */
    public static String header(String name) {

        name = name.toUpperCase();
        String string = "";
        int width = name.length() + 4;
        String s = " ".repeat(2);

        string = string.concat("┌" + "─".repeat(width) + "┐\n");
        string = string.concat("│" + s + name + s +  "│\n");
        string = string.concat("└" + "─".repeat(width) + "┘");

        return string;
    }

    /**Return a String whith the name of the menu to print it as a header
     *
     * @return
     */
    public String header() {

        String string = "";

        int width = size;

        if (Misc.isOdd(size) != Misc.isOdd(name.length())) {
            width = size - 1;
        }

        String s = " ".repeat((width - name.length())/2);

        string = string.concat("┌" + "─".repeat(width) + "┐\n");
        string = string.concat("│" + s + name + s +  "│\n");
        string = string.concat("└" + "─".repeat(width) + "┘");

        return string;
    }
}