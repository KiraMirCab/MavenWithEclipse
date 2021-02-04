package es.iessoterohernandez.endes;

public class Persona {
	 
    private final static char SEXO_DEF = 'H';
 
    public static final int INFRAPESO = -1;
 
    public static final int PESO_IDEAL = 0;
 
    public static final int SOBREPESO = 1;
 
    private String nombre;
    private int edad;
    private String DNI;
    private char sexo;
    private double peso;
    private double altura;
 
    public Persona() {
        this("", 0, SEXO_DEF, 0, 0);
    }
 
    public Persona(String nombre, int edad, char sexo) {
        this(nombre, edad, sexo, 0, 0);
    }
 
    public Persona(String nombre, int edad, char sexo, double peso, double altura) {
        this.nombre = nombre;
        this.edad = edad;
        this.peso = peso;
        this.altura = altura;
        generarDni();
        this.sexo = sexo;
        comprobarSexo();
    }
 
    private void comprobarSexo() {
         //Si el sexo no es una H o una M, por defecto es H
        if (sexo != 'H' && sexo != 'M') {
            this.sexo = SEXO_DEF;
        }
    }
 
    private void generarDni() {
        final int divisor = 23;
 
        //Generamos un número de 8 digitos
        int numDNI = ((int) Math.floor(Math.random() * (100000000 - 10000000) + 10000000));
        int res = numDNI - (numDNI / divisor * divisor);
 
        //Calculamos la letra del DNI
        char letraDNI = generaLetraDNI(res);
 
        //Pasamos el DNI a String
        DNI = Integer.toString(numDNI) + letraDNI;
    }
 
    private char generaLetraDNI(int res) {
        char letras[] = {'T', 'R', 'W', 'A', 'G', 'M', 'Y',
            'F', 'P', 'D', 'X', 'B', 'N', 'J', 'Z',
            'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E'};
 
        return letras[res];
    }
 
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
 
    public void setEdad(int edad) {
        this.edad = edad;
    }
 
    public void setSexo(char sexo) {
        this.sexo = sexo;
    }
 
    
    public void setPeso(double peso) {
        this.peso = peso;
    }
 
    public void setAltura(double altura) {
        this.altura = altura;
    }
 
    /**
     * Calcula el indice de masa corporal
     *
     * @return codigo numerico
     * <ul><li>-1: la persona esta por debajo de su peso ideal</li>
     * <li>0: la persona esta en su peso ideal</li>
     * <li>1: la persona esta por encima de su peso ideal</li></ul>
     */
    public int calcularIMC() {
        //Calculamos el peso de la persona
        double pesoActual = peso / (Math.pow(altura, 2));
        //Segun el peso, devuelve un codigo
        if (pesoActual >= 20 && pesoActual <= 25) {
            return PESO_IDEAL;
        } else if (pesoActual < 20) {
            return INFRAPESO;
        } else {
            return SOBREPESO;
        }
    }
 
    /**
     * Indica si la persona es mayor de edad
     *
     * @return true si es mayor de edad y false es menor de edad
     */
    public boolean esMayorDeEdad() {
        boolean mayor = false;
        if (edad >= 18) {
            mayor = true;
        }
        return mayor;
    }
 
    /**
     * Devuelve informacion del objeto
     *
     * @return cadena con toda la informacion
     */
    @Override
    public String toString() {
        String sexo;
        if (this.sexo == 'H') {
            sexo = "hombre";
        } else {
            sexo = "mujer";
        }
        return "Informacion de la persona:\n"
                + "Nombre: " + nombre + "\n"
                + "Sexo: " + sexo + "\n"
                + "Edad: " + edad + " años\n"
                + "DNI: " + DNI + "\n"
                + "Peso: " + peso + " kg\n"
                + "Altura: " + altura + " metros\n";
    }
    
    public String getDNI() {
    	return this.DNI;
    }
 
}

