package bytessystem.com.dairymanagement;

public class Customer {
    String cst_name, cst_mob, cst_add, cst_area, cst_id;

    public String getCst_name() {
        return cst_name;
    }

    public void setCst_name(String cst_name) {
        this.cst_name = cst_name;
    }

    public String getCst_mob() {
        return cst_mob;
    }

    public void setCst_mob(String cst_mob) {
        this.cst_mob = cst_mob;
    }

    public String getCst_add() {
        return cst_add;
    }

    public void setCst_add(String cst_add) {
        this.cst_add = cst_add;
    }

    public String getCst_area() {
        return cst_area;
    }

    public void setCst_area(String cst_area) {
        this.cst_area = cst_area;
    }

    public String getCst_id() {
        return cst_id;
    }

    public void setCst_id(String cst_id) {
        this.cst_id = cst_id;
    }

    public Customer(String cst_name, String cst_mob, String cst_add, String cst_area, String cst_id) {
        this.cst_name = cst_name;
        this.cst_mob = cst_mob;
        this.cst_add = cst_add;
        this.cst_area = cst_area;
        this.cst_id = cst_id;


    }
}

