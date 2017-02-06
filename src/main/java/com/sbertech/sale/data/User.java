package com.sbertech.sale.data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "user_table")
public class User extends BaseEntity {
    @Column(name = "userName", unique = true)
    private String userName;
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<Item> items;
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<Bid> bids;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public List<Bid> getBids() {
        return bids;
    }

    public void setBids(List<Bid> bids) {
        this.bids = bids;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (userName != null ? !userName.equals(user.userName) : user.userName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return userName != null ? userName.hashCode() : 0;
    }
}
