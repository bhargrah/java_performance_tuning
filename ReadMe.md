# Java Performance Tuning Guide

This repo will have all the tools and guide that are useful for debugging any java process. Aim  is to document all the commands and create a single repository which can be used as reference guide for memory analysis.

- [Performace Testing Tools](#performace-testing-tools)
- [Basic Commands](#basic-commands)
- [Profiler Types](#profiler-types)
- [Profiler Tools Names](#profiler-tools-names)
- [Java Mission Control](#java-mission-control)
- [JVM Visual VM](#jvm-visual-vm)

## Performace Testing Tools - 
* JMeter (Installation Link - https://visualvm.github.io/download.html)

## Basic Commands - 
| Sr. No|Commands|Use|
| ------------- | ------------- | ------------- |
| 1 | jps | list down java process |
| 2 | jinfo| ist down all info of process |
| 3 | jstat | status of memory allocation (jstat -gcutil 44525) |
| 4 | jmap| used for memory dump |
| 5 | jcmd | profiling tool (command line , combination of 2,3,4) |
| 6 | jmc| missing control , GUI app |

## Profiler Types
### CPU Profiler: 
- Concerned with the frequenscy and lenght of time of method execution  
    * Sampling(least overhead) & Instrumentation ()bytecode manipulation) ,  Hot method detection , optimize it 
### Memory Profiler: 
- Monitor classes , GC etc
### Thread Profiler: 
- Concerned with understanding what states threads are in and why (stop , blocked state check etc, deadlock etc)
### I/O Profiler: 

 use multiple profiler 
 
## Profiler Tools Names 
| Sr. No|Profilers Name|Link|
| ------------- | ------------- | ------------- |
|1|Java VisualVM|Free , bundeld with SDK|
|2|Java Flight Recorder|Free open source , production ready|
|3|NetBeans Profiler|Free|
|4|YourKit Java Profiler|licenced|
|5|JProfiler|licenced|


## Java Mission Control
### Mode Types
 -  Continuous mode 
 -  Interval mode 

### Configuration Types
 * Default Configuration (low over head , sample command below)
 * Profile Configuration (high over head)
 * Custom Configuration (user defined , mixed mode)
 
- JDK 8 ~ 10
``` java 
  XX:+UnlockDiagnosticVMOptions -
  XX:+DebugNonSafepoints -
  XX:+UnlockCommercialFeatures -
  XX:+FlightRecorder - 
  XX:StartingFlightRecording=settings=default|profile,maxsize=60M,maxage=1d
```  

- JDK 11 (few flags depricated)
``` java 
  XX:+UnlockDiagnosticVMOptions -
  XX:+DebugNonSafepoints -
  XX:StartingFlightRecording=settings=default|profile,maxsize=60M,maxage=1d
```  

- Flight Recording Settings 
``` java
  XX:StartingFlightRecording=
                    settings=default|profile,
                             maxsize=60M,
                             maxage=1d,
                             delay=30s,        // will delay the recording after 30 sec , warmup etc 
                             duration=10m,     // will record the application for 10 min 
                             name=MyRecording, // name of the recording 
                             filename=/tmp/myrecording.jfr // path for recording
                                      
``` 

## JVM Visual VM
