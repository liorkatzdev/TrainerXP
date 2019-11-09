import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

class HandleAClient implements Runnable 
{
	//טיפול בלקוח יחיד 
	//
 private Socket socket; // A connected socket

 private ObjectInputStream inputFromClient;
 private ObjectOutputStream outputToClient;


private AllUserData allUserDataFromClient;
private AllUserData allUserDataToServer;

 public HandleAClient(Socket socket) 
 {
 	this.socket = socket;
 }



 public void run() 
 {
   try {
	   // Create data input and output streams

	   outputToClient = new ObjectOutputStream(socket.getOutputStream());
	   inputFromClient = new ObjectInputStream(socket.getInputStream());
	   allUserDataFromClient=new AllUserData();
	   // Continuously serve the client
	   while (true) {

		   // read from client
	   try {
		allUserDataFromClient = (AllUserData) inputFromClient.readObject();
		
		
		System.out.println(allUserDataFromClient.getUserName());
		
		if(!allUserDataFromClient.getUserName().equals("unknown"))
		{
			if(allUserDataFromClient.getUserName().contains(("UpdateExerciseWeight"))) 
			{
				
			//entered to  User Name the Exercise name | and to the UserGender the new exercise Weight	
			SQLquerys.UpdateExerciseWeight(allUserDataFromClient.getId(), 
			SQLquerys.GetIDKeyByExercise(allUserDataFromClient.getUserName().substring("UpdateExerciseWeight ".length())),
			Double.parseDouble(allUserDataFromClient.getUserGender()));
			
			// run query to update weight
			
			}
			else
			{
				if(allUserDataFromClient.getUserName().contains(("UpdateUserWeight")))
				SQLquerys.UpdateUserWeight(allUserDataFromClient.getId(),allUserDataFromClient.getCurrentWeight());
			}
		}
	
		else 
		{
			allUserDataToServer=SQLquerys.GetUserDataByID(allUserDataFromClient.getId());
			// Send area back to the client
			outputToClient.writeObject(allUserDataToServer);
	
		}
		  
		  
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	  

 }
 } catch (IOException e) {
 	System.err.println(e);
 	}
     }
}
