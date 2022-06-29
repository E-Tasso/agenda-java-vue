package com.agenda.springboot.controller;

import com.agenda.springboot.controller.vo.request.ContactRequest;
import com.agenda.springboot.controller.vo.response.CreateContactResponse;
import com.agenda.springboot.controller.vo.response.GetContactResponse;
import com.agenda.springboot.entity.Contact;
import com.agenda.springboot.service.ContactService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin("http://localhost:3000/")
public class ContactController {

    private final ContactService contactService;

    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @GetMapping
    public ResponseEntity<List<GetContactResponse>> getContacts(){
        final List<GetContactResponse> getContactResponse =
                contactService.getContacts();
        return ResponseEntity.ok(getContactResponse);
    }

    @PostMapping
    public ResponseEntity<CreateContactResponse> createContact(@Valid @RequestBody ContactRequest request){
        Contact contact = contactService.createContact(request);
        CreateContactResponse createContactResponse = new CreateContactResponse();
        createContactResponse.setId(contact.getId());
        return ResponseEntity.status(HttpStatus.CREATED).body(createContactResponse);
    }

    @PutMapping(value ="/{id}")
    public ResponseEntity<GetContactResponse> updateContact(@PathVariable("id") Long id, @Valid @RequestBody ContactRequest request) {
        return ResponseEntity.status(HttpStatus.OK).body(contactService.updateContact(id, request));
    }

    @DeleteMapping(path ={"/{id}"})
    public void deleteContact(@PathVariable Long id) {
        contactService.deleteContact(id);
    }

}
