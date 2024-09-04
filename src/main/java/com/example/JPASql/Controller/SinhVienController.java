package com.example.JPASql.Controller;


import com.example.JPASql.entity.SinhVien;
import com.example.JPASql.entityDTO.UserDTO;
import com.example.JPASql.mapper.UserMapper;
import com.example.JPASql.service.SinhVienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.sql.Date;
import java.util.List;

@RestController
@RequestMapping("/students")
public class SinhVienController {
    @Autowired
    private SinhVienService sinhVienService;

    @GetMapping("")
    public List<SinhVien> getAllSinhVien(){
        return sinhVienService.getSinhVien();
    }


    @PostMapping("/add")
    public void addSinhVien(@RequestParam String hoTen,
                              @RequestParam String gioiTinh,
                              @RequestParam String ngaySinh) {
        boolean gt = false;

        if(gioiTinh.equals("Nam")){
            gt = true;
        }
        SinhVien sinhVien = new SinhVien();
        sinhVien.setHoTen(hoTen);
        sinhVien.setGioiTinh(gt);
        sinhVien.setNgaySinh(Date.valueOf(ngaySinh).toLocalDate());
        System.out.println(hoTen);
        sinhVienService.addSinhVien(sinhVien);
    }


    @PostMapping("/update/{id}")
    public String updateSinhVien(
            @PathVariable Long id,
            @RequestParam String hoTen,
            @RequestParam boolean gioiTinh,
            @RequestParam String ngaySinh
    ){
        SinhVien sinhVien = new SinhVien();
        sinhVien.setHoTen(hoTen);
        sinhVien.setNgaySinh(Date.valueOf(ngaySinh).toLocalDate());
        sinhVien.setGioiTinh(gioiTinh);
        sinhVienService.updateSinhVien(id, sinhVien);
        return "redirect:/students/list_SinhVien";
    }

    @PostMapping("/delete/{id}")
    public void deleteSinhVien(@PathVariable Long id){
        sinhVienService.deleteSinhVien(id);
    }


    @GetMapping("/mapper")
    public UserDTO getUserDTO(SinhVien sv){
        return sinhVienService.getUserDTO(sv);
    }
}

