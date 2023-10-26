public class Main{
    public static void main(String[] args){
        Product tomato = new Product(1, "tomato",
                "food",1.5, 589);
        Product zaraShirt = new Product(2, "zara shirt", "apprearance",
                12.0, 90);
        Product kitchenTable = new Product(3, "kitchen tabke", "household",
        299.0, 13);
        Product iphone = new Product(4, "iphone","Electronic",
                100.0, 4);
        Product footBall = new Product(5, "football","sport",
                199, 2);
        Order order1 = new Order("Mike Tyson", "2023-08-08 11:30:00");


        System.out.println("Adding 5 tomato to the order");
        boolean success1 = order1.addProduct(tomato, 5);
        System.out.println("result:" + (success1 ? "success": "Fail" ));

        System.out.println("total cost of order: " + order1.cost());

        System.out.println("Adding 2 iphone to the order..");
        boolean success2 = order1.addProduct(iphone, 2);
        System.out.println("result"+(success2 ? "succes": "Fail"));

        System.out.println("total cost of order: "+  order1.cost());

        System.out.println("adding 4 football to the order");
        boolean success3 = order1.addProduct(footBall, 4);
        System.out.println("result" +(success3 ? "success": "fail"));

        System.out.println("printing order information:");
        order1.printOrderInfor();

        DeliveryOrder deliveryOrder =  new DeliveryOrder("Chris Evan", "2023-08-09 13:14:00");

          deliveryOrder.setAddress("123 cau giay");

          System.out.println("adding 3 zaraShirt to the delivery order");

          boolean success4 = deliveryOrder.addProduct(zaraShirt, 3);
          System.out.println("result: " + (success4 ? "success":"fail"));
          System.out.println("total cost of order: " +  deliveryOrder.cost());

          System.out.println("adding 3 iphone to the delivery order");
          boolean success5 = deliveryOrder.addProduct(iphone, 3);
          System.out.println("result: " + (success5 ? "succes": "fail"));
          System.out.println("total cost of order: " + deliveryOrder.cost());

          System.out.println("printing delivery order information");
          deliveryOrder.printOrderInfor();



    }
}