package com.arcreane.web;

import lombok.Data;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Data
@Controller
public class WebMovieController/* implements IMovieController */{
    //protected IMovieService service;


    @RequestMapping("/My_DVD_Store")
    public String displayHome(){
        return "indexHome";
    }
//    @Override
//    public void AddMovie() {
//        System.out.println("Je fais rien");
//    }
}
