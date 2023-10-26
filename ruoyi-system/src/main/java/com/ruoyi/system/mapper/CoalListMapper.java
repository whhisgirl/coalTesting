package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.CoalList;
import org.apache.ibatis.annotations.Mapper;

/**
 * 【请填写功能名称】Mapper接口
 *
 * @author ruoyi
 * @date 2023-10-23
 */
@Mapper
public interface CoalListMapper {
    /**
     * 查询【请填写功能名称】
     *
     * @param coalNumber 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    public CoalList selectCoalListByCoalNumber(String coalNumber);

    /**
     * 查询【请填写功能名称】列表
     *
     * @param coalList 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<CoalList> selectCoalList(CoalList coalList);


    /**
     * 修改【请填写功能名称】
     *
     * @param coalList 【请填写功能名称】
     * @return 结果
     */
    public int updateCoalList(CoalList coalList);


}

