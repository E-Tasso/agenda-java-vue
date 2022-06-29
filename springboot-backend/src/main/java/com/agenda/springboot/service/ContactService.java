package com.agenda.springboot.service;

import com.agenda.springboot.controller.vo.request.ContactRequest;
import com.agenda.springboot.controller.vo.response.GetContactResponse;
import com.agenda.springboot.entity.Contact;
import com.agenda.springboot.mapper.ContactMapper;
import com.agenda.springboot.repository.ContactRepository;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service
public class ContactService {

    private final ContactRepository contactRepository;

    private final ContactMapper contactMapper;

    public ContactService(ContactRepository contactRepository, ContactMapper contactMapper) {
        this.contactRepository = contactRepository;
        this.contactMapper = contactMapper;
    }


    public List<GetContactResponse> getContacts(){
        List<Contact> contactList = contactRepository.findAll();
        List<GetContactResponse> getContactResponseList = new ArrayList<>();
        contactList.forEach(contact -> getContactResponseList.add(contactMapper.contactToGetContactResponse(contact)));
        return getContactResponseList;
    }

    public Contact createContact(ContactRequest request){
        Contact contact = new Contact();
        contact.setName(request.getName());
        contact.setEmail(request.getEmail());
        contact.setPhone(request.getPhone());
        return contactRepository.save(contact);
    }

    public GetContactResponse updateContact(Long id, ContactRequest request) {
        return contactMapper.contactToGetContactResponse(contactRepository.findById(id).map(record -> {
            record.setName(request.getName());
            record.setEmail(request.getEmail());
            record.setPhone(request.getPhone());
            return contactRepository.save(record);}).orElse(null));
    }

    public void deleteContact(Long id){
        try{
            contactRepository.deleteById(id);
        }catch(Exception e){
            throw new NotFoundException("No such id");
        }
    }

}
