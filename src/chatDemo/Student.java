package chatDemo;

import java.util.ArrayList;
import java.util.List;

public class Student
{
	public List<String> responses = new ArrayList<String>();
	public String firstName;
	public String lastName;
	public int score;

	public Student(String firstName, String lastName, String chatResponse1,
			String chatResponse2, String chatResponse3, String chatResponse4)
	{
		this.firstName = firstName;
		this.lastName = lastName;
		responses.add(chatResponse1);
		responses.add(chatResponse2);
		responses.add(chatResponse3);
		responses.add(chatResponse4);
	}

	public int getScore()
	{
		return score;
	}

	public void setScore(int score)
	{
		this.score = score;
	}

}
