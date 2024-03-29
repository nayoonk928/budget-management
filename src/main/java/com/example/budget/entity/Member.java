package com.example.budget.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member {

    @Id
    @Column(name = "member_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(nullable = false, unique = true)
    String account;

    @Column(nullable = false)
    String password;

    @Column(nullable = false, unique = true)
    String nickname;

    @Column(nullable = false)
    Boolean notification;

    @Builder
    public Member(String account, String password, String nickname, Boolean notification) {
        this.account = account;
        this.password = password;
        this.nickname = nickname;
        this.notification = notification != null ? notification : false;
    }

    public void update(String nickname, Boolean notification) {
        this.nickname = nickname;
        this.notification = notification != null ? notification : false;
    }

    public Member(Long id, String account, String password, String nickname, Boolean notification) {
        this.id = id;
        this.account = account;
        this.password = password;
        this.nickname = nickname;
        this.notification = notification != null ? notification : false;
    }

}
