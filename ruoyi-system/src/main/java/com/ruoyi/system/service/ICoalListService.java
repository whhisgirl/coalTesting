package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.CoalList;

/**
 * 【请填写功能名称】Service接口
 *
 * @author ruoyi
 * @date 2023-10-23
 */
public interface ICoalListService {
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
}

