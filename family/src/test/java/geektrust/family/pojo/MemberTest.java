package geektrust.family.pojo;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import geektrust.family.QueryProcessor;

public class MemberTest {
	private Family family;
	private QueryProcessor queryProcessor;
	
	@Before
	public void setUp() throws IOException{
		family = new Family();
		queryProcessor = new QueryProcessor();
		queryProcessor.processInitCommand(family);
	}
	
	@Test
	public void addChildTest() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		String name = "Ram";
		String gender = "Male";
		Optional<Member> angaOpt = family.searchMemberUtil("Anga");
		Member anga = angaOpt.orElseThrow(() -> new RuntimeException("Member not found."));
		anga.addChild(name, gender);
		
		Optional<Member> ramOpt = family.searchMemberUtil(name);
		Member ram = ramOpt.orElseThrow(() -> new RuntimeException("Member not found."));
		
		boolean result = ram.getName().equalsIgnoreCase(name);
		result = result && ram.getGender().equalsIgnoreCase(gender);
		Assert.assertTrue(result);
	}
	
	@Test
	public void findSiblingsTest() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		String name = "Chit";
		
		Optional<Member> memberOpt = family.searchMemberUtil(name);
		Member member = memberOpt.orElseThrow(() -> new RuntimeException("Member not found."));
		
		List<String> siblings = member.siblings();
		Assert.assertThat(siblings, CoreMatchers.hasItems("Ish", "Vich", "Aras"));
	}
	
	@Test
	public void findSistersTest() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		String name = "Vritha";
		
		Optional<Member> memberOpt = family.searchMemberUtil(name);
		Member member = memberOpt.orElseThrow(() -> new RuntimeException("Member not found."));
		
		List<String> sisters = member.sisters();
		Assert.assertThat(sisters, CoreMatchers.hasItems("Dritha", "Tritha"));
	}
	
	@Test
	public void findBrothersTest() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		String name = "Satya";
		
		Optional<Member> memberOpt = family.searchMemberUtil(name);
		Member member = memberOpt.orElseThrow(() -> new RuntimeException("Member not found."));
		
		List<String> brothers = member.brothers();
		Assert.assertThat(brothers, CoreMatchers.hasItems("Ish", "Vich", "Aras", "Chit"));
	}
	
	@Test
	public void addSpouseTest() {
		String name = "Vila";
		String spouseName = "Rakesh";
		String gender = "Male";
		
		Optional<Member> memberOpt = family.searchMemberUtil(name);
		Member member = memberOpt.orElseThrow(() -> new RuntimeException("Member not found."));
		
		member.addSpouse(spouseName, gender);
		memberOpt = family.searchMemberUtil(spouseName);
		member = memberOpt.orElseThrow(() -> new RuntimeException("Member not found."));
		
		boolean result = member.getName().equalsIgnoreCase(spouseName);
		result = result && member.getGender().equalsIgnoreCase(gender);
		Assert.assertTrue(result);
	}
	
	@Test
	public void getRelationshipTest() {
		String name = "Vila";
		String relationship = "Paternal-Aunt";
		Optional<Member> memberOpt = family.searchMemberUtil(name);
		Member member = memberOpt.orElseThrow(() -> new RuntimeException("Member not found."));
		
		String relatives = member.getRelatives(relationship);
		List<String> relativesList = Arrays.asList(relatives.split(" "));
		Assert.assertThat(relativesList, CoreMatchers.hasItem("Satya"));
	}
	
	@Test(expected = UnsupportedOperationException.class)
	public void getUnmodifiableChildrenTest() {
		String name = "Anga";
		Optional<Member> memberOpt = family.searchMemberUtil(name);
		Member member = memberOpt.orElseThrow(() -> new RuntimeException("Member not found."));
		member.getChildren().add(new Member("Yash", "Male"));
	}
	
	@Test
	public void isMemberMaleTest() {
		String name = "Ish";
		Optional<Member> memberOpt = family.searchMemberUtil(name);
		Member member = memberOpt.orElseThrow(() -> new RuntimeException("Member not found."));
		Assert.assertTrue(member.isMale());
	}
	
	@Test
	public void isMemberFemaleTest() {
		String name = "Satya";
		Optional<Member> memberOpt = family.searchMemberUtil(name);
		Member member = memberOpt.orElseThrow(() -> new RuntimeException("Member not found."));
		Assert.assertTrue(member.isFemale());
	}
}