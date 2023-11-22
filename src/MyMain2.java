public class MyMain2 {
    public static void main(String[] args) {
        GoodsManagerImpl goodsManager = new GoodsManagerImpl();
        //两次添加
        goodsManager.add_goods();
        System.out.println(goodsManager.findAll());
//        goodsManager.add_goods();
//        System.out.println(goodsManager.findAll());
        //删除
//        Scanner scanner=new Scanner(System.in);
//        System.out.println("输入需要删除的商品编号");
//        String no=scanner.next();
//        goodsManager.del_goods();
//        System.out.println(goodsManager.findAll());
//        //一次更新
//        goodsManager.update_goods();
//        System.out.println(goodsManager.findAll());
    }
}
