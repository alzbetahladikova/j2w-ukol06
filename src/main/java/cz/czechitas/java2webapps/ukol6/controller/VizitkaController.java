package cz.czechitas.java2webapps.ukol6.controller;

import cz.czechitas.java2webapps.ukol6.entity.Vizitka;
import cz.czechitas.java2webapps.ukol6.repository.VizitkaRepository;
import cz.czechitas.java2webapps.ukol6.service.VizitkaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class VizitkaController {
    private final VizitkaRepository vizitkaRepository;


    @Autowired
    public VizitkaController (VizitkaRepository vizitkaRepository){
        this.vizitkaRepository = vizitkaRepository;
    }
    @InitBinder
    public void nullStringBinding(WebDataBinder binder) {
        binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
    }

    @GetMapping("/")
    public ModelAndView seznam() {
        return new ModelAndView("seznam")
                .addObject("vizitka", vizitkaRepository.findAll());
    }
/*
    @GetMapping("/{id}")
    public ModelAndView vizitka(@PathVariable int id) {
        return new ModelAndView("vizitka")
                .addObject("vizitka", vizitkaRepository.findById(id).get());
    }

 */
/*
    @PostMapping("/{id}")
    public String ulozit(@ModelAttribute("formular") @Valid Vizitka vizitka, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "formular";
        }
        vizitkaRepository.save(vizitka);
        return "redirect:/";}


 */
}

