package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.DeTai;

@Repository
public interface DeTaiRepository extends JpaRepository<DeTai, String>  {
	public List<DeTai> findDeTaiByGiangVien_MaGV(String maGV);

}
