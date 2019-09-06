package com.thieu.setup.mappers;

import com.thieu.setup.models.Role;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Mapper
@Repository
public interface RoleMapper {
    void getRoleForUser(@Param("userId") int userId, @Param("createDate") Date createDate);

    Role findRoleByName(@Param("roleName") String roleName);
}
