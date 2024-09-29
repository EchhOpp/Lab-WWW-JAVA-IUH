package daoImpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import dao.DeTaiDao;
import dao.GiangVienDao;
import entity.DeTai;
import entity.GiangVien;

public class DeTaiImpl implements DeTaiDao{
	
//	private String maGiangVien;
//	private String tenGiangVien;
//	private String linhVucNghienCuu;
//	private String soDienThoai;
	
	private DataSource dataSource;
	
	
	

	public DeTaiImpl(DataSource dataSource) {
		super();
		this.dataSource = dataSource;
	}

	public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

	@Override
	public List<DeTai> getAllDeTai() {
		// TODO Auto-generated method stub
		List<DeTai> list = new ArrayList<DeTai>();
		String query = "SELECT * FROM DeTai";
		try(
				PreparedStatement ps = (PreparedStatement) dataSource.getConnection().prepareStatement(query);
				ResultSet rs = ps.executeQuery();
				
                ){
			while(rs.next()) {
				String maDeTai = rs.getString("MaDeTai");
				String tenDeTai = rs.getString("TenDeTai");
				String namDK = rs.getString("NamDangKy");
				String moTa = rs.getString("MoTaDeTai");
				String maGiangVien = rs.getString("MaGV");
				DeTai deTai = new DeTai(maDeTai, tenDeTai, namDK, moTa, new GiangVien(maGiangVien));
				list.add(deTai);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public boolean addDeTai(DeTai deTai) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateDeTai(DeTai deTai) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public DeTai getDeTai(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteDeTai(String id) {
		// TODO Auto-generated method stub
		return false;
	}
	
}
