public class Hilo2 extends Thread {

    private int n;

    public Hilo2(int n) {
        this.n = n;
    }

    public int factorialNumerosRecursivo(int numero){
        //casoBase

        if(numero == 1){
            return  1;
        }
        return numero * factorialNumerosRecursivo(numero-1);
    }

    @Override
    public void run() {
        int resultado = factorialNumerosRecursivo(n);
        //System.out.println("el factorial es =" + resultado);

    }
}
