/*
java bean
这个类只是描述商品，哪些属性可以访问，哪些属性不开放访问。
描述商品的一个java bean
 */
public class Goods {
    //封装，所有的属性私有化
    //no商品编号
    private String no;
    //name商品名称
    private String name;
    //price商品价格
    private double price;
    //shop商家名称
    private String shop;
    //商品分类 type
    private String type;
    //封装构造函数，全参，无参

    public Goods() {
    }

    public Goods(String no, String name, double price, String shop, String type) {
        this.no = no;
        this.name = name;
        this.price = price;
        this.shop = shop;
        this.type = type;
    }
    //这些商品都需要getter,和setter方法

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getShop() {
        return shop;
    }

    public void setShop(String shop) {
        this.shop = shop;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    //打印对象显示的地址，显示的本类中所有的属性的值,重写toString

    @Override
    public String toString() {
        return "Goods{" +
                "no='" + no + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", shop='" + shop + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
