import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class MeatProductMenu implements ProductMenu {
    List<Product> productList;

    public static String readFileAsString(String fileName) throws Exception {
        String data = "";
        data = new String(Files.readAllBytes(Paths.get(fileName)));
        return data;
    }


    public MeatProductMenu() throws Exception {
        productList = new ArrayList<>();
        String path = System.getProperty("user.dir");
        String productInfos[] = readFileAsString(path.concat("/src/DataBase/ProductInfo.txt")).split("\\R");
        for (String productInfo : productInfos) {

            String product[] = productInfo.split(":");

            if (product[0].equals("Meat")) {
                productList.add(new Product(product[0], product[1]));
            }
        }
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    @Override
    public void ShowMenu() {

        System.out.println("Meat Product Menu");
        String leftAlignFormat = "| %-15s | %-15s |%n";

        System.out.format("+-----------------+------+%n");
        System.out.format("| Product Category   | Product name |%n");
        System.out.format("+-----------------+------+%n");
        for (Product product : productList) {
            System.out.format(leftAlignFormat, product.getProductCategory(), product.getProductName());
        }

        System.out.format("+-----------------+------+%n");

    }

    @Override
    public void showAddButton() {

    }

    @Override
    public void showViewButton() {

    }

    @Override
    public void showRadioButton() {

    }

    @Override
    public void showLabels() {

    }

    @Override
    public void showComboxes() {

    }

    @Override
    public void add(Product product) {
        productList.add(product);
    }

    @Override
    public ListIterator getIterator() {
        return null;
    }
    //   Visitor Design pattern is used here
    @Override
    public void accept(NodeVisitor nodeVisitor) throws Exception {
        nodeVisitor.visit(this);

    }
}
