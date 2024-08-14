package com.mycom.myapp.board.service;
import java.util.List;
import org.springframework.stereotype.Service;
import com.mycom.myapp.board.dao.BoardDao;
import com.mycom.myapp.board.dto.BoardDto;
import com.mycom.myapp.board.dto.BoardParamDto;
import com.mycom.myapp.board.dto.BoardResultDto;
@Service
public class BoardServiceImpl implements BoardService {
    
    // BoardDao DI
    private final BoardDao boardDao;
    
    public BoardServiceImpl(BoardDao boardDao) {
        this.boardDao = boardDao;
    }
    
    @Override
    public BoardResultDto listBoard(BoardParamDto boardParamDto) {
        BoardResultDto boardResultDto = new BoardResultDto();
        
        try {
        List<BoardDto> list = boardDao.listBoard(boardParamDto);
        boardResultDto.setList(list);
        boardResultDto.setResult("success");
    }catch(Exception e) {
    	e.printStackTrace();
    	boardResultDto.setResult("fail");
    	
    }
        return boardResultDto;
    }
}