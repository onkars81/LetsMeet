package com.letsmeet.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.joda.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="fcomment")
public class FComment {

	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="fcomment_seq")
	
	@SequenceGenerator
	(
		name="fcomment_seq",
		sequenceName="fcomment_sequence",
		allocationSize=1,
		initialValue=1
	)
	int commentid;
	@NotEmpty(message="Comment Required !")
	String usercomment;
	@Email(message="email id not valid !")
	String email;
	@NotEmpty(message="full name required !")
	String username;
	
	LocalDateTime f_date;
	

	@ManyToOne
	@JoinColumn(name="forumid")
	@JsonIgnore
	private Forum forums;
	
	@ManyToOne
	@JoinColumn(name="userid")
	@JsonIgnore
	private User user;

	public int getCommentid() {
		return commentid;
	}

	public void setCommentid(int commentid) {
		this.commentid = commentid;
	}

	public String getUsercomment() {
		return usercomment;
	}

	public void setUsercomment(String usercomment) {
		this.usercomment = usercomment;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public LocalDateTime getF_date() {
		return f_date;
	}

	public void setF_date(LocalDateTime f_date) {
		this.f_date = f_date;
	}

	public Forum getForums() {
		return forums;
	}

	public void setForums(Forum forums) {
		this.forums = forums;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public FComment() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FComment(int commentid, String usercomment, String email, String username, LocalDateTime f_date,
			Forum forums, User user) {
		super();
		this.commentid = commentid;
		this.usercomment = usercomment;
		this.email = email;
		this.username = username;
		this.f_date = f_date;
		this.forums = forums;
		this.user = user;
	}


	


}
