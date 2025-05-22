package com.example.angkringan_99.model;

public class Comment {
    private Long id;
    private String name;
    private String comment;
    private String profession;
    private int rating;

    public Comment() {}

    public Comment(Long id, String name, String comment, String profession, int rating) {
        this.id = id;
        this.name = name;
        this.comment = comment;
        this.profession = profession;
        this.rating = rating;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
