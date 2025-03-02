# Mystery-RPG

A 2D game built from scratch in Java 1.8 using the JavaFx Framework.

<p align="center"><img src="GameFiles\SaveFiles\saveSlotImage_2.png" width="800"></p>

# Project backstory

This game was my project for my university course software design in Java where i first encountered object oriented programming
after only having done some simple C en VB.Net stuff.

Our teacher asked for a simple project but i always wanted to make my own videogame and took it a little further.
During the course of this project i learned a lot about programming and it pushed me to change my school major to Software Engineering.
The code in this project is far from perfect but i wanted to enclude it here anyway for educational purposes.
This project was made with the help of my project partner Sam Vanhove(No github).

Please note that i do not own the rights to any of the artwork. This code is only meant to be viewed for educational purposes.

# Running the project

## Prerequisites

To run this project install java 1.8 and the javafx framework from the open jdk.
Set your $JAVA_HOME env variable to point to java.

`export JAVA_HOME=$(/usr/libexec/java_home -v 1.8)`
`export JAVA_HOME=/Library/Java/JavaVirtualMachines/jdk-1.8.jdk/Contents/Home`

Make sure java 1.8 is the first java version in your path to make sure both java and javac use java 1.8.
`export PATH=$JAVA_HOME/bin:$PATH`

You can double check your configured version using `java -version` and `javac -version`

Make sure

## Compile & Run

To compile this project run the java compile command in the project root `javac -cp "gson-2.8.4.jar:." src/game/**/*.java`.
After compiling you can run the game with the java command `java -cp "gson-2.8.4.jar:src" game.Main`.
