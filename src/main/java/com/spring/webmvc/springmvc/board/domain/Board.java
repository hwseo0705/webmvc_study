package com.spring.webmvc.springmvc.board.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

@Setter
@Getter
@ToString
@NoArgsConstructor
public class Board {

    private int boardNo;
    private String writer;
    private String title;
    private String content;
    private int viewCnt;

    private Date regDate;

    public Board(String writer, String title, String content) {
        this.writer = writer;
        this.title = title;
        this.content = content;
    }

    public Board(ResultSet rs) throws SQLException {
        this.boardNo = rs.getInt("board_no");
        this.writer = rs.getString("writer");
        this.title = rs.getString("title");
        this.content = rs.getString("content");
        this.viewCnt = rs.getInt("view_cnt");
        this.regDate = rs.getTimestamp("reg_date");
    }
}
