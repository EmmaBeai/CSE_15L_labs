import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;

class Handler implements URLHandler {
    ArrayList<String> str = new ArrayList<String>();
  
    public String handleRequest(URI url) {
        if (url.getPath().equals("/")) {
            return String.format("String: %s", str.toString());
        } else {
            if (url.getPath().contains("/add")) {
                String[] parameters = url.getQuery().split("=");
                if (parameters[0].equals("s")) {
                    int paraLen = parameters.length;
                    for (int i = 1; i < paraLen; i++) {
                        str.add(parameters[i]);
                    }
                    return String.format("String appended by %s! It's now %s", str, str.toString());
                }
            }
            return "404 Not Found!";
        }
    }
}

class WebServer {
    public static void main(String[] args) throws IOException {
        if(args.length == 0){
            System.out.println("Missing port number! Try any number between 1024 to 49151");
            return;
        }

        int port = Integer.parseInt(args[0]);

        Server.start(port, new Handler());
    }
}
