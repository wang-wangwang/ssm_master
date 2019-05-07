package com.oracle.web.mapper;

import com.oracle.web.bean.Admin;

public interface AdminMapper {
	
    int deleteByPrimaryKey(Integer adminId);

    int insert(Admin record);

    Admin selectByPrimaryKey(String username);

}