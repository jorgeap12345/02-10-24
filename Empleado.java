import java.util.concurrent.BlockingQueue;

public class Empleado implements Runnable {
    private final BlockingQueue<Pedido> colaPedidos;

    public Empleado(BlockingQueue<Pedido> colaPedidos) {
        this.colaPedidos = colaPedidos;
    }

    @Override
    public void run() {
        try {
            while (true) {
                Pedido pedido = colaPedidos.take();
          
                System.out.println(Thread.currentThread().getName() + " esta procesando " + pedido);
                Thread.sleep(1000);
                System.out.println(Thread.currentThread().getName() + " ha completado " + pedido);
            }
        } catch (InterruptedException e) {
            System.out.println(Thread.currentThread().getName() + " fue interrumpido ");
        }

    }

}