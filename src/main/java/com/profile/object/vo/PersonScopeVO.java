package com.profile.object.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PersonScopeVO implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	
	private String personScopeId;
	
	private String personScopeName;

	private Integer personScopeNumber;
	
}
