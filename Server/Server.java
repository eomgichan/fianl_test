import java.io.*;
import java.io.IOException;
import java.net.*;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class Server {
	ServerSocket ss = null;
	ArrayList<ConnectedClient> clients = new ArrayList<ConnectedClient>();
	LoginChecker lc = null;
	public static void main(String[] args) {
		Server server = new Server();
		server.lc = new LoginChecker();
		try {
			server.ss = new ServerSocket(20000);
			System.out.println("Server > Server Socket is Created...");
			while(true) {
				Socket socket = server.ss.accept();
				ConnectedClient c = new ConnectedClient(socket, server);
				server.clients.add(c);
				c.start();
			}
			
		}catch(SocketException e) {
			System.out.println("Server > 소켓 관련 예외 발생, 서버종료");
		}catch(IOException e) {
			System.out.println("Server > 입출력 예외 발생");
		}
		
		
		
		
	}

}

class ConnectedClient extends Thread{
	Socket socket;
	OutputStream outStream;
	DataOutputStream dataOutStream;
	InputStream inStream;
	DataInputStream dataInStream;
	
	Server server;
	
	final String loginTag = "LOGIN";
    final String queryTag = "QUERY";
	
	ConnectedClient(Socket _s, Server _ss){
		this.socket = _s;
		this.server = _ss;
	}
	
	public void run() {
		System.out.println("Server >"+ this.socket.toString()+"에서의 접속이 연결되었습니다.");
		
		try {
			outStream = this.socket.getOutputStream();
			dataOutStream = new DataOutputStream(outStream);
			inStream = this.socket.getInputStream();
			dataInStream = new DataInputStream(inStream);
			String msg = null;
			while(true) {
				msg = dataInStream.readUTF();
				StringTokenizer stk = new StringTokenizer(msg, "//");
				if(stk.nextToken().equals(loginTag)) {
					String id = stk.nextToken();
					String pass = stk.nextToken();
					if(server.lc.check(id, pass)) {
						dataOutStream.writeUTF("Login_OK");
					}
					else {
						dataOutStream.writeUTF("LOGIN_FAIL");
					}
				}
			}
			
		}catch(IOException e) {
			
		}
		
		
	}
	
}

class LoginChecker{
	File dataFile = new File("users.txt");
	String readData;
	StringTokenizer st;
	ArrayList<User> userInfo = new ArrayList<User>();
	LoginChecker(){
		try {
			BufferedReader br = new BufferedReader(new FileReader(dataFile));
			while((readData=br.readLine()) !=null) {
				st = new StringTokenizer(readData, "//");
				String userID = st.nextToken();
				String userPass = st.nextToken();
				User user = new User(userID, userPass);
				userInfo.add(user);
			}
			br.close();
		}catch(Exception e) {
			
		}
	}
	
	boolean check(String _i, String _p) {
		boolean flag = false;
		for(int i = 0 ; i< userInfo.size(); i++) {
			if(userInfo.get(i).id.equals(_i) && userInfo.get(i).password.equals(_p)) {
				flag = true;
			}
		}
		return flag;
	}
}

class User {
	String id;
	String password;
	
	User(String _i, String _p){
		id= _i;
		password= _p;
	}
}