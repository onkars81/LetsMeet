package com.letsmeet.model;

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
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.joda.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name="forum")
public class Forum {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="forum_seq")
	@SequenceGenerator
	(
			name="forum_seq",
			sequenceName="forum_sequence",
			initialValue=1,
			allocationSize=1
	)
	private int forumid;
	
	private String forumpost;
	
	private String type;
	
	//private String forumcomment;
	
	@ManyToOne
	@JoinColumn(name="userid")
	@JsonIgnore
	private User user;
	
	@OneToMany(mappedBy = "forums", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<FComment> fcomments;
	
	LocalDateTime j_date;
	
	boolean approve;

	public boolean isApprove() {
		return approve;
	}

	public void setApprove(boolean approve) {
		this.approve = approve;
	}

	public int getForumid() {
		return forumid;
	}

	public void setForumid(int forumid) {
		this.forumid = forumid;
	}

	public String getForumpost() {
		return forumpost;
	}

	public void setForumpost(String forumpost) {
		this.forumpost = forumpost;
	}

	

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public LocalDateTime getJ_date() {
		return j_date;
	}

	public void setJ_date(LocalDateTime j_date) {
		this.j_date = j_date;
	}

	
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<FComment> getFcomments() {
		return fcomments;
	}

	public void setFcomments(List<FComment> fcomments) {
		this.fcomments = fcomments;
	}

	public Forum(int forumid, String forumpost, User user, LocalDateTime j_date, boolean approve) {
		this.forumid = forumid;
		this.forumpost = forumpost;
		
		this.user = user;
		this.j_date = j_date;
		this.approve = approve;
	}

	public Forum() {
	
	}
	
	
}
