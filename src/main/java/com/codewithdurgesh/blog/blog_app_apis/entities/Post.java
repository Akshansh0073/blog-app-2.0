package com.codewithdurgesh.blog.blog_app_apis.entities;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "post")
public class Post {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer postId;

	private String title;

	private String content;

	private String imageName;

	private Date addedDate;

	@ManyToOne
	@JoinColumn(name = "category_id")
	private Category category;

	@ManyToOne
	private User user;

	@OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
	private Set<Comment> comments = new HashSet<Comment>();

	// Getter and Setter

	public Post() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Set<Comment> getComments() {
		return comments;
	}

	public void setComments(Set<Comment> comments) {
		this.comments = comments;
	}

	public Integer getPostId() {
		return postId;
	}

	public void setPostId(Integer postId) {
		this.postId = postId;
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

	public String getImageName() {
		return imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}

	public Date getAddedDate() {
		return addedDate;
	}

	public void setAddedDate(Date addedDate) {
		this.addedDate = addedDate;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
