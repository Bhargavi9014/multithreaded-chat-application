# MULTITHREADED-CHAT-APPLICATION

*COMPANY: CODTECH IT SOLUTIONS

*NAME: KOLIPAKA BHARGAVI 

*INTER-ID: CT04DH1600

*DOMAIN: JAVA PROGRAMMING

*DURATION: 4 WEEKS

*MENTOR: NEELA SANTHOSH

## Description
This is a simple Java-based console chat application that enables real-time communication between multiple clients through a central server using sockets and multithreading. Each connected client can send and receive messages, and all messages are broadcast to every other client in the chat room.

## Features
- Connects multiple clients to a single server using Java sockets  
- Accepts username on client connection  
- Broadcasts messages to all active clients  
- Clients can exit the chat gracefully using the "exit" command  
- Server handles each client in a separate thread  
- Uses thread-safe data structures to manage clients  

## Topics Covered
- Java Socket Programming (Socket, ServerSocket)  
- Multithreading using Runnable and Thread 
- Thread-safe collections (CopyOnWriteArrayList)  
- Input/output stream handling (BufferedReader, PrintWriter)  
- Basic concurrency control  
- Clean code separation between client, server, and handler classes

## Requirements
- Java 8 or higher  
- Command-line terminal or Java IDE (Eclipse)  
- Internet not required (local networking only)

## Execution Flow
- ✅ Run Server.java first
  - This starts the server and waits for client connections.
- 🔁 Run Client.java multiple times
  - Each run starts a new client. Use separate terminal windows to simulate multiple users in the chat.
- ⚙️ Do not run ClientHandler.java manually
  - This class is used internally by the server to manage individual client connections using separate threads. 


