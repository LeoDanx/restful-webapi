package com.angelehl.rest.webservices.restfulwebservices.user;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Size;

@Entity
public class Post {
	
	@Id
	@GeneratedValue
	private Integer id;
	@Size(min=10)
	private String description;
	@ManyToOne(fetch=FetchType.LAZY)//Si quieres recuperar la info de usuario relacionada con el post post, añades Eager sino, pues lo contrario
	@JsonIgnore //esto porque no queremos que vaya junto con la respuesta
	private User user;
	
	
	public Integer getId() {
		return id;
	}
	public String getDescription() {
		return description;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	@Override
	public String toString() {
		return "Post [id=" + id + ", description=" + description + "]";
	}
}
