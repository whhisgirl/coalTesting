package com.ruoyi.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 【请填写功能名称】对象 batch
 * 
 * @author ruoyi
 * @date 2023-10-23
 */
public class Batch extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 批次编号 */
    private String batchNumber;

    /** 批次煤的重量 */
    @Excel(name = "批次煤的重量")
    private String batchCoalWeight;

    /** 矿区名称 */
    @Excel(name = "矿区名称")
    private String miningAreaName;

    /** 运输车辆车牌（集合） */
    @Excel(name = "运输车辆车牌", readConverterExp = "集=合")
    private String licensePlate;

    /** 矿区所在地（省/市/县） */
    @Excel(name = "矿区所在地", readConverterExp = "省=/市/县")
    private String locationMiningArea;

    /** 出发时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "出发时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date startTime;

    /** 到达时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "到达时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date arrivalTime;

    /** 登记表编号 */
    @Excel(name = "登记表编号")
    private String registrationNumber;

    /** 煤采样编号（一批多种煤） */
    @Excel(name = "煤采样编号", readConverterExp = "一=批多种煤")
    private String coalNumber;

    /** 汽运目的地 */
    @Excel(name = "汽运目的地")
    private String destination;

    /** 到达状态 */
    @Excel(name = "到达状态")
    private String arrivalStatus;

    public void setBatchNumber(String batchNumber) 
    {
        this.batchNumber = batchNumber;
    }

    public String getBatchNumber() 
    {
        return batchNumber;
    }
    public void setBatchCoalWeight(String batchCoalWeight) 
    {
        this.batchCoalWeight = batchCoalWeight;
    }

    public String getBatchCoalWeight() 
    {
        return batchCoalWeight;
    }
    public void setMiningAreaName(String miningAreaName) 
    {
        this.miningAreaName = miningAreaName;
    }

    public String getMiningAreaName() 
    {
        return miningAreaName;
    }
    public void setLicensePlate(String licensePlate) 
    {
        this.licensePlate = licensePlate;
    }

    public String getLicensePlate() 
    {
        return licensePlate;
    }
    public void setLocationMiningArea(String locationMiningArea) 
    {
        this.locationMiningArea = locationMiningArea;
    }

    public String getLocationMiningArea() 
    {
        return locationMiningArea;
    }
    public void setStartTime(Date startTime) 
    {
        this.startTime = startTime;
    }

    public Date getStartTime() 
    {
        return startTime;
    }
    public void setArrivalTime(Date arrivalTime) 
    {
        this.arrivalTime = arrivalTime;
    }

    public Date getArrivalTime() 
    {
        return arrivalTime;
    }
    public void setRegistrationNumber(String registrationNumber) 
    {
        this.registrationNumber = registrationNumber;
    }

    public String getRegistrationNumber() 
    {
        return registrationNumber;
    }
    public void setCoalNumber(String coalNumber) 
    {
        this.coalNumber = coalNumber;
    }

    public String getCoalNumber() 
    {
        return coalNumber;
    }
    public void setDestination(String destination) 
    {
        this.destination = destination;
    }

    public String getDestination() 
    {
        return destination;
    }
    public void setArrivalStatus(String arrivalStatus) 
    {
        this.arrivalStatus = arrivalStatus;
    }

    public String getArrivalStatus() 
    {
        return arrivalStatus;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("batchNumber", getBatchNumber())
            .append("batchCoalWeight", getBatchCoalWeight())
            .append("miningAreaName", getMiningAreaName())
            .append("licensePlate", getLicensePlate())
            .append("locationMiningArea", getLocationMiningArea())
            .append("startTime", getStartTime())
            .append("arrivalTime", getArrivalTime())
            .append("registrationNumber", getRegistrationNumber())
            .append("coalNumber", getCoalNumber())
            .append("destination", getDestination())
            .append("arrivalStatus", getArrivalStatus())
            .toString();
    }
}
