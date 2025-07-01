COMPANY NAME : CODTECH IT SOLUTIONS

NAME : S NIVILA

INTERN ID : CT04DF2638

DOMAIN : JAVA

DURATION : 4 WEEKS

MENTOR : NEELA SANTHOSH


📁 Task 1: File Operations


This project focuses on developing a basic File Handling Utility using Java. The main objective of this task is to understand and demonstrate core file operations such as writing, reading, and modifying text files using Java I/O and NIO libraries.
File handling is a fundamental concept in Java that is crucial for many real-world applications such as data processing, configuration management, content manipulation, and persistent storage. This project illustrates these concepts with a simple, well-structured Java program and clear documentation, making it an excellent learning resource for beginners and interns exploring Java development.
This task demonstrates basic file handling using Java. The program performs three main operations:

1. **Write to a file** – The program writes a predefined message to a text file  named `sample.txt` using `BufferedWriter`.
2. **Read from the file** – It reads the content of the file line-by-line using `BufferedReader` and prints it to the console.
3. **Modify file content** – It searches for a specific string in the file, replaces it with another string, and rewrites the modified content back to the file using `Files.write()`.

This task uses classes like `BufferedWriter`, `BufferedReader`, and `Files` from `java.io` and `java.nio.file`. It is designed to help interns understand file creation, reading, and editing in a structured and efficient way.

🎯 Objective

The goal of this task is to create a simple and effective Java program that:

• Writes content to a file.

• Reads and displays the file content.

• Modifies specific content within the file.

• Reads the updated file to verify the modification.

Apply core Java concepts such as:

• FileWriter and BufferedWriter for writing files

• FileReader and BufferedReader for reading files

• java.nio.file.Files and Paths for advanced file manipulation

• Ensure clean code structure and proper exception handling

📌 Technologies Used

 • Java SE 8+
    
 • Java I/O (java.io.*)
    
 • Java NIO (java.nio.file.*)
    
 • Java Collections (java.util.*)
    
 • BlueJ IDE (Recommended)


📂 Files & Structure

FileOperations.java: Main Java source file that contains all the file handling logic.

sample.txt: A text file that is dynamically created and modified by the program during runtime.

🔍 Functional Overview

The Java program performs the following operations sequentially:

1. Write to a File
The program begins by writing a predefined message to a file named sample.txt. It uses BufferedWriter and FileWriter to handle the file-writing process efficiently.
java
Copy
Edit
writeToFile("Hello, this is the original content.\nThis line will be modified.\n");

2. Read from the File
It then reads the contents of the file using BufferedReader and FileReader, printing each line to the console. This validates that the file was written successfully.
java
Copy
Edit
readFromFile();

3. Modify Specific Content
The program replaces a specific line in the file using Files.readAllLines() to read all lines and then updates the target line using the replaceAll() method. The modified content is then written back using Files.write().
java
Copy
Edit
modifyFileContent("This line will be modified.", "Done!");

4. Display Modified File Content
Finally, the modified file is read again to verify and display the updated content.
java
Copy
Edit
readFromFile();

🧠 Concepts Learned

• Working with buffered I/O for improved performance.

• Using List<String> to handle and manipulate file lines.

• Exception handling with try-catch blocks.

• Path resolution using java.nio.file.Paths.

• Real-world simulation of file modifications.

✅ Output Example

Original File Content:
Hello, this is the original content.
This line will be modified.

Modified File Content:
Hello, this is the original content.
Done!

📌 How to Run (Using BlueJ)
Open BlueJ and create a new project.

Add FileOperations.java to the project.

Compile the class.

Right-click and select void main(String[] args) to run.

Check the console output and the generated sample.txt file.

📢 Conclusion
This Java file handling utility is a foundational exercise that reinforces basic file operations in Java. It emphasizes clean, readable code, structured output, and real-world use cases. It also sets the stage for more advanced projects involving data parsing, file search, configuration loading, or logging utilities. A must-do for all Java learners looking to build confidence in file I/O.
