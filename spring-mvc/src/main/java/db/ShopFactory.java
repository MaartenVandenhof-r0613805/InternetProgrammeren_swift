package db;



public class ShopFactory {
    public static dbInterface getType(String type){
        if(type.equals("Memory")){
            System.out.print("MemoryDb");
            return new ShopService();
        }
        if(type.equals("JPA")) {
            return new ProductJpaDatabase();
        }
        return null;
    }


}
