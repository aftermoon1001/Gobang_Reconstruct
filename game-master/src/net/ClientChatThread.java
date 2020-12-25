package net;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import entity.User;
import msg.BaseMsg;

/**
 * 处理所连接的客户端的报文类数据收发
 * @author john
 *
 */
public class ClientChatThread extends Thread {
	private User user;
	private Socket client;
    

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Socket getClient() {
		return client;
	}

	public void setClient(Socket client) {
		this.client = client;
	}

	public ClientChatThread(Socket client) {
		super();
		this.client = client;
	}
	
	public void sendMsg(BaseMsg msg,Socket client) {
		try {
			ObjectOutputStream oos = new ObjectOutputStream(
					client.getOutputStream());
			oos.writeObject(msg);
			System.out.println("发送报文"+msg);
		//	oos.close();
			
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("给"+client+"发送数据失败");
		}
	}
	public void run() {
		 try {
			 while(true){
			 ObjectInputStream ois = new ObjectInputStream(client.getInputStream());
			 
			 BaseMsg msg = (BaseMsg)ois.readObject();
			 msg.setClient(client);
			 System.out.println("收到数据"+msg);
			 msg.doBiz();
		//	 ois.close();
			 }
		} catch (Exception e) {
			e.printStackTrace();
				MyServer.pool.remove(this);			

		}
	}
}
