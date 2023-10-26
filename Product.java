public class Product {
    private int sku;
    private String name;
    private String category;
    private double price;
    private int quantity;


    public Product( int sku, String name, String category, double price,
    int quantity){
        this.sku = sku;
        this.name = name;
        this.category = category;
        this.price = price;
        this.quantity = quantity;
    }
    public int getSku(){
        return sku;
    }
    public String getName(){
        return name;
    }
    public String getCategory(){
        return category;
    }
    public double getPrice(){
        return price;
    }
    public int getQuantity(){
        return quantity;
    }
    public void setQuantity(int quantity){
        this.quantity = quantity;
    }
}
