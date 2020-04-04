package geektrust.family.relations;

import static geektrust.family.pojo.Constants.NONE;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import geektrust.family.QueryProcessor;
import geektrust.family.pojo.Family;
import geektrust.family.pojo.Member;
import geektrust.family.relations.relationsImpl.SisterInLaw;

public class SisterInLawTest {
	private Family family;
	private QueryProcessor queryProcessor;
	private SisterInLaw sisterInLaw; 
	
	@Before
	public void setUp() throws IOException{
		family = new Family();
		queryProcessor = new QueryProcessor();
		queryProcessor.processInitCommand(family);
		sisterInLaw = new SisterInLaw();
	}
	
	@Test
	public void sisterInLawTest() {
		String name = "Lika";
		Optional<Member> angaOpt = family.searchMemberUtil(name);
		Member member = angaOpt.orElseThrow(() -> new RuntimeException("Member not found."));
		List<String> inLaws = Arrays.asList(sisterInLaw.of(member).split(" "));
		Assert.assertThat(inLaws, CoreMatchers.hasItems("Satya"));
	}
	
	@Test
	public void sisterInLawTest1() {
		String name = "Vich";
		Optional<Member> angaOpt = family.searchMemberUtil(name);
		Member member = angaOpt.orElseThrow(() -> new RuntimeException("Member not found."));
		List<String> inLaws = Arrays.asList(sisterInLaw.of(member).split(" "));
		Assert.assertThat(inLaws, CoreMatchers.hasItems("Amba", "Chitra"));
	}
	
	@Test
	public void noSisterInLawTest() {
		String name = "Dritha";
		Optional<Member> angaOpt = family.searchMemberUtil(name);
		Member member = angaOpt.orElseThrow(() -> new RuntimeException("Member not found."));
		String inLaws = sisterInLaw.of(member);
		Assert.assertTrue(inLaws.equalsIgnoreCase(NONE));
	}
}