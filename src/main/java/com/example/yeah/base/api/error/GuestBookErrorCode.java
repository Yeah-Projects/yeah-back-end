package com.example.yeah.base.api.error;

import org.springframework.http.HttpStatus;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum GuestBookErrorCode implements ErrorCode {
	Guest_BOOK_NOT_FOUND(HttpStatus.NOT_FOUND, "방명록을 불러올 수 없습니다.");

	private final HttpStatus httpStatus;
	private final String message;
}
