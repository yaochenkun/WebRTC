package com.webrtc.auto.core;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import com.webrtc.auto.common.Constants;
import com.webrtc.auto.socket.AutoSocketClientHandler;
import com.webrtc.auto.socket.SocketHandler;

public class Service {
	
	public static SocketHandler autoSocketHandler = null;
	
	public Service() throws UnknownHostException, IOException
	{
		String clientFlag = Constants.AUTO_FLAG;
		String serverAddr = Constants.ADDR;
		int    listenPort = Constants.WCS_TCP_LISTEN_PORT;
		
		//连接过程准备
		autoSocketHandler = new AutoSocketClientHandler(clientFlag, new Socket(serverAddr,listenPort));
		autoSocketHandler.send(clientFlag); //必须要发送一个客户端标志，以便WCS分清是哪个端再请求与它建立服务关系
		
		//开始双向通信
		autoSocketHandler.run();	//监听WCS有没有向自己发送消息
	}
	
	public static SocketHandler getAutoSocketHandler() {
		return autoSocketHandler;
	}
	
	//启用“自动总机模块”主函数
	public static void main(String[] args) throws UnknownHostException, IOException
	{
		new Service();
	}
}
