## String Server:
### Code:
<img width="527" alt="image" src="https://github.com/EmmaBeai/cse15l-lab-reports/assets/129473980/08468501-1c7d-4cee-86b3-ca2765355e53">
<img width="840" alt="image" src="https://github.com/EmmaBeai/cse15l-lab-reports/assets/129473980/ed1ea4b4-d64a-4a9f-a7c9-b0c8799fb682">

### Output_1: Add String "Hello"
<img width="928" alt="image" src="https://github.com/EmmaBeai/cse15l-lab-reports/assets/129473980/1ff51cdd-58d4-453e-92e4-b90e1cae4624">

when we add string "hello" i.e. make the path /add-message?s=Hello

1. Method called: the handleRequest method in the StringHandler class is called
2. Argument involved: in the handleRequest method, the relevant arguments are the URI url (this is the url that will be accessed), String chatOutput (this is a string which stores the information passed into the url) , and int index (this is the index of the information that has passed into the url)
3. Changed values:
    1. the url is changed to the url of the server + /add-message?s=Hello
    2. the String list params is assigned to value of list splitting the query, params[0] is now "s" and params[1] is now "Hello"
    3. the index is increment by 1 (it is now 1)
    4. the chatOutput is added a new String "1. Hello\n" 

### Output_2: Add String "How are you"
<img width="959" alt="image" src="https://github.com/EmmaBeai/cse15l-lab-reports/assets/129473980/ceb8328f-91ca-4c4b-9cea-e4d23f483f10">

when we add string "How are you" i.e. make the path /add-message?s=How are you

1. Method called: the handleRequest method in the StringHandler class is called
2. Argument involved: in the handleRequest method, the relevant arguments are the URI url (this is the url that will be accessed), String chatOutput (this is a string which stores the information passed into the url) , and int index (this is the index of the information that has passed into the url)
3. Changed values:
   1. the url is changed to the url of the server + /add-message?s=How are you
   2. the String list params is assigned to value of list splitting the query, params[0] is now "s" and params[1] is now "How are you"
   3. the index is increment by 1 (it is now 2)
   4. the chatOutput is added a new String "2. How are you\n" and is now "1. Hello\n2. How are you\n"


## The Keys
### private key:
The path to the private key for your SSH key for logging into ieng6 (on your computer or on the home directory of the lab computer):
<img width="462" alt="image" src="https://github.com/EmmaBeai/cse15l-lab-reports/assets/129473980/4a8959dc-b8c0-426e-a781-5f790485ed44">

### public key:
The path to the public key for your SSH key for logging into ieng6 (within your account on ieng6): 
<img width="465" alt="image" src="https://github.com/EmmaBeai/cse15l-lab-reports/assets/129473980/43af441a-20e1-4887-993b-d543917b9deb">
<img width="424" alt="image" src="https://github.com/EmmaBeai/cse15l-lab-reports/assets/129473980/7184c6c1-da80-4cd4-aa3a-72a796741445">

### terminal interaction:
<img width="820" alt="image" src="https://github.com/EmmaBeai/cse15l-lab-reports/assets/129473980/d0621b57-36e9-47d8-be59-20e0180b705b">


## Reflections
I learned about the remote server in lab in week 2. From the lab, I know that there are three remote servers assigned to our lab class and by using ssh, we can get access to the server which is assigned to us individually. Although we cannot read the thing from the server directly, we can use command like cat, ls, pwd to see the directories and files stored in our remote server. In week 3, we learn to store the key of the remote server to a .pub file on our local computer, after adding the key to that public key path file, we do not need password anymore when logging back in our remote server using our own account.





