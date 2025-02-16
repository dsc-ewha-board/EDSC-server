package com.february.edsc.domain.category;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
@AllArgsConstructor
public class CategoryListResponseDto {
	private final int totalNum;
	private final List<CategoryPackResponseDto> parentPackList;
}