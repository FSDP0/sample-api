package com.sample.testapi.controller;

import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.sample.testapi.model.Board;
import com.sample.testapi.model.BoardDetailDto;
import com.sample.testapi.model.BoardDto;
import com.sample.testapi.service.BoardService;

@RestController
@RequestMapping("boards")
public class BoardController {
    private BoardService boardService;

    private BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    @GetMapping
    private List<Board> findAll() {
        return this.boardService.findAll();
    }

    @GetMapping("/{boardId}")
    private BoardDetailDto findById(@PathVariable Integer boardId) {
        return this.boardService.findDetailById(boardId);
    }

    @PostMapping
    private void createBoard(@RequestBody BoardDto dto) {
        this.boardService.createBoard(dto);
    }

    @PutMapping("/{boardId}")
    private void editBoardInfo(@PathVariable Integer boardId, @RequestBody BoardDto dto) {
        this.boardService.updateBoard(boardId, dto);
    }

    @DeleteMapping("/{boardId}")
    private void deleteBoard(@PathVariable Integer boardId) {
        this.boardService.deleteBoard(boardId);
    }
}
