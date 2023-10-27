package com.ruoyi.system.domain;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 【请填写功能名称】对象 coal_list
 *
 * @author ruoyi
 * @date 2023-10-23
 */
public class CoalList extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 煤采样编号
     */
    @Excel(name = "煤采样编号")
    private String coalNumber;

    /**
     * 煤采样时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    @Excel(name = "煤采样时间", width = 30, dateFormat = "yyyy-MM-dd hh:mm:ss")
    private Date sampleTime;

    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    @Excel(name = "", width = 30, dateFormat = "yyyy-MM-dd hh:mm:ss")
    private Date beginTime;
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    @Excel(name = "", width = 30, dateFormat = "yyyy-MM-dd hh:mm:ss")
    private Date endTime;
    /**
     * 采样标准号
     */
    @Excel(name = "采样标准号")
    private String standardNumber;

    /**
     * 样品粒度
     */
    @Excel(name = "样品粒度")
    private String sampleStrength;

    /**
     * 采样方式
     */
    @Excel(name = "采样方式")
    private String samplingMethod;

    /**
     * 矿区名称
     */
    @Excel(name = "矿区名称")
    private String miningAreaName;

    /**
     * 采样人
     */
    @Excel(name = "采样人")
    private String sampler;

    /**
     * 采样照片（出发前）
     */
    @Excel(name = "批次煤的重量")
    private String batchCoalWeight;

    /**
     * 采样照片（到达目的地）
     */
    @Excel(name = "矿区所在地")
    private String locationMiningArea;

    @Excel(name = "批次编号")
    private String batchNumber;

    @Excel(name = "到达状态")
    private String arrivalStatus;

    @Excel(name = "车牌")
    private String licensePlate;

    @Excel(name = "目的地")
    private String destination;
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    @Excel(name = "出发时间", width = 30, dateFormat = "yyyy-MM-dd hh:mm:ss")
    private Date startTime;

    /**
     * 报告生成时间
     */


    public void setCoalNumber(String coalNumber) {
        this.coalNumber = coalNumber;
    }

    public String getCoalNumber() {
        return coalNumber;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setSampleTime(Date sampleTime) {
        this.sampleTime = sampleTime;
    }

    public Date getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Date beginTime) {
        this.beginTime = beginTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Date getSampleTime() {
        return sampleTime;
    }

    public void setStandardNumber(String standardNumber) {
        this.standardNumber = standardNumber;
    }

    public String getStandardNumber() {
        return standardNumber;
    }

    public void setSampleStrength(String sampleStrength) {
        this.sampleStrength = sampleStrength;
    }

    public String getSampleStrength() {
        return sampleStrength;
    }

    public void setSamplingMethod(String samplingMethod) {
        this.samplingMethod = samplingMethod;
    }

    public String getSamplingMethod() {
        return samplingMethod;
    }

    public void setMiningAreaName(String miningAreaName) {
        this.miningAreaName = miningAreaName;
    }

    public String getMiningAreaName() {
        return miningAreaName;
    }

    public void setSampler(String sampler) {
        this.sampler = sampler;
    }

    public String getSampler() {
        return sampler;
    }

    public void setBatchCoalWeight(String batchCoalWeight) {
        this.batchCoalWeight = batchCoalWeight;
    }

    public String getBatchCoalWeight() {
        return batchCoalWeight;
    }

    public void setLocationMiningArea(String locationMiningArea) {
        this.locationMiningArea = locationMiningArea;
    }

    public String getLocationMiningArea() {
        return locationMiningArea;
    }


    public void setBatchNumber(String batchNumber) {
        this.batchNumber = batchNumber;
    }

    public String getBatchNumber() {
        return batchNumber;
    }

    public void setArrivalStatus(String arrivalStatus) {
        this.arrivalStatus = arrivalStatus;
    }

    public String getArrivalStatus() {
        return arrivalStatus;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getDestination() {
        return destination;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("coalNumber", getCoalNumber())
                .append("sampleTime", getSampleTime())
                .append("beginTime", getBeginTime())
                .append("endTime", getEndTime())
                .append("standardNumber", getStandardNumber())
                .append("sampleStrength", getSampleStrength())
                .append("samplingMethod", getSamplingMethod())
                .append("miningAreaName", getMiningAreaName())
                .append("sampler", getSampler())
                .append("batchCoalWeight", getBatchCoalWeight())
                .append("locationMiningArea", getLocationMiningArea())
                .append("batchNumber", getBatchNumber())
                .append("arrivalStatus", getArrivalStatus())
                .append("batchCoalWeight", getBatchCoalWeight())
                .append("licensePlate", getLicensePlate())
                .append("destination", getDestination())
                .append("startTime", getStartTime())
                .toString();
    }
}
