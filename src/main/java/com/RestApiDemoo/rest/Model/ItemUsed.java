package com.RestApiDemoo.rest.Model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.*;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
@Entity
public class ItemUsed {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "item_id")
    private long ItemUsed_id;
    //    @Column(name = "name")
    private String ItemUsedName;
    //    @Column(name = "min_Q")
    private long ItemUsedQty;
    private LocalDate ItemUsedDate;

    public ItemUsed(){}
    public ItemUsed(long itemUsed_id, String itemUsedName, long itemUsedQty, LocalDate itemUsedDate) {
        ItemUsed_id = itemUsed_id;
        ItemUsedName = itemUsedName;
        ItemUsedQty = itemUsedQty;
        ItemUsedDate = itemUsedDate;
    }

    public long getItemUsed_id() {
        return ItemUsed_id;
    }

    public void setItemUsed_id(long itemUsed_id) {
        ItemUsed_id = itemUsed_id;
    }

    public String getItemUsedName() {
        return ItemUsedName;
    }

    public void setItemUsedName(String itemUsedName) {
        ItemUsedName = itemUsedName;
    }

    public long getItemUsedQty() {
        return ItemUsedQty;
    }

    public void setItemUsedQty(long itemUsedQty) {
        ItemUsedQty = itemUsedQty;
    }

    public LocalDate getItemUsedDate() {
        return ItemUsedDate;
    }

    public void setItemUsedDate(LocalDate itemUsedDate) {
        ItemUsedDate = itemUsedDate;
    }
}
