# Lab Report 5 - Putting it All Together

## Part 1 – Debugging Scenario

> The original post from a student with a screenshot showing a symptom and a description of a guess at the bug/some sense of what the failure-inducing input is. (Don’t actually make the post! Just write the content that would go in such a post)<br>

**Student:** <br>
```
import java.util.ArrayList;
import java.util.Arrays;

public class myQueue{
    int size;
    int capacity;
    ArrayList<Integer> queue;

    public myQueue(int capacity){
        this.size = 0;
        this.capacity = capacity;
        this.queue = new ArrayList<Integer>(capacity);
    }

    public void enqueue(int value){
        expandCapacity(this.queue);
        this.queue.add(value);
        size++;
    }

    private void expandCapacity(ArrayList<Integer> que){
        if(size < capacity) return;
        ArrayList<Integer> temp = new ArrayList<>(2*this.capacity);
        for(int i: que){
            temp.add(i);
        }
        this.queue = temp;
        this.capacity *= 2;
    }

    public int dequeue(){
        return this.queue.get(capacity - 1);
    }

    public static void main(String[] args) {
        myQueue queue = new myQueue(2);

        for (int i = 1; i <= 3; i++) {
            queue.enqueue(i);
        }

        for (int i = 0; i < 2; i++) {
            System.out.println("Dequeued: " + queue.dequeue());
        }
    }
}
```
Hello, this is my implementation for queue and I was trying to implement the `enqueue` and `dequeue` method for `myQueue` class, but when I am trying to dequeue from my created list, the system output `IndexOutOfBounds` error like this <br>
<img width="922" alt="image" src="https://github.com/EmmaBeai/cse15l-lab-reports/assets/129473980/46d2897c-a0fb-4a1c-9538-9e8c40e56ab8"> <br>
I tried to delete the code block of 
```
for (int i = 0; i < 2; i++) {
            System.out.println("Dequeued: " + queue.dequeue());
        }
```
in the main method, and the error disappear, so I am guessing that there is some problem with my implementation in `dequeue` in the `myQueue` class. so when I call it, it throws the `IndexOutOfBounds` error. With said, I cannot tell where my bugs are (the method looks fine with me), but I am guessing that maybe there are some conditions failed to check? or should I return early for some specific occasions? <br><br>
> A response from a TA asking a leading question or suggesting a command to try (To be clear, you are mimicking a TA here.)

**TA** <br>
Hello, thank you for reaching out for questions. From your screenshot, yes, there is problem existing in your implementation of the code, you actually do not need to delete the code block in the main method to find that out next time, the error message indicates an issue in the dequeue method at line 31: `at myQueue.dequeue(myQueue.java:31)`<br>
There are something for you to consider for your implementation of the `dequeue` method, I will list a few leading questions:<br>
1. What are the difference between `size` and `capacity` in your implementation? I can see that you understand it quite well in the implementation of the `expandCapacity` method.
2. When you are dequeuing elements from a queue, which element (what index) do you really what it to return?
3. After dequeuing from the list, do you need any modification of the list itself?
<br> For testing your code, I will recommend writing some JUnit tests and write your intended/expected output and what you have from your implementation. <br>
Good luck coding and still feel free to reach out if you still have any questions! <br><br>

> Another screenshot/terminal output showing what information the student got from trying that, and a clear description of what the bug is.

**Student** <br>
Thank you for your help! I thinked of the three question you raised for me earilier, and, after going through each of them, my code is no buggy anymore! <br> 
Here is my modification of the code <br>
```
public int dequeue(){
        if(size == 0) return -1;
        int element = this.queue.get(0);
        this.queue.remove(0);
        size--;
        return element;
    }
```
And I think I can also trying to define the errors existing earlier with answering the three leading questions you have for me: <br>
1. That's right, the first problem within my implementation of `dequeue` raised up as I mixed up the use of the instance variable `size` and `capacity`. I intended for the instance variable `capacity` to record the size of the list, and `size` to record the number of elements already existing in the list. The first bug with my code exist when I intended to get the index of `capacity - 1`: this may return null when the list is not filled. Therefore, instead of using the value relating to the `capacity` field as index, I use `size` instead.
2. Thank you for pointing out that my understanding for the `dequeue` method is wrong, instead of removing the last element from the queue, `dequeue` actually intended for the *first in first out* policy, so it should return the element at index 0. To avoid the `IndexOutOfBounds` exception this time, I choose to let the method `return -1` to indicate an error when there is no element in the list.
3. Your third question was inspiring, too. I noticed that I cannot only use the `get` method from the imported `java.util.ArrayList` to find the element I want. After finding the intended element, I need to remove it from the list and decrease the size of the list. Then it is the time I need to return the right element.
<br> I also followed your suggestions to write a `JUnit` test to test my output instead of doing it in the `main` method.<br> Here is the code for testing: <br>


```
import static org.junit.Assert.*;
import org.junit.*;

public class myQueueTest{
    @Test
    public void testDequeue(){
        myQueue queue = new myQueue(2);
          for (int i = 1; i <= 3; i++) {
            queue.enqueue(i);
        }
        assertArrayEquals(new Integer[]{1, 2, 3},queue.queue.toArray());
        int dequeue1 = queue.dequeue();
        int dequeue2 = queue.dequeue();
        assertEquals(1, dequeue1);
        assertEquals(2, dequeue2);
        assertArrayEquals(new Integer[]{3},queue.queue.toArray());
    }
}
```


<br> In the above test, I first tested again to make sure the `enqueue` method works well so that I have three elements in the list to start with (in this case, they are 1, 2, and 3). And I start to remove the *1* and *2* using the `dequeue` method, I use `assertEquals` to check if I was removing the right element and `assertArrayEquals` to check the resulting array. From my testing, my implementation works well. <br> Thanks again!!<br> I think it is also worth showing my output for running the test in following screenshot.<br>
<img width="285" alt="image" src="https://github.com/EmmaBeai/cse15l-lab-reports/assets/129473980/68e46582-5cca-4ec4-9e7e-e9112d75393d"><br> And here is my code within the `test.sh` file 

```
javac -cp .:lib/hamcrest-core-1.3.jar:lib/junit-4.13.2.jar *.java
java -cp .:lib/hamcrest-core-1.3.jar:lib/junit-4.13.2.jar org.junit.runner.JUnitCore myQueueTest
```

**Some details that *may* be left out in response**
1. The file & directory structure needed <br>
```
-lib 
    -hamcrest-core-1.3.jar
    -junit-4.13.2.jar 
-myQueue.class
-myQueue.java 
-myQueueTest.class 
-myQueueTest.java 
-test.sh
```
<br>
2. The contents of each file before fixing the bug <br>

from the `myQueue.java` file: <br>

```
import java.util.ArrayList;
import java.util.Arrays;

public class myQueue{
    int size;
    int capacity;
    ArrayList<Integer> queue;

    public myQueue(int capacity){
        this.size = 0;
        this.capacity = capacity;
        this.queue = new ArrayList<Integer>(capacity);
    }

    public void enqueue(int value){
        expandCapacity(this.queue);
        this.queue.add(value);
        size++;
    }

    private void expandCapacity(ArrayList<Integer> que){
        if(size < capacity) return;
        ArrayList<Integer> temp = new ArrayList<>(2*this.capacity);
        for(int i: que){
            temp.add(i);
        }
        this.queue = temp;
        this.capacity *= 2;
    }

    public int dequeue(){
        return this.queue.get(capacity - 1);
    }

    public static void main(String[] args) {
        myQueue queue = new myQueue(2);

        for (int i = 1; i <= 3; i++) {
            queue.enqueue(i);
        }

        for (int i = 0; i < 2; i++) {
            System.out.println("Dequeued: " + queue.dequeue());
        }
    }
}
```

3. The full command line (or lines) you ran to trigger the bug

```
public int dequeue(){
        return this.queue.get(capacity - 1);
    }

    public static void main(String[] args) {
        myQueue queue = new myQueue(2);

        for (int i = 1; i <= 3; i++) {
            queue.enqueue(i);
        }

        for (int i = 0; i < 2; i++) {
            System.out.println("Dequeued: " + queue.dequeue());
        }
    }
```

4. A description of what to edit to fix the bug: see student's last response.

## Part 2 - Reflection:
> In a couple of sentences, describe something you learned from your lab experience in the second half of this quarter that you didn’t know before. It could be a technical topic we addressed specifically, something cool you found out on your own building on labs, something you learned from a tutor or classmate, and so on. It doesn’t have to be specifically related to a lab writeup, we just want to hear about cool things you learned!

<br><br>
*in bullet point* <br>
1. Lab experience: One of the cool thing I learned from the 2<sup>nd</sup> half of the labs are collaboration with my classmate. There are more collab task within the lab session. I can still remember that in week 8's lab, we are asked to work in group to figure out the `git` command since it is too new to us. When discussing in groups, me and my groupmate split up the roles, one testing the code and one doing the research from online resources or reach out available tutors from class. Using this technique, some thing that was initially confusing and new to us becomes solvable. <br>
2. New Topic Learned <br>
   a. something cool:  I have to mention it again that one of the coolest thing I learned from labs was from week 7, the `vim`. Although we were asked to only spent 20 minutes reading the tutorial of `vim` in class, I acutally spend more time outside class to finish the whole tutorial of `vim`, and I am a pretty good `vim` user now. I love the feeling of saving a lot of time by using `vim`.<br>
   b. technical topic: One of the most confusing topic for me is the `jdb` thing from week 8's lab. Although I learned how to use the `run`, `stop`, `javac -g`, and `suspend` command from class, it is still confusing when doing it on the computer, that is probably a reason why I did not get a full pass on the last skill demo. I am still practicing this part right now and searching from more tutorial from online resources and I am also re-reading the lecture handout. <br>

 *in one paragraph ver*
 <br>
One of the cool thing I learned from the 2<sup>nd</sup> half of the labs are collaboration with my classmate. There are more collab task within the lab session. I can still remember that in week 8's lab, we are asked to work in group to figure out the `git` command since it is too new to us. When discussing in groups, me and my groupmate split up the roles, one testing the code and one doing the research from online resources or reach out available tutors from class. Using this technique, some thing that was initially confusing and new to us becomes solvable. There are also some topics that are impressing for me. I have to mention it again that one of the coolest thing I learned from labs was from week 7, the `vim`. Although we were asked to only spent 20 minutes reading the tutorial of `vim` in class, I acutally spend more time outside class to finish the whole tutorial of `vim`, and I am a pretty good `vim` user now. I love the feeling of saving a lot of time by using `vim`. One of the most confusing topic for me is the `jdb` thing from week 8's lab. Although I learned how to use the `run`, `stop`, `javac -g`, and `suspend` command from class, it is still confusing when doing it on the computer, that is probably a reason why I did not get a full pass on the last skill demo. I am still practicing this part right now and searching from more tutorial from online resources and I am also re-reading the lecture handout.



