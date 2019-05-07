package com.oracle.web.mapper;

import com.oracle.web.bean.Monster;
import com.oracle.web.bean.PageBean;
import com.oracle.web.bean.SubMonster;

import java.util.List;

public interface MonsterMapper {
    int deleteByPrimaryKey(Integer monsterId);

    int insert(Monster record);

    Monster selectByPrimaryKey(Integer monsterId);

    List<SubMonster> selectAll();

    int updateByPrimaryKey(Monster record);

	List<SubMonster> Bypage(int i);
	
	int counts();

	List<SubMonster> selectAllByPageHelper();
}