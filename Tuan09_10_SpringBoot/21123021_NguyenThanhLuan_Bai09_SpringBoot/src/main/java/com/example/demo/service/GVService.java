package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.GiangVien;
import com.example.demo.repositories.GiangVienRepository;

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

