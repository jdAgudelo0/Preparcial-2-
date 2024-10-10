public class Hilo3 extends Thread {
    private String palabra;


    public Hilo3(String palabra) {
        this.palabra = palabra;
    }

    public int contarConsonantes(String palabra) {
        int contador =0;
        palabra = palabra.toLowerCase();
        for (int i = 0; i < palabra.length(); i++) {
            char c = palabra.charAt(i);
            if (c >= 'a' && c <= 'z'  && "aeiou".indexOf(c) ==-1) {
                contador++;
            }
        }
        return contador;
    }
    @Override
    public void run() {
        int resultado = contarConsonantes(palabra);
        System.out.println("la cantidad de consonates encontrada es de =" + resultado);
    }
}
