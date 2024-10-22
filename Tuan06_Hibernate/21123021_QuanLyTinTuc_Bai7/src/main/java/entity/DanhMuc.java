package entity;

public class DanhMuc {
	private String maDM;
	private String tenDM;
	private String moTa;
	private String nguoiQL;
	private String ghiChu;
	
	public DanhMuc(String maDM, String tenDM, String moTa, String nguoiQL, String ghiChu) {
		super();
		this.maDM = maDM;
		this.tenDM = tenDM;
		this.moTa = moTa;
		this.nguoiQL = nguoiQL;
		this.ghiChu = ghiChu;
	}
	public DanhMuc() {
		super();
	}
	public DanhMuc(String maDM) {
		super();
		this.maDM = maDM;
	}
	public String getMaDM() {
		return maDM;
	}
	public void setMaDM(String maDM) {
		this.maDM = maDM;
	}
	public String getTenDM() {
		return tenDM;
	}
	public void setTenDM(String tenDM) {
		this.tenDM = tenDM;
	}
	public String getMoTa() {
		return moTa;
	}
	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}
	public String getNguoiQL() {
		return nguoiQL;
	}
	public void setNguoiQL(String nguoiQL) {
		this.nguoiQL = nguoiQL;
	}
	public String getGhiChu() {
		return ghiChu;
	}
	public void setGhiChu(String ghiChu) {
		this.ghiChu = ghiChu;
	}
	@Override
	public String toString() {
		return "DanhMuc [maDM=" + maDM + ", tenDM=" + tenDM + ", moTa=" + moTa + ", nguoiQL=" + nguoiQL + ", ghiChu="
				+ ghiChu + "]";
	}
	
}
