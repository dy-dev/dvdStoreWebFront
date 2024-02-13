package com.arcreane.dvdstore.web.webdvd;

import com.arcreane.dvdstore.core.controller.IMovieController;
import com.arcreane.dvdstore.core.entity.Movie;
import com.arcreane.dvdstore.core.service.IMovieService;
import com.arcreane.dvdstore.core.service.web.WebMovieService;
import jakarta.validation.Valid;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Data
@Controller
public class WebMovieController implements IMovieController {
    @Autowired
    protected IMovieService service;

    @GetMapping("/My_DVD_Store")
    public String displayHome(Model model) {
        var movies = service.getAllMovies();
        model.addAttribute("DVDList", movies);
        return "indexHome";
    }

    @RequestMapping("/My_second_DVD_Store")
    public @ModelAttribute("MyDvds") List<Movie> displaySecondHome(Model model) {
        return service.getAllMovies();
    }
//
//    @GetMapping("/{MovieTitle}")
//    public ModelAndView displayInfoOnMovie(@PathVariable("MovieTitle") String p_MovieName) {
//        var movie = service.getMovieByName(p_MovieName);
//        ModelAndView mv = new ModelAndView("dvd-details");
//        mv.addObject("dvd", movie);
//        return mv;
//    }

    @GetMapping("/add-dvd")
    public String displayForm(@ModelAttribute MovieForm dvdToCreate) {
        return "dvd-create";
    }

    @PostMapping("dvd-creation")
    public String createNewDVDEntry(@Valid @ModelAttribute MovieForm dvdToCreate, BindingResult result) {
        if(result.hasErrors())
            return "dvd-create";
        service.registerMovie(dvdToCreate.convertToMovie());
        return "dvd-info-creation";
    }

    @Override
    public void AddMovie() {
    }
}
