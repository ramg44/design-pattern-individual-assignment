public class DisplayProductMenuBasedOnVisitor implements NodeVisitor{


    @Override
    public void visit(ProductMenu product) throws Exception {
        product.ShowMenu();
    }

    @Override
    public void visit(Facade facade) {
        facade.showMenu();
    }
}
