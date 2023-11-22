import java.util.Collection;
import java.util.List;

/*
这是一个接口，专门管理商品的java bean
 */
public interface GoodsManager {
    //添加方法,一般初始化，返回值为空,这里参数在逻辑实现直接在方法中输入商品的相关参数
    public  void add_goods();
    //删除方法，传入索引，这里传入编号，因为这里的删除有ArrayList还有HashMap，HashMap高效率地做了商品编号去重
    public void del_goods();
    //更新方法，需要更新商品的所有内容，按商品的编号来更新
    public void update_goods();
    //查询，必须返回用户结果，一定要有返回，返回内容多个
    //按编号查,一个编号对应一个商品，返回值只有一个商品
    public Goods findByNo();
    //查询所有,出来是一个动态的集合，不能是数组，不需要去重,使用ArrayList，返回是一个ArrayList，里面是Goods
    public Collection<Goods> findAll();
    //按商品名称查,返回一堆商品
    public List<Goods> findByName();
    //按商品价格查，返回一堆商品
    public List<Goods> findByPrice();
}
