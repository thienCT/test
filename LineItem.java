public class LineItem {
    private Product product;
    private int quantity;

    public LineItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public double getCost() {
        return product.getPrice() * quantity;
    }

    public int getQuantity() {
        return quantity;
    }
    public Product getProduct(){
        return product;
    }

    }
