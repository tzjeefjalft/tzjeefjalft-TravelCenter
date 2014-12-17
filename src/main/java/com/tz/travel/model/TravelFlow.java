package com.tz.travel.model;

import javax.persistence.*;

/**
 * Created by tzjeefjalft on 12/11/2014.
 */
@Entity
@Table(name = "tbl_travel_flow", schema = "", catalog = "tcs")
public class TravelFlow {
    private int id;
    private int pid;
    private int cid;
    private ViewPoint tblViewPointByViewPointId;
    private TravelPlan tblTravelPlanByTravelId;

    @Id
    @Column(name = "TRAVEL_FLOW_ID")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "PID")
    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    @Basic
    @Column(name = "CID")
    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TravelFlow that = (TravelFlow) o;

        if (cid != that.cid) return false;
        if (id != that.id) return false;
        if (pid != that.pid) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + pid;
        result = 31 * result + cid;
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "VIEW_POINT_ID", referencedColumnName = "VIEW_POINT_ID", nullable = false)
    public ViewPoint getTblViewPointByViewPointId() {
        return tblViewPointByViewPointId;
    }

    public void setTblViewPointByViewPointId(ViewPoint tblViewPointByViewPointId) {
        this.tblViewPointByViewPointId = tblViewPointByViewPointId;
    }

    @ManyToOne
    @JoinColumn(name = "TRAVEL_PLAN_ID", nullable = false)
    public TravelPlan getTblTravelPlanByTravelId() {
        return tblTravelPlanByTravelId;
    }

    public void setTblTravelPlanByTravelId(TravelPlan tblTravelPlanByTravelId) {
        this.tblTravelPlanByTravelId = tblTravelPlanByTravelId;
    }
}
