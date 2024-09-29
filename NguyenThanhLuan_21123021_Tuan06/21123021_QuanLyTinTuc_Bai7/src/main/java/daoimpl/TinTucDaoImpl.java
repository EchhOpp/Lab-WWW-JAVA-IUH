package daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import dao.TinTucDao;
import entity.TinTuc;

public final class TinTucDaoImpl implements TinTucDao {
	
	private DataSource dataSource;
	
	public TinTucDaoImpl(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	

	@Override
	public List<TinTuc> getAllTinTuc() {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM TinTuc";
		List<TinTuc> list = new ArrayList();
		try(
                Connection con = dataSource.getConnection();
                PreparedStatement ps = con.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
                )
        {
            while (rs.next()) {
//            	private String maTT;
//            	private String tieuDe;
//            	private String noiDungTT;
//            	private String lienKet;
//            	private String maDM;
                TinTuc tt = new TinTuc();
                tt.setMaTT(rs.getString("maTT"));
                tt.setTieuDe(rs.getString("tieuDe"));
                tt.setNoiDungTT(rs.getString("noiDungTT"));
                tt.setLienKet(rs.getString("lienKet"));
                tt.setMaDM(rs.getString("maDM"));
                list.add(tt);
            }
            
        } catch (Exception e) {
        	e.printStackTrace();
        }
		return list;
	}

	@Override
	public TinTuc getTinTuc(String maTT) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean addTinTuc(TinTuc tt) {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO TinTuc(maTT, tieuDe, noiDungTT, lienKet, maDM) VALUES(?, ?, ?, ?, ?)";
		try(
                Connection con = dataSource.getConnection();
                PreparedStatement ps = con.prepareStatement(sql);
                )
        {
            ps.setString(1, tt.getMaTT());
            ps.setString(2, tt.getTieuDe());
            ps.setString(3, tt.getNoiDungTT());
            ps.setString(4, tt.getLienKet());
            ps.setString(5, tt.getMaDM());
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
        	e.printStackTrace();
        }
		return false;
	}

	@Override
	public boolean updateTinTuc(TinTuc tt) {
		// TODO Auto-generated method stub
        String sql = "UPDATE TinTuc SET tieuDe = ?, noiDungTT = ?, lienKet = ?, maDM = ? WHERE maTT = ?";
        try(
                Connection con = dataSource.getConnection();
                PreparedStatement ps = con.prepareStatement(sql);
                )
        {
            ps.setString(1, tt.getTieuDe());
            ps.setString(2, tt.getNoiDungTT());
            ps.setString(3, tt.getLienKet());
            ps.setString(4, tt.getMaDM());
            ps.setString(5, tt.getMaTT());
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
        	e.printStackTrace();
        }
        return false;
	}

	@Override
	public boolean deleteTinTuc(String maTT) {
		// TODO Auto-generated method stub
		        String sql = "DELETE FROM TinTuc WHERE maTT = ?";
        try(
                Connection con = dataSource.getConnection();
                PreparedStatement ps = con.prepareStatement(sql);
                )
        {
            ps.setString(1, maTT);
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
        	e.printStackTrace();
        
		}
		return false;
	}
}
