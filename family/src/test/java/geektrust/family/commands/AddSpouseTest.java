package geektrust.family.commands;

import geektrust.family.commands.impl.AddSpouse;
import geektrust.family.pojo.Family;
import geektrust.family.pojo.Member;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Optional;

public class AddSpouseTest {
	private Family family;
	private AddSpouse addSpouse;
	
	@Before
	public void setUp(){
		family = new Family();
		addSpouse = new AddSpouse();
		family.addFamilyHead("Anga", "Female");
	}
	
	@Test
	public void addSpouseTest() {
		String command = "ADD_SPOUSE Anga Shan Male";
		addSpouse.execute(command.split(" "), family);
		
		Optional<Member> angaOpt = family.searchMemberUtil("Anga");
		Member member = angaOpt.orElseThrow(() -> new RuntimeException("Member not found."));
		
		boolean result = member.getSpouse().getName().equalsIgnoreCase("Shan");
		result = result && member.getSpouse().getGender().equalsIgnoreCase("Male");
		Assert.assertTrue(result);
	}
}
