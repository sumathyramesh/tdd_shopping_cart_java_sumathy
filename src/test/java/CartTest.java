import org.junit.Test;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class CartTest {
    @Test
    public void testEmptyCart() {
        //Setup
        Cart cart = new Cart();

        //Exercise
        double expectedTotalPrice = 0.0;
        Item[] expectedItems = new Item[0];

        //Assert
        assertEquals(expectedTotalPrice,cart.totalPrice,0.00001);
        assertEquals(expectedItems.length,cart.items.length);
    }

    @Test
    public void testTotalPrice() {
        //Setup
        Cart cart = new Cart();
        Item item1 = new Item("iPhone", 600.00, false);
        Item item2 = new Item("iPad", 500.00, false);

        //Exercise
        cart.addItem(item1,10);
        cart.addItem(item2,10);
        double expectedTotalPrice = 11000;

        //Assert
        assertEquals(expectedTotalPrice,cart.getTotalPrice(),0.00001);
    }

    @Test
    public void testItemQuantities() {
        //Setup
        Cart cart = new Cart();
        Item item1 = new Item("iPhone", 600.00, false);
        Item item2 = new Item("iPad", 500.00, false);

        //Exercise
        cart.addItem(item1,10);
        cart.addItem(item2, 5);
        List<String> result = new ArrayList<String>();
        result.add("iPhone - x10");
        result.add("iPad - x5");

        Collections.sort(result);

        //Assert
        assertArrayEquals(result.toArray(),cart.itemQuantities().toArray());
    }

    @Test
    public void testItemizedList() {
        //Setup
        Cart cart = new Cart();
        Item item1 = new Item("iPhone", 600.00, false);
        Item item2 = new Item("iPad", 500.00, false);

        //Exercise
        cart.addItem(item1,10);
        cart.addItem(item2, 5);
        List<String> result = new ArrayList<String>();
        result.add("iPhone x10 - $6,000.00");
        result.add("iPad x5 - $2,500.00");

        Collections.sort(result);

        //Assert
        assertArrayEquals(result.toArray(),cart.itemizedList().toArray());
    }

    @Test
    public void testOnSale() {
        Cart cart = new Cart();
        Item item1 = new Item("iPhone", 600.00, false);
        Item item2 = new Item("iPad", 500.00, true);

        //Exercise
        cart.addItem(item1,10);
        cart.addItem(item2, 5);
        List<String> result = new ArrayList<String>();
        result.add("iPad x5 - $2,500.00");

        Collections.sort(result);

        //Assert
        assertArrayEquals(result.toArray(),cart.onSale().toArray());
    }
}
