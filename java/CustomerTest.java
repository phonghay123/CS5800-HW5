import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomerTest {

    @Test
    void customerWithNoDiscount() {
        Customer customer = new Customer("John", "");
        Order order = new Order();
        order.addItem(new Burger());
        assertEquals(5.0, customer.getTotalCost(order));
    }

    @Test
    void customerWithSilverDiscount() {
        Customer customer = new Customer("Doe", "Silver");
        Order order = new Order();
        order.addItem(new Burger());
        assertEquals(4.75, customer.getTotalCost(order));
    }

    @Test
    void customerWithGoldDiscount() {
        Customer customer = new Customer("Doe", "Gold");
        Order order = new Order();
        order.addItem(new Burger());
        assertEquals(4.5, customer.getTotalCost(order));
    }
}