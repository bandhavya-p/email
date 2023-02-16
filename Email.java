import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
/**
*  Email Program.
*  Receives sentences of input from the keyboard and
*  stores them in separate variables.
*  Connects to a TCP Server "smtp.chapman.edu".
*  Waits for a Welcome message from the server.
*  Sends the first sentence to the server.
*  Receives a response from the server and displays it.
*  Sends the second sentence to the server.
*  Receives a second response from the server and displays it.
*  Repeats until all sentences are sent.
*  Closes the socket and exits.
*  author: Trey Alexander
*  Email:  roalexander@chapman.edu
*  author: Bandhavya Parvathaneni 
*  Email: parvathaneni@chapman.edu
*  Date:  2/13/23
*  version: 3.1
*/

class Email { 

  public static void main(String[] argv) throws Exception { 
    // Get user input
    BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));

    //Recive user information
    System.out.print("Enter sender email address (Ex: user@chapman.edu): ");
    final String username = inFromUser.readLine();

    //Recieve recipient information
    System.out.print("Enter recipient email address (Ex: user@chapman.edu): ");
    final String recipientName = inFromUser.readLine();

    //Sender name
    System.out.print("Enter sender name: ");
    final String name = inFromUser.readLine();

    //Recipient name
    System.out.print("Enter recipient name: ");
    final String recipient = inFromUser.readLine();

    //Get subject of email
    System.out.print("Enter recipient name: ");
    final String subject = inFromUser.readLine();

    //Recieves sentences from the user
    System.out.print("Enter sentences (End using . on separate line): ");
    String sentence = inFromUser.readLine();

    // Finished getting user input

    // Connect to the server
    Socket clientSocket = null;

    try { 
      clientSocket = new Socket("smtp.chapman.edu", 25);
    } catch (Exception e) { 
      System.out.println("Failed to open socket connection");
      System.exit(0);
    }
    PrintWriter outToServer = new PrintWriter(clientSocket.getOutputStream(), true);
    BufferedReader inFromServer =  new BufferedReader(
        new InputStreamReader(clientSocket.getInputStream()));

    // Exchange messages with the server
    // Recive and display the Welcome Message
    String welcomeMessage = inFromServer.readLine();
    System.out.println("SERVER: " + welcomeMessage);

    //Connect to "icd.chapman.edu"
    outToServer.println("HELO icd.chapman.edu");
    System.out.println("CLIENT: HELO icd.chapman.edu");

    //Read server response
    String message = inFromServer.readLine();
    System.out.println("SERVER: " + message);

    //Sends user info displays response
    outToServer.println("MAIL FROM: " + username);
    System.out.println("CLIENT: MAIL FROM: " + username);

    //Read server response
    message = inFromServer.readLine();
    System.out.println("SERVER: " + message);

    //Send recipeint info displays response
    outToServer.println("RCPT TO: " + recipientName);
    System.out.println("CLIENT: RCPT TO: " + recipientName);

    //Read server response
    message = inFromServer.readLine();
    System.out.println("SERVER: " + message);

    //Next step of indicating DATA of email
    outToServer.println("DATA");
    System.out.println("CLIENT: DATA");

    //Read server response
    message = inFromServer.readLine();
    System.out.println("SERVER: " + message);

    //Send sender info
    outToServer.println("FROM: " + name);
    System.out.println("CLIENT: FROM: " + name);

    //Send reciever inFromUser
    outToServer.println("TO: " + recipient);
    System.out.println("CLIENT: TO: " + recipient);


    outToServer.println("Subject: " + subject);
    System.out.println("CLIENT: Subject" + subject);

    // Send  inputed sentences and display the response

    while (true) { 
      outToServer.println(sentence);
      System.out.println("CLIENT: " + sentence);
      sentence = inFromUser.readLine();

      if (sentence.equals(".")) { 
        break;
      }
    }

    outToServer.println(".");
    System.out.println("CLIENT: .");

    //Read server response
    message = inFromServer.readLine();
    System.out.println("SERVER: " + message);

    outToServer.println("QUIT");
    System.out.println("CLIENT: QUIT");

    //Read server response
    message = inFromServer.readLine();
    System.out.println("SERVER: " + message);

    //Final goodbye message
    System.out.println("Finished: SUCCESS");

    // Close the socket connection
    clientSocket.close();
  }
}
