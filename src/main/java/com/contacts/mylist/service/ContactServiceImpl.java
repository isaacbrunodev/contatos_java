package com.contacts.mylist.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.contacts.mylist.dto.ContactDTO;
import com.contacts.mylist.entity.Contact;
import com.contacts.mylist.repository.ContactRepository;

@Service
public class ContactServiceImpl implements ContactService {

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private ContactRepository contactRepository;

    @Override
    public List<ContactDTO> findAllContacts() {

        var contactList = contactRepository.findAll();
        List<ContactDTO> contactListDTO = new ArrayList<>();

        contactList.forEach(contact -> contactListDTO.add(mapper.map(contact, ContactDTO.class)));

        return contactListDTO;
    }

    @Override
    public ContactDTO addContact(ContactDTO contactDTO) {
        Contact contact = mapper.map(contactDTO, Contact.class);

        contactRepository.save(contact);

        return mapper.map(contact, ContactDTO.class);
    }

    @Override
    public ContactDTO findContactById(long id) {
        var contact = contactRepository.findById(id);

        return mapper.map(contact, ContactDTO.class);
    }

    @Override
    public List<ContactDTO> findAllContactsByFirstName(String firstName) {
        List<Contact> contactList = contactRepository.findAllByFirstNameContainsIgnoreCase(firstName);
        List<ContactDTO> contactListDTO = new ArrayList<>();

        contactList.forEach(contact -> contactListDTO.add(mapper.map(contact, ContactDTO.class)));
        return contactListDTO;
    }

    @Override
    public List<ContactDTO> findAllContactsByLastName(String lastName) {
        List<Contact> contactList = contactRepository.findAllByLastNameContainsIgnoreCase(lastName);
        List<ContactDTO> contactListDTO = new ArrayList<>();

        contactList.forEach(contact -> contactListDTO.add(mapper.map(contact, ContactDTO.class)));
        return contactListDTO;
    }

    @Override
    public void deleteUserById(long id) {
        var contact = contactRepository.findById(id);

        if (contact.isPresent()) {
            contactRepository.delete(contact.get());
        }
    }

    @Override
    public ContactDTO updateContact(ContactDTO contactDTO) {
        long id = contactDTO.getId();
        var oldContact = contactRepository.findById(id);

        if (!oldContact.isPresent()) {
            return null;
        }

        Contact newContact = new Contact();
        newContact = mapper.map(contactDTO, Contact.class);
        contactRepository.save(newContact);

        return mapper.map(newContact, ContactDTO.class);
    }

    @Override
    public List<ContactDTO> findAllByEmail(String email) {
        List<Contact> contactList = contactRepository.findAllByEmailContainsIgnoreCase(email);
        List<ContactDTO> contactListDTO = new ArrayList<>();

        contactList.forEach(contact -> contactListDTO.add(mapper.map(contact, ContactDTO.class)));
        return contactListDTO;
    }

    @Override
    public ContactDTO findByPhoneNumber(String phone) {
        Contact contact = contactRepository.findByPhoneNumber(phone);
        
        return mapper.map(contact, ContactDTO.class);
    }
}
