package com.dari.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class CommentReply {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long ReplyId ; 
	
	private String Description ; 
	private int LikesNb ; 
	private int DislikeNb ; 
	private boolean Blocked;
	@ManyToOne
	private Comment  comment;
	@ManyToOne
	private User user;

	
}