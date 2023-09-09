package com.fullstack.security.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Assignment {
	@Id
	@GeneratedValue
	private Long id;
	private String assign_title;
	@Column(columnDefinition="TEXT",length=1500)
	private String assign_description;
	private String assign_file;

}
