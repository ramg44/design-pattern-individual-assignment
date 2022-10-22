import java.util.Objects;

public class Product {
    private String ProductCategory;
    private String productName;

    public Product(String productName) {
        this.productName = productName;
    }

    public Product(String productCategory, String productName) {
        ProductCategory = productCategory;
        this.productName = productName;
    }


    public String getProductCategory() {
        return ProductCategory;
    }

    public void setProductCategory(String productCategory) {
        ProductCategory = productCategory;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product product)) return false;
        return Objects.equals(productName, product.productName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productName);
    }
}
