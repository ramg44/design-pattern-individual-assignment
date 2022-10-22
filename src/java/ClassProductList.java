import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ClassProductList {

    List<Product> productList;
    String path;
    HashMap<String, List<Product>> userProductUserList;
    String userProductInfos[];

    public static String readFileAsString(String fileName) throws Exception {
        String data = "";
        data = new String(Files.readAllBytes(Paths.get(fileName)));
        return data;
    }


    ClassProductList() throws Exception {
        productList = new ArrayList<>();
        MeatProductMenu meatProductMenu = new MeatProductMenu();
        ProduceProductMenu produceProductMenu = new ProduceProductMenu();
        userProductUserList = new HashMap<>();
        path = System.getProperty("user.dir");
        String productInfos[] = readFileAsString(path.concat("/src/DataBase/ProductInfo.txt")).split("\\R");
        userProductInfos = readFileAsString(path.concat("/src/DataBase/UserProduct.txt")).split("\\R");
        for (String productInfo : productInfos) {

            String product[] = productInfo.split(":");

            if (product[0].equals("Meat")) {
                productList.add(new Product(product[0], product[1]));
                meatProductMenu.add(new Product(product[0], product[1]));


            } else if (product[0].equals("Produce")) {
                productList.add(new Product(product[0], product[1]));
                produceProductMenu.add(new Product(product[0], product[1]));

            }

        }
        for (String productInfo : userProductInfos) {

            String product[] = productInfo.split(":");
            if (userProductUserList.containsKey(product[0])){
                userProductUserList.get(product[0]).add(new Product(product[1]));
            }
            else {
                List<Product> userproductList = new ArrayList<>();
                userproductList.add(new Product(product[1]));
                userProductUserList.put(product[0], userproductList);
            }


        }


    }

    public List<Product> getProductList() {
        return productList;
    }

    public HashMap<String, List<Product>> getUserProductList() throws Exception {
        return userProductUserList;
    }
    public void addUserProductToList(String name ,Product product) throws Exception {
        if (userProductUserList.containsKey(name)){
            userProductUserList.get(name).add(product);
        }
        else {
            userProductUserList.put(name, new ArrayList<>()).add(product);
        }

    }
    public void deleteUserProductToList(String name ,String productName) throws Exception {
        for(Product product :userProductUserList.get(name)){
            if(product.getProductName().equals(productName)){
                userProductUserList.get(name).remove(product);
                break;
            }

        }
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public ClassProductList(List<Product> productList) {
        this.productList = productList;
    }

}
