package com.letsmeet.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.persistence.*;
import javax.persistence.SequenceGenerator;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.MultipartFile;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="users")
public class User {

	@Id
	@GeneratedValue(strategy= GenerationType.SEQUENCE,generator="user_seq")
	@SequenceGenerator(
			name="user_seq",
			sequenceName="user_sequence",
			allocationSize=1,
			initialValue=1
			)
	int userid;
	@NotEmpty(message = "The user name must not be null")
	String name;
	@NotEmpty(message = "The user username must not be null")
	String username;
	@NotEmpty(message = "The user password must not be null")
	String password;
	@Email(message = "The user email must not be null")
	String email;
	boolean enabled;
	@Transient
	private MultipartFile image;
	
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Blogs> blogs;
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Comments> comments;
	
	@OneToMany(mappedBy="user",cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	private List<Forum> forums;
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<FComment> fcomments;
	
	@OneToMany(mappedBy = "action_user_id", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Relationship> relations;
	
	
	
	
	public List<Comments> getComments() {
		return comments;
	}
	public void setComments(List<Comments> comments) {
		this.comments = comments;
	}
	public List<Blogs> getBlogs() {
		return blogs;
	}
	public void setBlogs(List<Blogs> blogs) {
		this.blogs = blogs;
	}
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	
	public MultipartFile getImage() {
		return image;
	}
	public void setImage(MultipartFile image) {
		this.image = image;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public User() {
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public User(int userid, String name, String username, String password, String email, boolean enabled,
			MultipartFile image, List<Blogs> blogs) 
	{
		this.userid = userid;
		this.name = name;
		this.username = username;
		this.password = password;
		this.email = email;
		this.enabled = enabled;
		this.image = image;
		this.blogs = blogs;
	}
	
	
	
}
