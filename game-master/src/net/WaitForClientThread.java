package net;

import java.io.IOException;
import java.net.Socket;

/**
 * 线程类处理多客户端连接
 * @author john
 *
 */

class WaitForClientThread extends Thread{
	private MyServer myServer;
	
	public WaitForClientThread(MyServer s) {
		this.myServer = s;
	}
	
	public void run() {
		try {
			while(true){
			     Socket client = myServer.server.accept();
			     System.out.println(client+"成功连接服务器");
			     ClientChatThread cct=new ClientChatThread(client);
			     myServer.pool.add(cct);
			     cct.start();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}