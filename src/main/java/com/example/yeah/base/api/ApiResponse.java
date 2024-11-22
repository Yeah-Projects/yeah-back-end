package com.example.yeah.base.api;

import com.example.yeah.base.api.error.ErrorCode;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ApiResponse<T> {

	private static final boolean SUCCESS_STATUS = true;

	private static final boolean FAIL_STATUS = false;

	private static final String SUCCESS_MESSAGE = "API 호출 성공";

	private boolean isSuccess;

	private String message;

	private T data;

	public static <T> ApiResponse<T> createSuccess(T data) {
		return new ApiResponse<>(SUCCESS_STATUS, SUCCESS_MESSAGE, data);
	}

	public static ApiResponse createSuccessWithNoContent() {
		return new ApiResponse<>(SUCCESS_STATUS, SUCCESS_MESSAGE, null);
	}
 	//예외 처리때 배울 예정
	public static ApiResponse<?> createFail(ErrorCode errorCode) {
		return new ApiResponse<>(FAIL_STATUS, errorCode.getMessage(), null);
	}

	public static ApiResponse<?> createFail(String message) {
		return new ApiResponse<>(FAIL_STATUS, message, null);
	}

}