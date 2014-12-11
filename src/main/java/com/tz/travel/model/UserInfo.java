package com.tz.travel.model;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by tzjeefjalft on 12/11/2014.
 */
@Entity
@Table(name = "tbl_user_info", schema = "", catalog = "tcs")
public class UserInfo {
    private int id;
    private String userName;
    private String userPw;
    private int businessLevel;
    private Collection<TravelMember> tblTravelMembersById;
    private Collection<TravelPlan> tblTravelPlansById;
    private UserExt tblUserExtById;
    private Collection<ViewPoint> tblViewPointsById;

    @Id
    @Column(name = "ID")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "USER_NAME")
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Basic
    @Column(name = "USER_PW")
    public String getUserPw() {
        return userPw;
    }

    public void setUserPw(String userPw) {
        this.userPw = userPw;
    }

    @Basic
    @Column(name = "BUSINESS_LEVEL")
    public int getBusinessLevel() {
        return businessLevel;
    }

    public void setBusinessLevel(int businessLevel) {
        this.businessLevel = businessLevel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserInfo userInfo = (UserInfo) o;

        if (businessLevel != userInfo.businessLevel) return false;
        if (id != userInfo.id) return false;
        if (userName != null ? !userName.equals(userInfo.userName) : userInfo.userName != null) return false;
        if (userPw != null ? !userPw.equals(userInfo.userPw) : userInfo.userPw != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (userName != null ? userName.hashCode() : 0);
        result = 31 * result + (userPw != null ? userPw.hashCode() : 0);
        result = 31 * result + businessLevel;
        return result;
    }

    @OneToMany(mappedBy = "tblUserInfoByUserId")
    public Collection<TravelMember> getTblTravelMembersById() {
        return tblTravelMembersById;
    }

    public void setTblTravelMembersById(Collection<TravelMember> tblTravelMembersById) {
        this.tblTravelMembersById = tblTravelMembersById;
    }

    @OneToMany(mappedBy = "tblUserInfoByUserId")
    public Collection<TravelPlan> getTblTravelPlansById() {
        return tblTravelPlansById;
    }

    public void setTblTravelPlansById(Collection<TravelPlan> tblTravelPlansById) {
        this.tblTravelPlansById = tblTravelPlansById;
    }

    @OneToOne(mappedBy = "tblUserInfoById")
    public UserExt getTblUserExtById() {
        return tblUserExtById;
    }

    public void setTblUserExtById(UserExt tblUserExtById) {
        this.tblUserExtById = tblUserExtById;
    }

    @OneToMany(mappedBy = "tblUserInfoByUserId")
    public Collection<ViewPoint> getTblViewPointsById() {
        return tblViewPointsById;
    }

    public void setTblViewPointsById(Collection<ViewPoint> tblViewPointsById) {
        this.tblViewPointsById = tblViewPointsById;
    }
}
