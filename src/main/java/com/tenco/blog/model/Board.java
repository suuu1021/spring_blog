package com.tenco.blog.model;

import com.tenco.blog.utills.MyDateUtil;
import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;

@Data
// @Table : 실제 데이터베이스 테이블 명을 지정할 때 사용
@Table(name = "board_tb")
// @Entity JPA가 이 클래스를 데이터베이스 테이블과 맵핑하는 객체(entity)로 인식
// 즉, @Entity 어노테이션이 있어야 JPA가 이 객체를 관리한다.
@Entity
public class Board {

    // @Id 이 필드가 기본키(Primary key)임을 나타냄
    @Id
    // IDENTITY 전략 : 데이터베이스의 기본 전략을 사용한다. -> Auto_Increment
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    // 별도 어노테이션이 없으면 필드명이 컬럼명이 됨
    private String title;
    private String content;
    private String username;
    private Timestamp createdAt; // created_at (스네이크 케이스로 자동 변환)

    // 머스태치에서 표현할 시간의 포맷기능(행위)을 스스로 만들자.
    public String getTime() {
        return MyDateUtil.timestampFormat(createdAt);
    }
}
