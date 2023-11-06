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


private key:
<img width="554" alt="image" src="https://github.com/EmmaBeai/cse15l-lab-reports/assets/129473980/3c8449e7-af37-4a34-aa34-aba39541e47a">

public key:
it seems that it is an not solvable error here with the public key:
<img width="723" alt="image" src="https://github.com/EmmaBeai/cse15l-lab-reports/assets/129473980/b6844de9-ff10-4191-b37f-3c2603155885">


