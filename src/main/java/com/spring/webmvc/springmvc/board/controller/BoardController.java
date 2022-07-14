package com.spring.webmvc.springmvc.board.controller;

import com.spring.webmvc.springmvc.board.domain.Board;
import com.spring.webmvc.springmvc.chap02.service.BoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

/**
 * 게시물 목록요청: /board/list: GET
 * 게시물 상세조회요청: /board/content: GET
 * 게시글 쓰기 화면요청: /board/write: GET
 * 게시글 등록요청: /board/write: POST
 * 게시글 삭제요청: /board/delete: GET
 * 게시글 수정화면요청: /board/modify: GET
 * 게시글 수정요청: /board/modify: POST
 */

@Controller
@Log4j2
@RequiredArgsConstructor
public class BoardController {

    private final BoardService service;

    // 게시물 목록요청: /board/list: GET
    @GetMapping("/board/list")
    public String list(Model model) {

        List<Board> boardList = service.listService();
        log.info("/board/list GET 요청!! - {}", boardList);

        model.addAttribute("boards", boardList);
        return "board/board-list";
    }

    // 게시물 상세조회요청: /board/content: GET
    @GetMapping("/board/content")
    public String content(int boardNo, Model model) {
        log.info("/board/content GET 요청!!");

        Board board = service.contentService(boardNo);

        model.addAttribute("b", board);

        service.updateService(boardNo);

        return "board/board-content";
    }

    // 게시글 쓰기 화면요청: /board/write: GET
    @GetMapping("/board/write")
    public String write() {
        log.info("/board/write GET 요청!!");

        return "board/board-write";
    }

    // 게시글 등록요청: /board/write: POST
    @PostMapping("/board/postWrite")
    public String postWrite(Board board) {
        log.info("/board/postWrite POST! - " + board);

        return service.saveService(board) ? "redirect:/board/list" : "redirect:/";
    }

    // 게시글 삭제요청: /board/delete: GET
    @GetMapping("/board/delete")
    public String delete(int boardNo) {
        log.info("/score/delete GET - param1: {}", boardNo);
        return service.deleteService(boardNo) ? "redirect:/board/list" : "redirect:/";
    }

    // 게시글 수정화면요청: /board/modify: GET
    @GetMapping("/board/modify")
    public String modify(int boardNo, Model model) {
        log.info("/board/modify GET 요청!!");

        Board board = service.contentService(boardNo);

        model.addAttribute("b", board);

        return "board/board-modify";
    }
    // 게시글 수정요청: /board/modify: POST
    @PostMapping("/board/postModify")
    public String postModify(Board board) {
        log.info("/board/postWrite POST! - " + board);

        return service.modifyService(board) ? "redirect:/board/content?boardNo=" + board.getBoardNo() : "redirect:/";
    }
}
