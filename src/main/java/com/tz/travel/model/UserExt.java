package com.tz.travel.model;

import javax.persistence.*;

/**
 * Created by tzjeefjalft on 12/11/2014.
 */
@Entity
@Table(name = "tbl_user_ext", schema = "", catalog = "tcs")
public class UserExt {
    private int id;
    private String email;
    private int travelTimes;
    private Integer totalKm;
    private Integer phoneNumber;
    private UserInfo tblUserInfoById;

    @Id
    @Column(name = "ID")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "EMAIL")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "TRAVEL_TIMES")
    public int getTravelTimes() {
        return travelTimes;
    }

    public void setTravelTimes(int travelTimes) {
        this.travelTimes = travelTimes;
    }

    @Basic
    @Column(name = "TOTAL_KM")
    public Integer getTotalKm() {
        return totalKm;
    }

    public void setTotalKm(Integer totalKm) {
        this.totalKm = totalKm;
    }

    @Basic
    @Column(name = "PHONE_NUMBER")
    public Integer getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Integer phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserExt userExt = (UserExt) o;

        if (id != userExt.id) return false;
        if (travelTimes != userExt.travelTimes) return false;
        if (email != null ? !email.equals(userExt.email) : userExt.email != null) return false;
        if (phoneNumber != null ? !phoneNumber.equals(userExt.phoneNumber) : userExt.phoneNumber != null) return false;
        if (totalKm != null ? !totalKm.equals(userExt.totalKm) : userExt.totalKm != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + travelTimes;
        result = 31 * result + (totalKm != null ? totalKm.hashCode() : 0);
        result = 31 * result + (phoneNumber != null ? phoneNumber.hashCode() : 0);
        return result;
    }

    @OneToOne
    @JoinColumn(name = "ID", referencedColumnName = "ID", nullable = false)
    public UserInfo getTblUserInfoById() {
        return tblUserInfoById;
    }

    public void setTblUserInfoById(UserInfo tblUserInfoById) {
        this.tblUserInfoById = tblUserInfoById;
    }
}
