package geektrust.family.relations;

import geektrust.family.QueryProcessor;
import geektrust.family.pojo.Family;
import geektrust.family.pojo.Member;
import geektrust.family.relations.impl.Daughter;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static geektrust.family.pojo.Constants.NONE;

public class DaughterTest {
	private Family family;
	private Daughter daughter; 
	
	@Before
	public void setUp() throws IOException{
		family = new Family();
		QueryProcessor queryProcessor = new QueryProcessor();
		queryProcessor.processInitCommand(family);
		daughter = new Daughter();
	}
	
	@Test
	public void findDaughterTest() {
		String name = "Vich";
		Optional<Member> angaOpt = family.searchMemberUtil(name);
		Member member = angaOpt.orElseThrow(() -> new RuntimeException("Member not found."));
		List<String> daughters = Arrays.asList(daughter.of(member).split(" "));
		Assert.assertThat(daughters, CoreMatchers.hasItems("Vila", "Chika"));
	}
	
	@Test
	public void noDaughterTest() {
		String name = "Dritha";
		Optional<Member> angaOpt = family.searchMemberUtil(name);
		Member member = angaOpt.orElseThrow(() -> new RuntimeException("Member not found."));
		String daughters = daughter.of(member);
		Assert.assertTrue(daughters.equalsIgnoreCase(NONE));
	}
}
