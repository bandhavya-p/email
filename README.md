This README file describes the assignment. You must edit it to describe your program, not the assignment.

This repository contains a Email.java program that utilizes our previous TcpServer.java program and a TcpClient.java program. This program is similar to the original TCP client and server programs except that it takes input from the client which is sent to a server that sends out an email to a selected recipient. Our program prompts the client to input information such as their email address, the recipient's email address, the subject, the names of both the client and recipient, as well as the matter of this email. The client can input as much information as they please until they are ready to send. They can prompt the server to send by entering "." which prompts the server to stop.

The client will send two sentences to the server instead of just one, as you were asked to do in the Programming Assignment 0.
Using the TcpClient.java program as a starting point for the Email.java program that you will create for the email assignment by copying the TcpClient.java file to a file named Email.java. We then edit this file to not only take input from the client, but to also sent that out to the server and display it.

In the Email.java program,

you will collect information from the user to send an email message,
then (and only then!) send the message by connecting to the smtp.chapman.edu server and transmit the message.
Your program should display all the SMTP commands that you send to the server and all the responses that you receive from the server.

Before testing your program, make sure it passes checkstyle audit.

To test your program, edit the email.input file and replace

"sender_email_address" with "username@chapman.edu" where "username" is your actual username
"receiver_email_address" with your email sender_email_address
"sender_name" with your name
"receiver_name" with a different version of your name
Run the program with the test input by typing

java Email < email.input

Create a Jenkins job for the project following the assignment instructions.

For full credit, your program Must

include appropriate documentation
be capable of sending messages with multiple lines
handle the email.input file properly
i.e. run properly when executed as "java Email < email.input"
pass checkstyle review.
pass the Jenkins build.
Edit the text above so that it describes your Email program rather than the assignment Edit the text below as appropriate.

Identifying Information
Name: Bandhavya Parvathaneni
Student ID: 2406700
Email: parvathaneni@chapman.edu
Name: Trey Alexander
Student ID: 237235
Email: roalexander@chapman.edu
Course: CPSC 353
Assignment: PA001
Source Files
References
Known Errors
Build Insructions
Execution Instructions
