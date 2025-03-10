package com.ssafy.ws.step5.dto;

import java.util.Date;

/**
 * 게시글 정보를 나타내는 클래스
 */
public class Article {
	//코드를 작성하세요.
	private int articleId; // 게시글 ID
	private String title;
	private String content;
	private int userSeq;
	private int viweCnt;
	private Date regDate;
	
	
	public Article() {
		
	}
	
	public Article(int articleId, String title, String content, int userSeq, int viweCnt, Date regDate) {
		super();
		this.articleId = articleId;
		this.title = title;
		this.content = content;
		this.userSeq = userSeq;
		this.viweCnt = viweCnt;
		this.regDate = regDate;
	}
	
	
	
}
