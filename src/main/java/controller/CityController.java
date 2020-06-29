package controller;

import model.City;
import model.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import service.ICityService;
import service.ICountryService;

import javax.validation.Valid;

@Controller
public class CityController {
    @Autowired
    private ICityService iCityService;
    @Autowired
    private ICountryService iCountryService;

    @ModelAttribute("countries")
    public Iterable<Country> countries() {
        return iCountryService.findAll();
    }

    @GetMapping("/")
    public ModelAndView listCity() {
        Iterable<City> cities = iCityService.findAll();
        ModelAndView modelAndView = new ModelAndView("city/list");
        modelAndView.addObject("cities", cities);
        return modelAndView;
    }

    @GetMapping("/view/{id}")
    public ModelAndView viewCity(@PathVariable Long id) {
        City cities = iCityService.findById(id);
        if (cities != null) {
            ModelAndView modelAndView = new ModelAndView("city/view");
            modelAndView.addObject("cities", cities);
            return modelAndView;
        } else {
            ModelAndView modelAndView = new ModelAndView("error");
            return modelAndView;
        }
    }

    @GetMapping("/create")
    public ModelAndView createCityform() {
        ModelAndView modelAndView = new ModelAndView("city/create");
        modelAndView.addObject("cities", new City());
        return modelAndView;
    }

    @PostMapping("/create")
    public ModelAndView createCity(@Valid @ModelAttribute("cities") City cities, BindingResult bindingResult) {
        if (bindingResult.hasFieldErrors()) {
            ModelAndView modelAndView = new ModelAndView("city/create");
            return modelAndView;
        } else {
            iCityService.save(cities);
            ModelAndView modelAndView = new ModelAndView("city/create");
            modelAndView.addObject("cities", new City());
            return modelAndView;
        }

    }

    @GetMapping("/edit/{id}")
    public ModelAndView editCity(@PathVariable Long id) {
        City cities = iCityService.findById(id);
        if (cities != null) {
            ModelAndView modelAndView = new ModelAndView("city/edit");
            modelAndView.addObject("cities", cities);
            return modelAndView;
        } else {
            ModelAndView modelAndView = new ModelAndView("error");
            return modelAndView;
        }
    }

    @GetMapping("/delete/{id}")
    public ModelAndView deleteCity(@PathVariable Long id) {
        City cities = iCityService.findById(id);
        if (cities != null) {
            ModelAndView modelAndView = new ModelAndView("city/delete");
            modelAndView.addObject("cities", cities);
            return modelAndView;
        } else {
            ModelAndView modelAndView = new ModelAndView("error");
            return modelAndView;
        }
    }

    @PostMapping("/edit")
    public ModelAndView edit(@Valid @ModelAttribute("cities") City cities, BindingResult bindingResult) {
        iCityService.save(cities);
        if (bindingResult.hasFieldErrors()) {
            ModelAndView modelAndView = new ModelAndView("city/edit");
            return modelAndView;
        } else {
            ModelAndView modelAndView = new ModelAndView("redirect:/");
            modelAndView.addObject("message", "Cập nhật thành công");
            modelAndView.addObject("cities", cities);
            return modelAndView;
        }
    }

    @PostMapping("/delete")
    public ModelAndView delete(@ModelAttribute("cities") City cities) {
        iCityService.remove(cities.getId());
        ModelAndView modelAndView = new ModelAndView("redirect:/");
        modelAndView.addObject("cities", cities);
        return modelAndView;
    }
}
