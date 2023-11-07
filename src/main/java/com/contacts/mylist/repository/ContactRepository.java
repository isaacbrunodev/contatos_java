package com.contacts.mylist.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.contacts.mylist.entity.Contact;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Long> {

	List<Contact> findAllByFirstNameContainsIgnoreCase(String firstName);
	List<Contact> findAllByLastNameContainsIgnoreCase(String lastName);
    List<Contact> findAllByEmailContainsIgnoreCase(String email);
    Contact findByPhoneNumber(String phone);

}
