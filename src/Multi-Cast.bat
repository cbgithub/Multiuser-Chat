@echo off

REM change the path below to where your .java files are and it will compile. Just put this on your desktop (that)
pushd E:\Programming\School_Projects\Multiuser-Chat\src\

javac MulticastJoin.java
javac MulticastListener.java
javac MulticastSend.java
javac GUI.java
java GUI
