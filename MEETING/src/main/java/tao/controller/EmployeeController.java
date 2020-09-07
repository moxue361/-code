package tao.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import tao.model.Department;
import tao.model.Employee;
import tao.service.DepartmentService;
import tao.service.EmployeeService;

@Controller
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    final private static Integer PAGE_SIZE=8;

    @Autowired
    private DepartmentService departmentService;

    @RequestMapping("/")
    public String login() {
        return "forward:/login.jsp";
    }
    @PostMapping("/doLogin")
    public String doLogin(Employee employee, Model model,HttpSession httpSession) {
        Employee employee2 = employeeService.doLogin(employee);
        if (employee2 == null) {
            model.addAttribute("erro", "用户名或密码错误");
            model.addAttribute("username", employee.getUsername());
            return "forward:/login.jsp";
        } else {
            if (0==employee2.getStatus()) {
                model.addAttribute("erro", "该用户待审批");
                return "forward:/login.jsp";
            } else if (2==employee2.getStatus()) {
                model.addAttribute("erro", "该用户审批未通过");
                return "forward:/login.jsp";
            } else {
                httpSession.setAttribute("user", employee2);
                return "redirect:/notifications.jsp";
            }
        }
    }

    @RequestMapping("/register")
    public String register(Employee employee,Model model,HttpSession httpSession) {
        List<Department> deps = departmentService.findAll();
        model.addAttribute("deps",deps);
        return "forward:/register.jsp";
    }

    @PostMapping("/doRegister")
    public String doRegister(Model model,Employee employee) {
        Integer result = employeeService.addEmployee(employee);
        if (result==1) {
            return "redirect:/login.jsp";
        } else {
            model.addAttribute("employees",employee);
            model.addAttribute("registerErr","用户名已存在");
            return "forward:/register";
        }
    }

    // @Deprecated
    // @RequestMapping("/admin/searchemployees")
    // public String searchemployees(@RequestParam(defaultValue = "1") Integer page, Model model,Employee employee) {
    //     // 设置分页参数
    //     PageHelper.startPage(page,PAGE_SIZE);
    //     List<Employee> employees=employeeService.findByEmp(employee);
    //     PageInfo<Employee> pageInfo = new PageInfo<Employee>(employees);
    //     model.addAttribute("pageInfo", pageInfo.getList());
    //     model.addAttribute("pages", pageInfo.getPages());
    //     model.addAttribute("total", pageInfo.getTotal());
    //     model.addAttribute("pageNum", pageInfo.getPageNum());
    //     if(pageInfo.isIsLastPage()){
    //         model.addAttribute("nextPage", pageInfo.getPageNum());
    //     }else{
    //         model.addAttribute("nextPage",pageInfo.getNextPage());
    //     }
    //     if (pageInfo.isIsFirstPage()) {
    //         model.addAttribute("prePage", pageInfo.getPageNum());
    //     } else {
    //         model.addAttribute("prePage", pageInfo.getPrePage());
    //     }
    //     return "forward:/admin/searchemployees.jsp";
    // }

    @RequestMapping("/admin/searchemployees")
    public String searchemployees() {
        return "forward:/admin/searchemployees.jsp";
    }

    @RequestMapping("/admin/search")
    @ResponseBody
    public PageInfo<Employee> search(@RequestParam(defaultValue = "1") Integer page, Employee employee) {
        PageHelper.startPage(page,PAGE_SIZE);
        List<Employee> emps = employeeService.findByEmp(employee);
        PageInfo<Employee> pageInfo = new PageInfo<Employee>(emps);
        if(pageInfo.isIsLastPage())pageInfo.setNextPage(pageInfo.getPageNum());
        if (pageInfo.isIsFirstPage())pageInfo.setPrePage(pageInfo.getPageNum());
        return pageInfo;
        
    }

    @RequestMapping("/admin/removeEmp")
    public String removeEmp(@RequestParam(defaultValue = "1") Integer page, Employee employee,Integer id) {
        employeeService.removeEmp(id);
        return "redirect:/admin/searchemployees";
    }

}