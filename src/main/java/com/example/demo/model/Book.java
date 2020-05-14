package com.example.demo.model;

public class Book {
    //- Kitap tanimi yapılabilmeli ( kitap adı, kitap alt adı, kitap seri adı, yazar, yayın evi, isbn numarası, açıklama )
    private int id;
    private String name;
    private String ISBN;
    private String subName;
    private String seriesName;
    private String description;
    private String authorName;  //fk
    private String publisherName; //fk

    public Book(String name, String ISBN, String authorName, String publisherName) {
        this.name = name;
        this.ISBN = ISBN;
        this.authorName = authorName;
        this.publisherName = publisherName;
    }

    public Book(String name, String ISBN) {
        this.name = name;
        this.ISBN = ISBN;
    }

    public Book(Book another) {
        this.id = another.id;
        this.name = another.name;
        this.ISBN = another.ISBN;
        this.subName = another.subName;
        this.seriesName = another.seriesName;
        this.description = another.description;
        this.authorName = another.authorName;
        this.publisherName = another.publisherName;
    }

    public Book(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getSubName() {
        return subName;
    }

    public void setSubName(String subName) {
        this.subName = subName;
    }

    public String getSeriesName() {
        return seriesName;
    }

    public void setSeriesName(String seriesName) {
        this.seriesName = seriesName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getPublisherName() {
        return publisherName;
    }

    public void setPublisherName(String publisherName) {
        this.publisherName = publisherName;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", ISBN='" + ISBN + '\'' +
                ", subName='" + subName + '\'' +
                ", seriesName='" + seriesName + '\'' +
                ", description='" + description + '\'' +
                ", authorName='" + authorName + '\'' +
                ", publisherName='" + publisherName + '\'' +
                '}';
    }

}