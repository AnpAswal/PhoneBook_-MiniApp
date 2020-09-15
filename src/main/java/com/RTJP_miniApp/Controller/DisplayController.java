package com.RTJP_miniApp.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.RTJP_miniApp.POJO.Contact;
import com.RTJP_miniApp.Service.CntctService;

@Controller
public class DisplayController {

	@Autowired
	CntctService cs;

	@RequestMapping(value = { "/", "/loadform" }, method = RequestMethod.GET)
	public String loadpage(Model model) {
		Contact c = new Contact();
		model.addAttribute("formdata", c);
		return "Index";
	}

	@RequestMapping(value = "/savecontact", method = RequestMethod.POST)
	public String submitBtnHandler(@ModelAttribute("formdata") Contact contact, RedirectAttributes attr) {
		boolean saveContact = cs.saveContact(contact);
		if (contact.getCid() == null) {
			if (saveContact) {
				attr.addFlashAttribute("msg", "Contact saved");
			} else {
				attr.addFlashAttribute("errmsg", "OPPs.....Something went wrong!!!!");
			}

		} else {
			attr.addFlashAttribute("editmsg", "Contact updated succesfully");
		}
		return "redirect:loadform";
	}

	@RequestMapping(value = "/display", method = RequestMethod.GET)
	public String hyperlinkHandler(Model model) {
		Iterable<Contact> contacts = cs.displayAllcontacts();// geting all contacts from service
		model.addAttribute("contacts", contacts);// adding fetched contacts to view using model
		return "info";// render info page

	}

}
