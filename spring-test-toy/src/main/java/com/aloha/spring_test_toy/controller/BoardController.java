package com.aloha.spring_test_toy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.aloha.spring_test_toy.domain.Board;
import com.aloha.spring_test_toy.service.BoardService;





@Controller
@RequestMapping("/board")
public class BoardController {

    @Autowired
    private BoardService boardService;
    
    // 목록
    @GetMapping("/list")
    public String list(Model model) throws Exception {
        List<Board> boardList = boardService.list();
        model.addAttribute("boardList", boardList);
        return "/board/list";
    }
    
    // 조회
    @GetMapping("/read")
    public String read(@RequestParam("no") int no, Model model) throws Exception {
        Board board = boardService.read(no);
        model.addAttribute("board", board);
        return "/board/read";
    }

    // 등록
    @GetMapping("/insert")
    public String insert() {
        return "/board/insert";
    }
    // 등록 처리
    @PostMapping("/insert")
    public String insertPro(Board board) throws Exception {
        int result = boardService.insert(board);
        if (result > 0) {
            return "redirect:/board/list";
        }
        return "redirect:/board/insert?error";
    }
    
    // 수정
    @GetMapping("/update")
    public String update() {
        return "/board/update";
    }
    // 수정 처리
    @PostMapping("/update")
    public String updatePro(Board board) throws Exception {
        int result = boardService.update(board);
        if (result > 0) {
            return "redirect:/board/list";
        }
        return "redirect:/board/update?error";
    }
    
    // 삭제
    @GetMapping("/delete")
    public String delete(@RequestParam("no") int no) throws Exception {
        int result = boardService.delete(no);
        if (result > 0) {
            return "redirect:/board/list";
        }
        return "redirect:/board/update?error";
    }
    
}
