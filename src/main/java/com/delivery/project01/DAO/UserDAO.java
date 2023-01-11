package com.delivery.project01.DAO;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import com.delivery.project01.DTO.UserDTO;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserDAO {
    @Insert("INSERT INTO DVUser VALUES (#{Id}, #{Pw})")
    void InsertUser(UserDTO dto);
    @Select("SELECT * FROM DVUser WHERE Id=#{Id}")
    UserDTO selectOneUser(String Id);
    @Select("SELECT * FROM DVUser")
    List<UserDTO> selectAllUser();

}
