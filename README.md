# CSX42: Assignment 1
## Name: Priyanka Prakash Tanpure 

-----------------------------------------------------------------------
-----------------------------------------------------------------------


Following are the commands and the instructions to run ANT on your project.
#### Note: build.xml is present in wordPlay/src folder.

-----------------------------------------------------------------------
## Instruction to clean:

####Command: ant -buildfile wordPlay/src/build.xml clean

Description: It cleans up all the .class files that were generated when you
compiled your code.

-----------------------------------------------------------------------
## Instruction to compile:

####Command: ant -buildfile wordPlay/src/build.xml all

Description: Compiles your code and generates .class files inside the BUILD folder.

-----------------------------------------------------------------------
## Instruction to run:

####Command: ant -buildfile wordPlay/src/build.xml run -Dinput="input.txt" -Doutput="output.txt" -Dmetrics="metrics.txt"

Note: Arguments accept the absolute path of the files.


-----------------------------------------------------------------------
## Description:
Results.java class :-
I used StringBuffer for storing the rotated words. Each append of StringBuffer have O(1) complexity.
Overall Complexity of StringBuffer.append is O(n), n is the input size in this case number of words in input file.
And and the time of writing into the file just converted StringBuffer in to String. 

If we directly used String and perform concatenation, On each concatenation a new copy of the string is created, so that the overall complexity is O(n^2).

Also, if any other datastructure used let's say queue. Then there is overhead of performing operations like push(),pop().

-----------------------------------------------------------------------
### Academic Honesty statement:
-----------------------------------------------------------------------

"I have done this assignment completely on my own. I have not copied
it, nor have I given my solution to anyone else. I understand that if
I am involved in plagiarism or cheating an official form will be
submitted to the Academic Honesty Committee of the Watson School to
determine the action that needs to be taken. "

Date: 10 June 2020


