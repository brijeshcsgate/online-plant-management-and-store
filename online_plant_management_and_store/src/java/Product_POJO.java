
import java.util.UUID;
import javax.annotation.ManagedBean;


public class Product_POJO {
          
          String p_code;
          boolean isactive;
          String p_name ;
          String p_quantity ;
          String p_discription ;
          String p_brand ;
          String p_category ;
          String p_price;
          String p_purchases;
          String supplier_id;

    public Product_POJO(String p_name, String p_quantity, String p_discription, String p_brand, String p_category, String p_price, String supplier_id) {
        this.p_name = p_name;
        this.p_quantity = p_quantity;
        this.p_discription = p_discription;
        this.p_brand = p_brand;
        this.p_category = p_category;
        this.p_price = p_price;
        this.supplier_id = supplier_id;
        this.isactive=true;
        this.p_code="PRD"+UUID.randomUUID().toString().substring(25).toUpperCase();
        this.p_purchases="0";
    }
          

    public String getP_code() {
        return p_code;
    }

    public boolean isIsactive() {
        return isactive;
    }

    public String getP_name() {
        return p_name;
    }

    public String getP_quantity() {
        return p_quantity;
    }

    public String getP_discription() {
        return p_discription;
    }

    public String getP_brand() {
        return p_brand;
    }

    public String getP_category() {
        return p_category;
    }

    public String getP_price() {
        return p_price;
    }

    public String getP_purchases() {
        return p_purchases;
    }

    public String getSupplier_id() {
        return supplier_id;
    }
    
}
