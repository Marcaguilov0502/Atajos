public class Persona {


    //Atributos


    private String nombre;
    private long telefono;
    private int edad;


    //Constructores


    //Vacio
    public Persona() {
    }

    //Con parametros
    public Persona(String nombre, long telefono, int edad) {
        setNombre(nombre);
        setTelefono(telefono);
        setEdad(edad);
    }

    //Copia
    public Persona(Persona original) {
        setNombre(original.getNombre());
        setTelefono(original.getTelefono());
        setEdad(original.getEdad());
    }


    //Getters y Setters


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public long getTelefono() {
        return telefono;
    }

    public void setTelefono(long telefono) {
        this.telefono = telefono;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }


    //ToString


    @Override
    public String toString() {
        return "Persona{" +
                "nombre=" + nombre +
                ", telefono=" + telefono +
                ", edad=" + edad +
                '}';
    }


    //Metodos


}
