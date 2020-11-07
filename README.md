# Resolved Tasks
Some completed here, some in another project and copied here for more comfortable see it
- [Resolved Tasks](##resolved-tasks)
    - [Calculator](#calculator)
        - [Math Calculator](#math-calculator)
        - [Hash Calculator](#hash-calculator)
    - [Circular Buffer](#circular-buffer)
    - [Hospital](#hospital)
     

      
---

## Calculator
Here I've created realization for **Math Calculator** and **Hash Calculator**

### Math Calculator
In Math Calculator you can input any line with math operations and get output with the correct answer.

To run this program you need to run `MathRunner.java`. 

Here is an example of code work:

```
12:28:26 [main] INFO  org.training.calculator.MathRunner - Enter an expression:
2+6+6*8-5
12:28:39 [main] INFO  org.training.calculator.MathRunner - Result: 51
```

---

### Hash Calculator
In Hash Calculator you can encode any `md5` strings and decode low case `md5` stings.
Decode implemented with Threads. This code doesn't have a dump for any hash results, every time when you start decode string, the program brute force all possible combinations of low case English letters from `a` to infinity.

To run this program you need to run `HashRunner.java`.

For encode your string you need to input:
```
encode titkos
```
For decode your string you need to input:
```
decode 4fd0101ea3d0f5abbe296ef97f47afec
```

Here is an example of decode work:
```
12:41:52 [main] INFO  org.training.calculator.HashRunner - Enter an expression: 
decode 4fd0101ea3d0f5abbe296ef97f47afec
12:41:55 [main] INFO  org.training.calculator.operations.hash.MD5HashOperations - [start=0, end=1]
12:57:22 [main] INFO  org.training.calculator.operations.hash.MD5HashOperations - [start=1, end=3]
...
12:41:55 [main] INFO  org.training.calculator.operations.hash.MD5HashOperations - [start=23, end=25]
12:42:03 [pool-2-thread-14] INFO  org.training.calculator.operations.hash.MD5HashOperations - Hash found for 8.22 sec
12:42:03 [main] INFO  org.training.calculator.HashRunner - Result: titkos
```

---

## Circular Buffer
This is my realisation for **Circular Buffer**. This buffer can contain any objects and have fixed-size buffer as if it were connected end-to-end. This structure lends itself easily to buffering data streams.

For create new Circular Buffer input (where `10` is length of buffer):
```java
 CircularBuffer<String> circularBuffer2 = new CircularBuffer<>(10);
```
---
## Hospital
This is my realisation for this test Task:

The responsibility of the Quarantine object is to simulate diseases on a group of patients.
It is initialized with a list of patients' health status, separated by a comma.
Each health status is described by one or more characters
(in the test below, we will always have only one disease / patient)

The characters mean:
`H : Healthy`
`F : Fever`
`D : Diabetes`
`T : Tuberculosis`

Quarantine provides medicines to the patients, but can not target a specific group of patient.
The same medicines are always given to **all** the patients.

Then Quarantine can provide a report with this format:
`F:1 H:2 D:0 T:1 X:3`

Report give the number of patients that have the given disease.
`X means Dead`
