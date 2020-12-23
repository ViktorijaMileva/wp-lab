package mk.finki.ukim.mk.web.controller;

import mk.finki.ukim.mk.model.Balloon;
import mk.finki.ukim.mk.model.Country;
import mk.finki.ukim.mk.model.Manufacturer;
import mk.finki.ukim.mk.service.BalloonService;
import mk.finki.ukim.mk.service.CountryService;
import mk.finki.ukim.mk.service.ManufacturerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/balloons")
public class BalloonController {

    private final BalloonService balloonService;
    private final ManufacturerService manufacturerService;
    private final CountryService countryService;

    public BalloonController(BalloonService balloonService, ManufacturerService manufacturerService, CountryService countryService) {
        this.balloonService = balloonService;
        this.manufacturerService = manufacturerService;
        this.countryService = countryService;
    }

    @GetMapping("")
    public String getBalloonPage(@RequestParam(required = false) String error, Model model){
        if (error != null && !error.isEmpty()){
            model.addAttribute("error", error);
        }
        List<Balloon> balloonList = this.balloonService.listAll();
        model.addAttribute("balloonList", balloonList);
        return "listBalloons";
    }

    @PostMapping("/add")
    public String saveBalloon(@RequestParam String name,
                              @RequestParam String description,
                              @RequestParam Long manufacturer,
                              @RequestParam Long country){
        this.balloonService.save(name, description, manufacturer, country);
        return "redirect:/balloons/";
    }

    @DeleteMapping("/delete/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String deleteBalloon(@PathVariable Long id){
        this.balloonService.delete(id);
        return "redirect:/balloons/";
    }

    @GetMapping("/edit-form/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String getEditBalloonPage(@PathVariable Long id, Model model){
        if (this.balloonService.findById(id).isPresent()){
            Balloon balloon = this.balloonService.findById(id).get();
            List<Manufacturer> manufacturerList = this.manufacturerService.findAll();
            List<Country> countryList = this.countryService.findAll();
            model.addAttribute("manufacturerList", manufacturerList);
            model.addAttribute("countryList", countryList);
            model.addAttribute("balloon", balloon);
            return "add-balloons";
        }
        return "redirect:/balloons/";

    }

    @GetMapping("/add-form")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String getAddBalloonPage(Model model){
        List<Manufacturer> manufacturerList = this.manufacturerService.findAll();
        model.addAttribute(manufacturerList);
        List<Country> countryList = this.countryService.findAll();
        model.addAttribute(countryList);
        return "add-balloons";
    }

    @PostMapping("/sort")
    public String sortBalloon(@RequestParam String country, Model model){
        List<Balloon> sortedBalloons = this.balloonService.listAll().stream().filter(r->r.getCountry().getName().equals(country)).collect(Collectors.toList());
        model.addAttribute(sortedBalloons);
        return "listBalloons";
    }


}
