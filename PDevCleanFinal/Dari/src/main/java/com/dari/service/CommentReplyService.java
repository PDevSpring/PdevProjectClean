package com.dari.service;

import java.util.List;

import com.dari.model.Comment;
import com.dari.model.CommentReply;

public interface CommentReplyService {

	List<CommentReply> getallcomrep();


	void deletecomrepById(Long comId);

	CommentReply updatecomrep(CommentReply comment);

	void Blockcommentsrep(Long comId);

	boolean DecremLikerep(Long idCom);

	boolean IncremLike(Long idCom);

	boolean DecremDislikerep(Long idCom);

	boolean IncremDislikerep(Long idCom);

	void addComrep(CommentReply c, long comid);

	


}

