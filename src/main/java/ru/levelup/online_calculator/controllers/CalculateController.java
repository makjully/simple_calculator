package ru.levelup.online_calculator.controllers;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.thymeleaf.exceptions.TemplateInputException;
import ru.levelup.online_calculator.services.CalcOperation;

import javax.validation.constraints.Digits;
import javax.validation.executable.ValidateOnExecution;

@Controller
@AllArgsConstructor
@RequestMapping("/calc")
public class CalculateController {

    private final CalcOperation service;

    @RequestMapping("/")
    public String start() {
        return "startPage";
    }

    @RequestMapping("sum")
    public String sumInput() {
        return "sum";
    }

    @RequestMapping("sum/result")
    public String sumResult(@RequestParam("a") double a, @RequestParam("b") double b,
                            Model model) {
        model.addAttribute("result", service.sum(a, b));
        return "sum";
    }

    @RequestMapping("subtr")
    public String subtrInput() {
        return "subtraction";
    }

    @RequestMapping("subtr/result")
    public String subtrInput(@RequestParam("a") double a, @RequestParam("b") double b,
                             Model model) {
        model.addAttribute("result", service.subtr(a, b));
        return "subtraction";
    }

    @RequestMapping("multipl")
    public String multipl() {
        return "multiplication";
    }

    @RequestMapping("multipl/result")
    public String multipl(@RequestParam("a") double a, @RequestParam("b") double b,
                          Model model) {
        model.addAttribute("result", service.multipl(a, b));
        return "multiplication";
    }

    @RequestMapping("division")
    public String div() {
        return "division";
    }

    @RequestMapping("division/result")
    public String div(@RequestParam("a") double a, @RequestParam("b") double b,
                      Model model) {
        try {
            model.addAttribute("result", service.div(a, b));
        } catch (TemplateInputException e) {
            e.printStackTrace();
        }
        return "division";
    }
}