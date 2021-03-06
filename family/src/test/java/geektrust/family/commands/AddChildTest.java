package geektrust.family.commands;

import geektrust.family.commands.impl.AddChild;
import geektrust.family.pojo.Family;
import geektrust.family.pojo.Member;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Optional;

import static geektrust.family.pojo.Constants.*;

public class AddChildTest {
	private Family family;
	private AddChild addchild;
	
	@Before
	public void setUp(){
		family = new Family();
		addchild = new AddChild();
		family.addFamilyHead("Anga", "Female");
		Optional<Member> angaOpt = family.searchMemberUtil("Anga");
		Member member = angaOpt.orElseThrow(() -> new RuntimeException("Member not found."));
		member.addSpouse("Shan", "Male");
	}
	
	@Test
	public void addChildTest() {
		String command = "ADD_CHILD Anga Ram Male";
		String result = addchild.execute(command.split(" "), family);
		Assert.assertTrue(result.equalsIgnoreCase(CHILD_ADDITION_SUCCEEDED));
	}
	
	@Test
	public void addChildFailedTest() {
		String command = "ADD_CHILD Shan Ram Male";
		addchild.execute(command.split(" "), family);
		
		String result = addchild.execute(command.split(" "), family);
		Assert.assertTrue(result.equalsIgnoreCase(CHILD_ADDITION_FAILED));
	}
	
	@Test
	public void addChildFailedTest1() {
		String command = "ADD_CHILD Lika Ram Male";
		addchild.execute(command.split(" "), family);
		
		String result = addchild.execute(command.split(" "), family);
		Assert.assertTrue(result.equalsIgnoreCase(PERSON_NOT_FOUND));
	}
}
