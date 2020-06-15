package geektrust.family.relations;

import geektrust.family.QueryProcessor;
import geektrust.family.pojo.Family;
import geektrust.family.pojo.Member;
import geektrust.family.relations.impl.SisterInLaw;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static geektrust.family.pojo.Constants.NONE;
import static geektrust.family.pojo.Constants.PERSON_NOT_FOUND;


public class SisterInLawTest {
	private Family family;
	private SisterInLaw sisterInLaw;
	
	@Before
	public void setUp() throws IOException{
		family = new Family();
		QueryProcessor queryProcessor = new QueryProcessor();
		queryProcessor.processInitCommand(family);
		sisterInLaw = new SisterInLaw();
	}
	
	@Test
	public void sisterInLawTest() {
		String name = "Lika";
		Optional<Member> angaOpt = family.searchMemberUtil(name);
		Member member = angaOpt.orElseThrow(() -> new RuntimeException(PERSON_NOT_FOUND));
		List<String> inLaws = Arrays.asList(sisterInLaw.of(member).split(" "));
		Assert.assertThat(inLaws, CoreMatchers.hasItems("Satya"));
	}
	
	@Test
	public void sisterInLawTest1() {
		String name = "Vich";
		Optional<Member> angaOpt = family.searchMemberUtil(name);
		Member member = angaOpt.orElseThrow(() -> new RuntimeException(PERSON_NOT_FOUND));
		List<String> inLaws = Arrays.asList(sisterInLaw.of(member).split(" "));
		Assert.assertThat(inLaws, CoreMatchers.hasItems("Amba", "Chitra"));
	}
	
	@Test
	public void noSisterInLawTest() {
		String name = "Dritha";
		Optional<Member> angaOpt = family.searchMemberUtil(name);
		Member member = angaOpt.orElseThrow(() -> new RuntimeException(PERSON_NOT_FOUND));
		String inLaws = sisterInLaw.of(member);
		Assert.assertTrue(inLaws.equalsIgnoreCase(NONE));
	}
}