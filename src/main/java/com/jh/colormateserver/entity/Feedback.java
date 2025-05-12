package com.jh.colormateserver.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Feedback {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long feedbackId;

    @Column(nullable = false)
    private String nickname;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private FeedbackType type;
    // Large Object로 길이가 긴 문자열(TEXT)을 저장할 수 있게 하는 어노테이션
    @Lob
    private String content;

    @Column(nullable = false)
    private LocalDateTime createdAt;

    /* @PrePersist 는 JPA 라이프사이클 콜백입니다.
    DB에 엔티티가 persist() 되기 전, 즉 저장 직전에 자동 실행되는 메서드입니다.
    이걸 통해 createdAt 값을 자동으로 현재 시각으로 설정하게 됩니다.*/
    @PrePersist
    public void prePersist() {
        this.createdAt = LocalDateTime.now();
    }
}
