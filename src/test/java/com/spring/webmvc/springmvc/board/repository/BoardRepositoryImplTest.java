package com.spring.webmvc.springmvc.board.repository;

import com.spring.webmvc.springmvc.board.domain.Board;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class BoardRepositoryImplTest {

    @Autowired
    BoardRepository repository;

    @Test
    @DisplayName("게시물 정보가 데이터베이스 테이블에 삽입되어야 한다.")
    void saveTest() {
        Board b = new Board("Writer2", "Title2", "Content2");
        boolean result = repository.save(b);
        assertTrue(result);
    }

    @Test
    @DisplayName("게시물 정보가 데이터베이스 테이블에 삭제되어야 한다.")
    void removeTest() {
        // given
        int boardNo = 1;

        // when
        boolean result = repository.remove(boardNo);

        // then
        assertTrue(result);
    }

    @Test
    @DisplayName("특정 게시물 번호에 대한 정보를 조회해야 한다.")
    void findOneTest() {
        Board board = repository.findOne(2);

        System.out.println("\n\n\n" + board + "\n\n\n");

        assertEquals("Title", board.getTitle());
    }

    @Test
    @DisplayName("모든 게시물 정보를 조회해야 한다.")
    void findAllTest() {
        List<Board> boardList = repository.findAll();

        // scoreList.forEach(s -> System.out.println(s));
        boardList.forEach(System.out::println);
    }


}