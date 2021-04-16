package com.quanlybanhang.qlbh.serviceImpl;

import com.quanlybanhang.qlbh.dao.CommentDao;
import com.quanlybanhang.qlbh.dto.CommentDTO;
import com.quanlybanhang.qlbh.entity.CommentEntity;
import com.quanlybanhang.qlbh.modalmapping.CommentMapper;
import com.quanlybanhang.qlbh.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentDao commentDao;

    @Override
    public CommentDTO addComment(CommentDTO commentDTO) {
        CommentEntity commentEntity = CommentMapper.dto2Entity(commentDTO);
        commentEntity.setCreated_at(TimeService.getTimeNow());
        commentDTO = CommentMapper.entity2DTO(this.commentDao.save(commentEntity));
        return commentDTO;
    }

    @Override
    public List<CommentDTO> getAllComment() {
        List<CommentEntity> entityList = this.commentDao.findAll();
        List<CommentDTO> list = new ArrayList<>();
        for(CommentEntity entity : entityList){
            list.add(CommentMapper.entity2DTO(entity));
        }
        return list;
    }

    @Override
    public List<CommentDTO> getAllCommentByProduct(Integer pro_id) {
        List<CommentEntity> entityList = this.commentDao.getAllCommentByPro(pro_id);
        List<CommentDTO> list = new ArrayList<>();
        for(CommentEntity entity : entityList){
            list.add(CommentMapper.entity2DTO(entity));
        }
        return list;
    }

    @Override
    public Boolean deleteComment(Integer id) {
        this.commentDao.deleteById(id);
        return true;
    }
}
