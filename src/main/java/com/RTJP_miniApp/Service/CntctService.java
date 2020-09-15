package com.RTJP_miniApp.Service;


import org.springframework.stereotype.Service;
import com.RTJP_miniApp.POJO.Contact;

@Service
public interface CntctService {

//for 1st screen
	public boolean saveContact(Contact contact);
	public Iterable<Contact> displayAllcontacts();
//for 2nd screen
	public Contact getContactbyid(Integer cid);
	public boolean ispresentContact(Integer cid);
	public void deleteContactbyid(Integer cid);
	
	
	

}
