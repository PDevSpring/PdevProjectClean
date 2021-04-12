package com.dari.repository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dari.model.CommentReply;
@Repository
public interface CommentReplyRepository extends CrudRepository <CommentReply ,Long> {

}
