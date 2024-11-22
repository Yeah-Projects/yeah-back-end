package com.example.yeah.guestbook.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.yeah.base.api.error.GuestBookErrorCode;
import com.example.yeah.base.api.exception.RestApiException;
import com.example.yeah.guestbook.dto.GuestBookDto;
import com.example.yeah.guestbook.model.GuestBook;
import com.example.yeah.guestbook.repository.GuestBookRepository;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class GuestBookService {
	private final GuestBookRepository guestBookRepository;
	public void write(GuestBookDto.GuestBookWriteRequest request) {
		GuestBook guestBook = GuestBook.builder()
			.content(request.getContent())
			.build();
		guestBookRepository.save(guestBook);
		return;
	}

	public GuestBookDto.GuestBookListResponse getList() {
		List<GuestBook> GuestBookList = guestBookRepository.findRecent50()
			.orElseThrow(() -> new RestApiException(GuestBookErrorCode.Guest_BOOK_NOT_FOUND));
		List<GuestBookDto.GuestBookContent> contents = GuestBookList.stream()
			.map(guestBook -> GuestBookDto.GuestBookContent.builder()
				.content(guestBook.getContent())
				.createdAt(guestBook.getCreatedAt())
				.build())
			.collect(Collectors.toList());

		GuestBookDto.GuestBookListResponse response = GuestBookDto.GuestBookListResponse.builder()
			.GuestBookList(contents)
			.build();

		return response;
	}
}
