package com.february.edsc.domain.user;

import com.february.edsc.domain.user.like.Like;
import com.february.edsc.domain.post.Post;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;
    private String password;
    private String name;
    private String nickname;
    private String profileImage;
    private String phone;

    @OneToMany(mappedBy = "user")
    private List<Like> likes = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    private List<Post> posts = new ArrayList<>();

	public UserResponseDto toUserResponseDto() {
	    return UserResponseDto.builder()
            .email(email)
            .name(name)
            .nickname(nickname)
            .profileImage(profileImage)
            .build();
	}

    public UserDetailResponseDto toUserDetailResponseDto() {
        return UserDetailResponseDto.builder()
            .email(email)
            .name(name)
            .nickname(nickname)
            .phone(phone)
            .profileImage(profileImage)
			.postNum((long) posts.size())
            .build();
    }

	public void updateUser(UserUpdateDto userUpdateDto) {
        this.name = userUpdateDto.getName();
        this.nickname = userUpdateDto.getNickname();
        this.password = userUpdateDto.getPassword();
        this.phone = userUpdateDto.getPhone();
	}

    public void updateImage(String result) {
	    this.profileImage = result;
    }
}
