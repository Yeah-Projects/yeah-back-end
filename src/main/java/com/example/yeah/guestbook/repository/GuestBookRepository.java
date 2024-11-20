package com.example.yeah.guestbook.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.yeah.guestbook.model.GuestBook;

@Repository
public interface GuestBookRepository extends JpaRepository<GuestBook, Long> {

}
