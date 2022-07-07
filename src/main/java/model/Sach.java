package model;

import java.sql.Date;

public class Sach {
    private String id;
    private String tenSach;
    private float giaBan;
    private int namXuatBan;
    private Date ngayXuatBan;

    public Sach() {
    }

    public Sach(String id, String tenSach, float giaBan, int namXuatBan, Date ngayXuatBan) {
        this.id = id;
        this.tenSach = tenSach;
        this.giaBan = giaBan;
        this.namXuatBan = namXuatBan;
        this.ngayXuatBan = ngayXuatBan;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTenSach() {
        return tenSach;
    }

    public void setTenSach(String tenSach) {
        this.tenSach = tenSach;
    }

    public float getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(float giaBan) {
        this.giaBan = giaBan;
    }

    public int getNamXuatBan() {
        return namXuatBan;
    }

    public void setNamXuatBan(int namXuatBan) {
        this.namXuatBan = namXuatBan;
    }

    public Date getNgayXuatBan() {
        return ngayXuatBan;
    }

    public void setNgayXuatBan(Date ngayXuatBan) {
        this.ngayXuatBan = ngayXuatBan;
    }

    @Override
    public String toString() {
        return this.id+"/"+this.tenSach+"/"+this.giaBan+"/"+this.namXuatBan+"/"+this.ngayXuatBan;
    }
}
