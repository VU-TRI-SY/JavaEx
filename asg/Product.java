package asg;
public class Product{
    //public private: access modifier
    private static int count = 0; // count to generate product id
    int id;
    String name;
    double price;
    int quantity;

    public Product(String name_, double price_, int quantity_) {
        //this: refer to the current object -> object that call this method
        this.id = count++;
        this.name = name_;
        this.price = price_;
        this.quantity = quantity_;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }
    //get: lay thong tin
    //set: gan thong tin
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    
}

