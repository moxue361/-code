package tao.model;

public class Meetingroom {
    private Integer roomid;
    private Integer roomnum;
    private String roomname;
    private Integer capacity;
    private Integer status;
    private String description;

    @Override
    public String toString() {
        return "Meetingroom [capacity=" + capacity + ", description=" + description + ", roomid=" + roomid
                + ", roomname=" + roomname + ", roomnum=" + roomnum + ", status=" + status + "]";
    }

    public Integer getRoomid() {
        return roomid;
    }

    public void setRoomid(Integer roomid) {
        this.roomid = roomid;
    }

    public Integer getRoomnum() {
        return roomnum;
    }

    public void setRoomnum(Integer roomnum) {
        this.roomnum = roomnum;
    }

    public String getRoomname() {
        return roomname;
    }

    public void setRoomname(String roomname) {
        this.roomname = roomname;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
}