package com.dari.service;

import java.util.List;

import com.dari.model.Comment;
import com.dari.model.CommentReply;


public interface CommentService {

	

	void deletecomById(Long comId);
	
	Comment updatecom(Comment comment);
	
	String Blockcomments (Long comId);


	List<Comment> getallcoms();

	Comment findbyidCom(Long idc);


	boolean IncremDislike(Long idCom);

	boolean IncremLike(Long idCom);

	boolean DecremLike(Long idCom);

	boolean DecremDislike(Long idCom);

	void addCom(Comment c, long adid);




}
