package com.CAQAS.pojo;

public class User {
    private Integer userId;

    private String userName;

    private String userPassword;
    
    private Integer userRole;
    
    private String userMail;

    private Integer userDepId;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword == null ? null : userPassword.trim();
    }

    public Integer getUserRole() {
		return userRole;
	}

	public void setUserRole(Integer userRole) {
		this.userRole = userRole;
	}

	public String getUserMail() {
		return userMail;
	}

	public void setUserMail(String userMail) {
		this.userMail = userMail;
	}

	public Integer getUserDepId() {
        return userDepId;
    }

    public void setUserDepId(Integer userDepId) {
        this.userDepId = userDepId;
    }
}