package com.angelehl.rest.webservices.restfulwebservices.user.post;

import org.springframework.data.jpa.repository.JpaRepository;

import com.angelehl.rest.webservices.restfulwebservices.user.Post;

public interface PostRepository extends JpaRepository<Post, Integer> {
	
	

}
