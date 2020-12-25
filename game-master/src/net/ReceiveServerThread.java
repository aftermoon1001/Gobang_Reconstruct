package net;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

import msg.BaseMsg;

/**
 * 不断接受报文类并执行其Biz方法的线程
 * @author john
 *
 */
class ReceiveServerThread extends Thread{
	private  Socket client;

	public ReceiveServerThread(Socket client) {
		super();
		this.client = client;
	}

	public void run() {
		
			try {
				while(true){
				 ObjectInputStream ois = new ObjectInputStream(client.getInputStream());
				 BaseMsg msg = (BaseMsg)ois.readObject();
				 System.out.println("收到数据"+msg);
				 msg.doBiz();
		//		 ois.close();
			}
				} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		
	}
	
}