COMPANY NAME : CODTECH IT SOLUTIONS

NAME : S NIVILA

INTERN ID : CT04DF2638

DOMAIN : JAVA

DURATION : 4 WEEKS

MENTOR : NEELA SANTHOSH


📁 Task 1: File Operations

This task demonstrates basic file handling using Java. The program performs three main operations:

1. **Write to a file** – Adds predefined content into a text file (`sample.txt`).
2. **Read from the file** – Reads and prints each line to the console.
3. **Modify file content** – Replaces a specific line in the file with a new string.

This task uses classes like `BufferedWriter`, `BufferedReader`, and `Files` from `java.io` and `java.nio.file`. It is designed to help interns understand file creation, reading, and editing in a structured and efficient way.


🌐 Task 2: REST API Integration

In this task, a Java application consumes a **public REST API** to fetch and display structured weather data based on user input. The application uses:

- `HttpURLConnection` to send an HTTP GET request
- A public weather API (like OpenWeatherMap)
- A JSON parser (`org.json` or similar) to interpret the response

Users are prompted to enter a city name, and the application fetches the corresponding weather conditions, temperature, and humidity. This task demonstrates how to handle HTTP requests and parse JSON in Java.


📡 Task 3: Client-Server Chat Application

This multithreaded chat application allows **multiple clients** to connect and communicate in real-time using Java Sockets. It includes two main components:

- `Server.java`: Accepts incoming connections and broadcasts messages to all clients.
- `Client.java`: Connects to the server and sends/receives messages.

The server handles each client in a separate thread, demonstrating the use of `Thread` and `Socket` classes. This task builds practical skills in networking and concurrency in Java.

🎯 Task 4: Recommendation System

This task focuses on building a simple recommendation system using **Apache Mahout** and Java. It uses collaborative filtering to suggest items to users based on historical preferences. Key components:

- Sample user-item rating dataset
- Apache Mahout’s `DataModel` and `Recommender` classes
- Console output showing item recommendations per user

This project introduces machine learning basics through a hands-on recommendation engine and external library integration.


🛠 Technologies Used

- Java SE 8+
- Java I/O and NIO
- JSON Parsing (`org.json`)
- HTTP Networking
- Java Sockets and Threads
- Apache Mahout (for recommendation)
- Maven (for dependency management)


▶️ How to Run

1. Open any task folder in a Java IDE or terminal.
2. Compile using: `javac FileName.java`
3. Run using: `java ClassName`
4. For API/recommendation tasks, ensure required JAR files are included in the classpath.
