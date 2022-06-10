package com.fastcampus.jpa.bookmanager2.domain.listener;

import java.time.LocalDateTime;

public interface Auditable {

	LocalDateTime getCreatedAt();

	void setCreatedAt(LocalDateTime createAt);

	LocalDateTime getUpdatedAt();

	void setUpdatedAt(LocalDateTime updateAt);
}
