package com.contacts.mylist.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ContactDTO {

	private Long id;
	private String firstName;
	private String lastName;
	private String address;
	private String email;
	private String phoneNumber;
}
