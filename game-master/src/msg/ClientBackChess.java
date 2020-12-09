package msg;

import net.MyServer;
import entity.RoomPojo;
/**
 * 想悔棋者向服务端发送的报文类
 * @author john
 *
 */
public class ClientBackChess extends ClientMsg{
	public ClientBackChess(int roomid, boolean isleft) {
		super(roomid, isleft);
	}

	public void doBiz() {
		RoomPojo roompojo=MyServer.getMyServer().getRooms().get(roomid);
         if(isleft){
        	 ServerBackChess msg=new ServerBackChess();
        	 MyServer.getMyServer().sendMsgToClient(msg, roompojo.getRightPlayer());
         }
         else{
        	 ServerBackChess msg=new ServerBackChess();
        	 MyServer.getMyServer().sendMsgToClient(msg, roompojo.getLeftPlayer());
         }
	}

}