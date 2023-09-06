package com.demis.sample.controller;

import com.demis.sample.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/book")
@RequiredArgsConstructor
public class ItemController {
    private final ItemService service;

    @RequestMapping
    public ModelAndView viewBooks(ModelAndView model) {
        model.setViewName("countriesList");
        model.addObject("items", service.getItems());
        return model;
    }
}
