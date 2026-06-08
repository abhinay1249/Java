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

### Maven Dependencies

• Maven Dependencies are the external libraries or modules that your project needs in order to complie and run properly.

Examples: spring-core, junit, hibernate, etc

• You can search and find for maven dependencies at: https://www.mvnrepository.com.

• In the pom.xml file you can find the code such as,

<dependency>
    <groupId>org.springframework</groupId>
    <artifactId>spring-core</artifactId>
    <version>6.1.7</version>
</dependency>

• Any kind of new dependencies extracted from the mvn repository need to be added into the <dependencies> tag in the pom.xml file.

### MAVEN REPOSITORIES

• A place where the dependencies, jar files and the library files are kept for your project.

    • Central Repository (Official Online Repository)
    • Local Repository (On your Machine)
    • Remote Repository (Company or Third-Party Server)

1. Central Repository :- This is the Maven's official public repository hosted online at https://repo.maven.apache.org/maven2
    • It contains millions of open source libraries.
    • If something is not in your local repo, Maven looks here next.

2. Local Repository :- This is the .m2/repository folder in your computer. It is a hidden folder.
    • It is where Maven stores downloaded dependencies so it doesnt re-download them every time.
    • If a dependency is already here, Maven uses it directly.

3. Remote Repository :- These are the additional repositories defined in the pom.xml or settings.xml

    • Often used by companies or private teams to host internal jars.
    • Maven checks these before or after central, depending on the config.

 

<img width="479" height="145" alt="image" src="https://github.com/user-attachments/assets/5132e218-4c16-4ca3-bf0d-c14c2d723d7a" />

• You wish to install a new jar file into your project.
• It is not present in your local repository then it will  download it from the central repository.
• Once the download is completed from the central repository, then it will be saved into your local repository.

How To Check?

• Get the dependency from the central repo and run the command "mvn package", it will show logs such as downloading from central repo with the dependency library that was provided.
• Then again re-run the process through this command stating, "mvn clean package". 

Remote Repository:- These are the repositories that are used to utilize within the company itself more relatable to private repositories.

### POM 

• It stands for Project Object Model. It is a xml file.
• It is a kind of configuration file where is used in order to communicate with maven.
• Plugins are used to hold the java versions that need to be used in the project. They are built in this format,

<build>
    <plugins>
        <plugin>
            // Plugins you wish to include
        </plugin>
    </plugins>
</build>

• By using properties we can store it over there and use them in the plugins section.

<properties>
    <maven.complier.source>17</maven.complier.source>
    <maven.complier.target>17</maven.complier.target>
</properties>

<build>
    <plugins>
        <plugin>
            <configuration>
                <source>{maven.compiler.source}</source>
                <target>{maven.compiler.target}</target>
            </configuration>
        </plugin>
    </plugins>
</build>

### Effective POM

• It is a parent pom.xml file that holds all the dependencies, plugins for creating a project. 
• The command used for creating the effective-pom file is,

    "mvn help:effective-pom -Doutput=effective-pom.xml"

• It is suggested not to change any kind of dependencies in the effective pom file.

### Maven Build LifeCycle

1. default: Main lifecycle for building your application(Mostly Used)
2. clean: Cleaning the target/directory.
3. Site: For generating the documentation.

<img width="659" height="188" alt="image" src="https://github.com/user-attachments/assets/0ec89e2a-1a80-4f89-9e54-07c18cd7df55" />


• Validate is used to verify the all the attributes and the dependencies in the code.
• Compile is used to compile the entire application code.
• Test phase will test your code aganist all the test cases.
• Package is used to pack the entire application into a jar/war file.
• Verify is used for integration testing such as once the package is ready and few plugins are added for testing, verify is used over there.
• Install is used to save you application into local repository.
• Deploy is used to deploy it into your Remote Repository.
 
Key Note: - Junit is a library which is used to write the java test cases.
• In Junit.juniper.api.test, there exists a method known as assertEquals which is used to verify the expected and the obtained result in the unit test cases. 

