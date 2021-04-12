package com.dari.controller;
import java.util.List;

import com.dari.model.Comment;
import com.dari.model.User;
import com.dari.service.CommentService;

import javassist.bytecode.analysis.ControlFlow.Block;

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

@RestController
@RequestMapping ("/comment")
public class CommentController {
	
	@Autowired
	private CommentService commentService;
	
	
	@GetMapping("/getallcom")
	public List<Comment> show() {
		List<Comment> coms = commentService.getallcoms() ; 
		return coms ; 
	}
	
	@GetMapping("/getcom/{comId}")
	public Comment findidcom(@PathVariable("comId") Long comId) {
		 
		return commentService.findbyidCom(comId); 
	}
	
	//localhost:3000/SpringMVC/servlet/comment/addcom
	@PostMapping("/addcom") 
	public String addingcom(@RequestBody Comment c) {
		commentService.addCom(c);
		return "Comment added!"; 
	}
	/*{
	"CommentId" : 1,
	"Description":"ezrzefrefdsq", 
	"LikesNb": 1,
	"DislikeNb":2,
	"Blocked": true,
	"Ads": 1,
	"User": 2
	
}*/
	
	@DeleteMapping("/deletecom/{comId}")
	public void DeletecomById(@PathVariable("comId") Long comId) {
		commentService.deletecomById(comId);
	}
	
	@PutMapping("/updatecom")
	@ResponseBody  
	public Comment Updatecom (@RequestBody Comment comment)  {
		return commentService.updatecom(comment);	
		
	}
	
	
	@PutMapping(value = "/BlockComments/{comId}")
	@ResponseBody
	public String BlockComments(@PathVariable long comId)  {
		 return commentService.Blockcomments(comId);
	}
	
	
	
	}
	
	
	
	