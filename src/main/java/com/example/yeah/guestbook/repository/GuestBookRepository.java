package com.example.yeah.guestbook.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.yeah.guestbook.model.GuestBook;

@Repository
public interface GuestBookRepository extends JpaRepository<GuestBook, Long> {
	@Query(value = "SELECT * FROM guest_book ORDER BY created_at DESC LIMIT 50 OFFSET 0;", nativeQuery = true)
	Optional<List<GuestBook>> findRecent50();
}
