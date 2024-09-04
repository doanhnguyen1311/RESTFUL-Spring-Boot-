package com.example.JPASql.mapper;

import com.example.JPASql.entity.SinhVien;
import com.example.JPASql.entityDTO.UserDTO;
import org.apache.catalina.User;
import org.mapstruct.Mapper;

import java.util.List;
@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDTO toUserDTO(SinhVien user);

    SinhVien toUser(UserDTO userDTO);
}
