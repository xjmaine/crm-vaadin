package com.example.application.services;

import com.example.application.data.Company;
import com.example.application.data.Contact;
import com.example.application.data.Status;
import com.example.application.repositories.CompanyRepository;
import com.example.application.repositories.ContactRepository;
import com.example.application.repositories.StatusRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CrmService {
    private final ContactRepository contactRepository;
    private final CompanyRepository companyRepository;
    private final StatusRepository statusRepository;

    public CrmService(ContactRepository contactRepository, CompanyRepository companyRepository, StatusRepository statusRepository) {
        this.contactRepository = contactRepository;
        this.companyRepository = companyRepository;
        this.statusRepository = statusRepository;
    }

    //public APIs
    //filter text
    public List<Contact> findAllContacts(String filterText){
        if(filterText == null || filterText.isEmpty()){
            return contactRepository.findAll();
        } else{
            return contactRepository.search(filterText);
        }
    }

    public Long countContacts(){
        return contactRepository.count();
    }

    //delete contact
    public void deleteContact(Contact contact){
        contactRepository.delete(contact);
    }

    //create conntact
    public void saveContact(Contact contact){
        if(contact == null){
            System.err.println("Contact is null!");
            return;
        }
        contactRepository.save(contact);
    }

    //find companes
    public List<Company> findAllCompanies(){
        return companyRepository.findAll();
    }

    public List<Status> findAllStatuses(){
        return statusRepository.findAll();
    }
}
