package qldt.Dao;

import java.util.List;

import qldt.Entities.DienThoai;
import qldt.Entities.NhaCungCap;

public interface DienThoaiDao {
		public List<DienThoai> getALLDT();
		public DienThoai getDTByID(int maDT);
		public void addDT(DienThoai dt);
		public void updateDT(DienThoai dt);
		public void deleteDT(int maDT);
		
		public List<NhaCungCap> getALLNCC();
		public NhaCungCap getNCCByID(int maNCC);
		public List<DienThoai> getDTByNCC(int maNCC);
		public void addNCC(NhaCungCap ncc);
}
