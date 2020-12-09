package msg;

import entity.RoomPojo;
import net.MyServer;
/**
 * 被悔棋者向服务端发送是否愿意接收悔棋的报文类
 * @author john
 *
 */
public class ClientBackResult extends ClientMsg{
    private boolean result;

	public ClientBackResult(boolean result, int roomid, boolean isleft) {
		super(roomid, isleft);
		this.result = result;
	}

	public void doBiz() {
		RoomPojo roompojo=MyServer.getMyServer().getRooms().get(roomid);
         if(result){
        	if(isleft){
        		ServerBackSucceed msg=new ServerBackSucceed();
        		MyServer.getMyServer().sendMsgToClient(msg, roompojo.getRightPlayer());
        	}
        	else{
        		ServerBackSucceed msg=new ServerBackSucceed();
        		MyServer.getMyServer().sendMsgToClient(msg, roompojo.getLeftPlayer());
        	}
         }
         else{
        	if(isleft){
        		 ServerBackFail msg=new  ServerBackFail();
     		    MyServer.getMyServer().sendMsgToClient(msg, roompojo.getRightPlayer());
     	    }
     	    else{
     	    	 ServerBackFail msg=new  ServerBackFail();
     		    MyServer.getMyServer().sendMsgToClient(msg, roompojo.getLeftPlayer());
     	    } 	 
         }
	}

}
