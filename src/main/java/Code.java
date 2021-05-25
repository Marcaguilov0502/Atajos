import java.util.ArrayList;

public abstract class Code {

    //Attributes

    public static ArrayList <String> attributes;
    public static ArrayList <String> dataTypes;

    //Methods

    public static void getClassData() {

        attributes = new ArrayList<String>();
        dataTypes = new ArrayList<String>();

        boolean stop = false;

        System.out.println();
        System.out.println("-----------------------------------");
        System.out.println("   Press ENTER when you're done.   ");
        System.out.println("-----------------------------------");

        //Attribute Selection

        while (!stop) {
            System.out.print("\nAttribute: ");
            String attribute = Input.getString();
            if (attribute.equals("")) {
                stop = true;
            }
            else {
                System.out.print("Set the dataType: ");
                String dataType = Input.getString();

                attributes.add(attribute);
                dataTypes.add(dataType);

            }
        }
    }

    public static void generateClassCode() {

        System.out.print("\nClass name: ");
        String className = Input.getString();

        getClassData();

        System.out.println("---------------------------------------------------------------"+"\n\n\n\n\n\n\n\n\n");

        System.out.println("public class "+className+" {");

        System.out.println();
        System.out.println();
        System.out.println("    //Atributos");
        System.out.println();
        System.out.println();

        for (int i = 0; i < attributes.size(); i++) {
            System.out.println("    private "+dataTypes.get(i)+" "+attributes.get(i)+";");
        }

        System.out.println();
        System.out.println();
        System.out.println("    //Constructores");
        System.out.println();
        System.out.println();

        System.out.println("    //Vacio");

        System.out.println("    public "+className+"() {");
        System.out.println("    }");
        System.out.println();

        System.out.println("    //Con parametros");
        System.out.print("    public "+className+"(");
        for (int i = 0; i < attributes.size(); i++) {
            if (i != 0) {
                System.out.print(", ");
            }
            System.out.print(dataTypes.get(i)+" "+attributes.get(i));
        }
        System.out.println(") {");
        for (int i = 0; i < attributes.size(); i++) {
            System.out.println("        set"+Util.uppercaseFirst(attributes.get(i))+"("+attributes.get(i)+");");
        }
        System.out.println("    }");
        System.out.println();

        System.out.println("    //Copia");
        System.out.println("    public "+className+"("+className+" original) {");
        for (int i = 0; i < attributes.size(); i++) {
            System.out.println("        set"+Util.uppercaseFirst(attributes.get(i))+"(original.get"+Util.uppercaseFirst(attributes.get(i))+"());");
        }
        System.out.println("    }");

        System.out.println();
        System.out.println();
        System.out.println("    //Getters y Setters");
        System.out.println();
        System.out.println();

        for (int i = 0; i < attributes.size(); i++) {
            //getter
            System.out.println("    public "+dataTypes.get(i)+" get"+Util.uppercaseFirst(attributes.get(i))+"() {");
            System.out.println("        return "+attributes.get(i)+";");
            System.out.println("    }");
            //setter
            System.out.println();
            System.out.println("    public void set"+Util.uppercaseFirst(attributes.get(i))+"("+dataTypes.get(i)+" "+attributes.get(i)+") {");
            System.out.println("        this."+attributes.get(i)+" = "+attributes.get(i)+";");
            System.out.println("    }");
        }

        System.out.println();
        System.out.println();
        System.out.println("    //ToString");
        System.out.println();
        System.out.println();

        System.out.println("    @Override");
        System.out.println("    public String toString() {");
        System.out.println("        return "+'"'+className+"{"+'"'+" +");
        for (int i = 0; i < attributes.size(); i++) {
            System.out.print("            "+'"');
            if (i != 0) {
                System.out.print(", ");
            }
            System.out.println(attributes.get(i)+"="+'"'+" + "+attributes.get(i)+" +");
        }
        System.out.println("            '}';");
        System.out.println("    }");

        System.out.println();
        System.out.println();
        System.out.println("    //Metodos");
        System.out.println();
        System.out.println();

        System.out.println("}\n\n\n\n\n\n\n\n\n");

    }

}
