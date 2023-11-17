# Part I
## Task 1:
A failure-inducing input for the buggy program, as a JUnit test and any associated code (write it as a code block in Markdown)
```
@Test 
public void testReverseInPlace() {
    int[] input1 = {1, 2, 3 };
    ArrayExamples.reverseInPlace(input1);
    assertArrayEquals(new int[]{ 3,2,1 }, input1);
}
```
This will cause an error for the code block (below) in ArrayExamples.java
Code with bug: (this code overwrites the array incorrectly)
```
static void reverseInPlace(int[] arr) {
    for(int i = 0; i < arr.length; i += 1) {
      arr[i] = arr[arr.length - i - 1];
    }
  }
```

## Task 2:
An input that doesn't induce a failure, as a JUnit test and any associated code (write it as a code block in Markdown):
```
@Test 
public void testReverseInPlace() {
    int[] input1 = {3};
    ArrayExamples.reverseInPlace(input1);
    assertArrayEquals(new int[]{3}, input1);
}
```
The above Junit Test is testing the code block (below) in ArrayExamples.java
```
static void reverseInPlace(int[] arr) {
    for(int i = 0; i < arr.length; i += 1) {
      arr[i] = arr[arr.length - i - 1];
    }
  }
```
The code block above, since the bug comes from incorrectly overwritting the things in the array, but for array that only have one input, it is overwriting the original input over itself, which does not give any changes to the array, which suffies the condition of reversing the array of single input

## Task 3:
The symptom, as the output of running the tests (provide it as a screenshot of running JUnit with at least the two inputs above)
<img width="1007" alt="image" src="https://github.com/EmmaBeai/cse15l-lab-reports/assets/129473980/31c2ca75-b8ed-4f3d-914d-e8f2af83a9e3">


## Task 4:
The bug, as the before-and-after code change required to fix it (as two code blocks in Markdown)
Briefly describe why the fix addresses the issue.

This is the "Before Code" (buggy one from ArrayExamples.java):
```
static void reverseInPlace(int[] arr) {
    for(int i = 0; i < arr.length; i += 1) {
      arr[i] = arr[arr.length - i - 1];
    }
  }
```
This is the "After Fixing Code":
```
static void reverseInPlace(int[] arr) {
    for (int i = 0; i < arr.length / 2; i++) {
        int temp = arr[i];
        arr[i] = arr[arr.length - i - 1];
        arr[arr.length - i - 1] = temp;
    }
```
Reasoning for why the fix address the issue:
The buggy code has bug since it incorrectly overwrites the elements in the provided array. In each loop i, the element in position i got replaced by the element in position length-i-1, but the element in position i is never stored. Therefore, I fix the code by swapping the elements in position i and position length-i-1, and considering that up to position length/2, every element in the array has been swapped once, and repeating this process will undo the swapping, the for loop thus ends at i < arr.length/2



# Part II
The command I picked for researching in part II is command `find`
## first option:
`find -type t`
from the manual (using man find)
```
-type t
             True if the file is of the specified type.  Possible file types are as follows:

             b       block special
             c       character special
             d       directory
             f       regular file
             l       symbolic link
             p       FIFO
             s       socket
```
### example 1:
<img width="523" alt="image" src="https://github.com/EmmaBeai/cse15l-lab-reports/assets/129473980/7c954ad5-9c30-4f66-b7fd-6831d4bad65e">
displays all file in the /technical/biomed folder since this finding command only asked for the type to be file but not specific name of file.

### example 2:
<img width="463" alt="image" src="https://github.com/EmmaBeai/cse15l-lab-reports/assets/129473980/e6b41a37-5772-4880-a76c-f54907952cc2">
displays all the directory under the given path.


## second option:
`find -name`
from the manual (using man find)
```
-name pattern
    True if the last component of the pathname being examined matches pattern.  Special shell pattern matching characters
    (“[”, “]”, “*”, and “?”) may be used as part of pattern.  These characters may be matched explicitly by escaping them
    with a backslash (“\”).
```

### example 1:
<img width="573" alt="image" src="https://github.com/EmmaBeai/cse15l-lab-reports/assets/129473980/08272894-100e-4bf7-adc9-30a8e0bb215c">
this command displays all the txt file under the /technical/biomed with "1471" containd in the file name

### example 2:

