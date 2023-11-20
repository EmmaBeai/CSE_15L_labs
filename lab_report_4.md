# Lab 4
## Steps 4: Log into ieng6
<img width="566" alt="image" src="https://github.com/EmmaBeai/cse15l-lab-reports/assets/129473980/e2959968-dfb4-4376-aa54-c06aca25941e">

Keys pressed:

`ssh` `cs15lfa23@ieng6-202.ucsd.edu` `<enter>`

Key pressed explanation:

This is the first step in this lab report since this is a reproduction from the lab work we did last week. So I directly ty.pe in the necessary command for this command. And I am login into ieng6-202 as the 201 server not function normally.


## Step 5: Clone your fork of the repository from your Github account (using the SSH URL)
<img width="537" alt="image" src="https://github.com/EmmaBeai/cse15l-lab-reports/assets/129473980/ad076bd4-3d59-4eef-a527-bc48b3c2a206">

Keys pressed:

1. in the repository page:

`<ctrl>` `c` on the `git@github.com:EmmaBeai/lab7.git`

2. in the terminal:

`git` `clone` `<ctrl>` `v` `<enter>`

Key pressed explanation:

to save time, I choose to copy the ssh clone link from my repository, and uses the command `git` `clone` on the terminal (which has been logined into the ieng6-202) and paste the result to clone the repository


## Step 6: Run the tests, demonstrating that they fail
<img width="573" alt="image" src="https://github.com/EmmaBeai/cse15l-lab-reports/assets/129473980/de34f6ca-92c1-4757-81f7-f7bb56fb4a43">

Keys pressed:

1. `cd` `./l` `<tab>` `<enter>`
2. `bash`  ``./t` `<tab>` `<enter>`

Key pressed explanation:

The command for running the test is in `test.sh` file, so we only need to `bash` the file to run the tests. However, the first line in the `test.sh` file is: `javac -cp .:lib/hamcrest-core-1.3.jar:lib/junit-4.13.2.jar *.java`, indicating the `.sh` file is compling file in current working directory, so we need to use command `cd` to change the working directory before bashing the `.sh` file. As terminal fills the needed words for us and there is no other directories or files start with "l" in the home directory and no other directories or files starts with "t" in the `~/lab7` directory. Typing out `./` with their first letter follows with a `<tab>` key will direct us to the correct place



## Step 7: Edit the code file to fix the failing test

Keys pressed with explanation:

1. `vim` `./L` `<tab>` `.j` `<enter>`

we press the command `vim` and the file needed to be edited. this time, it is `ListExamples.java`, as there are two files start with letter "L", when we pressed `./L` with `<tab>`, the auto fill only filled in "ListExamples" for us, when we input `.j` and pressed `<tab>` again, the auto fill filled the whole name of `ListExamples.java` for us. we then pressed `<enter>` to go into the vim edit mode.

2. `44` `G`

44 is the line that needs to be change, and `G` leads us to line 44 if we type `44` and then type `G`

3. `e` `r` `2`

we uses `e` to reach the last string in the string "index1" which is "1" (1 needs to be changed to 2 in this case). then we uses `r` `2` to replace the string "1" to string "2"

5. `:wq` `<enter>`

we uses `:wq` to save and exit the file (`w` for saving and `q` for quitting). we uses `<enter>` to run the process

## Step 8: Run the tests, demonstrating that they now succeed
<img width="451" alt="image" src="https://github.com/EmmaBeai/cse15l-lab-reports/assets/129473980/480fa0ba-e999-46f9-b5f7-4c522d2864d1">

Keys pressed with explanation:

`<up>` `<up>` `<enter>`

we just runned the `bash` command needed for this step in step 6 (2 steps before), so we can simply press `<up>` to retrive our input. And we pressed `<enter>` to let the command run.


## Step 9: Commit and push the resulting change to your Github account (you can pick any commit message!)

<img width="485" alt="image" src="https://github.com/EmmaBeai/cse15l-lab-reports/assets/129473980/867837bd-722d-4213-b2f9-6d9a981645b9">

<img width="506" alt="image" src="https://github.com/EmmaBeai/cse15l-lab-reports/assets/129473980/c2c77c96-939f-4ba1-b47e-28101a79d3e3">

<img width="499" alt="image" src="https://github.com/EmmaBeai/cse15l-lab-reports/assets/129473980/a19be8ce-7ea5-4ddc-8f78-f7b3345bca8f">

key pressed and explanation:

1. `git` `add` `./L` `<tab>` `.j` `<enter>`

use `git` `add` to add `ListExamples.java`, we can use short cut using `<tab>`

2. `git` `commit` `-m` `"changes"`

use `git` `commit` `-m` and set messages to "changes"

3. `git` `push`

use `git` `push` to push the changes to the directory
