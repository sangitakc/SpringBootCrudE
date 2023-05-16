package com.crud.SpringBootCrud.mapper;

import com.crud.SpringBootCrud.dto.UserDto;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper implements RowMapper<UserDto> {

    @Override
    public UserDto mapRow(ResultSet rs, int rowNum) throws SQLException {
        UserDto userDto = new UserDto();
        userDto.setId(rs.getInt("id"));
        userDto.setName(rs.getString("name"));
        userDto.setAddress(rs.getString("address"));
        return userDto;
    }
}
