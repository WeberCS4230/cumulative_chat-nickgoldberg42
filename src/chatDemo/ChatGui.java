package chatDemo;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class ChatGui
{
	JTextArea textArea = new JTextArea();
	private JFrame frame;

	public void start()
	{
		ChatGui window = new ChatGui();
		window.frame.setVisible(true);

	}

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
		frame.getContentPane().add(panel, BorderLayout.CENTER);

		textArea.setLineWrap(true);
		textArea.setEditable(true);
		textArea.setBounds(10, 11, 397, 201);
		panel.add(textArea);

		JTextArea textArea_1 = new JTextArea();
		textArea_1.setBounds(10, 232, 340, 22);
		panel.add(textArea_1);

		JButton btnNewButton = new JButton("Submit");
		btnNewButton.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
				String entry = textArea_1.getText();
				textArea.append(entry + "\n");
			}
		});
		btnNewButton.setBounds(355, 228, 79, 33);
		btnNewButton.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
			}
		});
		panel.setLayout(null);
		panel.add(btnNewButton);

	}

	public void addText()
	{
		textArea.append("text" + "\n");
	}
}
