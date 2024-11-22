package com.example.yeah.guestbook.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.yeah.base.api.ApiResponse;
import com.example.yeah.guestbook.dto.GuestBookDto;
import com.example.yeah.guestbook.service.GuestBookService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@Tag(name = "guestbook api", description = "방명록에 관한 api")
@RequiredArgsConstructor
@RestController
@RequestMapping("/guestbook")
public class GuestBookController {
	private final GuestBookService guestBookService;

	@Operation(summary = "방명록 작성", description = "방명록을 작성합니다")
	@PostMapping("/write")
	public ResponseEntity<ApiResponse<Void>> enroll(
		@RequestBody GuestBookDto.GuestBookWriteRequest request) {
		guestBookService.write(request);
		return ResponseEntity.ok()
			.body(ApiResponse.createSuccessWithNoContent());
	}

	@Operation(summary = "방명록 불러오기", description = "최신 방명록 50개를 가져옵니다")
	@GetMapping("/get")
	public ResponseEntity<ApiResponse<GuestBookDto.GuestBookListResponse>> getGuestBookList(){
		GuestBookDto.GuestBookListResponse response = guestBookService.getList();
		return ResponseEntity.ok()
			.body(ApiResponse.createSuccess(response));
	}

}
