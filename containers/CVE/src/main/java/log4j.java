import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.ClassNotFoundException;
import java.net.ServerSocket;
import java.net.Socket;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class log4j {
    private static ServerSocket server;
    private static int port = 9876;
    private static final Logger logger = LogManager.getLogger("Logger");
    
    public static void main(String args[]) throws IOException, ClassNotFoundException{

        server = new ServerSocket(port);
        System.setProperty("com.sun.jndi.ldap.object.trustURLCodebase","true");

        while(true){
            System.out.println("Waiting for the client request");

            Socket socket = server.accept();

            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());

            String message = (String) ois.readObject();
            System.out.println("Message Received: " + message);
            logger.error(message);

            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());

            oos.writeObject("Hi Client "+message);

            ois.close();
            oos.close();
            socket.close();

            if(message.equalsIgnoreCase("exit")) break;
        }
        System.out.println("Shutting down Socket server!!");

        server.close();
    }
}