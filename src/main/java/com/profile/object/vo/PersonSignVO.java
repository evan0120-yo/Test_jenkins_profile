package com.profile.object.vo;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PersonSignVO implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	private int personSignNumber;
	
	private Integer percent;
	
	private SignVO sign;
}
