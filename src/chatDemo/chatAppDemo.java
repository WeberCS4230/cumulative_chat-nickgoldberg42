package chatDemo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class chatAppDemo
{

	public static void main(String[] args)
	{
		JFrame frame = new JFrame();
		Student justinBehunin = new Student("Justin", "Behunin", "Hi",
				"How have you been", "Haven't seen you in awhile",
				"How about this weather?");
		Student kenyonBrown = new Student("Kenyon", "Brown", "What's up?",
				"Pretty good", "Ugh so busy", "I know right?");
		Student nickGoldberg = new Student("Nick", "Goldberg", "Hi",
				"Who do I have to kill to get a drink around here?",
				"I'm an alcoholic", "How about those Pittsburgh Kneelers?");
		Student austinForsling = new Student("Austin", "Forsling", "Howdy!",
				"haha, right", "OK dude", "Damn Commies");
		Student tylerHoyer = new Student("Tyler", "Hoyer",
				"Gee, I hope I find a friend in this chat room", "Aww man",
				"What if I get a tatoo?", "Great! I'll get one!");
		Student stevenJulien = new Student("Steven", "Julien", "nope",
				"Sorry you're not cool enough", "Eh yeah that might do it",
				"You should get a pink unicorn");
		Student jonathanMirabile = new Student("Jonathan", "Mirabile",
				"Omae wa mou shindeiru", "gg no re", "get rekt scrub lol",
				"(0_0)");
		Student christopherNash = new Student("Christopher", "Nash", "N-Nani!?",
				"How did this happen?", "I swear revenge!", "I must train....");

		Group group1 = new Group(justinBehunin, kenyonBrown);
		Group group2 = new Group(nickGoldberg, austinForsling);
		Group group3 = new Group(tylerHoyer, stevenJulien);
		Group group4 = new Group(jonathanMirabile, christopherNash);

		List<Group> listOfGroups = new ArrayList<>();

		listOfGroups.add(group1);
		listOfGroups.add(group2);
		listOfGroups.add(group3);
		listOfGroups.add(group4);

		Collections.sort(listOfGroups);

		ChatGui cg = new ChatGui();

		for (int i = 0; i <= 3; i++)
		{
			cg.addText(listOfGroups.get(i).groupChat());
		}

		// Your JOptionPane is used statically, not with "new JOptionPane" call
		String ip = (String) JOptionPane.showInputDialog("Enter IP");

		// chatClient/chatServer are unused variables -2pts
		new Client(ip);
		new Server();
	}

}
