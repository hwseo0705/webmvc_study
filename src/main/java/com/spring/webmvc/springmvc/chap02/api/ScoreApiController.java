package com.spring.webmvc.springmvc.chap02.api;

import com.spring.webmvc.springmvc.chap02.domain.Score;
import com.spring.webmvc.springmvc.chap02.repository.ScoreMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Log4j2
@CrossOrigin
public class ScoreApiController {
    private final ScoreMapper repository;

    // 점수 등록 및 조회 화면 열기 요청
    @GetMapping("/score")
    public List<Score> list(@RequestBody String sort) {
        log.info("/score GET 요청!!");

        List<Score> scoreList = repository.findAll(sort);

        // 이름 마킹 처리
        for (Score s : scoreList) {
            String original = s.getName();
            StringBuilder markName = new StringBuilder(String.valueOf(original.charAt(0)));
            for (int i = 0; i < original.length() - 1; i++) {
                markName.append("*");
            }
            s.setName(markName.toString());
        }

        return scoreList;
    }


    // 점수 신규 등록 요청
    @PostMapping("/score")
    public String register(@RequestBody Score score) {
        score.calcTotalAndAvg();
        score.calcGrade();
        log.info("/score POST! - " + score);

        return repository.save(score) ? "insert-success" : "insert-fail";

    }

    @DeleteMapping("/score/{stuNum}")
    public String remove(@PathVariable int stuNum) {
        log.info("/score GET - {}", stuNum);
        return repository.remove(stuNum) ? "del-success" : "del-fail";
    }

    @GetMapping("/score/{stuNum}")
    public Score detail(@PathVariable int stuNum) {
        log.info("/score/{stuNum} GET - param: {}", stuNum);
        return repository.findOne(stuNum);
    }

}
