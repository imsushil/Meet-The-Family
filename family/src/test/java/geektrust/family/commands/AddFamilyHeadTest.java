package geektrust.family.commands;

import geektrust.family.commands.impl.AddFamilyHead;
import geektrust.family.pojo.Family;
import geektrust.family.pojo.Member;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Optional;

public class AddFamilyHeadTest {
	private Family family;
	private AddFamilyHead addFamilyHead;
	
	@Before
	public void setUp(){
		family = new Family();
		addFamilyHead = new AddFamilyHead();
	}
	
	@Test
	public void addFamilyHeadTest() {
		String command = "ADD_FAMILY_HEAD Anga Female";
		addFamilyHead.execute(command.split(" "), family);
		
		Optional<Member> angaOpt = family.searchMemberUtil("Anga");
		Member member = angaOpt.orElseThrow(() -> new RuntimeException("Member not found."));
		
		boolean result = member.getName().equalsIgnoreCase("Anga");
		result = result && member.getGender().equalsIgnoreCase("Female");
		Assert.assertTrue(result);
	}
}
