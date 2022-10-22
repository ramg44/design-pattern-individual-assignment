import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ProduceProductMenu implements ProductMenu {
    List<Product> productList;

    public static String readFileAsString(String fileName) throws Exception {
        String data = "";
        data = new String(Files.readAllBytes(Paths.get(fileName)));
        return data;
    }

    public ProduceProductMenu() throws Exception {
        productList = new ArrayList<>();
        String path = System.getProperty("user.dir");
        String productInfos[] = readFileAsString(path.concat("/src/DataBase/ProductInfo.txt")).split("\\R");
        for (String productInfo : productInfos) {

            String product[] = productInfo.split(":");

            if (product[0].equals("Produce")) {
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

        System.out.println("Produce Product Menu");
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
    //Iterator Design pattern used here
    @Override
    public ListIterator getIterator() {
        return new NameIterator();
    }
    //   Visitor Design pattern is used here
    @Override
    public void accept(NodeVisitor nodeVisitor) throws Exception {
        nodeVisitor.visit(this);

    }
    //Iterator Design pattern used here
    private class NameIterator implements ListIterator {

        int index;

        @Override
        public boolean hasNext() {

            if(index < productList.size()){
                return true;
            }
            return false;
        }

        @Override
        public Object next() {

            if(this.hasNext()){
                return productList.get(index++);
            }
            return null;
        }
    }
}
