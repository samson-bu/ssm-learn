package self.samson.ssm.learn.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import self.samson.ssm.learn.po.Items;
import self.samson.ssm.learn.po.ItemsExample;

public interface ItemsMapper {
    long countByExample(ItemsExample example);

    int deleteByExample(ItemsExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Items record);

    int insertSelective(Items record);

    List<Items> selectByExampleWithBLOBs(ItemsExample example);

    List<Items> selectByExample(ItemsExample example);

    Items selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Items record, @Param("example") ItemsExample example);

    int updateByExampleWithBLOBs(@Param("record") Items record, @Param("example") ItemsExample example);

    int updateByExample(@Param("record") Items record, @Param("example") ItemsExample example);

    int updateByPrimaryKeySelective(Items record);

    int updateByPrimaryKeyWithBLOBs(Items record);

    int updateByPrimaryKey(Items record);
}