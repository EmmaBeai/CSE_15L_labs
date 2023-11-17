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




