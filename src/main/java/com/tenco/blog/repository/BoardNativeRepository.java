package com.tenco.blog.repository;

import com.tenco.blog.model.Board;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository // IoC 대상
public class BoardNativeRepository {

    // JPA 의 핵심 인터페이스
    // 데이터베이스와의 모든 작업을 담당
    private EntityManager em;

    // 생성자를 확인해서 자동으로 EntityManager 객체를 주입 시킨다.
    // DI 처리
    public BoardNativeRepository(EntityManager em) {
        this.em = em;
    }

    // 게시글 목록 조회
    public List<Board> findAll() {
        // 쿼리 기술 --> 네이티브 쿼리

        // Board.class
        // Object[] --> List<Board>
        // 오브젝트가 아닌 리스트로 명시
        Query query = em.createNativeQuery("select * from board_tb order by id desc ", Board.class);

        // query.getResultList(); 여러 행의 결과를 List 객체로 반환
        // query.getSingleResult(); 단일 결과를 반환(한 개의 row 데이터만 있을 때)
        // List list = query.getResultList();
        return query.getResultList();
    }


    @Transactional
    public void save(String title, String content, String username) {

        Query query = em.createNativeQuery("insert into board_tb(title, content, username, created_at) " +
                " values(?, ?, ?, now())");

        query.setParameter(1, title);
        query.setParameter(2, content);
        query.setParameter(3, username);

        query.executeUpdate();
    }
}
