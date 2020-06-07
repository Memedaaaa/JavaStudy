package communication.stateDemo.ProducterAndCusromer;

/**
 * 产品
 */
public class Product {
    private String id;// 产品id
    private String name;//产品name

    public Product(String id, String name) {
        this.id = id;
        this.name = name;
    }
    public String toString() {
        return "(" + id + ";" + name + ")";
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
