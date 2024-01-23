package com.eshop.mapper;

import com.eshop.dto.UserDto;
import com.eshop.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper(componentModel = "spring")
public interface UserMapper {
	@Mapping(target = "id")
	@Mapping(target = "username")
	@Mapping(target = "firstname")
	@Mapping(target = "email")
	@Mapping(target = "address")
	UserDto toDto(User entity);

	@Mapping(target = "id")
	@Mapping(target = "username")
	@Mapping(target = "firstname")
	@Mapping(target = "email")
	@Mapping(target = "address")
	User fromDto(UserDto dto);

	@Mapping(target = "id")
	@Mapping(target = "username")
	@Mapping(target = "firstname")
	@Mapping(target = "email")
	@Mapping(target = "address")
	List<UserDto> toDto(List<User> entity);

	@Mapping(target = "id")
	@Mapping(target = "username")
	@Mapping(target = "firstname")
	@Mapping(target = "email")
	@Mapping(target = "address")
	List<User> fromDto(List<UserDto> dto);
}
