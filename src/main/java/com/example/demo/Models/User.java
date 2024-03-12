package com.example.demo.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name="user_tbl")
@Getter
@Setter

public class User {
	@Id
	@Column
	private int no;
	@Column
	private String user_id;
	@Column
	private String password;
	@Column
	private String fullname;
	@Column
	private int del_flg;
	
	public User() {
		
	}
	
	public User (int no, String user_id,String password, String fullname, int del_flg) {
		this.no = no;
		this.user_id = user_id;
		this.password = password;
		this.fullname = fullname;
		this.del_flg = del_flg;
	}

}
