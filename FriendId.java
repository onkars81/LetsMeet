package com.letsmeet.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class FriendId implements Serializable
	{

	private static final long serialVersionUID = 6378800811298459356L;
	/*@Column(name = "user_one_id")
	private int user_one_id;
    @Column(name="user_two_id")
	private int user_two_id;
*/
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_one_id", nullable = false, insertable = false, updatable = false)
    private User user_one_id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_two_id", nullable = false, insertable = false, updatable = false)
    private User user_two_id;
    
    
	public FriendId() {
		super();
		// TODO Auto-generated constructor stub
	}


	public FriendId(User user_one_id, User user_two_id) {
		super();
		this.user_one_id = user_one_id;
		this.user_two_id = user_two_id;
	}


	public User getUser_one_id() {
		return user_one_id;
	}


	public void setUser_one_id(User user_one_id) {
		this.user_one_id = user_one_id;
	}


	public User getUser_two_id() {
		return user_two_id;
	}


	public void setUser_two_id(User user_two_id) {
		this.user_two_id = user_two_id;
	}
	
	/*@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + user_one_id;
		result = prime * result + user_two_id;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FriendId other = (FriendId) obj;
		if (user_one_id != other.user_one_id)
			return false;
		if (user_two_id != other.user_two_id)
			return false;
		return true;
	}
	public int getUser_one_id() {
	return user_one_id;
	}
	public void setUser_one_id(int user_one_id) {
	this.user_one_id = user_one_id;
	}
	public int getUser_two_id() {
	return user_two_id;
	}
	public void setUser_two_id(int user_two_id) {
	this.user_two_id = user_two_id;
	}*/
	
	
	
}

