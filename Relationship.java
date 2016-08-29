package com.letsmeet.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class Relationship implements Serializable{

	
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private FriendId friendid;
	
	@Enumerated(EnumType.ORDINAL)
	@Column(name="status")
	public Status status;
	
	@ManyToOne
	@JoinColumn(name="userid")
	private User action_user_id;

	public enum Status{PENDING,ACCEPTED,BLOCKED,DECLINED;}

	public Status getStatus() {
		return status;
	}


	public void setStatus(Status status) {
		this.status = status;
	}


	public FriendId getFriendid() {
		return friendid;
	}


	public void setFriendid(FriendId friendid) {
		this.friendid = friendid;
	}


	public User getAction_user_id() {
		return action_user_id;
	}


	public void setAction_user_id(User action_user_id) {
		this.action_user_id = action_user_id;
	}



	
	
}


 

 




