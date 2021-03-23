import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) throws IOException {


        try (Socket socket = new Socket("localhost", 12345);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
             Scanner scanner = new Scanner(System.in);
        ) {
            System.out.println("производится вычисление N-го члена ряда Фибоначчи. " +
                    "Введите целое число:");
            int number = scanner.nextInt();
            out.write(number+"\n");
            out.flush();
            System.out.println( in.readLine());

        }
    }
}
