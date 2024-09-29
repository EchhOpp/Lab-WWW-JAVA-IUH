package daoImpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import dao.GiangVienDao;
import entity.GiangVien;

public class GiangVienImpl implements GiangVienDao{
	
	private DataSource dataSource;
	
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public List<GiangVien> getAllGiangVien() {
		List<GiangVien> list = new ArrayList<GiangVien>();
		String query = "SELECT * FROM GiangVien";
		try (
				PreparedStatement ps = (PreparedStatement) dataSource.getConnection().prepareStatement(query);
				ResultSet rs = ps.executeQuery();
                ){
			while(rs.next()) {
//				private String maGiangVien;
//				private String tenGiangVien;
//				private String linhVucNghienCuu;
//				private String soDienThoai;
				String maGiangVien = rs.getString("MaGiangVien");
				String tenGiangVien = rs.getString("TenGiangVien");
				String linhVucNghienCuu = rs.getString("LinhVucNghienCuu");
				String soDienThoai = rs.getString("SoDienThoai");
				GiangVien giangVien = new GiangVien(maGiangVien, tenGiangVien, linhVucNghienCuu, soDienThoai);
				list.add(giangVien);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public GiangVien getGiangVien(String id) {
		// TODO Auto-generated method stub
		GiangVien giangVien = new GiangVien();
		String query = "SELECT * FROM GiangVien WHERE MaGiangVien = ?";
		try (
                PreparedStatement ps = (PreparedStatement) dataSource.getConnection().prepareStatement(query);
                ){
			ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                giangVien.setMaGiangVien(rs.getString("MaGiangVien"));
                giangVien.setTenGiangVien(rs.getString("TenGiangVien"));
                giangVien.setLinhVucNghienCuu(rs.getString("LinhVucNghienCuu"));
                giangVien.setSoDienThoai(rs.getString("SoDienThoai"));
            }
        } catch (Exception e) {
        	e.printStackTrace();
        }
		return giangVien;
	}

	@Override
	public boolean addGiangVien(GiangVien giangVien) {
		// TODO Auto-generated method stub
		String query = "INSERT INTO GiangVien(MaGiangVien, TenGiangVien, LinhVucNghienCuu, SoDienThoai) VALUES(?, ?, ?, ?)";
		try (
                PreparedStatement ps = (PreparedStatement) dataSource.getConnection().prepareStatement(query);
                ){
            ps.setString(1, giangVien.getMaGiangVien());
            ps.setString(2, giangVien.getTenGiangVien());
            ps.setString(3, giangVien.getLinhVucNghienCuu());
            ps.setString(4, giangVien.getSoDienThoai());
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
        	e.printStackTrace();
        	}
		return false;
	}

	@Override
	public boolean updateGiangVien(GiangVien giangVien) {
		// TODO Auto-generated method stub
		String query = "UPDATE GiangVien SET TenGiangVien = ?, LinhVucNghienCuu = ?, SoDienThoai = ? WHERE MaGiangVien = ?";
		try (PreparedStatement ps = (PreparedStatement) dataSource.getConnection().prepareStatement(query);) {
			ps.setString(1, giangVien.getTenGiangVien());
			ps.setString(2, giangVien.getLinhVucNghienCuu());
			ps.setString(3, giangVien.getSoDienThoai());
			ps.setString(4, giangVien.getMaGiangVien());
			return ps.executeUpdate() > 0;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean deleteGiangVien(String id) {
		// TODO Auto-generated method stub
		String query = "DELETE FROM GiangVien WHERE MaGiangVien = ?";
		try (PreparedStatement ps = (PreparedStatement) dataSource.getConnection().prepareStatement(query);) {
			ps.setString(1, id);
			return ps.executeUpdate() > 0;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

}
