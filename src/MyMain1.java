import java.util.Scanner;

public class MyMain1 {
    public static void main(String[] args) {
        GoodsManagerImpl goodsManager = new GoodsManagerImpl();
        //一次添加
        goodsManager.add_goods();
        System.out.println(goodsManager.findAll());
       //按名字查
        Scanner scanner = new Scanner(System.in);
        System.out.println("输入查询的商品名称");
        String name=scanner.next();
        System.out.println(goodsManager.findByName());
    }
}
