package com.mycom.myapp.board.controller;
import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.mycom.myapp.board.dto.BoardDto;
import com.mycom.myapp.board.dto.BoardParamDto;
import com.mycom.myapp.board.dto.BoardResultDto;
import com.mycom.myapp.board.service.BoardService;
import com.mycom.myapp.user.dto.UserDto;
import jakarta.servlet.http.HttpSession;



@Controller
@RequestMapping("/boards")
public class BoardController {
    // BoardService DI
    private final BoardService boardService;
    
    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }
    
    @GetMapping("/list") // limit, offset parameter 를 포함하는 요청
    @ResponseBody
    private BoardResultDto listBoard(BoardParamDto boardParamDto) {
    	
    	BoardResultDto boardResultDto;
    	
    	if(Strings.isEmpty(boardParamDto.getSearchWord())  )  {
    		boardResultDto=boardService.listBoard(boardParamDto);
    	}else {
    		boardResultDto= boardService.listBoardSearchWord(boardParamDto);
    	}
        return boardResultDto;
    }
    
    @GetMapping("/detail/{boardId}") // limit, offset parameter 를 포함하는 요청
    @ResponseBody
    private BoardResultDto detailBoard(@PathVariable int boardId, HttpSession session) {
        BoardParamDto boardParamDto = new BoardParamDto();
        boardParamDto.setBoardId(boardId);
        int userSeq = ((UserDto)session.getAttribute("userDto")).getUserSeq(); // login 할 때 session 에 담은 객체
        boardParamDto.setUserSeq( userSeq );
        return boardService.detailBoard(boardParamDto);
    }
    
    @PostMapping("/insert")
    @ResponseBody
    private BoardResultDto insertBoard(BoardDto boardDto, HttpSession session) {
        int userSeq = ((UserDto)session.getAttribute("userDto")).getUserSeq(); // login 할 때 session 에 담은 객체
        boardDto.setUserSeq( userSeq );
        return boardService.insertBoard(boardDto);
    }
    
    @PostMapping("/update")
    @ResponseBody
    private BoardResultDto updateBoard(BoardDto boardDto, HttpSession session) {
        return boardService.updateBoard(boardDto);
    }
    
    @GetMapping("/delete/{boardId}") 
    @ResponseBody
    private BoardResultDto deleteBoard(@PathVariable int boardId) {
        return boardService.deleteBoard(boardId);
    }
    
}



