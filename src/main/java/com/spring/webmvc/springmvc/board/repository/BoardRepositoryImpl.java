package com.spring.webmvc.springmvc.board.repository;

import com.spring.webmvc.springmvc.board.domain.Board;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@RequiredArgsConstructor
@Repository
public class BoardRepositoryImpl implements BoardRepository {

    private final JdbcTemplate template;

    @Override
    public boolean save(Board board) {
        String sql = "INSERT INTO board (board_no, writer, title, content) VALUES (seq_board.nextval, ?,?,?)";
        return template.update(sql, board.getWriter(), board.getTitle(), board.getContent()) == 1;
    }

    @Override
    public boolean remove(int boardNo) {
        String sql = "DELETE FROM board WHERE board_no = ?";
        return template.update(sql, boardNo) == 1;
    }

    @Override
    public List<Board> findAll() {
        String sql = "SELECT * FROM board ORDER BY board_no DESC";
        // 단일 건수 조회시 사용
        return template.query(sql, (rs, rowNum) -> new Board(rs));
    }

    @Override
    public Board findOne(int boardNo) {
        String sql = "SELECT * FROM board WHERE board_no = ?";
        // 단일 건수 조회시 사용
        return template.queryForObject(sql, (rs, rowNum) -> new Board(rs), boardNo);
    }

    @Override
    public boolean modify(Board board) {
        remove(board.getBoardNo());
        String sql = "INSERT INTO board (board_no, writer, title, content) VALUES (?,?,?,?)";
        return template.update(sql, board.getBoardNo(), board.getWriter(), board.getTitle(), board.getContent()) == 1;
    }

    @Override
    public boolean update(int boardNo) {
        String sql = "UPDATE board SET view_cnt=? WHERE board_no=?";
        int viewCnt = findOne(boardNo).getViewCnt() + 1;
        return template.update(sql, viewCnt, boardNo) == 1;
    }
}
