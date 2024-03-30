import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class OrderTest {
    @Test
    void totalCost() {
        Order order = new Order();
        order.addItem(new Burger());
        order.addItem(new Fries());
        assertEquals(7.0, order.getTotalCost());
    }

    @Test
    void orderDescription() {
        Order order = new Order();
        order.addItem(new Burger());
        order.addItem(new Fries());
        assertEquals("Basic Burger\nFrench Fries\n", order.getOrderDescription());
    }

    @Test
    void removeLastAddedItem() {
        Order order = new Order();
        order.addItem(new Burger());
        order.addItem(new Fries());
        order.addItem(new HotDog());
        order.removeLastAddedItem();
        assertEquals(7.0, order.getTotalCost());
    }

    @Test
    void clearOrder() {
        Order order = new Order();
        order.addItem(new Burger());
        order.addItem(new Fries());
        order.clearOrder();
        assertEquals(0.0, order.getTotalCost());
        assertEquals("", order.getOrderDescription());
    }
}
