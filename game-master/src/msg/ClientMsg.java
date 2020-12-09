package msg;


public abstract class ClientMsg extends BaseMsg {
	protected int roomid;
	protected boolean isleft;
    
    
	

	public int getRoomid() {
		return roomid;
	}




	public void setRoomid(int roomid) {
		this.roomid = roomid;
	}




	public boolean isIsleft() {
		return isleft;
	}




	public void setIsleft(boolean isleft) {
		this.isleft = isleft;
	}
	




	public ClientMsg(int roomid, boolean isleft) {
		super();
		this.roomid = roomid;
		this.isleft = isleft;
	}
}
