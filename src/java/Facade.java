import java.util.*;

public class Facade extends Person implements ProductMenu{

    private int UserType;
    Product theSelectedProduct;
    private int nProductCategory;
    List<Product> theProductList;
    ClassProductList classProductList;
    Person thePerson;
    Login login;
    String userProduct[];
    ProductMenu meatProductMenu;
    ProductMenu produceProductMenu;

    public Facade(int userType, Product theSelectedProduct, int nProductCategory, Person thePerson) throws Exception {
        UserType = userType;
        this.theSelectedProduct = theSelectedProduct;
        this.nProductCategory = nProductCategory;
        this.thePerson = thePerson;

    }
//Facade design pattern is used here .product Menu is interfaced
    public Facade(ProductMenu meatProductMenu, ProductMenu produceProductMenu) throws Exception {
        //Bridge design pattern is used here where person is abstract class and product menu is interface with two concrete
        //classes MeatProductMenu and ProduceProductMenu
        super(meatProductMenu,produceProductMenu);

        this.meatProductMenu = meatProductMenu;
        this.produceProductMenu = produceProductMenu;
        this.login = new Login();
        this.classProductList = new ClassProductList();
        this.theProductList = classProductList.getProductList();

    }

    @Override
    public void showMenu() {
        System.out.println("List of products");
        String leftAlignFormat = "| %-15s | %-15s |%n";

        System.out.format("+-----------------+------+%n");
        System.out.format("| Product Category   | Product name |%n");
        System.out.format("+-----------------+------+%n");
        for (Product product : theProductList) {
            System.out.format(leftAlignFormat, product.getProductCategory(), product.getProductName());
        }

        System.out.format("+-----------------+------+%n");
    }

    @Override
    public ProductMenu CreateProductMenu(int productType) throws Exception {
        return null;
    }

    public void showUserProductList(String name) throws Exception {
        System.out.println("List of your products");
        String leftAlignFormat2 = "| %-15s | %-15s |%n";

        System.out.format("+-----------------+------+%n");
        System.out.format("| User name   | Product name |%n");
        System.out.format("+-----------------+------+%n");
        for (Product product : classProductList.userProductUserList.get(name)) {
            System.out.format(leftAlignFormat2, name, product.getProductName());
        }

        System.out.format("+-----------------+------+%n");

    }
    public List<Product> getUserProductList(String name){
        return classProductList.userProductUserList.get(name);
    }
    public void addUserProductToList(String user, Product product) throws Exception {
        classProductList.addUserProductToList(user,product);
    }
    public void deleteUserProductToList(String user, String productName) throws Exception {
        classProductList.deleteUserProductToList(user,productName);
    }
    public boolean login(String name, String password, String user) {
        return login.login(name,password,user);
    }

    // Factory design pattern  which will let the subclasses decide to instantiate the object
    public ProductMenu selectProductMenu(String menu) throws Exception {
        if(menu == null){
            return null;
        }
        if(menu.equalsIgnoreCase("Meat")){
            return new MeatProductMenu();

        } else if(menu.equalsIgnoreCase("Produce")){
            return new ProduceProductMenu();

        }

        return null;
    }

    public void addTrading() {

    }

    public void viewTrading() {

    }

    public void decideBidding() {

    }

    public void discussBidding() {

    }

    public void submitBidding() {

    }

    public void remind() {


    }

    public void createUser(UserInfoItem userInfoItem) {

    }

    public void createProductList() {

    }

    public void attachProductToUser() {

    }

    public Product selectProduct() {
        return this.theSelectedProduct;
    }

    public void productOperation() {

    }

    @Override
    public void ShowMenu() {

    }

    @Override
    public void showComboxes() {

    }

    @Override
    public void add(Product product) {

    }

    @Override
    public ListIterator getIterator() {
        return null;
    }
    //   Visitor Design pattern is used here
    public void accept(NodeVisitor nodeVisitor) throws Exception {
        nodeVisitor.visit(this);
        nodeVisitor.visit(meatProductMenu);
        nodeVisitor.visit(produceProductMenu);

    }
}
