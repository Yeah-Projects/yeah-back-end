package com.example.yeah.guestbook.dto;


import java.time.LocalDateTime;
import java.util.List;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class GuestBookDto {

	@Getter
	@NoArgsConstructor
	public static class GuestBookWriteRequest {
		private String content;
	}

	@Getter
	@Builder
	public static class GuestBookContent {
		private LocalDateTime createdAt;
		private String content;
	}

	@Getter
	@Builder
	public static class GuestBookListResponse {
		private List<GuestBookContent> GuestBookList;
	}
}
