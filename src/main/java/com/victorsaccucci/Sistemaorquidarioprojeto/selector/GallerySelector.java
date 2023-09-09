package com.victorsaccucci.Sistemaorquidarioprojeto.selector;

public class GallerySelector extends BaseSelector{
        private String title;
        private Long userId;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getTitle(){
            return title;
        }
    public void setTitle(String title) {
        this.title = title;
    }
}
