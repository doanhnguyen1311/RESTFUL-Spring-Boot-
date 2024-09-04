package com.example.JPASql.view;

import com.example.JPASql.entity.SinhVien;
import com.example.JPASql.service.SinhVienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class SinhVienView {
    @Autowired
    private SinhVienService sinhVienService;


    @GetMapping("/list_SinhVien")
    public String viewSinhVien(Model model){
        List<SinhVien> ds = sinhVienService.getSinhVien();
        model.addAttribute("listSV", ds);
        return "student_list";
    }
}
