package tao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import tao.service.EmployeeService;

@Controller
@RequestMapping("/admin")
public class ApproveAccountController{
    @Autowired
    private EmployeeService employeeService;

    @RequestMapping("/approveaccount")
    public String departments(Model model){
        model.addAttribute("employees",employeeService.findApplicants());
        return "forward:/admin/approveaccount.jsp";
    }

    @GetMapping("/updateStatus")
    public String updateStatus(Integer employeeid,Integer status){
        employeeService.updateStatus(employeeid,status);
        return "redirect:/admin/approveaccount";
    }
}