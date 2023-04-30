package com.kusitms.samsion.common.security.oauth;

import java.util.Map;

import com.kusitms.samsion.domain.user.entity.User;

import lombok.Builder;
import lombok.Getter;

/**
 * TODO : kakao, naver 로그인 추가하기
 */
@Getter
public class OAuth2Attributes {
	private Map<String, Object> attributes;
	private String nameAttributeKey;
	private String name;
	private String email;
	private String imageUrl;

	@Builder
	public OAuth2Attributes(Map<String, Object> attributes, String nameAttributeKey, String name, String email,
		String imageUrl) {
		this.attributes = attributes;
		this.nameAttributeKey = nameAttributeKey;
		this.name = name;
		this.email = email;
		this.imageUrl = imageUrl;
	}

	public OAuth2Attributes() {
	}

	public static OAuth2Attributes of(String registrationId, String userNameAttributeName, Map<String, Object> attributes) {
		return ofGoogle(userNameAttributeName, attributes);
	}

	private static OAuth2Attributes ofGoogle(String userNameAttributeName, Map<String, Object> attributes) {
		return OAuth2Attributes.builder()
			.attributes(attributes)
			.nameAttributeKey(userNameAttributeName)
			.name((String) attributes.get("name"))
			.email((String) attributes.get("email"))
			.imageUrl((String) attributes.get("picture"))
			.build();
	}

	public User toEntity() {
		return User.builder()
			.nickname(name)
			.email(email)
			.imageUrl(imageUrl)
			.build();
	}
}
