package com.example.demo.Models;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name="news_tbl")
@Getter
@Setter

public class News {
	@Id
	@Column
	private int news_id;
	@Column
	private String user_name;
	@Column
	private String news_title;
	@Column
	private Date news_date;
	@Column
	private String news_text;
	
	public News() {
		
	}
	
	
	public News (int news_id, String user_name, String news_title, Date news_date, String news_text) {
		this.news_id = news_id;
		this.user_name = user_name;
		this.news_title = news_title;
		this.news_date = news_date;
		this.news_text = news_text;
	}
}
