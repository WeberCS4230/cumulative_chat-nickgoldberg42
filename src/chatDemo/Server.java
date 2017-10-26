package chatDemo;

import java.io.IOException;
import java.io.PrintWriter;
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
					PrintWriter writer = new PrintWriter(
							socket.getOutputStream());
					System.out.println(writer);

				}
			}
		} catch (IOException e)
		{
			e.printStackTrace();
		} finally
		{
			try
			{
				ss.close();
			} catch (IOException e)
			{
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args)
	{
		new Server();

	}
}
