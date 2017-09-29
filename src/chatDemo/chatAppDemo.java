package chatDemo;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class chatAppDemo
{

	public static void main(String[] args)
	{
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

		Set<Group> setOfGroups = new TreeSet<>();
		setOfGroups.add(group1);
		setOfGroups.add(group2);
		setOfGroups.add(group3);
		setOfGroups.add(group4);

		Iterator<Group> itr = setOfGroups.iterator();
		while (itr.hasNext())
		{
			System.out.println(itr.next().student1.firstName);
		}
	}

	public static void groupChat(Group group)
	{
		System.out.println(group.student1.responses.get(0));
		System.out.println(group.student2.responses.get(0));
		System.out.println(group.student1.responses.get(1));
		System.out.println(group.student2.responses.get(1));
		System.out.println(group.student1.responses.get(2));
		System.out.println(group.student2.responses.get(2));
		System.out.println(group.student1.responses.get(3));
		System.out.println(group.student2.responses.get(3));
	}

}
