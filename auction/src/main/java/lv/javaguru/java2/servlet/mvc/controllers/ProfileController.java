package lv.javaguru.java2.servlet.mvc.controllers;

import lv.javaguru.java2.services.FileUploader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Vladislav on 3/21/2015.
 */
@Controller
public class ProfileController {

    @Autowired
    FileUploader uploader;

    @RequestMapping(value = "/prot/profile", method = {RequestMethod.GET})
    public ModelAndView processGetRequest(HttpServletRequest request, HttpServletResponse response) {


        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("profile");
        modelAndView.addObject("model", null);



        return modelAndView;
    }

    @RequestMapping(value = "profile", method = {RequestMethod.POST})
    public ModelAndView processPutRequest(HttpServletRequest request, HttpServletResponse response){

        uploader.uploadAvatar(request);


        return new ModelAndView("profile", "model", null);
    }
}
