import java.text.NumberFormat;
import java.util.*;

public class Cart {
    Item[] items;
    double totalPrice;
    private Map<Item,Integer> lineItems;

    public Cart() {
        items = new Item[0];
        totalPrice = 0.0;
        lineItems = new HashMap<>();
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void addItem(Item item, int qty){
        totalPrice += item.price * qty;
        lineItems.put(item, qty);
    }

    public List<String> itemQuantities() {
        List<String> tempResult = new ArrayList<String>();
        for (Map.Entry<Item, Integer> entry : lineItems.entrySet())
        {
            tempResult.add(entry.getKey().name + " - x" + entry.getValue());
        }
        Collections.sort(tempResult);
        return tempResult;
    }

    public List<String> itemizedList() {
        List<String> tempResult = new ArrayList<String>();
        for (Map.Entry<Item, Integer> entry : lineItems.entrySet())
        {
            NumberFormat format = NumberFormat.getCurrencyInstance(Locale.US);
            String currency = format.format(entry.getValue()*entry.getKey().price);
            tempResult.add(entry.getKey().name + " x" + entry.getValue() + " - " + currency);
        }
        Collections.sort(tempResult);
        return tempResult;
    }

    public List<String> onSale() {
        List<String> tempResult = new ArrayList<String>();
        for (Map.Entry<Item, Integer> entry : lineItems.entrySet())
        {
            if (entry.getKey().onSale) {
                NumberFormat format = NumberFormat.getCurrencyInstance(Locale.US);
                String currency = format.format(entry.getValue() * entry.getKey().price);
                tempResult.add(entry.getKey().name + " x" + entry.getValue() + " - " + currency);
            }
        }
        Collections.sort(tempResult);
        return tempResult;
    }
}
