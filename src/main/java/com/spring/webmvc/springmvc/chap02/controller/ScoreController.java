package com.spring.webmvc.springmvc.chap02.controller;

import com.spring.webmvc.springmvc.chap02.domain.Score;
import com.spring.webmvc.springmvc.chap02.repository.ScoreMapper;
import com.spring.webmvc.springmvc.chap02.repository.ScoreRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@Log4j2
@RequiredArgsConstructor
public class ScoreController {

    // private final ScoreRepository repository;
    private final ScoreMapper repository;

    // 점수 등록 및 조회 화면 열기 요청
    @RequestMapping("/score/list")
    public String list(@RequestParam(defaultValue = "num") String sort, Model model) {
        log.info("/score/list GET 요청!! - param1 : {}", sort);

        // jsp에게 점수 정보 리스트를 전달해야 함.
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

        model.addAttribute("scores", scoreList);
        return "chap02/score-list";
    }


    // 점수 신규 등록 요청
    @RequestMapping("/score/register")
    public String register(Score score) { // new Score() done by Spring with NoArgsConstructor
        score.calcTotalAndAvg();
        score.calcGrade();
        log.info("score/register POST! - " + score);

        // redirect to score/list to go to the list page while auto updating
        return repository.save(score) ? "redirect:/score/list" : "redirect:/";

    }

    @RequestMapping("/score/delete")
    public String remove(int stuNum) {
        log.info("/score/delete GET - param1: {}", stuNum);
        return repository.remove(stuNum) ? "redirect:/score/list" : "redirect:/";
    }

//    @RequestMapping("/score/detail")
//    public String detail(int stuNum, Model model) {
//        Score score = repository.findOne(stuNum);
//        model.addAttribute("s", score);
//        return "chap02/score-detail";
//    }

    @RequestMapping("/score/detail")
    public ModelAndView detail(int stuNum) {
        log.info("/score/detail GET - param: {}", stuNum);
        Score score = repository.findOne(stuNum);
        ModelAndView mv = new ModelAndView("chap02/score-detail");
        mv.addObject("s", score);
        return mv;
    }

    @RequestMapping("/score/byAvg")
    public String byAvg(Model model) {
        List<Score> scoreList = repository.byAvg();
        model.addAttribute("scores", scoreList);
        return "chap02/score-list";
    }

    @RequestMapping("/score/getMax")
    public String getMax(Model model) {
        List<Integer> maxList = repository.maxScore();
        model.addAttribute("s", maxList.get(0));
        model.addAttribute("h", maxList.get(1));
        model.addAttribute("w", maxList.get(2));
        return "chap02/score-max";
    }
}
