package com.quanlybanhang.qlbh.controller;

import com.quanlybanhang.qlbh.dto.CommentDTO;
import com.quanlybanhang.qlbh.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v12")
@CrossOrigin(origins = "http://localhost:4200")
public class CommentController {



    @Autowired
    private CommentService commentService;

    @PostMapping("add-comment")
    public ResponseEntity<?> addComment(@RequestBody CommentDTO commentDTO){
        return new ResponseEntity<>(this.commentService.addComment(commentDTO), HttpStatus.CREATED);
    }

    @GetMapping("get-all-comment")
    public ResponseEntity<?> getAllComment(){
        return new ResponseEntity<>(this.commentService.getAllComment(),HttpStatus.OK);
    }

    @GetMapping("get-all-comment-by-product/{pro_id}")
    public ResponseEntity<?> getAllComment(@PathVariable Integer pro_id){
        return new ResponseEntity<>(this.commentService.getAllCommentByProduct(pro_id),HttpStatus.OK);
    }

    @DeleteMapping("delete-comment/{id}")
    public Boolean deleteCommentById(@PathVariable Integer id){
        return this.commentService.deleteComment(id);
    }
}
