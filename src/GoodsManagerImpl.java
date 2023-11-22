import java.util.*;

public class GoodsManagerImpl implements GoodsManager{
    //设置一个总管家，HashMap，满足封装，需要私有,Map类型需要键(key） 就是no，是String,value是对象，是Goods
    private  Map<String,Goods> goods_list=new HashMap<>();
    //根据字符串源码中的处理方法，一个char[]定义一个size，到底有多个数。
    private   int size=0;
    //最开始完成，添加一个商品,注意里面goods是执行过程中用户输入的,这里的goods就不需要传参
    @Override
    public  void add_goods() {
        //需要输入商品的名称，商品的价格，店铺的名称，商品的分类
        Scanner scanner=new Scanner(System.in);
        //接收商品名称
        System.out.println("请输入添加商品的名称");
        String name=scanner.next();
        //接收商品的价格
        System.out.println("请输入添加商品的价格");
        //初始化没有定义的价格
        double price=9999;
        try {
            price = scanner.nextDouble();
        }catch(Exception e){

        }
        //接收商品的商家
        System.out.println("商家名称");
        String shop=scanner.next();
        //接收商品的分类
        System.out.println("商品的分类");
        String type=scanner.next();
        //产生一个no，no让系统随机产生，产生后加上一个索引size，理解当前商品的索引值
        //UUID，一串随机,随机类型是UUID类型，如果用+号，在这里有一个StringBuilder对象，只有一个size,这里使用concat，
        String no=UUID.randomUUID().toString().concat(size+"");
        //初始化，商品参数结束，直接实例化
        Goods goods=new Goods(no,name,price,shop,type);
        //放在HashMap中就已经去重
        goods_list.put(no,goods);
        size++;
    }

    @Override
    public void del_goods() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入删除的商品编号");
        String no=scanner.next();
        System.out.println("你确定要删除该商品吗?(y/n)");
        String ans=scanner.next();
        if(ans.toLowerCase().equals("y")){
            goods_list.remove(no);
        }else{
            System.out.println("删除取消，你可以选择其它操作");
        }
    }

    @Override
    public void update_goods() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入修改商品的商品编号:");
        //需要用户输入编号
        String no=scanner.next();
        //必须按商品的编号，告诉商品原来名称，需要改成,先把商品取出
        Goods goods=goods_list.get(no);
        //要求输入需要修改的商品名称内容
        System.out.println("商品名称的原来内容:");
        System.out.println(goods.getName());
        //输出需要修改的商品名称内容
        System.out.println("请输入修改后的名称");
        String name=scanner.next();
        // 要求输入需要修改的商品价格内容
        System.out.println("商品名称的原来价格:");
        System.out.println(goods.getPrice());
        //输出需要修改的商品价格
        System.out.println("请输入修改后的价格");
        double price=goods.getPrice();
        try{
           price=scanner.nextDouble();
        }catch(Exception e){

        }
        // 要求输入需要修改的商品店铺名称内容
        System.out.println("商品名称的店铺名称:");
        System.out.println(goods.getShop());
        //输出需要修改的商品店铺名称
        System.out.println("请输入修改后的店铺名称");
        String shop=scanner.next();
        // 要求输入需要修改的商品类别内容
        System.out.println("商品名称的商品类别:");
        System.out.println(goods.getType());
        //输出需要修改的商品类别
        System.out.println("请输入修改后的商品类别");
        String type=scanner.next();
        //修改商品的属性值，可以利用HashMap中key值覆盖的道理，产生一个新的商品
        goods=new Goods(goods.getNo(),name,price,shop,type);
        goods_list.put(goods.getNo(),goods);
    }

    @Override
    public Goods findByNo() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入查询的商品编号:");
        String no=scanner.next();
        return goods_list.get(no);
    }

    @Override
    public Collection<Goods> findAll() {
        //显示所有，就是遍历HashMap,遍历HashMap中的值就可以,不需要遍历key,因为key的目的是去重
        //直接使用values显示所有的值
        return goods_list.values();
    }

    @Override
    public List<Goods> findByName() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("输入需要查询的商品名称：");
        String name=scanner.next();
        //构造结果
        List<Goods> myresult=new ArrayList<>();
        Collection<Goods> mygoods=goods_list.values();
        //这里迭代器写
        Iterator<Goods> myiter=mygoods.iterator();
        while(myiter.hasNext()){
            Goods goods=myiter.next();
            if(goods.getName().indexOf(name)>-1){
                myresult.add(goods);
            }
        }
        return myresult;
    }

    @Override
    public List<Goods> findByPrice() {
        Scanner scanner=new Scanner(System.in);
        System.out.println("请输入查询商品价格的开始区间：");
        double start=0;
        double end=0;
        try {
            start=scanner.nextDouble();
        }catch(Exception e){

        }
        System.out.println("请输入查询商品价格的结束区间：");
        try {
            end=scanner.nextDouble();
        }catch(Exception e){

        }
        //构造结果
        List<Goods> myresult=new ArrayList<>();
        Collection<Goods> mygoods=goods_list.values();
        //这里迭代器写
        Iterator<Goods> myiter=mygoods.iterator();
        while(myiter.hasNext()){
            Goods goods=myiter.next();
            if(goods.getPrice()>=start && goods.getPrice()<=end){
                myresult.add(goods);
            }
        }
        return myresult;
    }
}
