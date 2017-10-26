package chatDemo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client
{
	ChatGui chat;

	public Client(String ip, ChatGui cg)
			throws UnknownHostException, IOException
	{
		chat = cg;

		Socket socket = new Socket(ip, 8090);

		new Thread(new Handler(socket)).start();
	}

	private class Handler implements Runnable
	{
		Socket sock;
		BufferedReader buffReader;
		PrintWriter writer;

		public Handler(Socket socket) throws IOException
		{
			sock = socket;

			buffReader = new BufferedReader(
					new InputStreamReader(sock.getInputStream()));
			writer = new PrintWriter(sock.getOutputStream());
		}

		@Override
		public void run()
		{

			while (sock.isConnected())
			{
				try
				{
					addToChat(buffReader.readLine());

					writer.println("djfsdk");
					writer.flush();
				} catch (IOException e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	// public static void main(String[] args)
	// throws UnknownHostException, IOException
	// {
	// new Client("127.0.0.1", );
	// }

	public void addToChat(String in)
	{
		chat.addText(in);
	}

}
