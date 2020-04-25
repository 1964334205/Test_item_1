package cn.itcast.domain;
//存储用户购物车数据
public class Book {
    private String id;
    private String name;
    private String author;
    private float unit_price;
    private String description;

    public Book() {

    }

    public Book(String id, String name, String author, float unit_price, String description) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.unit_price = unit_price;
        this.description = description;
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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public float getUnit_price() {
        return unit_price;
    }

    public void setUnit_price(float unit_price) {
        this.unit_price = unit_price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
