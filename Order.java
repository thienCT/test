import javax.sound.sampled.Line;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private List<LineItem> lineItems;
    private String customerName;
    private String orderDateTime;

    public Order(String customerName, String orderDateTime){
        this.lineItems = new ArrayList<>();
        this.customerName = customerName;
        this.orderDateTime = orderDateTime;
    }
    public double cost(){
        double totalCost = 0.0;
        for (LineItem item :  lineItems){
            totalCost += item.cost();
        }
        return totalCost;
    }
    public boolean addProduct(Product product, int quantity){
        if (quantity <= product.getQuantity()){
            LineItem lineItem =  new LineItem(product, quantity);
            lineItems.add(lineItem);
            product.setQuantity(product.getQuantity() - quantity);
            return true;
        }
        return false;
    }

    public  void printOrderInfor(){
        System.out.println("Customer Name: " + customerName);
        System.out.println("Order date/time: " + orderDateTime);
        System.out.println("line items");
        for (LineItem item: lineItems){
            System.out.println("product: " + item.getProduct().getName());
            System.out.println(("quantity: " + item.getQuantity()));
            System.out.println("cost: " + item.getCost());
        }
        System.out.println("Total cost: " + cost());

    }
}
