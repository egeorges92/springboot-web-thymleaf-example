package com.example.example.controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
class MainController {

    private DateFormat dateFormat = new SimpleDateFormat("yyy-MM-dd");
    private DateFormat dayOfWeekDateFormat = new SimpleDateFormat("EEEE");
	
	@RequestMapping(value = { "/", "/index.html", "/index.htm"}, method = RequestMethod.GET)
    public String home(Model model) {
        model.addAttribute("date", dateFormat.format(new Date()));
        return "index";
    }
	
	@RequestMapping(value = { "/day-of-week" }, method = RequestMethod.POST)
    public String dayOfWeek(Model model, @ModelAttribute("date") String date) throws ParseException {
        model.addAttribute("date", date);
        Date theDate = dateFormat.parse(date);
        model.addAttribute("dayOfWeek", dayOfWeekDateFormat.format(theDate));
        return "day_of_week";
    }
	
}
