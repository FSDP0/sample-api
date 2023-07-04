package com.sample.testapi.model;

import lombok.Builder;
import lombok.Getter;

@Getter
public class Board {
    private Integer id; // 게시글id

    private String title; // 제목

    private String content; // 내용

    private Integer writer; // 작성자

    private Integer editor; // 수정자

    @Builder
    public Board(Integer id, String title, String content, Integer writer, Integer editor) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.writer = writer;
        this.editor = editor;
    }
}
