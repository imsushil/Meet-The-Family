package geektrust.family.pojo;

import geektrust.family.QueryProcessor;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static geektrust.family.pojo.Constants.PERSON_NOT_FOUND;

public class MemberTest {
	private Family family;
	
	@Before
	public void setUp() throws IOException{
		family = new Family();
		QueryProcessor queryProcessor = new QueryProcessor();
		queryProcessor.processInitCommand(family);
	}
	
	@Test
	public void addChildTest() {
		String name = "Ram";
		String gender = "Male";
		Optional<Member> angaOpt = family.searchMemberUtil("Anga");
		Member anga = angaOpt.orElseThrow(() -> new RuntimeException(PERSON_NOT_FOUND));
		anga.addChild(name, gender);
		
		Optional<Member> ramOpt = family.searchMemberUtil(name);
		Member ram = ramOpt.orElseThrow(() -> new RuntimeException(PERSON_NOT_FOUND));
		
		boolean result = ram.getName().equalsIgnoreCase(name);
		result = result && ram.getGender().equalsIgnoreCase(gender);
		Assert.assertTrue(result);
	}
	
	@Test
	public void findSistersTest(){
		String name = "Vritha";
		
		Optional<Member> memberOpt = family.searchMemberUtil(name);
		Member member = memberOpt.orElseThrow(() -> new RuntimeException(PERSON_NOT_FOUND));
		
		List<String> sisters = member.sisters();
		Assert.assertThat(sisters, CoreMatchers.hasItems("Dritha", "Tritha"));
	}
	
	@Test
	public void findBrothersTest() {
		String name = "Satya";
		
		Optional<Member> memberOpt = family.searchMemberUtil(name);
		Member member = memberOpt.orElseThrow(() -> new RuntimeException(PERSON_NOT_FOUND));
		
		List<String> brothers = member.brothers();
		Assert.assertThat(brothers, CoreMatchers.hasItems("Ish", "Vich", "Aras", "Chit"));
	}
	
	@Test
	public void addSpouseTest() {
		String name = "Vila";
		String spouseName = "Rakesh";
		String gender = "Male";
		
		Optional<Member> memberOpt = family.searchMemberUtil(name);
		Member member = memberOpt.orElseThrow(() -> new RuntimeException(PERSON_NOT_FOUND));
		
		member.addSpouse(spouseName, gender);
		memberOpt = family.searchMemberUtil(spouseName);
		member = memberOpt.orElseThrow(() -> new RuntimeException(PERSON_NOT_FOUND));
		
		boolean result = member.getName().equalsIgnoreCase(spouseName);
		result = result && member.getGender().equalsIgnoreCase(gender);
		Assert.assertTrue(result);
	}
	
	@Test
	public void getRelationshipTest() {
		String name = "Vila";
		String relationship = "Paternal-Aunt";
		Optional<Member> memberOpt = family.searchMemberUtil(name);
		Member member = memberOpt.orElseThrow(() -> new RuntimeException(PERSON_NOT_FOUND));
		
		String relatives = member.getRelatives(relationship);
		List<String> relativesList = Arrays.asList(relatives.split(" "));
		Assert.assertThat(relativesList, CoreMatchers.hasItem("Satya"));
	}
	
	@Test(expected = UnsupportedOperationException.class)
	public void getUnmodifiableChildrenTest() {
		String name = "Anga";
		Optional<Member> memberOpt = family.searchMemberUtil(name);
		Member member = memberOpt.orElseThrow(() -> new RuntimeException(PERSON_NOT_FOUND));
		member.getChildren().add(new Member("Yash", "Male"));
	}
	
	@Test
	public void isMemberMaleTest() {
		String name = "Ish";
		Optional<Member> memberOpt = family.searchMemberUtil(name);
		Member member = memberOpt.orElseThrow(() -> new RuntimeException(PERSON_NOT_FOUND));
		Assert.assertTrue(member.isMale());
	}
	
	@Test
	public void isMemberFemaleTest() {
		String name = "Satya";
		Optional<Member> memberOpt = family.searchMemberUtil(name);
		Member member = memberOpt.orElseThrow(() -> new RuntimeException(PERSON_NOT_FOUND));
		Assert.assertTrue(member.isFemale());
	}
}