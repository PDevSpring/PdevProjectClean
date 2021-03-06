package com.dari.service;


import java.time.Instant;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dari.model.Ads;
import com.dari.model.Comment;
import com.dari.service.FilterService;
import com.dari.model.Notification;
import com.dari.repository.AdsRepository;
import com.dari.repository.CommentRepository;
import com.dari.repository.NotificationRepository;



@Service
public class CommentServiceImpl implements CommentService {
	
	@Autowired 
	private CommentRepository commentRepository; 
	@Autowired 
	private NotificationRepository NotificationRepository;
	
	
	@Autowired
	AdsRepository adsrepository;
	
	
	@Override
	public List<Comment> getallcoms(){
		return (List<Comment>) commentRepository.findAll();	}
	
	
	
	@Override
	public void addCom (Comment c,long adid) {
		Ads ad =adsrepository.findById(adid).get();
		System.out.println(ad.getPrice());
		c.setAds(ad);
		commentRepository.save(c);
		Notification n = new Notification();
		n.setCreatedAt(Instant.now());
		n.setUser(c.getAds().getUser());
		//n.setCreatedAt(new Date());
		n.setMessage("New comment added from "+c.getAds().getUser().getFirstName());
		n.setAds(c.getAds());

		NotificationRepository.save(n);
		
	}
		
	
	@Override
	public Comment findbyidCom (Long  idc) {
		return commentRepository.findById(idc).get();
		
	}
	
	public void deletecomById (Long comId) {
		commentRepository.deleteById(comId);
		
	}
	
	public Comment updatecom (Comment comment)  {
		 commentRepository.save(comment);
		 return comment;
	}
@Override
	public String Blockcomments (Long comId) {
		List<Comment> com  = (List<Comment>) commentRepository.findAll ();
		String ret = null;
		for (Comment a : com) {
			if (a.getCommentId() == comId) {
				String input = a.getDescription();
				String output = FilterService.getCensoredText(input);
				
				if (output.contains("*")) {
					a.setBlocked(true);
					commentRepository.save(a);
					
					 ret ="comment blocked";
					
					} 
					
					else 
					
						{a.setBlocked(false);
						ret="comment clean";
						}
			}
			commentRepository.save(a);
				
				
				
			}
		return ret;
		}
	
@Override
public boolean IncremDislike(Long idCom) {

	int A = 0;
	

	List<Comment> comments = (List<Comment>) commentRepository.findAll();

	for (Comment aa : comments) {
		if (aa.getCommentId() == idCom) {
			A = commentRepository.findById(idCom).get().getDislikeNb();
			A++;
			aa.setDislikeNb(A);
		}
		commentRepository.save(aa);
	}
	return true;

}
@Override

public boolean IncremLike(Long idCom) {

	int A = 0;

	List<Comment> comments = (List<Comment>) commentRepository.findAll();

	for (Comment aa : comments) {
		if (aa.getCommentId() == idCom) {
			A = commentRepository.findById(idCom).get().getLikesNb();
			A++;
			aa.setLikesNb(A);
		}
		commentRepository.save(aa);
	}
	return true;

}



@Override

public boolean DecremLike(Long idCom) {

	int A = 0;

	List<Comment> comments = (List<Comment>) commentRepository.findAll();

	for (Comment aa : comments) {
		if (aa.getCommentId() == idCom) {
			A = commentRepository.findById(idCom).get().getLikesNb();
			A--;
			aa.setLikesNb(A);
		}
		commentRepository.save(aa);
	}
	return true;

}
@Override
public boolean DecremDislike(Long idCom) {

	int A = 0;
	

	List<Comment> comments = (List<Comment>) commentRepository.findAll();

	for (Comment aa : comments) {
		if (aa.getCommentId() == idCom) {
			A = commentRepository.findById(idCom).get().getDislikeNb();
			A--;
			aa.setDislikeNb(A);
		}
		commentRepository.save(aa);
	}
	return true;

}



	}
	
	


