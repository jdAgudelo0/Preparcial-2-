public class Hilo1 extends Thread {

    private int n;

    public Hilo1(int n) {
        this.n = n;
    }

    public int sumarNumerosRecursivo(int numero){
        //casoBase

        if(numero == 0){
            return  0;
        }
        return numero + sumarNumerosRecursivo(numero-1);
    }

    @Override
    public void run() {
        int resultado = sumarNumerosRecursivo(n);
       // System.out.println("la suma es =" + resultado);


    }

}


