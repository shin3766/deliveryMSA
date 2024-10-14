package com.deliverymsa.users.domain.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Embedded;
import java.util.Objects;

@Embeddable
public class UserCreadentials {

    @Column(name = "username", nullable = false, unique = true)
    private String username;

    @Column(name = "password", nullable = false)
    private String password;

    public UserCreadentials(String username, String password) {

        if (username.isBlank() ||
                username.trim().isEmpty() ||
                !username.matches("[a-z0-9]{4,10}")) {

            throw new IllegalArgumentException("UserException: 유저이름관련 에러. 정의한 후에 지울것");
        } else if (password.isBlank() ||
                        password.trim().isEmpty() ||
                        !password.matches("[A-Za-z0-9@$!%*?&]{8,15}$")) {

            throw new IllegalArgumentException("UserException: 비밀번호관련 에러. 정의한 후에 지울것");
        }

        this.username = username;
        this.password = password;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        UserCreadentials that = (UserCreadentials) o;
        return Objects.equals(username, that.username) && Objects.equals(password,
                that.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, password);
    }
}
