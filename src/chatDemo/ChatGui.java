package chatDemo;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class ChatGui
{
	JTextArea textArea = new JTextArea();
	JTextArea textEntry = new JTextArea();
	private JFrame frame;

	public ChatGui()
	{
		initialize();
	}

	public void initialize()
	{
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel panel = new JPanel();

		panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));

		textArea.setLineWrap(true);
		textArea.setEditable(true);
		panel.add(textArea);

		JScrollPane scroll = new JScrollPane(textArea);
		panel.add(scroll);

		textEntry.setFocusable(true);
		textEntry.addKeyListener(new KeyAdapter()
		{
			@Override
			public void keyPressed(KeyEvent e)
			{

				if (e.getKeyCode() == KeyEvent.VK_ENTER && e.isControlDown())
				{
					String entry = textEntry.getText();
					textArea.append(entry + "\n");

					JScrollBar vertical = scroll.getVerticalScrollBar();
					vertical.setValue(vertical.getMaximum());

					textEntry.setText("");
				}
			}
		});
		panel.add(textEntry);

		JButton submitButton = new JButton("Submit");
		submitButton.addMouseListener(new MouseAdapter()
		{

			@Override
			public void mouseClicked(MouseEvent e)
			{
				String entry = textEntry.getText();
				textArea.append(entry + "\n");

				JScrollBar vertical = scroll.getVerticalScrollBar();
				vertical.setValue(vertical.getMaximum());

				textEntry.setText("");
			}

		});

		frame.getContentPane().add(panel);
		panel.add(submitButton);
		frame.setVisible(true);

	}

	public void addText(String text)
	{
		textArea.append(text + "\n");

	}
}
