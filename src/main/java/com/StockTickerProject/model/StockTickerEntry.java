package com.StockTickerProject.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.DataOutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

@Data
public class StockTickerEntry {
    public UUID ID;
    public int quarter;
    public String stock;
    public Date date;
    public double high; //maybe change to string
    public double low;
    public double close;
    public double open;
    public int volume;
    public double percentChangePrice;
    public double percentChangeVolume;
    public int previousWeeksVolume;
    public double nextWeekOpen;
    public double nextWeekClose;
    public double percentChangeNWPrice;
    public int daysToNextDividend;
    public double percentReturnNextDividend;

    public StockTickerEntry() {
        //default constructor
    }



    public StockTickerEntry(
            @JsonProperty("quarter") String quarter,
            @JsonProperty("stock") String stock,
            @JsonProperty("date") String date,
            @JsonProperty("high") String high,
            @JsonProperty("low") String low,
            @JsonProperty("close") String close,
            @JsonProperty("open") String open,
            @JsonProperty("volume") String volume,
            @JsonProperty("percentChangePrice") String percentChangePrice,
            @JsonProperty("percentChangeVolume") String percentChangeVolume,
            @JsonProperty("previousWeeksVolume") String previousWeeksVolume,
            @JsonProperty("nextWeekOpen") String nextWeekOpen,
            @JsonProperty("nextWeekClose") String nextWeekClose,
            @JsonProperty("percentChangeNWPrice") String percentChangeNWPrice,
            @JsonProperty("daysToNextDividend") String daysToNextDividend,
            @JsonProperty("percentReturnNextDividend") String percentReturnNextDividend) throws ParseException {
        ID = UUID.randomUUID();
        this.quarter = Integer.parseInt(quarter);
        this.stock = stock;
        this.date = new SimpleDateFormat("MM/dd/yyyy").parse(date);
        this.high = Double.parseDouble(high);
        this.low = Double.parseDouble(low);
        this.close = Double.parseDouble(close);
        this.open = Double.parseDouble(open);
        this.volume = Integer.parseInt(volume);
        this.percentChangePrice = Double.parseDouble(percentChangePrice);
        this.percentChangeVolume = Double.parseDouble(percentChangeVolume);
        this.previousWeeksVolume = Integer.parseInt(previousWeeksVolume);
        this.nextWeekOpen = Double.parseDouble(nextWeekOpen);
        this.nextWeekClose = Double.parseDouble(nextWeekClose);
        this.percentChangeNWPrice = Double.parseDouble(percentChangeNWPrice);
        this.daysToNextDividend = Integer.parseInt(daysToNextDividend);
        this.percentReturnNextDividend = Double.parseDouble(percentReturnNextDividend);
    }

    public StockTickerEntry(
            UUID id,
            String quarter,
            String stock,
            String date,
            String open,
            String high,
            String low,
            String close,
            String volume,
            String percentChangePrice,
            String percentChangeVolume,
            String previousWeeksVolume,
            String nextWeekOpen,
            String nextWeekClose,
            String percentChangeNWPrice,
            String daysToNextDividend,
            String percentReturnNextDividend
    ) throws ParseException {
        ID = id;
        this.quarter = Integer.parseInt(quarter);
        this.stock = stock;
        this.date = new SimpleDateFormat("MM/dd/yyyy").parse(date);
        this.high = Double.parseDouble(high);
        this.low = Double.parseDouble(low);
        this.close = Double.parseDouble(close);
        this.open = Double.parseDouble(open);
        this.volume = Integer.parseInt(volume);
        this.percentChangePrice = Double.parseDouble(percentChangePrice);
        this.percentChangeVolume = Double.parseDouble(percentChangeVolume);
        this.previousWeeksVolume = Integer.parseInt(previousWeeksVolume);
        this.nextWeekOpen = Double.parseDouble(nextWeekOpen);
        this.nextWeekClose = Double.parseDouble(nextWeekClose);
        this.percentChangeNWPrice = Double.parseDouble(percentChangeNWPrice);
        this.daysToNextDividend = Integer.parseInt(daysToNextDividend);
        this.percentReturnNextDividend = Double.parseDouble(percentReturnNextDividend);
    }


}
