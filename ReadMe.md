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
    * Sampling(least overhead) & Instrumentation ()bytecode manipulation) ,  Hot method detection , optimize it 
- Memory : Monitor classes , GC etc
- Thread : Concerned with understanding what states threads are in and why (stop , blocked state check etc, deadlock etc)
- I/O : 

 use multiple profiler 
 
#### Types
To be updated 

#### Names 
+ JProfiler (widely used)
+ YourKit Java Profiler (best , but licenced)
+ Java VisualVM (lightweight , free) [1st step]
+ NetBeans Profiler (free open source)
+ Java Flight Recorder (free open source , production ready ,free)


To enable Flight Recorder (JVM Settings)
* `java -X:+UnlockCommercialFeatures -XX:+FlightRecorder` -- work in  java < 11

 `-XX:+UnlockCommercialFeatures`  -- not to be used in java 11
 
 - Java11 - 
 `-XX:+UnlockDiagnosticVMOptions --XX:+DebugNonSafepoints`
 
 continuous mode 
 regular interval mode 
 
 Default Configuration (low over head)
 Profile Configuration (high over head)
 Custom Configuration (user defined , mixed mode)
 
- JDK 8
``` java 
  XX:+UnlockDiagnosticVMOptions -
  XX:+DebugNonSafepoints -
  XX:+UnlockCommercialFeatures -
  XX:+FlightRecorder - 
  XX:StartingFlightRecording=settings=default|profile,maxsize=60M,maxage=1d
```  

- JDK 11
``` java 
  XX:+UnlockDiagnosticVMOptions -
  XX:+DebugNonSafepoints -
  XX:StartingFlightRecording=settings=default|profile,maxsize=60M,maxage=1d
```  

- Flight Recording Settings 
``` java
  XX:StartingFlightRecording=settings=default|profile,
                                      maxsize=60M,
                                      maxage=1d,
                                      delay=30s,        // will delay the recording after 30 sec , warmup etc 
                                      duration=10m,     // will record the application for 10 min 
                                      name=MyRecording, // name of the recording 
                                      filename=/tmp/myrecording.jfr // path for recording
                                      
``` 

 | JDK 8  | JDK11 | Remarks|
| ------------- | ------------- | ------------- |
| XX:+UnlockCommercialFeatures | http://localhost:9351/  | Y |
| Treasury Service  | http://localhost:9352/  | Y |


 
