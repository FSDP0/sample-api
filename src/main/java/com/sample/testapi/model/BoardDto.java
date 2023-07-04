package com.sample.testapi.model;

import lombok.Builder;
import lombok.Getter;

@Getter
public class BoardDto {
    private Integer id; // 게시글id

    private String title; // 제목

    private String content; // 내용

    private Integer writer; // 작성자

    private Integer editor; // 수정자

    @Builder
    public BoardDto(Integer id, String title, String content, Integer writer, Integer editor) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.writer = writer;
        this.editor = editor;
    }

    public Board toEntity() {
        Board board = Board.builder().id(this.id).title(this.title).content(this.content)
                .writer(this.writer).editor(this.editor).build();
        return board;
    }
}
