package chatDemo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
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

				new Thread(new Handler(socket)).start();

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
	// public void broadcast(String message) {
	// for (Client c: clients) {
	// c.getWriter().println(message);
	// }
	// }

	private class Handler implements Runnable
	{
		private final InputStream input;
		Socket sock;

		public Handler(Socket socket) throws IOException
		{

			input = socket.getInputStream();
			sock = socket;
		}

		@Override
		public void run()
		{
			try
			{
				while (sock.isConnected())
				{
					PrintWriter writer = new PrintWriter(
							sock.getOutputStream());
					writer.println("djfsdk");
					writer.flush();

					BufferedReader buffReader = new BufferedReader(
							new InputStreamReader(input));
					System.out.println(buffReader.readLine());
				}
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
