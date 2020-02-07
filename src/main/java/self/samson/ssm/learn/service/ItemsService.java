package self.samson.ssm.learn.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import self.samson.ssm.learn.mapper.ItemsMapper;
import self.samson.ssm.learn.po.Items;
import self.samson.ssm.learn.po.ItemsExample;

import java.util.List;

@Service
public class ItemsService {

    @Autowired
    private ItemsMapper itemsMapper;

    /**
     * 商品的查询列表
     * @param items 要查询的商品
     * @return 满足条件的商品列表
     */
    public List<Items> findItemsList (Items items) {
        ItemsExample itemsExample = new ItemsExample();
        ItemsExample.Criteria criteria = itemsExample.createCriteria();
        if (null != items && null != items.getName() && !items.getName().isEmpty()) {
            criteria.andNameLike(items.getName());
        } else if (null != items && null != items.getId()) {
            criteria.andIdEqualTo(items.getId());
        }

        return itemsMapper.selectByExample(itemsExample);
    }

    /**
     * 根据商品ID查询商品信息
     * @param id 商品ID
     * @return 满足条件的商品
     */
    public Items findItemsById(int id) {
        return itemsMapper.selectByPrimaryKey(id);
    }

    /**
     * 更新商品信息
     * @param id 商品ID
     * @param items 要更新的商品信息
     */
    public void updateItems(int id, Items items) {
        itemsMapper.updateByPrimaryKey(items);
    }

}
