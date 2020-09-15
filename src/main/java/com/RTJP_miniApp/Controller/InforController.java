package com.RTJP_miniApp.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.RTJP_miniApp.POJO.Contact;
import com.RTJP_miniApp.Service.CntctService;

@Controller
public class InforController {

	@Autowired
	CntctService cs;
	
	@RequestMapping(value = "/addcontact", method = RequestMethod.GET)
	//map method to url present in info.jsp or directly go from info page to index page
	public String addContact(Model model) {
		Contact c=new Contact();
		model.addAttribute("formdata", c);
		return "Index";

	}

	@RequestMapping(value = "/edit", method = RequestMethod.GET) // when edit is clicked this method will take action
	public String getContactbyId(@RequestParam("id") Integer cid, Model model) {
		// bind id(key) from form to cid 
		//@ModelAttribute("id") shows error why??? because it is not binded
		Contact contact = cs.getContactbyid(cid);// fecth data in form of contact object
		model.addAttribute("formdata",contact);
		// send the contact object to form key same as what was used to store empy object
		//to display content in editable mode using model attribute (2 way binding)
		return "Index";// (return to homepage with model object having data)
	}

	@RequestMapping(value = "/del", method = RequestMethod.GET)
	public String deleteContact(@RequestParam("id") Integer cid, RedirectAttributes attr) {
		 
		 if (cs.ispresentContact(cid))
		 {
		 cs.deleteContactbyid(cid);
		 attr.addFlashAttribute("msg", "Contact deleted");
		 }
		 
		return "redirect:display";

	}

}
