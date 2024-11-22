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

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/guestbook")
public class GuestBookController {
	private final GuestBookService guestBookService;
	@PostMapping("/write")
	public ResponseEntity<ApiResponse<Void>> enroll(
		@RequestBody GuestBookDto.GuestBookWriteRequest request) {
		guestBookService.write(request);
		return ResponseEntity.ok()
			.body(ApiResponse.createSuccessWithNoContent());
	}

	@GetMapping("/get")
	public ResponseEntity<ApiResponse<GuestBookDto.GuestBookListResponse>> getGuestBookList(){
		GuestBookDto.GuestBookListResponse response = guestBookService.getList();
		return ResponseEntity.ok()
			.body(ApiResponse.createSuccess(response));
	}

}
