package com.tz.travel.model;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by tzjeefjalft on 12/11/2014.
 */
@Entity
@Table(name = "tbl_travel_plan", schema = "", catalog = "tcs")
public class TravelPlan {
    private int id;
    private String title;
    private int status;
    private String description;
    private String imgPath;
    private Collection<TravelFlow> tblTravelFlowsById;
    private Collection<TravelMember> tblTravelMembersById;
    private UserInfo tblUserInfoByUserId;

    @Id
    @Column(name = "TRAVEL_PLAN_ID")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "TITLE")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "STATUS")
    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Basic
    @Column(name = "DESCRIPTION")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "IMG_PATH")
    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TravelPlan that = (TravelPlan) o;

        if (id != that.id) return false;
        if (status != that.status) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (imgPath != null ? !imgPath.equals(that.imgPath) : that.imgPath != null) return false;
        if (title != null ? !title.equals(that.title) : that.title != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + status;
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (imgPath != null ? imgPath.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "tblTravelPlanByTravelId")
    public Collection<TravelFlow> getTblTravelFlowsById() {
        return tblTravelFlowsById;
    }

    public void setTblTravelFlowsById(Collection<TravelFlow> tblTravelFlowsById) {
        this.tblTravelFlowsById = tblTravelFlowsById;
    }

    @OneToMany(mappedBy = "tblTravelPlanByTravelId")
    public Collection<TravelMember> getTblTravelMembersById() {
        return tblTravelMembersById;
    }

    public void setTblTravelMembersById(Collection<TravelMember> tblTravelMembersById) {
        this.tblTravelMembersById = tblTravelMembersById;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_ID", nullable = true)
    public UserInfo getTblUserInfoByUserId() {
        return tblUserInfoByUserId;
    }

    public void setTblUserInfoByUserId(UserInfo tblUserInfoByUserId) {
        this.tblUserInfoByUserId = tblUserInfoByUserId;
    }
}
