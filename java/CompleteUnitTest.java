import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({CompleteUnitTest.class,FoodItemTest.class,OrderTest.class,LoyaltyDiscountTest.class,CustomerTest.class})
public class CompleteUnitTest {
}
