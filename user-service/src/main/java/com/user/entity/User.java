package com.user.entity;

import org.antlr.v4.runtime.misc.NotNull;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class User {
	
	@Column(name = "id")
	@Id
	private String userId;
	
	@NotNull
	@Column(name = "name", length = 20)
	private String name;
	
	@NotNull
	private String email;
	
	private String about;

}
