package com.springapp.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/search")
public class PhoneBookController {

    @Autowired private PhoneBookDAO PhoneBookDAO;

    /**
     * This handler method is invoked when
     * http://localhost:8080/phoneBookTask is requested.
     * The method returns view name "index"
     * which will be resolved into /WEB-INF/index.jsp.
     *  See src/main/webapp/WEB-INF/servlet-context.xml
     */
    @RequestMapping(method = RequestMethod.GET)
    public String list(Map<String, Object> model) {
        List<PhoneBook> resultList = PhoneBookDAO.findAll();
        model.put("resultList", resultList);
        SearchForm searchForm = new SearchForm();
        model.put("searchForm", searchForm);
        model.put("fieldList", getFieldList());
        return "index";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String search(@ModelAttribute("searchForm") SearchForm searchForm, Map<String, Object> model) {
        List<PhoneBook> resultList;
        if (searchForm.fieldToSearch.equals("all")) {
            resultList = PhoneBookDAO.searchPhoneBooks(searchForm.lineToSearch);
        } else {
            resultList = PhoneBookDAO.searchPhoneBooks(searchForm.lineToSearch, searchForm.fieldToSearch);
        }
        model.put("resultList", resultList);
        model.put("fieldList", getFieldList());
        return "index";
    }

    private List getFieldList() {
        List<String> fieldList = Arrays.asList("all","name","lastName","patronymicName","cellPhoneNum","officePhoneNum","homePhoneNum");
        return fieldList;
    }
}
