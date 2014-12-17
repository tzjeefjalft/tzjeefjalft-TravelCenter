package com.tz.travel.model;

import javax.persistence.*;

/**
 * Created by tzjeefjalft on 12/11/2014.
 */
@Entity
@Table(name = "tbl_travel_member", schema = "", catalog = "tcs")
public class TravelMember {
    private int id;
    private TravelPlan tblTravelPlanByTravelId;
    private UserInfo tblUserInfoByUserId;

    @Id
    @Column(name = "TRAVEL_MEMBER_ID")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TravelMember that = (TravelMember) o;

        if (id != that.id) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id;
    }

    @ManyToOne
    @JoinColumn(name = "TRAVEL_PLAN_ID", referencedColumnName = "TRAVEL_PLAN_ID", nullable = false)
    public TravelPlan getTblTravelPlanByTravelId() {
        return tblTravelPlanByTravelId;
    }

    public void setTblTravelPlanByTravelId(TravelPlan tblTravelPlanByTravelId) {
        this.tblTravelPlanByTravelId = tblTravelPlanByTravelId;
    }

    @ManyToOne
    @JoinColumn(name = "USER_ID", referencedColumnName = "USER_ID", nullable = false)
    public UserInfo getTblUserInfoByUserId() {
        return tblUserInfoByUserId;
    }

    public void setTblUserInfoByUserId(UserInfo tblUserInfoByUserId) {
        this.tblUserInfoByUserId = tblUserInfoByUserId;
    }
}
