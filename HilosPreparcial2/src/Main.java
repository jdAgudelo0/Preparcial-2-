//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws InterruptedException {

        Hilo1 hilo1 = new Hilo1(10);

        hilo1.start();

        try{
            hilo1.join();
        }catch(InterruptedException e){
            e.printStackTrace();
        }

        Hilo2 hilo2 = new Hilo2(6);

        hilo2.start();

        try{
            hilo2.join();
        }catch(InterruptedException e){
            e.printStackTrace();
        }

        Hilo3 hilo3 = new Hilo3("Electroencefalografista");
        hilo3.start();
        try{
            hilo3.join();
        }catch(InterruptedException e){
            e.printStackTrace();
        }

        Metodos metodos = new Metodos();

        int resultado = metodos.multiplicacion(hilo1.sumarNumerosRecursivo(10), hilo2.factorialNumerosRecursivo(6));

        metodos.imprimir(resultado, hilo3.contarConsonantes("Electroencefalografista"));
    }
}