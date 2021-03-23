import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {


        try (ServerSocket serverSocket = new ServerSocket(12345);
             Socket socket = serverSocket.accept();
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
        ) {
            int num = Integer.parseInt(in.readLine());

            int n = calculate(num);
            out.write(num+ " член ряда Фибоначчи = " + n + "\n");
            out.flush();


        }
    }

    public static int calculate(int num) {
        int f1 = 1;
        int f2 = 1;
        for (int i = 2; i < num; i++) {
            int f3 = f1 + f2;
            f1 = f2;
            f2 = f3;

        }
        return f2;
    }
}
