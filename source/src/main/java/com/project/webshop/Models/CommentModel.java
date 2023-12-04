package com.project.webshop.Models;

import com.project.webshop.DAO.CommentDAO;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class CommentModel {
    private int productID, rate;
    private String email, comment;
    private LocalDate publishDate;

    CommentDAO commentDAO;
    public CommentModel(/*int commentID, */int productID, int rate, String email, String comment, LocalDate publishDate) {
        //this.commentID = commentID;
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

    public int getProductID() {
        return productID;
    }

    public int getRate() {
        return rate;
    }

    public String getEmail() {
        return email;
    }

    public String getComment() {
        return comment;
    }

    public LocalDate getPublishDate() {
        return publishDate;
    }
}
