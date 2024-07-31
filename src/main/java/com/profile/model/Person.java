package com.profile.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Person implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	private String personId;
	
	private String personName;
	
	private LocalDate birthDay;
	private LocalDateTime birthTime;
	
}
