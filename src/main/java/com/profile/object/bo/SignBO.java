package com.profile.object.bo;

import java.time.LocalDate;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SignBO implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	
	// 星座
	private String signId;
	
	private String signName;
	
	private LocalDate startDate;
	
	private LocalDate endDate;
	
	private LocalDate middleDate;
	
	private Integer serialNumber;
	
	private String elementId;
}
