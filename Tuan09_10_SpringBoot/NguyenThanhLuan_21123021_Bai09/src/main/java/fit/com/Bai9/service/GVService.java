package fit.com.Bai9.service;

import java.util.List;

import fit.com.Bai9.entity.GiangVien;
import fit.com.Bai9.repositories.GiangVienRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class GVService {
	
	@Autowired
	private GiangVienRepository giangVienRepository;
	
	@Transactional
	public List<GiangVien> getAll() {
		return giangVienRepository.findAll();
	}
	
	@Transactional
	public GiangVien getGiangVien(String maGV) {
		return giangVienRepository.findById(maGV).orElse(null);
	}
	
	@Transactional
	public boolean addGiangVien(GiangVien giangVien) {
		
		return giangVienRepository.save(giangVien) != null;
	}
}

