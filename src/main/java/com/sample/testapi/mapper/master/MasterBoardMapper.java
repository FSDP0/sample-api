package com.sample.testapi.mapper.master;

import org.apache.ibatis.annotations.Param;
import com.sample.testapi.model.BoardDto;

public interface MasterBoardMapper {
    void createBoard(@Param("board") BoardDto board);

    void updateBoard(@Param("id") Integer id, @Param("board") BoardDto board);

    void deleteBoard(@Param("id") Integer id);
}
