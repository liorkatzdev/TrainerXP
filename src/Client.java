import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

class Client 
{

	//כתיבה לשרט וקריאה מהשרט 
	//עבור כל לקוח יש משתנה מסוג זה שהוא מועבר לשרט והשרט יודע איך לטפל בו
 // IO streams
 private static ObjectOutputStream toServer;
 private static ObjectInputStream fromServer;
 
 
	
 private Socket socket;

 public Client(){
		
    try {
     // Create a socket to connect to the server
     socket = new Socket("localhost", 8000);
   
  // Create an output stream to send data 
     // to the server
      toServer = new ObjectOutputStream(socket.getOutputStream());
      
  // Create an input stream to receive data
  // from the server
   fromServer = new ObjectInputStream(socket.getInputStream());

   
	 }
 catch (IOException ex) {  }
}
	
 public void writeToServer(AllUserData userdata ){
   try {
	   
	toServer.writeObject(userdata);
	toServer.reset();
	toServer.flush();
  } catch (IOException e) {e.printStackTrace(); }
 }


 public AllUserData readFromServer()
 {		//קוראת את האובייקט AllUserData מהסוקט
   try {
 try {
	return (AllUserData) fromServer.readObject();
} catch (ClassNotFoundException e) {
	e.printStackTrace();
}
  } catch (IOException e) {e.printStackTrace(); }
 return null;
}
			
}
