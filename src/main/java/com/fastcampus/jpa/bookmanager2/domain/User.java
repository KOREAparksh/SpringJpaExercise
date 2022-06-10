package com.fastcampus.jpa.bookmanager2.domain;

import com.fastcampus.jpa.bookmanager2.domain.listener.Auditable;
import com.fastcampus.jpa.bookmanager2.domain.listener.UserEntityListener;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Builder
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Entity
@EntityListeners(value = {AuditingEntityListener.class, UserEntityListener.class})
//@Table(name = "user", indexes = {@Index(columnList = "name")}, uniqueConstraints = {@UniqueConstraint(columnNames = {"email"})})
public class User extends BaseEntity implements Auditable {
	@Id
	@GeneratedValue
	private Long id;

	@NonNull
	private String name;

	@NonNull
	private String email;

	//	//중요
	@Enumerated(value = EnumType.STRING)
	private Gender gender;

//	@Column(updatable = false)
//	@CreatedDate
//	private LocalDateTime createdAt;
//
//	@LastModifiedDate
//	private LocalDateTime updatedAt;

//	@Transient
//	private String testData;

//	@OneToMany(fetch = FetchType.EAGER)
//	private List<Address> address;

//	@PrePersist
//	public void prePersist() {
//		this.createdAt = LocalDateTime.now();
//		this.updatedAt = LocalDateTime.now();
//	}
//
//
//	@PreUpdate
//	public void preUpdate() {
//		this.updatedAt = LocalDateTime.now();
//	}
}
