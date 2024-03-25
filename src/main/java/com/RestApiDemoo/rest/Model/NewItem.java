package com.RestApiDemoo.rest.Model;

import jakarta.persistence.*;
import lombok.ToString;

@ToString
@Entity(name = "newitem")
public class NewItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "newitem_id")
    private long newitem_id;
    @Column(name="newitem_name")
    private String newitem_name;
    @Column(name="newitem_qty")
    private long newitem_qty;

    public NewItem() {
    }

    public NewItem(long newitem_id, String newitem_name, long newitem_qty) {
        this.newitem_id = newitem_id;
        this.newitem_name = newitem_name;
        this.newitem_qty = newitem_qty;
    }

    public long getNewitem_id() {
        return newitem_id;
    }

    public void setNewitem_id(long newitem_id) {
        this.newitem_id = newitem_id;
    }

    public String getNewitem_name() {
        return newitem_name;
    }

    public void setNewitem_name(String newitem_name) {
        this.newitem_name = newitem_name;
    }

    public long getNewitem_qty() {
        return newitem_qty;
    }

    public void setNewitem_qty(long newitem_qty) {
        this.newitem_qty = newitem_qty;
    }

    @Override
    public String toString() {
        return "newitem{" +
                "newitem_id=" + newitem_id +
                ", newitem_name='" + newitem_name + '\'' +
                ", newitem_qty=" + newitem_qty +
                '}';
    }
}
