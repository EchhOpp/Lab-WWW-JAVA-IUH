package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.GiangVien;

@Repository
public interface GiangVienRepository extends JpaRepository<GiangVien, String>{
	
}
