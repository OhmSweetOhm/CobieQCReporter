# CobieQcReporter
CobieQcReporter

DESCRIPTION:
This is a standalone GUI tool for checking COBie Construction and Design files.

PRE-REQS:
Java 1.8
Apache Maven

RECOMMENDED:
The Java bin folder should be part of your Environment path for convenience. 
You can test this by opening a command prompt and typing: java
If you get an error about no such command exists then java is not in your PATH.
To find out how to add Java to your environment path visit:
https://docs.oracle.com/javase/tutorial/essential/environment/paths.html

Command Usage:
1) run the QC report: java -jar CobieQCReporter.jar
 

NOTE:
If you don't have Java in your PATH then you can run the command by substituting "java -jar" for
<full path to your java bin> -jar
For example, to run the help command:  C:\Program Files\Java\jdk1.8.0_25\bin\java.exe -jar CobieQCReporter.jar -h