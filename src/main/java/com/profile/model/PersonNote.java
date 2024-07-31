package com.profile.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PersonNote implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	private String personNoteId;
	
	private String personId;
	
	private String content;
}
