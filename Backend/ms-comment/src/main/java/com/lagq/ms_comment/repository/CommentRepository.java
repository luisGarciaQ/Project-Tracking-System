package com.lagq.ms_comment.repository;


import com.lagq.ms_comment.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long>
{
    List<Comment> findByTicketId(Long ticketId);
    
    List<Comment> findByAuthorId(Long ticketId);
}
