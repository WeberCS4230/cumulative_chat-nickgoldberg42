package chatDemo;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server
{
	private ServerSocket ss;

	public Server()
	{
		try
		{
			ss = new ServerSocket(8090);

			while (true)
			{
				Socket socket = ss.accept();

				int read;
				while ((read = socket.getInputStream().read()) >= 0)
				{
					System.out.println(read);
					socket.getOutputStream().write((read + "\n").getBytes());
				}
			}
		} catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	public static void main(String[] args)
	{
		new Server();

	}
}
