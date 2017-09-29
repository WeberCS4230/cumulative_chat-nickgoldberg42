package chatDemo;

public class Group implements Comparable<Group>
{
	Student student1;
	Student student2;

	public Group(Student student1, Student student2)
	{
		this.student1 = student1;
		this.student2 = student2;
	}

	@Override
	public int compareTo(Group o)
	{
		if (this.student1.firstName.compareTo(o.student1.firstName) == 0)
			return 0;
		else if (this.student1.firstName.compareTo(o.student1.firstName) == 1)
			return 1;
		else
			return -1;

	}

}
