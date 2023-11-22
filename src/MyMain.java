import java.util.Scanner;

public class MyMain {
    public static void main(String[] args) {
        System.out.println("-----------------------");
        System.out.println("   商品的后台管理系统");
        System.out.println("         (商家版)");
        System.out.println("          版本号:v1.0");
        System.out.println("          作者:CCCCC");
        System.out.println("-----------------------");
        Scanner scanner = new Scanner(System.in);
        char function_no='0';
        //需要把非静态类的方法GoodManagerImpl进行实例化
        GoodsManagerImpl manager = new GoodsManagerImpl();
        //这个显示的菜单，执行一遍操作后，后面还可以选择，这个菜单反复出现，供用户选择
        //显示商家进行商品增删改查的操作
        while(true){
            System.out.println("-----------------------");
            System.out.println("1-------添加商品");
            System.out.println("2-------删除商品");
            System.out.println("3-------修改商品");
            System.out.println("4-------查询所有商品");
            System.out.println("5-------按编号查询特定商品");
            System.out.println("6-------按商品名称查询部分商品");
            System.out.println("7-------按价格区间查询部分商品");
            System.out.println("8-------退出");
            System.out.println("---------------------------");
            System.out.println("请选择操作的功能编号:");
            String myfunction_no=scanner.next();
            System.out.println(myfunction_no);
            //字符串本身就是一个char数组
            function_no=myfunction_no.toCharArray()[0];
//            try{
//                function_no=(char)scanner.nextByte();
//
//            }catch(Exception e){
//                System.out.println("你选择的功能编号不正确，请重新选择");
//                //使用 continue后面代码不执行，继续下次循环，执行速度太快，try...catch没有判断输入内容就开始执行
//            }
            //如果循环中有switch的优化，break只是退出switch的作用，并不退出循环，这里只能用if条件限定用户的退出
            if(function_no=='8'){
                break;
            }
            //采用switch,break退出的是switch
            switch(function_no){
                case '1': manager.add_goods();break;
                case '2': manager.del_goods();break;
                case '3': manager.update_goods();break;
                case '4':
                    System.out.println(manager.findAll());break;
                case '5':
                    System.out.println(manager.findByNo());break;
                case '6':
                    System.out.println(manager.findByName());break;
                case '7':
                    System.out.println(manager.findByPrice());break;
//                default:continue;
            }
        }

    }
}
