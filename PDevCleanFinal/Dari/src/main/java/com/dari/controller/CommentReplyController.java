package com.dari.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import com.dari.model.CommentReply;
import com.dari.service.CommentReplyService;

@RestController
@RequestMapping ("/App/ads/commentrep")
public class CommentReplyController {
	
	@GetMapping("/test")
	public String test() {
		return "working fine ! " ; 
	}
	
	@Autowired
	private CommentReplyService commentreplyService;
	
	
	@GetMapping("/getallcomrep")
	public List<CommentReply> show() {
		List<CommentReply> comrep = commentreplyService.getallcomrep() ; 
		return comrep ; 
	}
	@PostMapping("/addcomrep/{idcom}") 
	public String addingcomrep(@RequestBody CommentReply c,@PathVariable("idcom") Long comId) {
		commentreplyService.addComrep(c,comId);
		return "Comment added!"; 
	}
	
	@DeleteMapping("/deletecomrep{comId}")
	public void DeletecomrepById(@PathVariable("comId") Long comId) {
		commentreplyService.deletecomrepById(comId);
	}
	
	@PutMapping("/updatecomrep")
	@ResponseBody  
	public CommentReply Updatecomrep (@RequestBody CommentReply comment)  {
		return commentreplyService.updatecomrep(comment);	
		
	}
	
	
	@PutMapping(value = "/BlockCommentsrep")
	@ResponseBody
	public void BlockCommentsrep(@PathVariable long comId)  {
		 commentreplyService.Blockcommentsrep(comId);
	}
	
	@PutMapping(value = "/inclike/{comId}")
	@ResponseBody
	public boolean inclike(@PathVariable long comId)  {
		 return commentreplyService.IncremLike(comId);
	}
	
	@PutMapping(value = "/incdislike/{comId}")
	@ResponseBody
	public boolean incdislike(@PathVariable long comId)  {
		 return commentreplyService.IncremDislikerep(comId);
	}
	
	
	@PutMapping(value = "/declike/{comId}")
	@ResponseBody
	public boolean declike(@PathVariable long comId)  {
		 return commentreplyService.DecremLikerep(comId);
	}
	
	@PutMapping(value = "/decdislike/{comId}")
	@ResponseBody
	public boolean decdislike(@PathVariable long comId)  {
		 return commentreplyService.DecremDislikerep(comId);
	}
	
	
	
}
	


