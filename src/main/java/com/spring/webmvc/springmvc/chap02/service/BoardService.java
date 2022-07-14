package com.spring.webmvc.springmvc.chap02.service;

import com.spring.webmvc.springmvc.board.domain.Board;
import com.spring.webmvc.springmvc.board.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository repository;

    public List<Board> listService() {
        List<Board> boardList = repository.findAll();
        return boardList;
    }

    public Board contentService(int boardNo) {
        Board board = repository.findOne(boardNo);
        return board;
    }

    public boolean deleteService(int boardNo) {
        return repository.remove(boardNo);
    }

    public boolean saveService(Board board) {

        return repository.save(board);
    }

    public boolean modifyService(Board board) {
        return repository.modify(board);
    }

    public void updateService(int boardNo) {
        repository.update(boardNo);
    }
}
