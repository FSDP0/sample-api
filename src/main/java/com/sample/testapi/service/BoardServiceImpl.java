package com.sample.testapi.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.sample.testapi.mapper.master.MasterBoardMapper;
import com.sample.testapi.mapper.slave.SlaveBoardMapper;
import com.sample.testapi.model.Board;
import com.sample.testapi.model.BoardDetailDto;
import com.sample.testapi.model.BoardDto;

@Service
public class BoardServiceImpl implements BoardService {
    private final MasterBoardMapper masterBoardMapper; // INSERT, UPDATE, DELETE
    private final SlaveBoardMapper slaveBoardMapper; // SELECT

    public BoardServiceImpl(MasterBoardMapper masterBoardMapper,
            SlaveBoardMapper slaveBoardMapper) {
        this.masterBoardMapper = masterBoardMapper;
        this.slaveBoardMapper = slaveBoardMapper;
    }

    @Override
    public List<Board> findAll() {
        return this.slaveBoardMapper.findAll();
    }

    @Override
    public Board findById(Integer id) {
        return this.slaveBoardMapper.findById(id);
    }

    @Override
    public BoardDetailDto findDetailById(Integer id) {
        return this.slaveBoardMapper.findDetailById(id);
    }

    @Override
    public void createBoard(BoardDto boardDto) {
        this.masterBoardMapper.createBoard(boardDto);
    }

    @Override
    public void updateBoard(Integer id, BoardDto boardDto) {
        this.masterBoardMapper.updateBoard(id, boardDto);
    }

    @Override
    public void deleteBoard(Integer id) {
        this.masterBoardMapper.deleteBoard(id);
    }
}
