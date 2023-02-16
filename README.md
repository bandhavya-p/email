
This repository contains a Email.java program that utilizes our previous TcpServer.java program and a TcpClient.java program. Our program has a class Email where it prompts the user to input information such as the sender's and recipient's email address, the names of both the client and recipient, the subject, as well as the matter of this email. The program sends this inputted information to the server by using <inFromUser.readLine()> The client can input as much information as they please until they are ready to send. They can prompt completion by entering "." which prompts the server to stop. We use a try and catch exception in order to have a socket connection to the smtp server through port 25 <clientSocket = new Socket("smtp.chapman.edu", 25);>. After doing so, we send the previously inputted information to the server using <outToServer> and display the information on screen. We used a while loop to allow the client to input as many sentences as they please until they send "." which prompts our loop to break. We then close the socket connection using <clientSocket.close>.


Identifying Information
* Name: Bandhavya Parvathaneni
* Student ID: 2406700
* Email: parvathaneni@chapman.edu
* Name: Trey Alexander
* Student ID: 237235
* Email: roalexander@chapman.edu
* Course: CPSC 353
* Assignment: PA001 - Email

Source Files
* TCPClient.java
* TCPServer.java
* email.input

References
* class notes

Known Errors

Build Insructions
* javac Email.java
* java Email < email.input

Execution Instructions
* Compile the Email.java file (javac Email.java)
* Run the Email file by using the email.input file to input information (java Email < email.input)
