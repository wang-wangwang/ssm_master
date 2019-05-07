package com.oracle.web.test;

import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.github.pagehelper.PageHelper;
import com.oracle.web.bean.SubMonster;
import com.oracle.web.mapper.MonsterMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
public class testMapper {

	@Autowired
	private MonsterMapper monsterMapper;

	@Test
	public void testSelectAll() {

		PageHelper.startPage(1, 5);

		List<SubMonster> list = this.monsterMapper.selectAllByPageHelper();

		for (SubMonster subMonster : list) {

			System.out.println(subMonster);

		}

	}

}
