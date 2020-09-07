package tao.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tao.mapper.EmployeeMapper;
import tao.mapper.MeetingroomMapper;
import tao.model.Employee;
import tao.model.Meeting;
import tao.model.Meetingroom;

@Service
public class MeetingroomService {
    @Autowired
	private MeetingroomMapper meetingroomMapper;
	@Autowired
	private EmployeeMapper employeeMapper;

    public List<Meetingroom> findAll() {
        return meetingroomMapper.findAll();
    }

	public Meetingroom findOneById(Integer id) {
		return meetingroomMapper.findOneById(id);
	}

	public void updateRoom(Meetingroom meetingroom) {
		meetingroomMapper.updateRoom(meetingroom);
	}

	public void addRoom(Meetingroom meetingroom) {
		meetingroomMapper.addRoom(meetingroom);
	}

	public List<Employee> getEmpsByDepId(Integer id) {
		return employeeMapper.findEmpsByDepId(id);
	}

	public void addMeeting(Meeting meeting, Employee user, Integer[] emps) {
		meeting.setReservationtime(new Date());
		// 设置发起人的id
		meeting.setReservationistid(user.getEmployeeid());
		meetingroomMapper.addMeeting(meeting);
		// 此时meetingid回填
		meetingroomMapper.addEmps(meeting.getMeetingid(), emps);
	}

}
