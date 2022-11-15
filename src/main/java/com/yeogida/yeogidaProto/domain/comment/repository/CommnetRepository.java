package com.yeogida.yeogidaProto.domain.comment.repository;

import com.yeogida.yeogidaProto.domain.comment.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommnetRepository extends JpaRepository<Comment, Long> {
}
