package com.RestApiDemoo.rest.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@Entity(name = "items")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "item_id")
    private long item_id;
    @Column(name = "name")
    private String name;
    @Column(name = "min_Q")
    private long min_Q;

    public Item() {
    }

    public Item(long item_id, String name, long min_Q) {
        this.item_id = item_id;
        this.name = name;
        this.min_Q = min_Q;
    }

    public long getItem_id() {
        return item_id;
    }

    public void setItem_id(long item_id) {
        this.item_id = item_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getMin_Q() {
        return min_Q;
    }

    public void setMin_Q(long min_Q) {
        this.min_Q = min_Q;
    }
}
