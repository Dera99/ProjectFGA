package com.app.services;

import com.app.config.connection;
import com.app.model.ModelData;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ServiceData {
    ResultSet rs = null;
    Connection CC = new connection().connect();;
    PreparedStatement pst = null;
    Statement stt;
    
    public List<ModelData> getDataBarang() throws SQLException {
        List<ModelData> list = new ArrayList<>();
        String sql = "select * from Data";
        pst = CC.prepareStatement(sql);
        rs = pst.executeQuery();
        while(rs.next()){
            String kodeBarang = rs.getString("Kode_Barang");
            String namaBarang = rs.getString("Nama_Barang");
            String model = rs.getString("Model");
            String jenis = rs.getString("Jenis");
            String kadar = rs.getString("Kadar");
            int berat = rs.getInt("Berat");
            list.add(new ModelData(kodeBarang, namaBarang, model, jenis, kadar, berat));
        }
        rs.close();
        pst.close();
        return list;
    }
    public void insertData(ModelData data){
        String sql = "INSERT INTO Data (Kode_Barang, Nama_Barang, Model, Jenis, Kadar, Berat) values (?,?,?,?,?,?)";
        try {
            pst = CC.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pst.setString(1, data.getKodeBarang());
            pst.setString(2, data.getNamaBarang());
            pst.setString(3, data.getModel());
            pst.setString(4, data.getJenis());
            pst.setString(5, data.getKadar());
            pst.setString(6, String.valueOf(data.getBerat()));
        pst.execute();
        rs = pst.getGeneratedKeys();
        rs.first();
        int IdBarang = rs.getInt(1);
        data.setId(IdBarang);
        System.out.println("Keys : "+IdBarang);
        rs.close();
        pst.close();
        } catch (SQLException ex) {
            Logger.getLogger(ServiceData.class.getName()).log(Level.SEVERE, null, ex);
        } catch(Exception e){
            System.out.println("");
        }  
    }
    public void deleteData(int IdBarang) throws SQLException {
        String sql = "delete from Data where IdBarang=? limit 1";
        pst = CC.prepareStatement(sql);
        pst.setInt(1, IdBarang);
        pst.execute();
        pst.close();
    }
     public void updateData(ModelData data) throws SQLException {
         String sql = "update data set Kode_Barang=?, Nama_Barang=?, Model=?, Jenis=?, Kadar=?, Berat=? where IdBarang=? limit 1";
         pst = CC.prepareStatement(sql);
            pst.setString(1, data.getKodeBarang());
            pst.setString(2, data.getNamaBarang());
            pst.setString(3, data.getModel());
            pst.setString(4, data.getJenis());
            pst.setString(5, data.getKadar());
            pst.setString(6, String.valueOf(data.getBerat()));
            pst.setInt(7, data.getId());
         pst.execute();
         pst.close();
     } 
     public List<ModelData> searchData(String search)throws SQLException{
        List<ModelData> list = new ArrayList<>();
        //String sql = "SELECT * FROM data WHERE Kode_Barang LIKE '%"+search+"%' OR Nama_Barang LIKE '%"+search+"%' OR Model LIKE '%"+search+"%' OR Jenis LIKE '%"+search+"%' OR Kadar LIKE '%"+search+"%' OR Berat LIKE '%"+search+"%' LIMIT 0, 25;";
        String sql =  "SELECT * FROM data WHERE Kode_Barang LIKE '%"+search+"%' OR Nama_Barang LIKE '%"+search+"%'";
        pst = CC.prepareStatement(sql);
        rs = pst.executeQuery();
         System.out.println(search);
         System.out.println(rs);
        while(rs.next()){
            String kodeBarang = rs.getString("Kode_Barang");
            String namaBarang = rs.getString("Nama_Barang");
            String model = rs.getString("Model");
            String jenis = rs.getString("Jenis");
            String kadar = rs.getString("Kadar");
            int berat = rs.getInt("Berat");
            list.add(new ModelData(kodeBarang, namaBarang, model, jenis, kadar, berat));
        }
        rs.close();
        pst.close();
        return list;
     }
}
