package com.project.webshop.Models;

import com.project.webshop.DAO.CommentDAO;

import java.time.LocalDateTime;

public class CommentModel {
    private int commentID, productID, rate;
    private String email, comment;
    private LocalDateTime publishDate;

    CommentDAO commentDAO;
    public CommentModel(int commentID, int productID, int rate, String email, String comment, LocalDateTime publishDate) {
        this.commentID = commentID;
        this.productID = productID;
        this.rate = rate;
        this.email = email;
        this.comment = comment;
        this.publishDate = publishDate;
        commentDAO = new CommentDAO();
    }

    public CommentDAO getCommentDAO() {
        return commentDAO;
    }
}
