package chatDemo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class ChatGui
{
	JTextArea textArea = new JTextArea(15, 30);
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

		JTextArea textArea_1 = new JTextArea();
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
		frame.add(panel);
		panel.add(btnNewButton);
		frame.setVisible(true);

	}

	public void addText()
	{
		textArea.append("text" + "\n");
	}
}
