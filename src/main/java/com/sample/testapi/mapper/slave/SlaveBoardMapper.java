package com.sample.testapi.mapper.slave;

import java.util.List;
import com.sample.testapi.model.Board;
import com.sample.testapi.model.BoardDetailDto;

public interface SlaveBoardMapper {
    List<Board> findAll();

    Board findById(Integer id);

    BoardDetailDto findDetailById(Integer id);
}
