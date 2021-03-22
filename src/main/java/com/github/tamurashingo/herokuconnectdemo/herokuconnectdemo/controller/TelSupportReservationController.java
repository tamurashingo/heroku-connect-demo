package com.github.tamurashingo.herokuconnectdemo.herokuconnectdemo.controller;

import com.github.tamurashingo.herokuconnectdemo.herokuconnectdemo.controller.request.TelSupportReservationForm;
import com.github.tamurashingo.herokuconnectdemo.herokuconnectdemo.service.TelSupportReservationService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/tel_support")
@Controller
public class TelSupportReservationController {

    private final TelSupportReservationService service;

    public TelSupportReservationController(TelSupportReservationService service) {
        this.service = service;
    }

    @GetMapping("/")
    public String getAllReservations(Model model) throws Exception {
        model.addAttribute("reservations", service.findAll());
        return "tel_support/index";
    }

    @GetMapping("/add")
    public String addReservation(@ModelAttribute TelSupportReservationForm form) {
        return "tel_support/form";
    }

    @PostMapping("/process")
    public String process(@Validated @ModelAttribute TelSupportReservationForm form, BindingResult result, Model model) throws Exception {
        if (result.hasErrors()) {
            return "tel_support/form";
        }
        try {
            service.createReservation(form);
        } catch (TelSupportReservationService.TelSupportReservationException ex) {
            model.addAttribute("error_message", ex.getMessage());
            return "tel_support/form";
        }

        return "redirect:/tel_support/";
    }

}
