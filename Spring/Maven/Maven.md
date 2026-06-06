# Introduction

Maven is a build Automation Tool that was developed by Apache. 

### How does the Java Code Gets Converted and applied into a Web Application?

Here it is,

<img width="633" height="245" alt="image" src="https://github.com/user-attachments/assets/cfa3e2ea-a9b7-4294-a525-8c8ed622a466" />

1. Initially, A User will write the respective Java code with some logic and save it in a .java file. 
2. When the respective file has been compiled it produces a .class file.
3. The code will be run for unit testcases.
4. And Once the test cases are passed then it can be stored as a package and then can be presented either as a jar file or war file.
5. If its the development is related to standalone application then, it can be packed into a jar file or if it is web application that need to be deployed on server (such as TomCat) then it need to packed into a war file.

### Usage Of Maven

• From the above steps, In Order to automate the process from the complie to package it can be done by a build tool.
• Automate the code into a package for building it a, build tool is required. That is exactly where "MAVEN" is used. 
• You can manually, do the complie and pack it but automation makes things easier and efficient.
• It manages dependencies and automates the build process of Java Projects including tasks such as compiling code, packaging, testing and deployment.

### Maven Can Do

• It will create a standard project folder structure.
• It will download and manage dependencies/libraries automatically.
• Execute unit test cases using testing frameworks like JUnit.

### Create a Simple Maven Project

mvn archetype:generate -DgroupId=com.abhinay -DartifactId=maven-first-app -DarchetypeArtifactId=maven-archetype-quickstart -DarchetypeVersion=1.4 -DinteractiveMode=false

• The above command creates a simple java project.
• "mvn" - maven
• "archetype:generate" - generate one project
• "-DgroupId=com.abhinay" - package name
• "-DartifactId=maven-first-app" - when the project is done then it will be in jar/war file the file name will be this.
• "-DarchetypeArtifactId=maven-archetype-quickstart" - It is stating to generate a simple standalone project in jar file.
• "-DarchetypeVersion=1.4" - A normal version
• "-DinteractiveMode=false" - At the time of creating project, dont ask any kind of parameters.
• "-D" - It is a parameter that will pass to maven to create a java project.  

• Execute this in Command Prompt of that folder.

### After the Command is Executed

• A pom.xml is created.
• A src folder is created in which it contains two folders as main and Test

### Maven Terminologies

1. ARCHETYPE - It is a template that defines the structure of a Maven Project.

Examples:-
maven-archetype-quickstart -> Java Standalone Application.
maven-archetype-webapp -> Java Web Application.

2. GROUPID - It represents the organization or company name.

Examples:-
com.tcs,com.google

Note: GroupId follows a reverse domain name convention, typically representing a company or organization.

3. ARTIFACTID - Represents the name of the project/module.

Examples:-
amazon-app, nike-app, ua-app

4. VERSION - Specifies the version of the project.

Examples:-
0.0.1-SNAPSHOT, 1.0-RELEASE

SNAPSHOT - Under Development
RELEASE - Final version, delivered to client.

5. PACKAGING TYPE - Defines the packaging format of the project.

Examples:-
jar, war

Note: The default packaging is jar if not specified.

6. MAVEN DEPENDENCIES - Libraries or external Modules required for project development.

Examples:-
spring, hibernate, junit, kafka, redis

7. MAVEN GOALS - Used to perform specific steps in the Maven build lifecycle.

Examples:-
clean, compile, test, package, deploy

8. MAVEN REPOSITORIES - Storage Locations for Maven Dependencies(artiacts/libaries).

Examples:-
Central Repository, Remote Repository, Local Repository

### MAVEN GOALS

It is a unit of task that are used to perform various stages of the project build lifecycle.

• In order to compile, run the command - mvn compile 
• In order to delete the target folder, run the command - mvn clean 
• In order to compile and test the test cases, run the command - mvn test
• In order to package the app, run the command - "mvn package". This command shall compile, test and convert it into jar/war file.
• In order to delete the target and then recompile and re-test and package it, run this command - mvn clean package.
• The final .jar/.war file will be stored in the target directory itself.
