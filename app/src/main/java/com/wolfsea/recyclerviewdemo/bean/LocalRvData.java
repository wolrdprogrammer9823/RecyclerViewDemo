package com.wolfsea.recyclerviewdemo.bean;
import java.util.Objects;

/**
 * @author liuliheng
 * @desc  实体类
 * @time 2020/11/17  11:02
 **/
public class LocalRvData {

    private String title;

    private String content;

    public LocalRvData(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        LocalRvData that = (LocalRvData) o;
        return Objects.equals(title, that.title) &&
                Objects.equals(content, that.content);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, content);
    }

    @Override
    public String toString() {
        return this.getClass().getName() + "{" +
                "title='" + title + '\'' +
                ", content='" + content + '\'' +
                '}';
    }

}
