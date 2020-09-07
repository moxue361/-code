package tao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import tao.service.DepartmentService;

@Controller
@RequestMapping("/admin")
public class DepartmentController {
    @Autowired
    DepartmentService departmentService;

    @GetMapping("/departments")
    public String departments(Model model) {
        model.addAttribute("deps",departmentService.findAll());
        return "forward:/admin/departments.jsp";
    }

    @PostMapping("/addDep")
    public String addDep(String departmentname) {
        departmentService.addDep(departmentname);
        System.out.println(departmentname);
        return "redirect:/admin/departments";
    }

    @GetMapping("/delDep")
    public String delDep(Integer depId) {
        departmentService.delDep(depId);
        return "redirect:/admin/departments";
    }

    @RequestMapping("/updateDep")
    @ResponseBody
    public String updateDep(Integer id,String name) {  
        Integer result = departmentService.updateDep(id,name);
        if(result==1){
            return "success";
        }else{
            return "erro";
        }
    }


}