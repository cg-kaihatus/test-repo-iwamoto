package com.example.demo.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Models.News;
import com.example.demo.Repositories.NewsRepository;

@RestController
@RequestMapping("homepage/news")
public class NewsController {
	
	private final NewsRepository newsRepository;
	
	@Autowired
	public NewsController (NewsRepository newsRepository) {
		this.newsRepository = newsRepository;
	}

	
	/* 【お知らせ情報取得メソッド】
	 * 
	 * 受付URL(GET):http://localhost:8080/homepage/news/noticegetall
	 * 引数なし
	 */
	
	@GetMapping("noticegetall")
	@CrossOrigin(origins = "*")
	public List<News> getAllNewses() {
		List<News> newsList = newsRepository.findAll();
		return newsList;
	}
	
	@PostMapping("noticeupdate")
	@ResponseStatus(HttpStatus.CREATED)
	@CrossOrigin(origins = "*")
	
	/* 受付URL(POST): http://localhost:8080/homepage/news/noticeupdate
	 * 日付はyyyy-mm-dd形式で更新
	 */
	public void NewsUpdate (@RequestBody News news) {
		newsRepository.saveAndFlush(news);
	}
	
	
	
	//NewsID指定での取得
	@GetMapping("noticegetone/{strNo}")
	@CrossOrigin(origins = "*")
	/*
	 * 受付URL(GET)： http://localhost:8080/homepage/news/noticegetone/{strNo}
	 */
	
	public List<News> getOneNews(@PathVariable("strNo") String strNo) {
		int intNo = Integer.parseInt(strNo);
		List<News> newsList = newsRepository.findById(intNo);
		return newsList;
	}
	
	//最新n個取得する
	@GetMapping("noticeget/{strNo}")
	@CrossOrigin(origins = "*")
	/*受付URL(GET)： http://localhost:8080/homepage/news/noticeget/{strNo}
	 * 
	 */
	public List<News> getMaxNews(@PathVariable("strNo") String strNo){
		int intNo = Integer.parseInt(strNo);
		List<News> newsList = newsRepository.findByNewsDateRow(intNo);
		return newsList;
		
	}
	
	
	
	
}
