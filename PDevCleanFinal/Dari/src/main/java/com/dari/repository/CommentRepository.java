package com.dari.repository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dari.model.Comment;

@Repository
public interface CommentRepository extends CrudRepository <Comment, Long> {



}