package chatDemo;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class Client
{

	public Client(String ip)
	{

		Socket socket = null;
		try
		{
			socket = new Socket(ip, 8090);

			new Thread(new Handler(socket.getInputStream())).start();

			socket.getOutputStream().write(new byte[] { 3 });
			socket.getOutputStream().flush();
		} catch (IOException e)
		{
			e.printStackTrace();
		} finally
		{
			try
			{
				socket.getInputStream().close();
			} catch (IOException e)
			{
				// shutting down
			}

			try
			{
				socket.getOutputStream().close();
			} catch (IOException e)
			{
				// shutting down
			}

			try
			{
				socket.close();
			} catch (IOException e)
			{
				// shutting down
			}
		}
	}

	public static void main(String[] args)
	{
		new Client("127.0.0.1");

	}

	private class Handler implements Runnable
	{
		private final InputStream input;

		public Handler(InputStream is)
		{
			input = is;
		}

		@Override
		public void run()
		{
			for (int i = 0; i < 100; i++)
			{
				try
				{
					System.out.println(input.read());
				} catch (IOException e)
				{
					e.printStackTrace();
				}
			}

		}
	}

}
