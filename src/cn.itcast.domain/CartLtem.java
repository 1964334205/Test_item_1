package cn.itcast.domain;
//用于代表某个商品和商品出现的次数(购物项)
public class CartLtem {
    private Book book;
    private int quantity;
    private float unit_price;

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
        this.unit_price = this.book.getUnit_price()*quantity;
    }

    public float getUnit_price() {
        return unit_price;
    }

    public void setUnit_price(float unit_price) {
        this.unit_price = unit_price;
    }
}
