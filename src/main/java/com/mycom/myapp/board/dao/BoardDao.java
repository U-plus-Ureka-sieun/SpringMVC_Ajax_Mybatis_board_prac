package com.mycom.myapp.board.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.mycom.myapp.board.dto.BoardDto;
import com.mycom.myapp.board.dto.BoardParamDto;

@Mapper
public interface BoardDao {
	List<BoardDto> listBoard(BoardParamDto boardParamDto);
	int listBoardTotalCount();
	
	List<BoardDto> listBoardSearchWord(BoardParamDto boardParamDto);
	int listBoardSearchWordTotalCount(BoardParamDto boardParamDto);
	
	BoardDto detailBoard(BoardParamDto boardParamDto);
	
	int insertBoard(BoardDto boardDto);
	int updateBoard(BoardDto boardDto);
	int deleteBoard(int boardId);
}
