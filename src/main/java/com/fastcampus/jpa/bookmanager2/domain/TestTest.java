package com.fastcampus.jpa.bookmanager2.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@EntityListeners(value = AuditingEntityListener.class)
public class TestTest extends BaseEntity {
	@Id
	@GeneratedValue
	private Long id;

	private String name;
	private String nickName;
}
