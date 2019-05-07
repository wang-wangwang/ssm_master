package com.oracle.web.bean;

public class SubMonster extends Monster{
	
	public School schools;

	public School getSchools() {
		return schools;
	}

	public void setSchools(School schools) {
		this.schools = schools;
	}

	@Override
	public String toString() {
		return "SubMonster [schools=" + schools + "]";
	}



	
}
