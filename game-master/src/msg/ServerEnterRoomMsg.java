package msg;

import entity.User;
import net.MyClient;
import entity.RoomPojo;
/**
 * 进入房间报文类
 * @author john
 *
 */
public class ServerEnterRoomMsg extends ClientMsg{
	private User user;

	public ServerEnterRoomMsg(int roomid, boolean isleft, User user) {
		super(roomid, isleft);
		this.user=user;
	}


	public void doBiz() {
	    MyClient.getMyClient().getRoomlist().toRoom(roomid,isleft,user);
	}
	

}
