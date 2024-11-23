package fit.com.Bai9.controller;

import java.util.Arrays;
import java.util.List;

import fit.com.Bai9.entity.DeTai;
import fit.com.Bai9.entity.GiangVien;
import fit.com.Bai9.service.DTService;
import fit.com.Bai9.service.GVService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/home")
public class HomeController {
	@Autowired
	private GVService giangVienService;
	@Autowired
	private DTService deTaiService;

	@GetMapping("/danhSach")
	public String showHomePage(Model theModel) {
		List<GiangVien> list = giangVienService.getAll();
		System.out.println("Hello");
		theModel.addAttribute("list", list);
		return "DanhSach";
	}

	@GetMapping("/detail")
	public String showDetailPageTheoGV(@RequestParam("maGV") String maGV, Model model) {
		List<DeTai> list = deTaiService.findDeTaiByGV(maGV);
		GiangVien gv = giangVienService.getGiangVien(maGV);
		model.addAttribute("gv", gv);
		model.addAttribute("list", list);
		return "danhSachDeTaiTheoGiangVien";
	}

	@GetMapping("/detailDeTai")
	public String showDetailDeTai(@RequestParam("maDeTai") String maDT, Model model) {
		DeTai dt = deTaiService.getDeTai(maDT);
		model.addAttribute("dt", dt);
		return "detailDeTai";
	}

	@GetMapping("/showFormAddDeTai")
	public String showFormAddDeTai(Model model) {
		List<GiangVien> list = giangVienService.getAll();
		DeTai deTai = new DeTai();
		model.addAttribute("deTai", deTai);
		model.addAttribute("list", list);
		return "addDeTai";
	}

	@GetMapping("/showFormAddGiangVien")
	public String showFormAddGV(Model model) {
		GiangVien gv = new GiangVien();
		model.addAttribute("giangVien", gv);
		return "addGiangVien";
	}

	@PostMapping("/addDetai")
	public String addDeTai(@Validated @ModelAttribute("deTai") DeTai deTai, BindingResult bindingResult,
						   HttpServletRequest request, Model model) {
		List<GiangVien> list = giangVienService.getAll();
		model.addAttribute("list", list);
		if (bindingResult.hasErrors()) {
			model.addAttribute(bindingResult);
			return "addDeTai";
		}
		if (deTaiService.addDeTai(deTai)) {
			return "redirect:/home/danhSach";
		} else {
			return "addDeTai";
		}

	}

	@PostMapping("/addGiangVien")
	public String addGiangVien(@Validated @ModelAttribute("giangVien") GiangVien giangVien, BindingResult bindingResult,
			HttpServletRequest request, Model model) {
		if (bindingResult.hasErrors()) {
			model.addAttribute(bindingResult);
			return "addGiangVien";
		}
		
		if (giangVienService.addGiangVien(giangVien)) {
			return "redirect:/home/danhSach";
		} else {
			return "addGiangVien";
		}
	}
	/*
	 * public String showHomePage(Model model, HttpServletRequest request,
	 * HttpServletResponse response) { List<GiangVien> giangVienList =
	 * giangVienService.getAllGiangVien(); model.addAttribute("giangVienList",
	 * giangVienList); // You can use request and response objects here as needed
	 * return "DanhSach"; }
	 */

}
