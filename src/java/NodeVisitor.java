import java.util.List;

public interface  NodeVisitor {
    public abstract void visit(ProductMenu products) throws Exception;
    public abstract void visit(Facade facade);
}
