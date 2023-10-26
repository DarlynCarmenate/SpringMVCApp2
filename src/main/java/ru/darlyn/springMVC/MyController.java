package ru.darlyn.springMVC;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/employee")
public class MyController {

    @RequestMapping("/")
    public String showFirstView() {
        return "first-view";
    }

    @RequestMapping("/askDetails")
    public String askEmployeeDetails(Model model) {
        model.addAttribute("employee", new Employee());
        return "ask-emp-details-view";
    }

//    @RequestMapping("showDetails")
//    public String showEmpDetails() {
//        return "show-emp-details-view";
//    }

//    Запрос параметра через HttpRequestServlet
//    @RequestMapping("showDetails")
//    public String showEmpDetails(HttpServletRequest request, Model model) {
//        String empName = request.getParameter("employeeName");
//        empName = "Mrs. " + empName;
//        model.addAttribute("nameAttribute", empName);
//        model.addAttribute("descroption", " - researcher");
//        return "show-emp-details-view";
//    }

//    Запрос параметра через @RequestParam

//    @RequestMapping("showDetails")
//    public String showEmpDetails(@RequestParam("employeeName") String empName,
//                                 Model model) {
//
//        empName = "Mrs. " + empName;
//        model.addAttribute("nameAttribute", empName);
//
//        return "show-emp-details-view";
//    }

    @RequestMapping("/showDetails")
    public String showEmpDetails(@Valid @ModelAttribute("employee") Employee emp,
                                 BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            return "ask-emp-details-view";
        } else {
            return "show-emp-details-view";
        }
    }
}
