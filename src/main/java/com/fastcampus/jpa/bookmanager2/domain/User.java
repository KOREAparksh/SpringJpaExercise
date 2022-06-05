package com.fastcampus.jpa.bookmanager2.domain;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;


@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Builder
@Entity
@Table(name = "user", indexes = {@Index(columnList = "name")}, uniqueConstraints = {@UniqueConstraint(columnNames = {"email"})})
public class User {
	@Id
	@GeneratedValue
	private Long id;

	@NonNull
	private String name;

	@NonNull
	private String email;

	//중요
	@Enumerated(value = EnumType.STRING)
	private Gender gender;

	@Column(updatable = false)
	private LocalDateTime createdAt;

	private LocalDateTime updatedAt;

//	@Transient
//	private String testData;

//	@OneToMany(fetch = FetchType.EAGER)
//	private List<Address> address;
}
