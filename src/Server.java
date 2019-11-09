import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

class Server 
{
	
	//

   private ServerSocket serverSocket;

   public Server() {
      try {
	 serverSocket = new ServerSocket(8000);
    } catch (IOException e) {
 	e.printStackTrace();
	}
   }
   
   //פתיחת הסוקט לקבלת נתונים

   public Socket Accept() {
        try {
	 return serverSocket.accept();
         } catch (IOException e) {
	 	e.printStackTrace();
	 }   
      return null;
   }

}
