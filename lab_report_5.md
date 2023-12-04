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
        myQueue queue = new myQueue(5);

        for (int i = 1; i <= 3; i++) {
            queue.enqueue(i);
        }

        for (int i = 0; i < 2; i++) {
            System.out.println("Dequeued: " + queue.dequeue());
        }
    }
}
```
Hello, this is my implementation for queue and I was trying to implement the `enqueue` and `dequeue` method for `myQueue` class, but when I am trying to dequeue from my created list, the system output IndexOutOfBounds error like this <br>
<img width="922" alt="image" src="https://github.com/EmmaBeai/cse15l-lab-reports/assets/129473980/46d2897c-a0fb-4a1c-9538-9e8c40e56ab8"> <br>
I tried to delete the code block of 
```
for (int i = 0; i < 2; i++) {
            System.out.println("Dequeued: " + queue.dequeue());
        }
```
in the main method, and the error disappear, so I am guessing that there is some problem with my implementation in `dequeue` in the `myQueue` class. so when I call it, it throws the IndexOutOfBounds error. With said, I cannot tell where my bugs are (the method looks fine with me), but I am guessing that maybe there are some conditions failed to check? or should I return early for some specific occasions? <br><br>
> A response from a TA asking a leading question or suggesting a command to try (To be clear, you are mimicking a TA here.)

**TA** <br>
Hello, thank you for reaching out for questions. From your screenshot, yes, there is problem existing in your implementation of the code, you actually do not need to delete the code block in the main method to find that out next time, the error message indicates an issue in the dequeue method at line 31: `at myQueue.dequeue(myQueue.java:31)`<br>
There are something for you to consider for your implementation of the `dequeue` method, I will list a few leading questions:<br>
1. What are the difference between `size` and `capacity` in your implementation? I can see that you understand it quite well in the implementation of the `expandCapacity` method.
2. When you are dequeuing elements from a queue, which element (what index) do you really what it to return?
3. After dequeuing from the list, do you need any modification of the list itself?
<br>
For testing your code, I will recommend writing some JUnit tests and write your intended/expected output and what you have from your implementation. <br>
Good luck coding and still feel free to reach out if you still have any questions!<br><br>
> Another screenshot/terminal output showing what information the student got from trying that, and a clear description of what the bug is.
> 1

**TA**
