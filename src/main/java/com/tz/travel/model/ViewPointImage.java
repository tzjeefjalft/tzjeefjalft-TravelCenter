package com.tz.travel.model;

import javax.persistence.*;

/**
 * Created by tzjeefjalft on 12/11/2014.
 */
@Entity
@Table(name = "tbl_view_point_image", schema = "", catalog = "tcs")
public class ViewPointImage {
    private int id;
    private String imgPath;
    private ViewPoint tblViewPointByViewPointId;

    @Id
    @Column(name = "VIEW_POINT_IMAGE_ID")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

        ViewPointImage that = (ViewPointImage) o;

        if (id != that.id) return false;
        if (imgPath != null ? !imgPath.equals(that.imgPath) : that.imgPath != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (imgPath != null ? imgPath.hashCode() : 0);
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
}
