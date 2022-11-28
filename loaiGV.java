package model;

public class loaiGV {

    private int id;
    private String ten;

    public loaiGV() {
    }

    public loaiGV(int id, String ten) {
        this.id = id;
        this.ten = ten;
    }

    public loaiGV(String string) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    @Override
    public String toString() {
        return "LoaiGV{" + "id=" + id + ", ten=" + ten + '}';
    }

}
