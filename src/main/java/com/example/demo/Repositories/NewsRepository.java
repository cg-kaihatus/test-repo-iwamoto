package com.example.demo.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.Models.News;


@Repository
public interface NewsRepository extends JpaRepository <News,Integer> {
	List<News> findById(int news_id);
	
	@Query(value = "SELECT * FROM news_tbl ORDER BY news_date DESC LIMIT ?1",nativeQuery = true)
	List<News> findByNewsDateRow(Integer NewsDate);
	

}
