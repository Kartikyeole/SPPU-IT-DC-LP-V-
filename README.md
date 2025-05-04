
## Distributed Systems Assignments of SPPU Final Year IT Syllabus (2019 pattern)


| Assignment No. | Problem Statement  |
| :--------------:  | :-------------- |
|[Assignment 1](Assign1)| Implement multi-threaded client/server Process communication using RMI.| 
|[Assignment 2](Assign2)| Develop distributed application using CORBA to demonstrate object brokering (Calculator or String operations).|
|[Assignment 3](Assign3)| Develop a distributed system, to find sum of N elements in an array by distributing N/n elements to n number of processors MPI or OpenMP. Demonstrate by displaying the intermediate sums calculated at different processors. |
|[Assignment 4](Assign4)| Implement Berkeley algorithm for clock synchronization.|
|[Assignment 5](Assign5)| Implement token ring based mutual exclusion algorithm.|
|[Assignment 6](Assign6)| Implement Bully and Ring algorithm for leader election.|
|[Assignment 7](Assign7)| Create a simple web service and write distributed application(calculator) to consume the Web Service.|
|[Extra](Sockets)| Develop any distributed application for implementing client-server communication programs based on Java Sockets.|

## Execution Steps


### Pre-requisites:

1. Install JDK-8

        sudo apt-get remove openjdk*
        sudo apt update
        sudo apt install openjdk-8-jdk openjdk-8-jre
    
2. Download [MPJ Express](https://sourceforge.net/projects/mpjexpress/files/releases/mpj-v0_44.tar.gz/download) and extract in the Downloads dir         
 
 3. Install Apache Netbeans
            
         sudo apt update && sudo apt upgrade
         sudo snap install netbeans --classic
     Glassfish server version must be 4.1.1

    --------------------------------------------------------------------------------

C:\Users\hp\Desktop\DS\Assign2>   set JAVA_HOME=C:\Program Files\Java\jdk1.8.0_202 set PATH=%JAVA_HOME%\bin;%PATH%

C:\Users\hp\Desktop\DS\Assign2>   set PATH=%JAVA_HOME%\bin;%PATH%

   ---------------------------------------------------------------------------------



### Assignment---  Socket(client-server communication)

Terminal 1:
	javac *.java
	java Server

Terminal 2:
	java Client

--------------------------------------------------


    
### Assignment---  RMI(calculator) & RMI(string)
 Terminal 1:
	javac *.java
	rmiregistry

Terminal 2:

    java Server

Terminal 3:

    java Client
------------------------------------------------




### Assignment---  CORBA(calculator):

Make sure java version is jdk 8 in each terminal if another jdk version like jdk19 is also installed in the system
use following commands after installing jdk8:---

set JAVA_HOME=C:\Program Files\Java\jdk1.8.0_202 

set PATH=%JAVA_HOME%\bin;%PATH%
java -version


Terminal 1:
	idlj -fall CalculatorModule.idl
	
	javac *.java CalculatorModule/*.java


	orbd -ORBInitialPort 1056

Terminal 2: 
	java CalculatorServer -ORBInitialPort 1056
Terminal 3:
	java CalculatorClient -ORBInitialPort 1056
---------------------------------------------------------





### Assignment---  CORBA(string operation):

Make sure java version is jdk 8 in each terminal if another jdk version like jdk19 is also installed in the system
use following commands after installing jdk8:---

set JAVA_HOME=C:\Program Files\Java\jdk1.8.0_202 

set PATH=%JAVA_HOME%\bin;%PATH%
java -version

Terminal 1:

    idlj -fall ReverseModule.idl
    javac *.java ReverseModule/*.java
    orbd -ORBInitialPort 1056&
    java ReverseServer -ORBInitialPort 1056& 

Terminal 2:

    java ReverseClient -ORBInitialPort 1056 -ORBInitialHost localhost


-------------------------------------------------------------------------------



### Assignment--- MPI(find sum of N):

Terminal:
	
    set MPJ_HOME=C:\Users\hp\Downloads\mpj-v0_44\mpj-v0_44     //windows path of mpj
    set PATH=%MPJ_HOME%\bin;%PATH%
    mpjrun.bat
    javac -cp %MPJ_HOME%\lib\mpj.jar ArrSum.java
    mpjrun.bat -np 4 ArrSum

-------------------------------------------------

    export MPJ_HOME=/home/ubuntu/Downloads/mpj-v0_44 //ubuntu
    export PATH=$MPJ_HOME/bin:$PATH
    javac -cp $MPJ_HOME/lib/mpj.jar ArrSum.java
    $MPJ_HOME/bin/mpjrun.sh -np 4 ArrSum


-------------------------------------------------------------------------------------------




### Assignment--- Berkeley:

Terminal 1:

    python server.py


Terminal 2,3,4:

    python client.py



--------------------------------------------------------------------





### Assignment--- TokenRing:

Terminal

    javac Tring.java
    java Tring

---------------------------------------------------------------------------


### Assignmnet--- Bully & Ring:

Terminal

    javac Bully.java
    java Bully
    javac Ring.java
    java Ring
 
-----------------------------------------------------------------------------
### Assignment 7:

   [Youtube tutorial](https://www.youtube.com/watch?v=0z-HvSfr-M4)



    
### Extra:

Terminal 1:

    javac *.java
    java Server
 Terminal 2:
 
    java Client
    
    
