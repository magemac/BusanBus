package com.cos.busanbus;

import android.text.Editable;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.sql.Time;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@Entity
public class Bus {
    @PrimaryKey
    public int busLineNum;

    public String busType;
    public String companyId;
    public String endTime;
    public String firstTime;
    public String headway;
    public String headwayHoli;
    public String headwayNorm;
    public String headwayPeak;
    public Long lineId;
    public String startPoint;
    public String endPoint;

    public Bus(int busLineNum, String busType, String companyId, String endTime, String firstTime, String headway, String headwayHoli, String headwayNorm, String headwayPeak, Long lineId, String startPoint, String endPoint) {
        this.busLineNum = busLineNum;
        this.busType = busType;
        this.companyId = companyId;
        this.endTime = endTime;
        this.firstTime = firstTime;
        this.headway = headway;
        this.headwayHoli = headwayHoli;
        this.headwayNorm = headwayNorm;
        this.headwayPeak = headwayPeak;
        this.lineId = lineId;
        this.startPoint = startPoint;
        this.endPoint = endPoint;
    }

    public Bus(String busType) {
        this.busType = busType;
    }

    public Bus(){};
}
