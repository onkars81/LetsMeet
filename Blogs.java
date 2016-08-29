package com.letsmeet.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import oracle.sql.Datum;

@Entity
@Table(name="Blogs")
public class Blogs {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="blog_seq")
	@SequenceGenerator
	(
		name="blog_seq",
		sequenceName="blog_sequence",
		allocationSize=1,
		initialValue=1
	)
	private int blogNo; 
	private String title;
	private String content;
	private Datum bdate;
	
	@ManyToOne
	@JoinColumn(name="userid")
	@JsonIgnore
	private User user;
	
	@OneToMany(mappedBy = "blogs", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Comments> comments;
	
	
	public List<Comments> getComments() {
		return comments;
	}
	public void setComments(List<Comments> comments) {
		this.comments = comments;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}

	public Datum getBdate() {
		return bdate;
	}
	public void setBdate(Datum bdate) {
		this.bdate = bdate;
	}
	public int getBlogNo() {
		return blogNo;
	}
	public void setBlogNo(int blogNo) {
		this.blogNo = blogNo;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	public Blogs() {
			}


	public Blogs(int blogNo, String title, String content, Datum bdate, User user) {
		
		this.blogNo = blogNo;
		this.title = title;
		this.content = content;
		this.bdate = bdate;
		this.user = user;
	}

}
