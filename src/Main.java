/*
Para practicar la encapsulación:
Crear clase Persona.
    Crear variables las privadas edad, nombre y telefono de la clase Persona.
    Crear gets y sets de cada propiedad.
    Crear un objeto persona en el main.
Utiliza los gets y sets para darle valores a las propiedades edad, nombre y telefono, por último muéstralas por consola.
 */

import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Persona persona1 = new Persona();
        persona1.setNombre("Juan");
        persona1.setEdad(28);
        persona1.setTelefono("666 63 63 63");

        Persona persona2 =  new Persona("Rocio", 26, "666998877");

        printPersona(persona1);
        printPersona(persona2);
    }

    public static void printPersona(Persona persona) {
        System.out.println("Persona" +
                "\n\t- nombre: " + persona.getNombre() +
                "\n\t- edad: " + persona.getEdad() +
                "\n\t- telefono: " + persona.getTelefono());
    }

    public static class Persona {
        private String nombre;
        private int edad;
        private String telefono;

        public Persona() {}
        public Persona(String nombre, int edad, String telefono) {
            this.nombre = nombre;
            this.setEdad(edad);
            this.setTelefono(telefono);
        }

        public String getTelefono() {
            return this.telefono;
        }

        public void setTelefono(String telefono) {
            Pattern telRegex = Pattern.compile("\\d{9}" +
                    "|^(\\d{2})[\\s-/](\\d{3})([\\s-/]\\d{2}){2}" +
                    "|^(\\d{3})([\\s-/]\\d{2}){3}");
            if (!telRegex.matcher(telefono).matches()) {
                throw new IllegalArgumentException("Telefono no es valido");
            }
            this.telefono = telefono;
        }


        public int getEdad() {
            return this.edad;
        }

        public void setEdad(int edad){
            if (edad < 0) {
                throw new IllegalArgumentException("Edad no es valido");
            }
            this.edad = edad;
        }

        public String getNombre() {
            return this.nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        @Override
        public String toString() {
            return "Persona{" +
                    "nombre='" + nombre + '\'' +
                    ", edad=" + edad +
                    ", telefono='" + telefono + '\'' +
                    '}';
        }
    }
}