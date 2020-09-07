package tao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import tao.model.Meeting;
import tao.model.Meetingroom;

public interface MeetingroomMapper {
    public List<Meetingroom> findAll();

	public Meetingroom findOneById(Integer id);

	public void updateRoom(Meetingroom meetingroom);

	public void addRoom(Meetingroom meetingroom);

	public void addMeeting(Meeting meeting);

	public void addEmps(@Param("meetingId") Integer meetingId,@Param("emps") Integer[] emps);
}
