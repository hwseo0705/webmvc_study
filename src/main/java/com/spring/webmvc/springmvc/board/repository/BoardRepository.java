package com.spring.webmvc.springmvc.board.repository;

import com.spring.webmvc.springmvc.board.domain.Board;

import java.util.List;

public interface BoardRepository {

    boolean save(Board board);

    boolean remove(int boardNo);

    List<Board> findAll();

    Board findOne(int boardNo);

    boolean modify(Board board);

    boolean update(int boardNo);
}
