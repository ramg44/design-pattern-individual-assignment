import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {
        Facade facade = new Facade(new MeatProductMenu(), new ProduceProductMenu());

//   Visitor Design pattern is used here
        facade.accept(new DisplayProductMenuBasedOnVisitor());

        Scanner scnInt = new Scanner(System.in);
        Scanner scnStr = new Scanner(System.in);

        String userType;
        String name;
        String password;
        int nProductCategory;
        while (true) {
            System.out.println("Please enter Buyer if youwant to buy " +
                    "or" +
                    "Seller if you want to sell");
            userType = scnStr.nextLine();
            if (userType.equals("Buyer")) {
                System.out.println("Enter User Name");
                name = scnStr.nextLine();
                System.out.println("Enter User Password");
                password = scnStr.nextLine();
                if (facade.login(name, password, userType)) {
                    System.out.println("Successfully logged in");

                    facade.showMenu();
                    while (true) {
                        System.out.println("Enter 0 to see available Meat Product menu, 1 to Produce Product menu and 2 to add the product to your list ");
                        int productMenu = scnInt.nextInt();
                        if (productMenu == 0) {
                            facade.meatProductMenu.ShowMenu();
                        } else if (productMenu == 1) {
                            System.out.println("Meat Product Menu");
                            String leftAlignFormat = "| %-15s | %-15s |%n";
                            System.out.format("+-----------------+------+%n");
                            System.out.format("| Product Category| Product name |%n");
                            System.out.format("+-----------------+------+%n");
               //Iterator Design pattern used here
                            for (ListIterator iter = facade.produceProductMenu.getIterator(); iter.hasNext(); ) {
                                Product product = (Product) iter.next();
                                System.out.format(leftAlignFormat, product.getProductCategory(), product.getProductName());
                            }
                            System.out.format("+-----------------+------+%n");
                        } else if (productMenu == 2) {
                            break;

                        } else {
                            System.out.println("Invalid entry !!!!!!!!!!!!");
                        }
                    }
                    facade.showUserProductList(name);
                    while (true) {
                        System.out.println("Enter 0 to add the product,1 to delete the product and 2 to exit");
                        int input = scnInt.nextInt();
                        if (input == 0) {
                            System.out.println("Enter the product name that you want to add to your list");
                            String productname = scnStr.nextLine();
                            if (facade.theProductList.contains(new Product(productname))) {
                                facade.addUserProductToList(name, new Product(productname));
                                facade.showUserProductList(name);
                            } else {
                                System.out.println("Error!!! Please enter the product which showed in below list!!!!!!!!");
                                facade.showMenu();
                            }


                        } else if (input == 1) {
                            System.out.println("Enter the product name that you want to delete");
                            String productname = scnStr.nextLine();
                            if (facade.getUserProductList(name).contains(new Product(productname))) {
                                facade.deleteUserProductToList(name, productname);
                                facade.showUserProductList(name);
                            } else {
                                System.out.println("Error!!! Please enter the product which showed in below list!!!!!!!!");
                                facade.showUserProductList(name);
                            }
                        } else if (input == 2) {
                            break;
                        } else {
                            System.out.println("Invalid entry !!!!!!!!!!!!");
                        }

                    }
                } else {
                    System.out.println("Invalid Credentials please try again");
                }
            } else if (userType.equals("Seller")) {
                System.out.println("Enter User Name");
                name = scnStr.nextLine();
                System.out.println("Enter User Password");
                password = scnStr.nextLine();
                if (facade.login(name, password, userType)) {
                    System.out.println("Successfully logged in");
                    facade.showUserProductList(name);
                    while (true) {
                        System.out.println("Enter 0 to display Meat Product menu, 1 to Produce Product menu and 2 to create the product to sell ");
                        int productMenu = scnInt.nextInt();
                        if (productMenu == 0) {
                            facade.selectProductMenu("Meat").ShowMenu();
                        } else if (productMenu == 1) {
                            facade.selectProductMenu("Produce").ShowMenu();
                        } else if (productMenu == 2) {
                            break;

                        } else {
                            System.out.println("Invalid entry !!!!!!!!!!!!");
                        }
                    }

                    while (true) {
                        System.out.println("Enter 0 to add the product, 1 to delete the product and 2 for exit ");
                        int input = scnInt.nextInt();
                        if (input == 0) {
                            System.out.println("Enter the product category that you want to add to your list");
                            String productCategory = scnStr.nextLine();
                            System.out.println("Enter the product name that you want to add to your list");
                            String productname = scnStr.nextLine();
                            if (!facade.theProductList.contains(new Product(productCategory, productname))) {
                                facade.addUserProductToList(name, new Product(productname));
                                facade.theProductList.add(new Product(productCategory, productname));
                            } else {
                                System.out.println("!!!!!The product already exist in store");
                            }
                            facade.showUserProductList(name);
                        } else if (input == 1) {
                            System.out.println("Enter the product name that you want to delete");
                            String productname = scnStr.nextLine();
                            if (facade.getUserProductList(name).contains(new Product(productname))) {
                                facade.deleteUserProductToList(name, productname);
                                facade.theProductList.remove(new Product(productname));
                                facade.showUserProductList(name);
                            } else {
                                System.out.println("Error!!! Please enter the product which showed in below list!!!!!!!!");
                                facade.showUserProductList(name);
                            }
                        } else if (input == 2) {
                            break;
                        } else {
                            System.out.println("Invalid entry !!!!!!!!!!!!");
                        }

                    }
                } else {
                    System.out.println("Invalid Credentials please try again");
                }

            } else {
                System.out.println("Invalid user type please try again");
            }

        }

    }
}
