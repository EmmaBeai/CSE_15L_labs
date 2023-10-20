# Lab Report 1

## The `cd` command
<img width="484" alt="image" src="https://github.com/EmmaBeai/cse15l-lab-reports/assets/129473980/16942337-a928-4bc3-a05f-be0a554397c1">


### `cd` with no argument:
1. Working Directory: /home
2. Output (result): the result is not visible, and you will be "directed" to the /home directory, as you are already in the /home directory, this commend will have no impact

### `cd`with a working directory as argument:
1. Working Directory: /home
2. Output (result): this commend will change the current working directory from /home to /home/lecture1

### `cd` with a file name as argument
1. Working Directory: /home
2. Output (result): this commend will encounter an error, as we cannot set a file as working directory


## The `ls` command
<img width="661" alt="image" src="https://github.com/EmmaBeai/cse15l-lab-reports/assets/129473980/bbf04ef0-69f0-439d-923c-745a344e3b92">

### `ls` with no argument:
1. Working Directory: /home
2. Output (result): the "ls" with no argument list the files and folders in the current working directory, which is the /home directory

### `ls`with a working directory (in this case /home/lecture1) as argument:
1. Working Directory: /home
2. Output (result): the "ls" with a working directory named "/home/lecture1" list the files and folders in the lecture1 directory

### `ls` with a file name (the path for the file is /home/lecture1/Hello.java) as argument:
1. Working Directory: /home/lecture1
2. Output (result): Since Hello.java is a single file, the listing of files and folders in /home/lecture1/Hello.java is just Hello.java itself.


## The `cat` command
<img width="459" alt="image" src="https://github.com/EmmaBeai/cse15l-lab-reports/assets/129473980/536d5c4b-a2d0-443b-97b4-4f0aba7c314f">

### `cat` with no argument:
1. Working Directory: /home
2. Output (result): the `cat` command is going to record your typing and copy them, this command will not end automatically without users interfere (in this case using Ctrl+C to end the command) 

### `cat` with a working directory (in this case /home/lecture1) as argument:
1. Working Directory: /home
2. Output (result): the `cat` command is encountering with an error here as the method is designed to print the contents of (one or more) files, but /home/lecture1 is not a file

### `cat` with a file name (the path for the file is /home/lecture1/README) as argument:
1. Working Directory: /home
2. Output (result): the `cat` command here prints out the content in the README file when provided it the correct path to that file.
