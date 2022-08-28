package com.app.model;

import com.raven.table.model.TableRowData;

public class ModelData extends TableRowData {


    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getKodeBarang() {
        return kodeBarang;
    }
    public void setKodeBarang(String kodeBarang) {
        this.kodeBarang = kodeBarang;
    }
    public String getNamaBarang() {
        return namaBarang;
    }
    public void setNamaBarang(String namaBarang) {
        this.namaBarang = namaBarang;
    }
    public String getModel() {
        return model;
    }
    public void setModel(String model) {
        this.model = model;
    }
    public String getJenis() {
        return jenis;
    }
    public void setJenis(String jenis) {
        this.jenis = jenis;
    }
    public String getKadar() {
        return kadar;
    }
    public void setKadar(String kadar) {
        this.kadar = kadar;
    }
    public int getBerat() {
        return berat;
    }
    public void setBerat(int berat) {
        this.berat = berat;
    }

     public ModelData(String kodeBarang,String namaBarang,String model,String jenis,String kadar,int berat) {
      this.kodeBarang = kodeBarang;
      this.namaBarang = namaBarang;
      this.model = model;
      this.jenis = jenis;
      this.kadar = kadar;
      this.berat = berat;     
    }
    
    public ModelData() {
    }

    private String kodeBarang;
    private String namaBarang;
    private String model;
    private String jenis;
    private String kadar;
    private int berat;
    private int id;

    @Override
    public Object[] toTableRow() {
        return new Object[]{kodeBarang, namaBarang, model, jenis, kadar, berat};
    }

    /**
     * @return the id
     */
    
}
