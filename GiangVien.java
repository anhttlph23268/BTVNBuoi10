package model;

import java.util.Vector;

public class GiangVien {

    private int maNV;
    private String tenGV;
    private int tuoi;
    private int bac;
    private boolean gioiTinh;
    private loaiGV loaigv;

    public GiangVien() {
    }

    public GiangVien(int maNV, String tenGV, int tuoi, int bac, boolean gioiTinh, loaiGV loaigv) {
        this.maNV = maNV;
        this.tenGV = tenGV;
        this.tuoi = tuoi;
        this.bac = bac;
        this.gioiTinh = gioiTinh;
        this.loaigv = loaigv;
    }

    public int getMaNV() {
        return maNV;
    }

    public void setMaNV(int maNV) {
        this.maNV = maNV;
    }

    public String getTenGV() {
        return tenGV;
    }

    public void setTenGV(String tenGV) {
        this.tenGV = tenGV;
    }

    public int getTuoi() {
        return tuoi;
    }

    public void setTuoi(int tuoi) {
        this.tuoi = tuoi;
    }

    public int getBac() {
        return bac;
    }

    public void setBac(int bac) {
        this.bac = bac;
    }

    public boolean isGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(boolean gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public loaiGV getLoaigv() {
        return loaigv;
    }

    public void setLoaigv(loaiGV loaigv) {
        this.loaigv = loaigv;
    }

    @Override
    public String toString() {
        return "GiangVien{" + "maNV=" + maNV + ", tenGV=" + tenGV + ", tuoi=" + tuoi + ", bac=" + bac + ", gioiTinh=" + gioiTinh + ", loaigv=" + loaigv + '}';
    }

    public Vector<?> toDataRow() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
