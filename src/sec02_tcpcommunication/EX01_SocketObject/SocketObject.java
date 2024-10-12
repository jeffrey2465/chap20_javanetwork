package sec02_tcpcommunication.EX01_SocketObject;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class SocketObject {
	public static void main(String[] args) throws UnknownHostException, IOException {
		
		//#1. Socket 객체 생성
		Socket socket1 = new Socket();
		Socket socket2 = new Socket("www.naver.com", 80);
		Socket socket3 = new Socket("www.naver.com", 80, InetAddress.getLocalHost(), 10000);
		Socket socket4 = new Socket(InetAddress.getByName("www.naver.com"), 80);
		Socket socket5 = new Socket(InetAddress.getByName("www.naver.com"), 80, InetAddress.getLocalHost(), 20000);
		//(참고) 만일 InetAddress.getLocalHost()에서 unreachable 예외가 발생하는 경우(다른 IP를 리턴하는 경우) InetAddress.getName("IP주소")로 직접 입력할 것
		
		//#2. Socket 메서드
		//@connect 메서드 / 원격지 주소 정보 제공
		System.out.println(socket1.getInetAddress() + ":" + socket1.getPort());
		socket1.connect(new InetSocketAddress("www.naver.com", 80));
		System.out.println(socket1.getInetAddress() + ":" + socket1.getPort());
		System.out.println(socket2.getInetAddress() + ":" + socket2.getPort());
		System.out.println();		
		
		//@로컬주소정보(지정한 경우 + 지정하지 않은 경우)
		System.out.println(socket2.getLocalAddress()+":"+socket2.getLocalPort());
		System.out.println(socket2.getLocalSocketAddress());
		
		System.out.println(socket3.getLocalAddress()+":"+socket3.getLocalPort());
		System.out.println(socket3.getLocalSocketAddress());
		System.out.println();
		
		//@send/receive 버퍼 사이즈
		System.out.println(socket2.getSendBufferSize()+", "+socket2.getReceiveBufferSize());
		
	}
}
