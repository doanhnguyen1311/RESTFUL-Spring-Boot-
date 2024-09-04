package com.example.JPASql.entity;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;
import java.time.LocalDate;


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "SinhVien")

public class SinhVien {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "maSinhVien")
    private int maSinhVien;

    @Column(name = "gioiTinh")
    private boolean gioiTinh;

    @Column(name = "hoTen")
    private String hoTen;

    @Column(name = "ngaySinh")
    private LocalDate ngaySinh;
}
