package com.buddhist.user.mapper;

import com.buddhist.user.model.Inventory;
import com.buddhist.user.model.InventoryExample;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface InventoryMapper {
    long countByExample(InventoryExample example);

    int deleteByExample(InventoryExample example);

    int deleteByPrimaryKey(Integer iid);

    int insert(Inventory record);

    int insertSelective(Inventory record);

    List<Inventory> selectByExample(InventoryExample example);

    Inventory selectByPrimaryKey(Integer iid);

    int updateByExampleSelective(@Param("record") Inventory record, @Param("example") InventoryExample example);

    int updateByExample(@Param("record") Inventory record, @Param("example") InventoryExample example);

    int updateByPrimaryKeySelective(Inventory record);

    int updateByPrimaryKey(Inventory record);

    /*
    * 根据条件传入并进行查询符合条件的清单信息
    * */
    List<Inventory> selectInventoryByCondition(Inventory inventory);

    /*
     * 根据发布清单者的身份以及清单类别，是否指定订单进行查询
     * */
    List<Inventory> selectInventoryByIdentifyAndCIdAndReceive
    (@Param("identify") String identify, @Param("cid") Integer cid, @Param("receive") String receive);
}