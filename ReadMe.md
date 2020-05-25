# Java Performance Tuning Guide

This repo will have all the tools and guide that are useful for debugging any java process. Aim  is to document all the commands and create a single repository which can be used as reference guide for memory analysis.



### Commands - 
1) jps -- list down java process 
2) jinfo -- list down all info of process
3) jstat -- status of memory allocation (jstat -gcutil 44525)
4) jmap -- used for memory dump
5) jcmd -- profiling tool (command line , combination of 2,3,4) 
6) jmc -- (missing control , GUI app)

### Tools - 
* JMeter
* Installation Link - https://visualvm.github.io/download.html

### Profiler Types
- CPU : Concerned witht eh frequenscy and lenght of time of method execution  
    * Sampling(least overhead) & Instrumentation ,  Hot method detection , optimize it 
- Memory
- Thread
- I/O
#### Types
To be updated 

#### Names 
+ JProfiler (widely used)
+ YourKit Java Profiler (best , but licenced)
+ Java VisualVM (lightweight , free)
+ NetBeans Profiler (free open source)
+ Java Flight Recorder (free open source)


To enable Flight Recorder (JVM Settings)
java -X:+UnlockCommercialFeatures -XX:+FlightRecorder -- work in  java < 11

 -X:+UnlockCommercialFeatures  -- not to be used in java 11
 
 continuous mode 
 regular interval mode 
 
 Default Configuration (low over head)
 Profile Configuration (high over head)
 Custom Configuration (user defined , mixed mode)
 
 
 
