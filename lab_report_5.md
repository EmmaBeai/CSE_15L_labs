# Lab Report 5 - Putting it All Together

## Part 1 – Debugging Scenario

> The original post from a student with a screenshot showing a symptom and a description of a guess at the bug/some sense of what the failure-inducing input is. (Don’t actually make the post! Just write the content that would go in such a post)<br>

**Student:**

I am having trouble with the `reverseOrder(ArrayList<Integer> list)` in the MyList.java file. when I call the `reverseOrder` method, the output does not work as expected.<br>
```
public void reverseOrder(ArrayList<Integer> list) {
        for (int i = list.size() - 1; i >= 0; i--) {
            list.set(list.size()-1-i, list.get(i));
        }
    }
```

Above is my code snippet for the `reverseOrder` method, I am guessing that the bug with this code exists inside the for loop. (Maybe I am not correctly updating the element in the list?), but I did reverse the order: I swap the order i in the loop with its corresponding list.size()-1-i and there is no `IndexOutOfBoundsException` came up for my code.<br><br>
> A response from a TA asking a leading question or suggesting a command to try (To be clear, you are mimicking a TA here.)<br>

**TA**

Hi! You are on the right track in identifying the issue in your `reverseOrder` method.<br>
And here is the leading question for you to consider: When you do the swap, you need to consider exactly which elements in the list you are swapping<br>
As suggestion, try to initialize your code using `ArrayList` and `add` method to add some element in your list. Then, perform your `reverseOrder` method on this list to see how the elements are really swapping in your code.<br><br>

>
**Student**
