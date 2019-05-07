package com.oracle.web.bean;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class Monster {
	private Integer monsterId;

	private String mname;

	private String email;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date birthday;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date entryday;

	private Integer school;

	public Monster() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Monster(Integer monsterId, String mname, String email, Date birthday, Date entryday, Integer school) {
		super();
		this.monsterId = monsterId;
		this.mname = mname;
		this.email = email;
		this.birthday = birthday;
		this.entryday = entryday;
		this.school = school;
	}

	public Integer getMonsterId() {
		return monsterId;
	}

	public void setMonsterId(Integer monsterId) {
		this.monsterId = monsterId;
	}

	public String getMname() {
		return mname;
	}

	public void setMname(String mname) {
		this.mname = mname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public Date getEntryday() {
		return entryday;
	}

	public void setEntryday(Date entryday) {
		this.entryday = entryday;
	}

	public Integer getSchool() {
		return school;
	}

	public void setSchool(Integer school) {
		this.school = school;
	}

	@Override
	public String toString() {
		return "Monster [monsterId=" + monsterId + ", mname=" + mname + ", email=" + email + ", birthday=" + birthday
				+ ", entryday=" + entryday + ", school=" + school + "]";
	}


}