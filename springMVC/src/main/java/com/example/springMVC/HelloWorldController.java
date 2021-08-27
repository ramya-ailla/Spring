package com.example.springMVC;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/hello")
public class HelloWorldController {

    //need a controller method to show the form
    @RequestMapping("/showForm")
    public String showForm(){
        return "helloworld-form";
    }
    //need a controller method to process the form
    @RequestMapping("/processForm")
    public String processForm(){
        return "helloworld";
    }

    //need a controller method to read form data and add it to the model
    @RequestMapping("/processFormVersionTwo")
    public String letsShoutDude(HttpServletRequest request, Model model){
        //read the request parameter from the HTML form
        String theName = request.getParameter("studentName");
        //convert the data to all upperCase
        theName = theName.toUpperCase();
        //Create the message
        String result = "Yoo! "+theName;
        //add message to the model
        model.addAttribute("message",result);
        return "helloworld";
    }
    @RequestMapping("/processFormVersionThree")
    public String processFormVersionThree(@RequestParam("studentName") String theName, Model model){
        //convert the data to all upperCase
        theName = theName.toUpperCase();
        //Create the message
        String result = "Hello "+theName;
        //add message to the model
        model.addAttribute("message",result);
        return "helloworld";
    }

}
