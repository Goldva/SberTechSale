package com.sbertech.sale.data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "user_table")
public class User extends BaseEntity {
    @Column(name = "name", unique = true)
    private String name;
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<Item> items;
    @OneToOne(mappedBy = "user", fetch = FetchType.LAZY)
    private Bid bid;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public Bid getBid() {
        return bid;
    }

    public void setBid(Bid bid) {
        this.bid = bid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (name != null ? !name.equals(user.name) : user.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }
}
