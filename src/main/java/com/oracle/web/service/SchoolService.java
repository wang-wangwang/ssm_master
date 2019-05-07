package com.oracle.web.service;

import java.util.List;

import com.oracle.web.bean.School;

public interface SchoolService {

	List<School> list();

	School selectById(Integer schoolId);

}
