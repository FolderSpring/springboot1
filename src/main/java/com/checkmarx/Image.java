package com.checkmarx;

public class Image {

    private String searchTerm;
    private String url;

    public Image() {
    }

    public String getSearchTerm() {
        return searchTerm;
    }

    public void setSearchTerm(String searchTerm) {
        this.searchTerm = searchTerm;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "Image{" +
                "searchTerm='" + searchTerm + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
