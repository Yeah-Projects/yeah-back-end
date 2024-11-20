package com.example.yeah.guestbook.dto;


import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class GuestBookDto {

	@Getter
	@NoArgsConstructor
	public static class GuestBookWriteRequest {

	}

	@Getter
	@Builder
	public static class GuestBookWriteResponse {

	}

	@Getter
	@Builder
	public static class GuestBookListResponse {

	}
}
