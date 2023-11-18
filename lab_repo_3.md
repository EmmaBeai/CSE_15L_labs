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
## First Option: `find -type t`
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
#### Example 1: `find ./technical/biomed -type f`
<img width="523" alt="image" src="https://github.com/EmmaBeai/cse15l-lab-reports/assets/129473980/7c954ad5-9c30-4f66-b7fd-6831d4bad65e">

displays all file in the `/technical/biomed` folder since this finding command only asked for the type to be file but not specific name of file.

#### Example 2: `find ./technical -type d`
<img width="463" alt="image" src="https://github.com/EmmaBeai/cse15l-lab-reports/assets/129473980/e6b41a37-5772-4880-a76c-f54907952cc2">

displays all the directory under the given path.


## Second Option: `find -name`
from the manual (using man find)

```
-name pattern
    True if the last component of the pathname being examined matches pattern.  Special shell pattern matching characters
    (“[”, “]”, “*”, and “?”) may be used as part of pattern.  These characters may be matched explicitly by escaping them
    with a backslash (“\”).
```

#### Example 1: `find ./technical/biomed -name "*1471*.txt"`
<img width="573" alt="image" src="https://github.com/EmmaBeai/cse15l-lab-reports/assets/129473980/08272894-100e-4bf7-adc9-30a8e0bb215c">

this command displays all the txt file under the `/technical/biomed` with "1471" containd in the file name


#### Example 2: `find ./technical/biomed  -name "*rr*.txt" -o -name "*cc*.txt"`
<img width="729" alt="image" src="https://github.com/EmmaBeai/cse15l-lab-reports/assets/129473980/82ba6b98-ba31-4866-80da-140753bc8784">

this command display the result using `-name` as well as the `-o` after the command `find`. the `-o` after the `-name` helps to find all .txt file in the `/technical/biomed` directory with name containing "rr" or "cc" in the file name. 



## Third Option: `find -delete`
from the manual (using man find)
···
-delete
    Delete found files and/or directories.  Always returns true.  This executes from the current working directory as find
    recurses down the tree.  It will not attempt to delete a filename with a “/” character in its pathname relative to “.”
    for security reasons.  Depth-first traversal processing is implied by this option.  The -delete primary will fail to
    delete a directory if it is not empty.  Following symlinks is incompatible with this option.
···

#### Example 1: `find ./technical/government/Media -iname "*law*.txt" -delete`
<img width="715" alt="image" src="https://github.com/EmmaBeai/cse15l-lab-reports/assets/129473980/6511d821-3dd3-4877-b4b3-27e73e1bc537">

Considering the difficulty to display the result of delete directly, I use three command to show the result of deletion:

1. `find ./technical/government/Media -iname "*law*.txt"`: (the -iname finds all file with name "law" contained by considering both the upper or lower letters). We use this line to show what was originally in the `./technical/government/Media` with desired name
2. `find ./technical/government/Media -iname "*law*.txt" -delete`: we then use the command containing `-delete` to delete all the files display in step one
3. `find ./technical/government/Media -iname "*law*.txt"`: we call step one again to see if we sucessfully delete the files, this time it does not show up anything, means the deletion is sucessful.


#### Example 2: `find ./technical -name "emptyDirectoryForTesting" -delete`
<img width="688" alt="image" src="https://github.com/EmmaBeai/cse15l-lab-reports/assets/129473980/7b1348f7-5b91-499c-bac0-593b681ff373">

Although `rm -d` command is more common when we need to delete a directory, we can still use the `-delete` option after the `find` command to delete empty directories. As there is no empty directories originally in the `./technical directory`, we need to make one to test this code

1. `mkdir ./technical/emptyDirectoryForTesting`: make an empty directory in the ./technical directory
2. `ls ./technical`: check existing files and directories under the ./technical directory, we can see the emptyDirectoryForTesting exist.
3. `find ./technical -name "emptyDirectoryForTesting" -delete`: use this command to delete it
4. `ls ./technical`: verify it again, we can see that it is disappeared.


## Fourth Option: `find -regex`
from the manual (using man find)
···
-regex pattern
    True if the whole path of the file matches pattern using regular expression.  To match a file named “./foo/xyzzy”, you
    can use the regular expression “.*/[xyz]*” or “.*/foo/.*”, but not “xyzzy” or “/foo/”.
···

#### Example 1: `find ./technical/plos -type f ! -regex '.*pmed.*'`
<img width="631" alt="image" src="https://github.com/EmmaBeai/cse15l-lab-reports/assets/129473980/df54dd14-45cf-4268-b7a8-3ba005506d3b">

the directory `./technical/plos` originally contains .txt file contains string either "journal" or "pmed" indicating the source of the .txt file. we use the negation of the `-regex` method here to find the file which does NOT contains the string "pmed" in its name


#### Example 2: `find ./technical/biomed -type f ! -regex ".*[34].*"`
<img width="721" alt="image" src="https://github.com/EmmaBeai/cse15l-lab-reports/assets/129473980/e8f68fac-73de-4018-9087-a20f52486779">

This one is a bit tricky if only looking at the inbuilt manual for `find -regex`, the manual does not sepcify the use for the format ".*[]*.", so I asked ChatGPT for a more detailed answer:

<img width="876" alt="image" src="https://github.com/EmmaBeai/cse15l-lab-reports/assets/129473980/831b4fed-51b2-43bd-9208-6b7e9bf7076e">

According to ChatGPT, if I want to find file names excluding the file containing either 3 or 4, I need to use ".*[34]*." to do the task. Therefore, the ".*[]*." serves as a list of elements that need to be noticed by the `-regex` method if showing up in the name.

As above mention, this command line find all files under `./technical/biomed` except for those contains integer 3 or 4 within the file name.

