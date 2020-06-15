package geektrust.family.pojo;

import java.lang.reflect.Field;
import java.util.Optional;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class FamilyTest {
	private Family family;
	
	@Before
	public void setUp(){
		family = new Family();
	}
	
	private void init() throws NoSuchFieldException, IllegalAccessException {
		String name = "Anga";
		String gender = "Female";
		family.addFamilyHead(name, gender);
		Field familyHeadField = family.getClass().getDeclaredField("familyHead");
		familyHeadField.setAccessible(true);
		Member anga = (Member)familyHeadField.get(family);
		anga.addChild("Ram", "Male");
	}
	
	@Test
	public void addFamilyHeadTest() throws NoSuchFieldException, IllegalAccessException {
		String name = "Anga";
		String gender = "Female";
		family.addFamilyHead(name, gender);
		Field familyHeadField = family.getClass().getDeclaredField("familyHead");
		familyHeadField.setAccessible(true);
		
		Member familyHead = new Member(name, gender);
		Assert.assertTrue(familyHeadField.get(family).equals(familyHead));
	}
	
	@Test
	public void searchMemberTest() throws NoSuchFieldException, IllegalAccessException {
		init();
		String name = "Ram";
		String gender = "Male";
		
		Optional<Member> memberOpt = family.searchMemberUtil(name);
		Member member = memberOpt.orElseThrow(() -> new RuntimeException("Member not found!"));
		
		boolean result = member.getName().equalsIgnoreCase(name);
		result = result && member.getGender().equalsIgnoreCase(gender);
		Assert.assertTrue(result);
	}
}