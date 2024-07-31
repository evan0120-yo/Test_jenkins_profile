package com.profile.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface PersonNoteMapper {
	void save(@Param("personNoteId") String personNoteId, @Param("personId") String personId, @Param("content") String content);
	void delete(@Param("personNoteId") String personNoteId);
}
