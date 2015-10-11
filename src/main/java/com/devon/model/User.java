package com.devon.model;

import org.springframework.data.annotation.Id;

public class User {

	@Id
	private String id;
	private String thumbnail;
	private String smallImage;
	private String name;
	private String type;

	public User() {
	}

	public User(String id, String type) {
		this.id = id;
		this.type = type;
	}

	public String getSmallImage() {
		return smallImage;
	}

	public void setSmallImage(String smallImage) {
		this.smallImage = smallImage;
	}

	public String getThumbnail() {
		return thumbnail;
	}

	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}
