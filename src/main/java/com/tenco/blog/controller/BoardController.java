package com.tenco.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller // IoC 대상 - 싱글톤 패턴으로 관리 됨
public class BoardController {

    @GetMapping({"/", "/index"})
    public String index() {
        // prefix: /templates/
        // return: index
        // suffix: .mustache
        // 기본 경로를 src/main/resources/templates/index.mustache
        return "index";
    }

    @GetMapping("/board/save-form")
    public String saveForm() {
        return "board/save-form";
    }


    /**
     * 상세보기 화면 요청
     * board/1
     */
    @GetMapping("/board/{id}")
    public String detail(@PathVariable(name = "id") Integer id){
        // URL 에서 받은 id 값을 사용해서 특정 게시글 상세보기 조회
        // 실제로는 이 id 값으로 데이터 베이스에 있는 게시글 조회하고
        // 머스태치 파일로 데이터를 내려 주어야 한다 (Model)
        return "board/detail";
    }
}
