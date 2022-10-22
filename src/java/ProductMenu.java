public interface ProductMenu {
    public void ShowMenu();
    public void showAddButton();
    public void showViewButton();
    public void showRadioButton();
    public void showLabels();
    public void showComboxes();
    public void add(Product product);
    public ListIterator getIterator();
    public void accept(NodeVisitor nodeVisitor) throws Exception;
}
// Which will acts ass a bridge
