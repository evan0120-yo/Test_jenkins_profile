package com.profile.mapper;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.profile.object.vo.PersonScopeVO;
import com.profile.object.vo.PersonSignVO;
import com.profile.object.vo.PersonVO;
import com.profile.object.vo.SignVO;

@Mapper
public interface PersonMapper {
	
	void save(@Param("personId") String personId, @Param("personName") String personName);
	void update(@Param("personId") String personId, @Param("personName") String personName, @Param("birthDay") LocalDate birthDay, @Param("birthTime") LocalDateTime birthTime);
	void delete(@Param("personId") String personId);
	List<PersonVO> findAll(@Param("personName") String personName);
	Optional<PersonVO> findById(@Param("personId") String personId);
	List<PersonSignVO> findPersonSignByPersonId(String personId);
	List<SignVO> findSignById(String signId);
	PersonScopeVO findPersonScopeByPersonScopeNumber(Integer personScopeNumber);
}
