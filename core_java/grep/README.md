# Introduction
(50-100 words)
Discuss the design of each app. What does the app do? What technologies have you used? (e.g. core java, libraries, lambda, IDE, docker, etc..)

This application used java 8 to create a memic to the linux `grep` command. The program searches through the text file and extracts contents if the desired match is found. It read the file through a Buffered Reader, and process each extracted line and returns the line if a match is found using java regular expressions. We also implmented this using Java Stream API to allow for multithreading and more efficiency. 

## Technologies
    - Java 8
    - Maven
    - Dockers
    - Java Stream API
    - Visual Studio Code
    - Git/Github


# Quick Start
To start the application you first need to compile with Maven: 
`mvn clean package`

Run locally on machine:
`java -cp target/grep-1.0-SNAPSHOT.jar ca.jrvs.apps.grep.JavaGrepImp 'RegexPattern' ./data ./out/grep.txt`

Run using Docker Image:
`docker run --rm osama252/grep <regexPattern> <rootPathToTxtFile> <outputFile>`


#Implemenation
## Pseudocode
```
matchedLines = []
for file in listFilesRecursively(rootDir)
  for line in readLines(file)
    if containsPattern(line)
      matchedLines.add(line)
writeToFile(matchedLines)
```

## Performance Issue
(30-60 words)
Discuss the memory issue and how would you fix it
One of the issues that may arise and the program can fail is due to 'out of memory' error. In any java application, the heap memory is allocated memory by the JVM and when it becomes insufficient and used up, it'll return an error. To fix an issue like this, we can implement buffers to limit memory usage in a given iteration, hence the use of bufferedReaders. 


# Test
How did you test your application manually? (e.g. prepare sample data, run some test cases manually, compare result)
The application was tested manually and can be compared to the linux grep to confirm results. We also implmented log4j logger for printing error messages for debugging purposes. Every class was tested using the IDE debugger alongside the build process to ensure each component was written correctly. 

Sample data was used to compare the linux `grep` and implemented java grep as well as the using lambda expression for java stream. Ensured the output was correctly performed and was done in the correct directory.  


# Deployment
How you dockerize your app for easier distribution?
To distribute the application, the final product was packaged using Maven and creating a Docker image. To run this image we can use the following command (3 arguments): 

`docker run --rm osama252/grep <regexPattern> <rootPathToTxtFile> <outputFile>`


# Improvement
List three things you can improve in this project.
    1. Make the application quicker by implmenting multithreading as we have already implemented using streams.
    2. Have the app use memory more efficiently to quicken the time it takes to search through files. 
    3. Implement feature to search through multiple regex expression making it better than linux `grep`.

 