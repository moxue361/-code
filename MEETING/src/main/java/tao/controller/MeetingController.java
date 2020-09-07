package tao.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import tao.model.Department;
import tao.model.Employee;
import tao.model.Meeting;
import tao.model.Meetingroom;
import tao.service.DepartmentService;
import tao.service.MeetingroomService;

@Controller
public class MeetingController {
    @Autowired
    private MeetingroomService meetingroomService;
    @Autowired
    private DepartmentService departmentService;

    @RequestMapping("/meetingrooms")
    public String meetingrooms(Model model) {
        model.addAttribute("rooms", meetingroomService.findAll());
        return "forward:/meetingrooms.jsp";
    }

    @RequestMapping("/roomdetails")
    public String roomdetails(Integer roomid, Model model) {
        model.addAttribute("room", meetingroomService.findOneById(roomid));
        return "forward:/roomdetails.jsp";
    }

    @RequestMapping("/admin/updateRoom")
    public String updateRoom(Meetingroom meetingroom, Model model) {
        meetingroomService.updateRoom(meetingroom);
        return "redirect:/meetingrooms";
    }

    @RequestMapping("/admin/addMeetingroom")
    public String addMeetingroom(Meetingroom meetingroom) {
        meetingroomService.addRoom(meetingroom);
        return "redirect:/meetingrooms";
    }

    @GetMapping("/bookmeeting")
    public String bookmeeting(Model model) {
        model.addAttribute("rooms", meetingroomService.findAll());
        return "forward:/bookmeeting.jsp";
    }

    @RequestMapping("/allDeps")
    @ResponseBody
    public List<Department> allDeps() {
        return departmentService.findAll();
    }

    @RequestMapping("/getEmpsByDepId")
    @ResponseBody
    public List<Employee> getEmpsByDepId(Integer depId) {
        return meetingroomService.getEmpsByDepId(depId);
    }

    @RequestMapping("/admin/bookMeeting")
    public String bookMeeting(Integer[] emps,Meeting meeting,HttpSession httpSession) {
        Employee user= (Employee) httpSession.getAttribute("user");
        meetingroomService.addMeeting(meeting,user,emps);
        return "redirect:/notifications.jsp";
    }
}