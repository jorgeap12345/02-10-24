import java.util.concurrent.atomic.AtomicInteger;


public class Pedido {
    private static final AtomicInteger idGenerador = new AtomicInteger(0);
    private final int id;
    public Pedido() {
        this.id = idGenerador.incrementAndGet();
    }
    public int getId() {
        return id;
    }
    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return "Pedido # " + id;
    }
}