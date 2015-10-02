package com.company;

/**
 * Created by cedric on 02/10/15.
 */
public class Player {
    private String Name;
    private int AvgPrice;
    private int BuyPrice;
    private int Sellprice;

    public Player(String name, int avgPrice, int buyPrice, int sellprice) {
        Name = name;
        AvgPrice = avgPrice;
        BuyPrice = buyPrice;
        Sellprice = sellprice;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getAvgPrice() {
        return AvgPrice;
    }

    public void setAvgPrice(int avgPrice) {
        AvgPrice = avgPrice;
    }

    public int getBuyPrice() {
        return BuyPrice;
    }

    public void setBuyPrice(int buyPrice) {
        BuyPrice = buyPrice;
    }

    public int getSellprice() {
        return Sellprice;
    }

    public void setSellprice(int sellprice) {
        Sellprice = sellprice;
    }
}
