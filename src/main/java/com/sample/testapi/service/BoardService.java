package com.sample.testapi.service;

import java.util.List;
import com.sample.testapi.model.Board;
import com.sample.testapi.model.BoardDetailDto;
import com.sample.testapi.model.BoardDto;

public interface BoardService {

    // 게시판 목록 조회
    List<Board> findAll();

    // 게시판 상세 조회
    Board findById(Integer id);

    BoardDetailDto findDetailById(Integer id);

    // 게시판 등록
    void createBoard(BoardDto board);

    // 게시판 수정
    void updateBoard(Integer id, BoardDto board);

    // 게시판 삭제
    void deleteBoard(Integer id);

}
