package com.fastcampus.jpa.bookmanager2.domain;

import com.fastcampus.jpa.bookmanager2.domain.listener.Auditable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@NoArgsConstructor
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
//@EntityListeners(value = AuditingEntityListener.class)
public class Book extends BaseEntity implements Auditable {
	@Id
	@GeneratedValue
	private Long id;

	private String name;
	private String author;
//	private LocalDateTime createdAt;
//	private LocalDateTime updatedAt;

//	@PrePersist
//	public void prePersist() {
//		this.createAt = LocalDateTime.now();
//		this.updateAt = LocalDateTime.now();
//	}
//
//	@PreUpdate
//	public void preUpdate() {
//		this.updateAt = LocalDateTime.now();
//	}
}
