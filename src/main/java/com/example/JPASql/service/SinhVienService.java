package com.example.JPASql.service;

import com.example.JPASql.entity.SinhVien;
import com.example.JPASql.entityDTO.UserDTO;
import com.example.JPASql.mapper.UserMapper;
import com.example.JPASql.repository.SinhVienRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SinhVienService {
    @Autowired
    private SinhVienRepository sinhVienRepository;


    @Autowired
    private UserMapper mapper;

    public List<SinhVien> getSinhVien(){
        return sinhVienRepository.findAll();
    }

    public void addSinhVien(SinhVien sv){
        sinhVienRepository.save(sv);
    }

    public void updateSinhVien(Long id, SinhVien sv){
        SinhVien updateSV = sinhVienRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Sinh Vien khong ton tai"));
        updateSV.setHoTen(sv.getHoTen());
        updateSV.setNgaySinh(sv.getNgaySinh());
        updateSV.setGioiTinh(sv.isGioiTinh());
        sinhVienRepository.save(updateSV);
    }

    public void deleteSinhVien(Long id){
        sinhVienRepository.deleteById(id);
    }


    // mapper

    public UserDTO getUserDTO(SinhVien sv){
        return mapper.toUserDTO(sv);
    }

    public SinhVien getUser(UserDTO dto){
        return mapper.toUser(dto);
    }

}

