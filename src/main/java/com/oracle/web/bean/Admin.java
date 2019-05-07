package com.oracle.web.bean;

public class Admin {
    private Integer adminId;

    private String aname;

    private String username;

    private String password;
    
    private String touxiang;

    public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public Admin(Integer adminId, String aname, String username, String password, String touxiang) {
		super();
		this.adminId = adminId;
		this.aname = aname;
		this.username = username;
		this.password = password;
		this.touxiang = touxiang;
	}



	public String getTouxiang() {
		return touxiang;
	}



	public void setTouxiang(String touxiang) {
		this.touxiang = touxiang;
	}



	public Integer getAdminId() {
        return adminId;
    }

    public void setAdminId(Integer adminId) {
        this.adminId = adminId;
    }

    public String getAname() {
        return aname;
    }

    public void setAname(String aname) {
        this.aname = aname == null ? null : aname.trim();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }
}