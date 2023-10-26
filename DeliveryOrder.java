public class DeliveryOrder extends Order{
    private String address;
    public DeliveryOrder(String customerName, String orderDateTime){
        super(customerName, orderDateTime);
    }
    public  void setAddress(String address){
        this.address = address;
    }
    public String getAddress(){
        return address;
    }
}
