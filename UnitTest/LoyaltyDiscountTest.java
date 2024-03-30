import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LoyaltyDiscountTest {

    @Test
    void noDiscount() {
        LoyaltyDiscount discount = new NoDiscount();
        assertEquals(10.0, discount.applyDiscount(10.0));
    }

    @Test
    void silverDiscount() {
        LoyaltyDiscount discount = new SilverDiscount();
        assertEquals(9.5, discount.applyDiscount(10.0));
    }

    @Test
    void goldDiscount() {
        LoyaltyDiscount discount = new GoldDiscount();
        assertEquals(9.0, discount.applyDiscount(10.0));
    }
}