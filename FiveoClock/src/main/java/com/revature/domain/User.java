package com.revature.domain;



import java.io.Serializable;

import javax.persistence.*;





@Entity

@Table(name="USERS")

public class User implements Serializable {

	public User() {

		super();

	}

	

	@Id

	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="UserSequence")

	@SequenceGenerator(allocationSize=1, name="UserSequence", sequenceName="SQ_USER_PK")

	@Column(name = "USER_ID")

	private int userId;

	

	@Column(name = "EMAIL")

	private String email;

	

	@Column(name = "PASSWORD")

	private String password;

	

	@Column(name = "IS_ADMIN")

	private boolean isAdmin;



	public User(String email, String password, boolean isAdmin) {

		super();

		this.email = email;

		this.password = password;

		this.isAdmin = isAdmin;

	}

	

	public User(String email, String password) {

		super();

		this.email = email;

		this.password = password;

		this.isAdmin = false;

	}



	

	

	public int getUserId() {

		return userId;

	}



	public void setUserId(int userId) {

		this.userId = userId;

	}



	public String getEmail() {

		return email;

	}



	public void setEmail(String email) {

		this.email = email;

	}



	public String getPassword() {

		return password;

	}



	public void setPassword(String password) {

		this.password = password;

	}



	public boolean isAdmin() {

		return isAdmin;

	}



	public void setAdmin(boolean isAdmin) {

		this.isAdmin = isAdmin;

	}



	@Override

	public String toString() {

		return "User [userId=" + userId + ", email=" + email + ", password=" + password + ", isAdmin=" + isAdmin + "]";

	}	

	

}