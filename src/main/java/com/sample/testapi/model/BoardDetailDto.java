package com.sample.testapi.model;

import lombok.Builder;
import lombok.Getter;

@Getter
public class BoardDetailDto {
    private Integer id; // 게시글id

    private String title; // 제목

    private String content; // 내용

    private Integer writer; // 작성자 아이디

    private String name; // 작성자 이름

    private String detailAddr; // 작성자 주소

    @Builder
    public BoardDetailDto(Integer id, String title, String content, Integer writer, String name,
            String detailAddr) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.writer = writer;
        this.name = name;
        this.detailAddr = detailAddr;
    }
}
