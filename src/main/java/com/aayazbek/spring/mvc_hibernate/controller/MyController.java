package com.aayazbek.spring.mvc_hibernate.controller;

import com.aayazbek.spring.mvc_hibernate.entity.City;
import com.aayazbek.spring.mvc_hibernate.entity.CityDTO;
import com.aayazbek.spring.mvc_hibernate.entity.Country;
import com.aayazbek.spring.mvc_hibernate.entity.Employee;
import com.aayazbek.spring.mvc_hibernate.service.city.CityService;
import com.aayazbek.spring.mvc_hibernate.service.country.CountryService;
import com.aayazbek.spring.mvc_hibernate.service.employee.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class MyController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private CityService cityService;

    @Autowired
    private CountryService countryService;

    @RequestMapping("/")
    public String showAllEmployees(Model model) {

        List<Employee> allEmployees = employeeService.getAllEmployees();
        model.addAttribute("allEmps", allEmployees);

        return "all-employees";
    }

    @RequestMapping("/addNewEmployee")
    public String addNewEmployee(Model model) {

        Employee employee = new Employee();
        model.addAttribute("employee", employee);

        List<Country> countries = countryService.getAllCountries();
        model.addAttribute("countries", countries);

        return "employee-info";
    }

    @RequestMapping("/getCities")
    public @ResponseBody
    List<CityDTO> addNewEmployee(@RequestParam("id") int id) {
        return cityService.findByCountry(id);
    }

    @RequestMapping("/saveEmployee")
    public String saveEmployee(@ModelAttribute("employee") Employee employee) {

        employeeService.saveEmployee(employee);

        return "redirect:/";

    }

    @RequestMapping("/updateInfo")
    public String updateEmployee(@RequestParam("empId") int id, Model model) {

        Employee employee = employeeService.getEmployee(id);
        model.addAttribute("employee", employee);

        List<Country> countries = countryService.getAllCountries();
        model.addAttribute("countries", countries);

        List<CityDTO> cities = cityService.findByCountry(employee.getCountry().getId());
        model.addAttribute("cities", cities);

        return "employee-info";

    }

    @RequestMapping("/deleteEmployee")
    public String deleteEmployee(@RequestParam("empId") int id) {
        employeeService.deleteEmployee(id);
        return "redirect:/";

    }

    @RequestMapping("/search")
    public String search(HttpServletRequest request, Model model) {

        model.addAttribute("allEmps", employeeService.findBySurname(request.getParameter("surname")));
        return "all-employees";
    }
}
