package org.nishanth.models;

//import java.sql.Timestamp;

public class Category {
    private int id;
    private String categoryName;

    public Category(String categoryName) {
//        this.id = id;
//        this.categoryName = categoryName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
    public String getName() {
        return null;
    }
}
