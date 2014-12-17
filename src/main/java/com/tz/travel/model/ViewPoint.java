package com.tz.travel.model;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by tzjeefjalft on 12/11/2014.
 */
@Entity
@Table(name = "tbl_view_point", schema = "", catalog = "tcs")
public class ViewPoint {
    private int id;
    private String nodeText;
    private Double latitude;
    private Double longitude;
    private String description;
    private Collection<TravelFlow> tblTravelFlowsById;
    private UserInfo tblUserInfoByUserId;
    private Collection<ViewPointImage> tblViewPointImagesById;

    @Id
    @Column(name = "VIEW_POINT_ID")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "NODE_TEXT")
    public String getNodeText() {
        return nodeText;
    }

    public void setNodeText(String nodeText) {
        this.nodeText = nodeText;
    }

    @Basic
    @Column(name = "LATITUDE")
    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    @Basic
    @Column(name = "LONGITUDE")
    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    @Basic
    @Column(name = "DESCRIPTION")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ViewPoint viewPoint = (ViewPoint) o;

        if (id != viewPoint.id) return false;
        if (description != null ? !description.equals(viewPoint.description) : viewPoint.description != null)
            return false;
        if (latitude != null ? !latitude.equals(viewPoint.latitude) : viewPoint.latitude != null) return false;
        if (longitude != null ? !longitude.equals(viewPoint.longitude) : viewPoint.longitude != null) return false;
        if (nodeText != null ? !nodeText.equals(viewPoint.nodeText) : viewPoint.nodeText != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (nodeText != null ? nodeText.hashCode() : 0);
        result = 31 * result + (latitude != null ? latitude.hashCode() : 0);
        result = 31 * result + (longitude != null ? longitude.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "tblViewPointByViewPointId")
    public Collection<TravelFlow> getTblTravelFlowsById() {
        return tblTravelFlowsById;
    }

    public void setTblTravelFlowsById(Collection<TravelFlow> tblTravelFlowsById) {
        this.tblTravelFlowsById = tblTravelFlowsById;
    }

    @ManyToOne
    @JoinColumn(name = "USER_ID", referencedColumnName = "USER_ID", nullable = false)
    public UserInfo getTblUserInfoByUserId() {
        return tblUserInfoByUserId;
    }

    public void setTblUserInfoByUserId(UserInfo tblUserInfoByUserId) {
        this.tblUserInfoByUserId = tblUserInfoByUserId;
    }

    @OneToMany(mappedBy = "tblViewPointByViewPointId")
    public Collection<ViewPointImage> getTblViewPointImagesById() {
        return tblViewPointImagesById;
    }

    public void setTblViewPointImagesById(Collection<ViewPointImage> tblViewPointImagesById) {
        this.tblViewPointImagesById = tblViewPointImagesById;
    }
}
