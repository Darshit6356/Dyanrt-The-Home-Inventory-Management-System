package com.RestApiDemoo.rest.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
public class ItemBuy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "item_id")
    private long ItemBuy_id;
//    @Column(name = "name")
    private String ItemBuyName;
//    @Column(name = "min_Q")
    private float ItemBuyPrice;
    private long ItemBuyQty;
    private LocalDate ItemBuyDate;

    public ItemBuy(){}

    public ItemBuy(long itemBuy_id, String itemBuyName, float itemBuyPrice, long itemBuyQty, LocalDate itemBuyDate) {
        ItemBuy_id = itemBuy_id;
        ItemBuyName = itemBuyName;
        ItemBuyPrice = itemBuyPrice;
        ItemBuyQty = itemBuyQty;
        ItemBuyDate = itemBuyDate;
    }

    public long getItemBuy_id() {
        return ItemBuy_id;
    }

    public void setItemBuy_id(long itemBuy_id) {
        ItemBuy_id = itemBuy_id;
    }

    public String getItemBuyName() {
        return ItemBuyName;
    }

    public void setItemBuyName(String itemBuyName) {
        ItemBuyName = itemBuyName;
    }

    public float getItemBuyPrice() {
        return ItemBuyPrice;
    }

    public void setItemBuyPrice(float itemBuyPrice) {
        ItemBuyPrice = itemBuyPrice;
    }

    public long getItemBuyQty() {
        return ItemBuyQty;
    }

    public void setItemBuyQty(long itemBuyQty) {
        ItemBuyQty = itemBuyQty;
    }

    public LocalDate getItemBuyDate() {
        return ItemBuyDate;
    }

    public void setItemBuyDate(LocalDate itemBuyDate) {
        ItemBuyDate = itemBuyDate;
    }
}
