package geektrust.family.relations;

import geektrust.family.QueryProcessor;
import geektrust.family.pojo.Family;
import geektrust.family.pojo.Member;
import geektrust.family.relations.impl.BrotherInLaw;
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

public class BrotherInLawTest {
	private Family family;
	private BrotherInLaw brotherInLaw; 
	
	@Before
	public void setUp() throws IOException{
		family = new Family();
		QueryProcessor queryProcessor = new QueryProcessor();
		queryProcessor.processInitCommand(family);
		brotherInLaw = new BrotherInLaw();
	}
	
	@Test
	public void brotherInLawTest() {
		String name = "Lika";
		Optional<Member> angaOpt = family.searchMemberUtil(name);
		Member member = angaOpt.orElseThrow(() -> new RuntimeException(PERSON_NOT_FOUND));
		List<String> inLaws = Arrays.asList(brotherInLaw.of(member).split(" "));
		Assert.assertThat(inLaws, CoreMatchers.hasItems("Ish", "Chit", "Aras"));
	}
	
	@Test
	public void brotherInLaw1Test() {
		String name = "Tritha";
		Optional<Member> angaOpt = family.searchMemberUtil(name);
		Member member = angaOpt.orElseThrow(() -> new RuntimeException(PERSON_NOT_FOUND));
		List<String> inLaws = Arrays.asList(brotherInLaw.of(member).split(" "));
		Assert.assertThat(inLaws, CoreMatchers.hasItems("Jaya"));
	}
	
	@Test
	public void noBrotherInLawTest() {
		String name = "Dritha";
		Optional<Member> angaOpt = family.searchMemberUtil(name);
		Member member = angaOpt.orElseThrow(() -> new RuntimeException(PERSON_NOT_FOUND));
		String inLaws = brotherInLaw.of(member);
		Assert.assertTrue(inLaws.equalsIgnoreCase(NONE));
	}
}
