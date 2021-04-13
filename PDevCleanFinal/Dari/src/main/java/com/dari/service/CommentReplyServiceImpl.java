package com.dari.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dari.model.Comment;
import com.dari.model.CommentReply;
import com.dari.model.Notification;
import com.dari.repository.AdsRepository;
import com.dari.repository.CommentReplyRepository;
import com.dari.repository.CommentRepository;
import com.dari.repository.NotificationRepository;

@Service
public class CommentReplyServiceImpl implements CommentReplyService {
	
	@Autowired 
	private CommentReplyRepository commentreplyRepository; 
	
	@Autowired
	private CommentRepository comrepository;
	
	
	@Autowired
	private AdsRepository adsrepository;
	@Autowired 
	private NotificationRepository NotificationRepository;
	
	
	@Override
	public List<CommentReply> getallcomrep(){
		return (List<CommentReply>) commentreplyRepository.findAll();	}
	
	
	
	@Override
	public void addComrep (CommentReply c,long comid) {
		Comment com=comrepository.findById(comid).get();
		c.setComment(com);
		commentreplyRepository.save(c);
		
		Notification n = new Notification();
		n.setUser(c.getComment().getAds().getUser());
		//n.setCreatedAt(new Date());
		n.setMessage("New comment added from "+c.getUser());
		n.setAds(c.getComment().getAds());

		NotificationRepository.save(n);
		
		  
	}
	
	@Override
	public void deletecomrepById (Long comId) {
		commentreplyRepository.deleteById(comId);
		
	}
	
	@Override
	public CommentReply updatecomrep (CommentReply comment)  {
		 commentreplyRepository.save(comment);
		 return comment;
	}
	@Override
	public void Blockcommentsrep (Long comId) {
		List<CommentReply> com  = (List<CommentReply>) commentreplyRepository.findAll ();
		for (CommentReply a : com) {
			if (a.getReplyId() == comId) {
				String input = a.getDescription();
				String output = FilterService.getCensoredText(input);
				
				if (output.contains("*")) {
					a.setBlocked(true);
					commentreplyRepository.save(a);
				} else 
					a.setBlocked(false);
			}
			commentreplyRepository.save(a);
				
				
				
			}

		}

	@Override
	public boolean IncremDislikerep(Long idCom) {

		int A = 0;
		

		List<CommentReply> commentsrep = (List<CommentReply>) commentreplyRepository.findAll();

		for (CommentReply aa : commentsrep) {
			if (aa.getReplyId() == idCom) {
				A = commentreplyRepository.findById(idCom).get().getDislikeNb();
				A++;
				aa.setDislikeNb(A);
			}
			commentreplyRepository.save(aa);
		}
		return true;

	}
	@Override

	public boolean IncremLike(Long idCom) {

		int A = 0;

		List<CommentReply> commentsrep = (List<CommentReply>) commentreplyRepository.findAll();

		for (CommentReply aa : commentsrep) {
			if (aa.getReplyId() == idCom) {
				A = commentreplyRepository.findById(idCom).get().getLikesNb();
				A++;
				aa.setLikesNb(A);
			}
			commentreplyRepository.save(aa);
		}
		return true;

	}



	@Override

	public boolean DecremLikerep(Long idCom) {

		int A = 0;

		List<CommentReply> commentsrep = (List<CommentReply>) commentreplyRepository.findAll();

		for (CommentReply aa : commentsrep) {
			if (aa.getReplyId() == idCom) {
				A = commentreplyRepository.findById(idCom).get().getLikesNb();
				A--;
				aa.setLikesNb(A);
			}
			commentreplyRepository.save(aa);
		}
		return true;

	}
	@Override
	public boolean DecremDislikerep(Long idCom) {

		int A = 0;
		

		List<CommentReply> commentsrep = (List<CommentReply>) commentreplyRepository.findAll();

		for (CommentReply aa : commentsrep) {
			if (aa.getReplyId() == idCom) {
				A = commentreplyRepository.findById(idCom).get().getDislikeNb();
				A--;
				aa.setDislikeNb(A);
			}
			commentreplyRepository.save(aa);
		}
		return true;

	}




	



	


	}
	


