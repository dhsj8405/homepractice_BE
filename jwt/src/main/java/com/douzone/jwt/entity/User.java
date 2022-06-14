package com.douzone.jwt.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
//import javax.validation.constraints.NotNull;
//import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

//테이블과 링크될 클래스임을 나타내는 어노테이션
@Entity
@Table(name = "user")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {

   @Id													// 해당 테이블의 PK 필드
   @Column(name = "user_id")							// 테이블의 컬럼(굳이 선언 안해도 사용되지만, 기본값 외에 추가로 변경이 필요한 옵션이 있으면 사용)
   @GeneratedValue(strategy = GenerationType.IDENTITY)	// PK 생성규칙 : 스프링 부트2.0에서 GenterationType.IDENTITY 옵션을 추가해야만 auto_increment가 된다.
   private Long userId;

   @Column(name = "username", length = 50, unique = true)
   private String username;

   @Column(name = "password", length = 100)
   private String password;

   @Column(name = "nickname", length = 50)
   private String nickname;

   @Column(name = "activated")
   private boolean activated;

   @ManyToMany
   @JoinTable(
      name = "user_authority",
      joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "user_id")},
      inverseJoinColumns = {@JoinColumn(name = "authority_name", referencedColumnName = "authority_name")})
   private Set<Authority> authorities;
}