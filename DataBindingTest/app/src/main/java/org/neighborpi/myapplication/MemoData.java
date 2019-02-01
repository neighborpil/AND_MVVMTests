package org.neighborpi.myapplication;

public class MemoData {

    public String Title;
    public String Content;

    public MemoData(String title, String content){
        this.Title = title;
        this.Content = content;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }
}

