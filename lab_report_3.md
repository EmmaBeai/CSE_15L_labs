# Bugs:
Part 1 - Bugs
Choose one of the bugs from week 4’s lab.

Provide:

A failure-inducing input for the buggy program, as a JUnit test and any associated code (write it as a code block in Markdown)
'''
import static org.junit.Assert.*;
import org.junit.*;

public class LinkedListTests {
	@Test
    public void testAppend(){
        LinkedList l1 = new LinkedList();
        l1.append(1);
        l1.append(2);
        l1.append(3);
        assertEquals("1 2 3", l1.toString());
        assertEquals(3, l1.length());

    }
}
'''
<img width="944" alt="image" src="https://github.com/EmmaBeai/cse15l-lab-reports/assets/129473980/687fce32-5c50-4d35-a1fa-f790c4c42e5d">
An input that doesn’t induce a failure, as a JUnit test and any associated code (write it as a code block in Markdown)
'''
import static org.junit.Assert.*;
import org.junit.*;

public class LinkedListTests {
	@Test
    public void testAppend(){
        LinkedList l1 = new LinkedList();
        l1.append(1);
        assertEquals("1 ", l1.toString());
        assertEquals(1, l1.length());

    }
}
'''
The symptom, as the output of running the tests (provide it as a screenshot of running JUnit with at least the two inputs above)
The bug, as the before-and-after code change required to fix it (as two code blocks in Markdown)
Briefly describe why the fix addresses the issue.




# Researching Commands
Consider the commands less, find, and grep. Choose one of them. Online, find 4 interesting command-line options or alternate ways to use the command you chose. To find information about the commands, a simple Web search like “find command-line options” will probably give decent results. There is also a built-in command on many systems called man (short for “manual”) that displays information about commands; you can use man grep, for example, to see a long listing of information about how grep works. Also consider asking ChatGPT!

For example, we saw the -name option for find in class. For each of those options, give 2 examples of using it on files and directories from ./technical. Show each example as a code block that shows the command and its output, and write a sentence or two about what it’s doing and why it’s useful.

That makes 8 total examples, all focused on a single command. There should be two examples each for four different command-line options. Many commands like these have pretty sophisticated behavior possible – it can take years to be exposed to and learn all of the possible tricks and inner workings.

Along with each option/mode you show, cite your source for how you found out about it as a URL or a description of where you found it. See the syllabus on Academic Integrity and how to cite sources like ChatGPT for this class.
