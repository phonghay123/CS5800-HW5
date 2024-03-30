//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.*;
interface FoodItem {
    String getDescription();
    double getCost();

    void setCost(double cost);
}
class Burger implements FoodItem {
    private double basePrice = 5.0;

    @Override
    public String getDescription() {
        return "Basic Burger";
    }

    @Override
    public double getCost() {
        return basePrice;
    }

    @Override
    public void setCost(double cost) {
        this.basePrice = cost;
    }
}

class Fries implements FoodItem {
    private double basePrice = 2.0;


    @Override
    public String getDescription() {
        return "French Fries";
    }

    @Override
    public double getCost() {
        return basePrice;
    }
    @Override
    public void setCost(double cost) {
        this.basePrice = cost;
    }
}

class HotDog implements FoodItem {
    private double basePrice = 4.0;

    @Override
    public String getDescription() {
        return "Hot Dog";
    }

    @Override
    public double getCost() {
        return basePrice;
    }
    @Override
    public void setCost(double cost) {
        this.basePrice = cost;
    }
}

class CheeseBurger implements FoodItem {
    private FoodItem foodItem;
    private double cost = 3.0;
    public CheeseBurger(FoodItem foodItem) {
        this.foodItem = foodItem;
        this.foodItem.setCost(this.foodItem.getCost() + cost);
    }

    @Override
    public double getCost() {
        return foodItem.getCost();
    }

    @Override
    public String getDescription() {
        return foodItem.getDescription() + " with " + " Cheese ";
    }
    @Override
    public void setCost(double cost) {
        this.cost = cost;
    }
}

class BaconFries implements FoodItem {
    private FoodItem foodItem;
    private double cost = 5.0;
    public BaconFries (FoodItem foodItem) {
        this.foodItem = foodItem;
        this.foodItem.setCost(this.foodItem.getCost() + cost);
    }

    @Override
    public double getCost() {
        return foodItem.getCost();
    }

    @Override
    public String getDescription() {
        return foodItem.getDescription() + " with " + " Bacon ";
    }

    @Override
    public void setCost(double cost) {
        this.cost = cost;
    }
}

class MustardHotdot implements FoodItem {
    private FoodItem foodItem;
    private double cost = 0.5;
    public MustardHotdot(FoodItem foodItem) {
        this.foodItem = foodItem;
        this.foodItem.setCost(this.foodItem.getCost() + cost);
    }

    @Override
    public double getCost() {
        return foodItem.getCost();
    }

    @Override
    public String getDescription() {
        return foodItem.getDescription() + " with " + " Mustard ";
    }

    @Override
    public void setCost(double cost) {
        this.cost = cost;
    }
}

class Order {
    private List<FoodItem> items;

    public Order() {
        this.items = new ArrayList<>();
    }

    public void addItem(FoodItem item) {
        items.add(item);
    }

    public void removeLastAddedItem()
    {
        items.remove(items.size() - 1);
    }

    public void clearOrder(){
        items.clear();
    }

    public double getTotalCost() {
        double totalCost = 0.0;
        for (FoodItem item : items) {
            totalCost += item.getCost();
        }
        return totalCost;
    }

    public String getOrderDescription() {
        StringBuilder description = new StringBuilder();
        for (FoodItem item : items) {
            description.append(item.getDescription() + "\n");
        }
        return description.toString();
    }
}

interface LoyaltyDiscount {
    double applyDiscount(double cost);
    String getStatus();
}

class NoDiscount implements LoyaltyDiscount {

    @Override
    public double applyDiscount(double cost) {
        return cost;
    }

    @Override
    public String getStatus() {
        return "None";
    }
}

class SilverDiscount implements LoyaltyDiscount {
    private double discount = 0.05;

    @Override
    public double applyDiscount(double cost) {

        return cost * (1 - discount);

    }

    @Override
    public String getStatus() {
        return "Silver";
    }
}

class GoldDiscount implements LoyaltyDiscount {
    private double discount = 0.1;

    @Override
    public double applyDiscount(double cost) {
        return cost * (1 - discount);

    }

    @Override
    public String getStatus() {
        return "Gold";
    }
}
class Customer {
    private String name;
    private LoyaltyDiscount loyalty;

    public Customer(String name, String loyalty) {
        this.name = name;
        switch (loyalty)
        {
            case "Silver":
                this.loyalty = new SilverDiscount();
                break;
            case "Gold":
                this.loyalty = new GoldDiscount();
                break;
            default:
                this.loyalty = new NoDiscount();
        }
    }

    public String getName() {
        return name;
    }

    public void setName(java.lang.String name) {
        this.name = name;
    }

    public LoyaltyDiscount getLoyalty() {
        return loyalty;
    }

    public void setLoyalty(LoyaltyDiscount loyalty) {
        this.loyalty = loyalty;
    }

    public double getTotalCost(Order order){
        return loyalty.applyDiscount(order.getTotalCost());
    }

    public static class CustomerBuilder{
        private String name;
        private String loyalty;
        public Customer build(){
            return new Customer(name,loyalty);
        }

        public CustomerBuilder addName(String name){
            this.name = name;
            return this;
        }

        public CustomerBuilder silverLoyalty() {
            this.loyalty = "Silver";
            return this;
        }

        public CustomerBuilder goldLoyalty(){
            this.loyalty = "Gold";
            return this;
        }

        public CustomerBuilder noLoyalty(){
            this.loyalty = "";
            return this;
        }
    }
}
public class Decorator {
    public static void main(String[] args) {
        // Create some food items
        FoodItem burger = new Burger();
        FoodItem fries = new Fries();
        FoodItem hotdot = new HotDog();

        //menu price print out
        System.out.println("Restaurant Menu: ");
        System.out.println(burger.getDescription() + " with price of: $" + burger.getCost());
        System.out.println(fries.getDescription() + " with price of: $" + fries.getCost());
        System.out.println(hotdot.getDescription() + " with price of: $" + hotdot.getCost());

        // Add toppings
        burger= new CheeseBurger(burger);
        fries = new BaconFries(fries);
        hotdot = new MustardHotdot(hotdot);

        //menu price print out
        System.out.println(burger.getDescription() + " with price of: $" + burger.getCost());
        System.out.println(fries.getDescription() + " with price of: $" + fries.getCost());
        System.out.println(hotdot.getDescription() + " with price of: $" + hotdot.getCost());
        System.out.println();

        // Create an order
        Order order = new Order();
        order.addItem(burger);
        order.addItem(fries);
        order.addItem(hotdot);

        //Create Customers
        Customer customer1 = new Customer.CustomerBuilder().addName("John").noLoyalty().build();
        Customer customer2 = new Customer.CustomerBuilder().addName("Doe").silverLoyalty().build();
        Customer customer3 = new Customer.CustomerBuilder().addName("Matt").goldLoyalty().build();

        // Display order details
        System.out.println("Order Description:");
        System.out.println(order.getOrderDescription());

        // Apply loyalty discount
        double totalCost1 = customer1.getTotalCost(order);
        double totalCost2 = customer2.getTotalCost(order);
        double totalCost3 = customer3.getTotalCost(order);

        System.out.println("Total Cost before discount: $" + order.getTotalCost());
        System.out.println("Total Cost after discount of " + customer1.getName() + " with loyalty status " + customer1.getLoyalty().getStatus() + " : $" + String.format("%.2f", totalCost1));
        System.out.println("Total Cost after discount of " + customer2.getName() + " with loyalty status " + customer2.getLoyalty().getStatus() + " : $" + String.format("%.2f", totalCost2));
        System.out.println("Total Cost after discount of " + customer3.getName() + " with loyalty status " + customer3.getLoyalty().getStatus() + " : $" + String.format("%.2f", totalCost3));

    }
}