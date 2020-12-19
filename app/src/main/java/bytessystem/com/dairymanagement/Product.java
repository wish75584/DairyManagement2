package bytessystem.com.dairymanagement;

public class Product {

    String P_id, P_name, P_rate;

    public Product(String p_id, String p_name, String p_rate) {
        P_id = p_id;
        P_name = p_name;
        P_rate = p_rate;
    }

    public String getP_id() {
        return P_id;
    }

    public void setP_id(String p_id) {
        P_id = p_id;
    }

    public String getP_name() {
        return P_name;
    }

    public void setP_name(String p_name) {
        P_name = p_name;
    }

    public String getP_rate() {
        return P_rate;
    }

    public void setP_rate(String p_rate) {
        P_rate = p_rate;
    }
}


