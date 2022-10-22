public abstract class Person {

    ProductMenu meatProductMenu;
    ProductMenu produceProductMenu;

    ProductMenu productMenu;
     private String name;

    public Person(ProductMenu meatProductMenu,ProductMenu produceProductMenu) throws Exception {
      this.meatProductMenu = meatProductMenu;
      this.produceProductMenu =produceProductMenu;
    }

    public Person() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public abstract void showMenu();

    public void showAddButton() {

    }

    public void showViewButton() {

    }

    public void showRadioButton() {

    }

    public void showLabels() {

    }

    public abstract ProductMenu CreateProductMenu(int productType) throws Exception;

}
