package com.quanlybanhang.qlbh.service;

import com.quanlybanhang.qlbh.dto.CommentDTO;

import java.util.List;

public interface CommentService {
    CommentDTO addComment(CommentDTO commentDTO);
    List<CommentDTO> getAllComment();
    List<CommentDTO> getAllCommentByProduct(Integer pro_id);
    Boolean deleteComment(Integer id);
}
