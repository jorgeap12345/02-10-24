import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Procesarpedido {
    public static void main(String[] args) {
        BlockingQueue<Pedido> colaPedidos = new LinkedBlockingQueue<>();
        Thread empleado1 = new Thread(new Empleado(colaPedidos), "Empleado 1");
        Thread empleado2 = new Thread(new Empleado(colaPedidos), "Empleado 2");
        empleado1.start();
        empleado2.start();
   
        for (int i = 0; i < 10; i++) {
            Pedido pedido = new Pedido();
            try {
                colaPedidos.put(pedido);
                System.out.println("Pedido creado: " + pedido);
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println("El hilo principal fue interrumpido");
            }
        }

    }

}