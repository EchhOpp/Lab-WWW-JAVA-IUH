package fit.com.Bai9.service;

import java.util.List;

import fit.com.Bai9.entity.DeTai;
import fit.com.Bai9.repositories.DeTaiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class DTService {
	@Autowired
	private DeTaiRepository deTaiRepository;
	
	@Transactional
	public List<DeTai> getAll() {
		return deTaiRepository.findAll();
	}
	@Transactional
	public boolean addDeTai(DeTai deTai) {
		return deTaiRepository.save(deTai) != null;
	}
	@Transactional
	public List<DeTai> findDeTaiByGV(String maGV) {
		return deTaiRepository.findDeTaiByGiangVien_MaGV(maGV);
	}
	@Transactional
	public void xoaDeTai(String maDT) {
		deTaiRepository.deleteById(maDT);
	}
	@Transactional
	public DeTai getDeTai(String maDT) {
		return deTaiRepository.findById(maDT).get();
	}

}
