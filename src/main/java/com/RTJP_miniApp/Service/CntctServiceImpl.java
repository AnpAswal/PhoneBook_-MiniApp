package com.RTJP_miniApp.Service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.RTJP_miniApp.Entity.CntctEntity;
import com.RTJP_miniApp.POJO.Contact;
import com.RTJP_miniApp.Repositry.ContactRepo;
import com.RTJP_miniApp.Service.CntctService;

@Service
public class CntctServiceImpl implements CntctService {

	@Autowired
	ContactRepo repo;

	public boolean saveContact(Contact contact) {
		// creating entity object to store contact data
		CntctEntity entity = new CntctEntity();
		// copy contact on entity
		BeanUtils.copyProperties(contact, entity);
		// push entity to DB,function returns entity again with filled unique Cid
		CntctEntity svdentity = repo.save(entity);
		// check for true or false
		return svdentity.getCid() != null;
	}

	@Override
	public Iterable<Contact> displayAllcontacts() {
		// creating contacts list to send tocontroller
		List<Contact> contacts = new ArrayList<Contact>();
		// fetch all contacts fromDB
		Iterable<CntctEntity> all = repo.findAll();
		// coping every entry to contactlist
		for (CntctEntity element : all) {
			Contact c = new Contact();
			BeanUtils.copyProperties(element, c);
			contacts.add(c);
		}
		return contacts;
		// return list of contacts
	}

	@Override
	public Contact getContactbyid(Integer cid) {

		Optional<CntctEntity> optional = repo.findById(cid);// fetching data fromDB using cid sent by controller
		Contact c = new Contact();// to store data fetched from DB to POJO and send to controller
		if (optional.isPresent())// null check
		{
			CntctEntity entity = optional.get();// get optional data as entity
			BeanUtils.copyProperties(entity, c);// copy entity to pojo
			return c;
		}

		return null;//else return null
	}

	@Override
	public void deleteContactbyid(Integer cid) {
		repo.deleteById(cid);

	}

	@Override
	public boolean ispresentContact(Integer cid) {
	     boolean ispresent = repo.existsById(cid);
		return ispresent;
	}

}
