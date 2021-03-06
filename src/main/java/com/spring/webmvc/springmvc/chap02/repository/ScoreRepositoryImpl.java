package com.spring.webmvc.springmvc.chap02.repository;

import com.spring.webmvc.springmvc.chap02.domain.Score;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor // final 필드를 초기화 해주는 생성자 선언
@Repository // autowired 하기 위하여 spring 등록 / @Repository = @Component
public class ScoreRepositoryImpl implements ScoreRepository {

    // 스프링 JDBC - JDBC Template : JDBC를 단순화
    private final JdbcTemplate template;

    @Override
    public boolean save(Score score) {
        String sql = "INSERT INTO tbl_score VALUES (seq_tbl_score.nextval, ?,?,?,?,?,?,?)";
        // INSERT, UPDATE, DELETE = 템플릿의 update() 메서드 활용
        return template.update(sql, score.getName(), score.getKor(), score.getEng(), score.getMath(), score.getTotal(), score.getAverage(), score.getGrade().toString()) == 1;
    }

    @Override
    public List<Score> findAll(String sort) {
        StringBuilder sql = new StringBuilder("SELECT * FROM tbl_score");

        switch (sort) {
            case "num":
                sql.append(" ORDER BY stu_num");
                break;
            case "name":
                sql.append(" ORDER BY stu_name");
                break;
            case "average":
                sql.append(" ORDER BY average DESC");
                break;
        }

        // SELECT 문의 경우는 query()

        // 1.
        /*return template.query(sql, new ScoreRowMapper());*/

        // 2.
        /*return template.query(sql, new RowMapper<Score>() {
            @Override
            public Score mapRow(ResultSet rs, int rowNum) throws SQLException {
                return new Score(rs);
            }
        });*/

        // 3.
        return template.query(sql.toString(), (rs, rowNum) -> new Score(rs));
    }

    @Override
    public Score findOne(int stuNum) {

        String sql = "SELECT * FROM tbl_score WHERE stu_num = ?";
        // 단일 건수 조회시 사용
        return template.queryForObject(sql, (rs, rowNum) -> new Score(rs), stuNum);
    }

    @Override
    public boolean remove(int stuNum) {
        String sql = "DELETE FROM tbl_score WHERE stu_num = ?";
        return template.update(sql, stuNum) == 1;
    }

    @Override
    public List<Score> byAvg() {
        String sql = "SELECT * FROM tbl_score ORDER BY average";
        return template.query(sql, (rs, rowNum) -> new Score(rs));
    }


    public List<Integer> maxScore() {
        String sql = "SELECT MAX(kor) as kor_m, MAX(eng) as eng_m, MAX(math) as math_m FROM tbl_score";
        return template.queryForObject(sql, (rs, rowNum) -> {
            ArrayList<Integer> list = new ArrayList<>();
            list.add(rs.getInt("kor_m"));
            list.add(rs.getInt("eng_m"));
            list.add(rs.getInt("math_m"));
            return list;
        });
    }
}
