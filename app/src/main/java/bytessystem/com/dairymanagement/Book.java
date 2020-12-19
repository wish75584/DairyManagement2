package bytessystem.com.dairymanagement;

public class Book {

    String db_name, db_prod;
    String db_id;

    public Book(String db_name, String db_prod, String db_id) {
        this.db_name = db_name;
        this.db_prod = db_prod;
        this.db_id = db_id;
    }

    public String getDb_name() {
        return db_name;
    }

    public void setDb_name(String db_name) {
        this.db_name = db_name;
    }

    public String getDb_prod() {
        return db_prod;
    }

    public void setDb_prod(String db_prod) {
        this.db_prod = db_prod;
    }

    public String getDb_id() {
        return db_id;
    }

    public void setDb_id(String db_id) {
        this.db_id = db_id;
    }
}




