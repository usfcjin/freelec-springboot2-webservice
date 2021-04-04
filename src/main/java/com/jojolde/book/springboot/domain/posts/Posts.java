package com.jojolde.book.springboot.domain.posts;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Getter
// 클래스 내 모든 필드의 Getter 메소드를 자동생성
@NoArgsConstructor
// 기본생성자 자동추가
// public Posts() {} 와 같은 효과
@Entity
// 테이블과 링크될 클레스임을 나타냅니다.
// 기본값으로 클레스의 카멜케이스 이름을 언터스코어 네이밍 이름으로 테이블 이름을 매핑합니다.
public class Posts {

    @Id
    // 해당 테이블의 PK 필드를 나타냅니다.
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // PK의 생성 규칙을 나타냅니다.
    private Long id;

    @Column(length = 500, nullable = false)
    // 테이블의 칼럼을 나타내며 굳이 선언하지 않아도 해당 클레스의 필드는 모두 컬럼이 됩니다.
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    @Builder
    // 해당 클래스의 빌드 패턴 클래스를 생성
    // 생성자 상단에 선언 시 생성자에 포함된 필드만 빌더에 포함
    public Posts(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
