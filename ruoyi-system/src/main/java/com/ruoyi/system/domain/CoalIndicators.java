package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 【请填写功能名称】对象 coal_indicators
 * 
 * @author ruoyi
 * @date 2023-10-23
 */
public class CoalIndicators extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 煤采样编号 */
    private String coalNumber;

    /** 水分 */
    @Excel(name = "水分")
    private String waterContent;

    /** 灰分 */
    @Excel(name = "灰分")
    private String ashContent;

    /** 挥发分 */
    @Excel(name = "挥发分")
    private String coalVolatile;

    /** 密度 */
    @Excel(name = "密度")
    private String density;

    /** 电阻率 */
    @Excel(name = "电阻率")
    private String resistivity;

    /** 基低位发热量 */
    @Excel(name = "基低位发热量")
    private String baseLowCalorific;

    public void setCoalNumber(String coalNumber) 
    {
        this.coalNumber = coalNumber;
    }

    public String getCoalNumber() 
    {
        return coalNumber;
    }
    public void setWaterContent(String waterContent) 
    {
        this.waterContent = waterContent;
    }

    public String getWaterContent() 
    {
        return waterContent;
    }
    public void setAshContent(String ashContent) 
    {
        this.ashContent = ashContent;
    }

    public String getAshContent() 
    {
        return ashContent;
    }
    public void setCoalVolatile(String coalVolatile) 
    {
        this.coalVolatile = coalVolatile;
    }

    public String getCoalVolatile() 
    {
        return coalVolatile;
    }
    public void setDensity(String density) 
    {
        this.density = density;
    }

    public String getDensity() 
    {
        return density;
    }
    public void setResistivity(String resistivity) 
    {
        this.resistivity = resistivity;
    }

    public String getResistivity() 
    {
        return resistivity;
    }
    public void setBaseLowCalorific(String baseLowCalorific) 
    {
        this.baseLowCalorific = baseLowCalorific;
    }

    public String getBaseLowCalorific() 
    {
        return baseLowCalorific;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("coalNumber", getCoalNumber())
            .append("waterContent", getWaterContent())
            .append("ashContent", getAshContent())
            .append("coalVolatile", getCoalVolatile())
            .append("density", getDensity())
            .append("resistivity", getResistivity())
            .append("baseLowCalorific", getBaseLowCalorific())
            .toString();
    }
}
