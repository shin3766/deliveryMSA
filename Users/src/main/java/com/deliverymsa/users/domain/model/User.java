package com.deliverymsa.users.domain.model;

import jakarta.persistence.Access;
import jakarta.persistence.AccessType;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.apache.hc.client5.http.auth.Credentials;
import org.hibernate.sql.Update;
import org.springframework.boot.autoconfigure.ldap.embedded.EmbeddedLdapProperties.Credential;

@Entity
@Table(name = "p_users")
@Getter
@Access(AccessType.FIELD)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User {

    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Embedded
    private UserCreadentials userCreadentials;

    private UserRole userRole;

    private boolean isDeleted;

    @Builder(access = AccessLevel.PRIVATE)
    public User(UserCreadentials userCreadentials, UserRole userRole, boolean isDeleted) {
        this.userCreadentials = userCreadentials;
        this.userRole = userRole;
        this.isDeleted = isDeleted;
    }

    // user 생성
    public static User from(CreateUserRequestDto requestDto) {

        return User.builder()
               .userCreadentials(new UserCreadentials())
               .userRole()
               .isDeleted(Boolean.FALSE)
               .build();
    }

    // user 업데이트
    public void updateUser(UpdateUserRequestDto requestDto) {
        this.userCreadentials = new UserCreadentials(requestDto.userCreadentials);
        this.userRole = requestDto.userRole;
    }

    // user 삭제
    public void deleteUser() {
        this.isDeleted = Boolean.TRUE;
    }
}
