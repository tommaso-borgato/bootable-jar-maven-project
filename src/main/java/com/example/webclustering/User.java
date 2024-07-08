package com.example.webclustering;

import java.io.Serializable;

public class User implements Serializable {
	private final long created;

	User(long created) {
		this.created = created;
	}
	public long getCreated() {
		return created;
	}
}