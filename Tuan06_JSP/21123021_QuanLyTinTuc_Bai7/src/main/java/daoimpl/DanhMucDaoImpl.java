package daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import dao.DanhMucDao;
import entity.DanhMuc;

public class DanhMucDaoImpl implements DanhMucDao {
	
	private DataSource dataSource;
	
	public DanhMucDaoImpl(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public List<DanhMuc> getAllDanhMuc() {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM DanhMuc";
		List<DanhMuc> list = new ArrayList();
		try(
				Connection con = dataSource.getConnection();
                PreparedStatement ps = con.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
                )
		{
			while (rs.next()) {
				DanhMuc dm = new DanhMuc();
				dm.setMaDM(rs.getString("maDM"));
				dm.setTenDM(rs.getString("tenDM"));
				dm.setMoTa(rs.getString("moTa"));
				dm.setNguoiQL(rs.getString("nguoiQL"));
				dm.setGhiChu(rs.getString("ghiChu"));
				list.add(dm);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public DanhMuc getDanhMuc(String maDM) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addDanhMuc(DanhMuc dm) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateDanhMuc(DanhMuc dm) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteDanhMuc(String maDM) {
		// TODO Auto-generated method stub
		
	}

}
