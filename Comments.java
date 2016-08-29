package com.letsmeet.model;

import java.sql.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;

import oracle.sql.Datum;

@Entity
@Table(name="Comments")
public class Comments {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="comment_seq")
	
	@SequenceGenerator
	(
		name="comment_seq",
		sequenceName="comment_sequence",
		allocationSize=1,
		initialValue=1
	)
	int commentid;
	@NotEmpty(message="Comment Required !")
	String usercomment;
	@Email(message="email id not valid !")
	String email;
	@NotEmpty(message="full name required !")
	String fullname;
	Datum comment_date;
	

	@ManyToOne
	@JoinColumn(name="blogNo")
	@JsonIgnore
	private Blogs blogs;
	
	@ManyToOne
	@JoinColumn(name="userid")
	@JsonIgnore
	private User user;
	
	public User getUsers() {
		return user;
	}
	public void setUsers(User user) {
		this.user = user;
	}


	public Comments() {
	}


	public Comments(int commentid, String usercomment, String email, String fullname, Datum comment_date) {
		super();
		this.commentid = commentid;
		this.usercomment = usercomment;
		this.email = email;
		this.fullname = fullname;
		this.comment_date = comment_date;
	}

	public Blogs getBlogs() {
		return blogs;
	}


	public void setBlogs(Blogs blogs) {
		this.blogs = blogs;
	}


	public String getUsercomment() {
		return usercomment;
	}


	public void setUsercomment(String usercomment) {
		this.usercomment = usercomment;
	}


	public int getCommentid() {
		return commentid;
	}


	public void setCommentid(int commentid) {
		this.commentid = commentid;
	}


	

	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getFullname() {
		return fullname;
	}


	public void setFullname(String fullname) {
		this.fullname = fullname;
	}


	public Datum getComment_date() {
		return comment_date;
	}


	public void setComment_date(Datum comment_date) {
		this.comment_date = comment_date;
	}
	
	
}
