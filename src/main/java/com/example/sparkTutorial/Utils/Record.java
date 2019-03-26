package com.example.sparkTutorial.Utils;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


@Entity
public class Record implements Serializable {

    @Id
    @SequenceGenerator(name = "record_id", sequenceName = "record_SQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "record_id")
    private Integer id;
    @Column(name = "Region", nullable = true)
    private String Region;
    @Column(name = "Country", nullable = true)
    private String Country;
    @Column(name = "ItemType", nullable = true)
    private String ItemType;
    @Column(name = "SalesChannel", nullable = true)
    private String SalesChannel;
    @Column(name = "OrderPriority", nullable = true)
    private String OrderPriority;
    @Column(name = "OrderDate", nullable = true)
    private Date OrderDate;
    @Column(name = "OrderID", nullable = true)
    private Integer OrderID;
    @Column(name = "ShipDate", nullable = true)
    private Date ShipDate;
    @Column(name = "UnitsSold", nullable = true)
    private Double UnitsSold;
    @Column(name = "UnitPrice", nullable = true)
    private Double UnitPrice;
    @Column(name = "UnitCost", nullable = true)
    private Double UnitCost;
    @Column(name = "TotalRevenue", nullable = true)
    private Double TotalRevenue;
    @Column(name = "TotalCost", nullable = true)
    private Double TotalCost;
    @Column(name = "TotalProfit", nullable = true)
    private Double TotalProfit;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRegion() {
        return Region;
    }

    public void setRegion(String region) {
        Region = region;
    }

    public String getCountry() {
        return Country;
    }

    public void setCountry(String country) {
        Country = country;
    }

    public String getItemType() {
        return ItemType;
    }

    public void setItemType(String itemType) {
        ItemType = itemType;
    }

    public String getSalesChannel() {
        return SalesChannel;
    }

    public void setSalesChannel(String salesChannel) {
        SalesChannel = salesChannel;
    }

    public String getOrderPriority() {
        return OrderPriority;
    }

    public void setOrderPriority(String orderPriority) {
        OrderPriority = orderPriority;
    }

    public Date getOrderDate() {
        return OrderDate;
    }

    public void setOrderDate(Date orderDate) {
        OrderDate = orderDate;
    }

    public Integer getOrderID() {
        return OrderID;
    }

    public void setOrderID(Integer orderID) {
        OrderID = orderID;
    }

    public Date getShipDate() {
        return ShipDate;
    }

    public void setShipDate(Date shipDate) {
        ShipDate = shipDate;
    }

    public Double getUnitsSold() {
        return UnitsSold;
    }

    public void setUnitsSold(Double unitsSold) {
        UnitsSold = unitsSold;
    }

    public Double getUnitPrice() {
        return UnitPrice;
    }

    public void setUnitPrice(Double unitPrice) {
        UnitPrice = unitPrice;
    }

    public Double getUnitCost() {
        return UnitCost;
    }

    public void setUnitCost(Double unitCost) {
        UnitCost = unitCost;
    }

    public Double getTotalRevenue() {
        return TotalRevenue;
    }

    public void setTotalRevenue(Double totalRevenue) {
        TotalRevenue = totalRevenue;
    }

    public Double getTotalCost() {
        return TotalCost;
    }

    public void setTotalCost(Double totalCost) {
        TotalCost = totalCost;
    }

    public Double getTotalProfit() {
        return TotalProfit;
    }

    public void setTotalProfit(Double totalProfit) {
        TotalProfit = totalProfit;
    }
}