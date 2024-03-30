import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
class FoodItemTest {
    @Test
    void basicBurgerCost() {
        FoodItem burger = new Burger();
        assertEquals(5.0, burger.getCost());
    }

    @Test
    void burgerWithCheeseCost() {
        FoodItem burger = new CheeseBurger(new Burger());
        assertEquals(8.0, burger.getCost());
    }

    @Test
    void friesCost() {
        FoodItem fries = new Fries();
        assertEquals(2.0, fries.getCost());
    }

    @Test
    void friesWithBaconCost() {
        FoodItem fries = new BaconFries(new Fries());
        assertEquals(7.0, fries.getCost());
    }

    @Test
    void hotDogCost() {
        FoodItem hotDog = new HotDog();
        assertEquals(4.0, hotDog.getCost());
    }

    @Test
    void hotDogWithMustardCost() {
        FoodItem hotDog = new MustardHotdot(new HotDog());
        assertEquals(4.5, hotDog.getCost());
    }
}

