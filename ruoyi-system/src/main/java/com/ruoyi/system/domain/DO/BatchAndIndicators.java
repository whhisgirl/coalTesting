package com.ruoyi.system.domain.DO;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Date;
import java.util.List;

/**
 * 【请填写功能名称】对象 coal_indicators
 *
 * @author ruoyi
 * @date 2023-10-23
 */
public class BatchAndIndicators extends BaseEntity
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

    /**
     * 批次编号
     */
    private String batchNumber;

    private String miningAreaName;

    private String licensePlate;

    private String locationMiningArea;

    private Date sampleTime;

    private String sampleTimeBegin;
    private String sampleTimeAfter;

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

    public String getBatchNumber() {
        return batchNumber;
    }

    public void setBatchNumber(String batchNumber) {
        this.batchNumber = batchNumber;
    }

    public String getMiningAreaName() {
        return miningAreaName;
    }

    public void setMiningAreaName(String miningAreaName) {
        this.miningAreaName = miningAreaName;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public String getLocationMiningArea() {
        return locationMiningArea;
    }

    public void setLocationMiningArea(String locationMiningArea) {
        this.locationMiningArea = locationMiningArea;
    }

    public Date getSampleTime() {
        return sampleTime;
    }

    public void setSampleTime(Date sampleTime) {
        this.sampleTime = sampleTime;
    }

    public String getSampleTimeBegin() {
        return sampleTimeBegin;
    }

    public void setSampleTimeBegin(String sampleTimeBegin) {
        this.sampleTimeBegin = sampleTimeBegin;
    }

    public String getSampleTimeAfter() {
        return sampleTimeAfter;
    }

    public void setSampleTimeAfter(String sampleTimeAfter) {
        this.sampleTimeAfter = sampleTimeAfter;
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
