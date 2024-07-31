package com.profile.object.vo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import com.profile.model.PersonNote;
import com.profile.model.PersonTagCross;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PersonVO implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	private String personId;
	private String personName;
	private LocalDate birthDay;
	private LocalDateTime birthTime;
	private List<PersonSignVO> personSigns;
	private List<PersonNote> personNotes;
	private List<PersonTagCross> personTagCrosses;
	
	@Data
	public class PersonSignVO implements java.io.Serializable {

		private static final long serialVersionUID = 1L;

		private int personSignNumber;
		
		private Integer percent;
		
		private SignVO sign;
		
		@Data
		public class SignVO implements java.io.Serializable {

			private static final long serialVersionUID = 1L;
			
			private String signId;

			private String signName;
		}
	}
}
