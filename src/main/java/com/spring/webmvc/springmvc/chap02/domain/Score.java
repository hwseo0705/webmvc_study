package com.spring.webmvc.springmvc.chap02.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.log4j.Log4j2;

import java.sql.ResultSet;
import java.sql.SQLException;

import static com.spring.webmvc.springmvc.chap02.domain.Grade.*;

@Setter
@Getter
@ToString
@Log4j2
//@NoArgsConstructor
public class Score {

    // 클라이언트가 전달할 데이터
    private String name; // student name
    private int kor, eng, math; // score

    // 서버에서 생성하는 데이터
    private int stuNum; // 학번
    private int total;
    private double average;
    private Grade grade; // 학점

    public Score() {
//        log.info("Score NoArgsConstructor Called!!!!!!!!!!!!!!!!!!!!");
    }

    public Score(String name, int kor, int eng, int math) {
        this.name = name;
        this.kor = kor;
        this.eng = eng;
        this.math = math;
        calcTotalAndAvg();
        calcGrade();
    }

    public Score(ResultSet rs) throws SQLException {
        this.stuNum = rs.getInt("stu_num");
        this.name = rs.getString("stu_name");
        this.kor = rs.getInt("kor");
        this.eng = rs.getInt("eng");
        this.math = rs.getInt("math");
        this.total = rs.getInt("total");
        this.average = rs.getDouble("average");
        this.grade = Grade.valueOf(rs.getString("grade"));
    }

    public void calcTotalAndAvg() {
        this.total = kor + eng + math;
        this.average = total / 3.0;
    }

    public void calcGrade() {
        if (this.average >= 90) {
            this.grade = A;
        } else if (this.average >= 80) {
            this.grade = B;
        } else if (this.average >= 70) {
            this.grade = C;
        } else if (this.average >= 60) {
            this.grade = D;
        } else {
            this.grade = F;
        }
    }
}
