import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Procesarpedido {
    public static void main(String[] args) {
        BlockingQueue<Pedido> colaPedidos = new LinkedBlockingQueue<>();
        Thread empleado1 = new Thread(new Empleado(colaPedidos), "Juan");
        Thread empleado2 = new Thread(new Empleado(colaPedidos), "Pablo");
        Thread empleado3 = new Thread(new Empleado(colaPedidos), "Raul");
        empleado1.start();
        empleado2.start();
        empleado3.start();

        for (int i = 0; i < 12; i++) {
            Pedido pedido = new Pedido();
            try {
                colaPedidos.put(pedido);
                System.out.println("Pedido creado: " + pedido);
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                System.out.println("El hilo principal fue interrumpido");
            }
        }

    }

}