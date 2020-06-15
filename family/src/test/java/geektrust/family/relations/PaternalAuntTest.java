package geektrust.family.relations;

import geektrust.family.QueryProcessor;
import geektrust.family.pojo.Family;
import geektrust.family.pojo.Member;
import geektrust.family.relations.impl.PaternalAunt;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class PaternalAuntTest {
	private Family family;
	private PaternalAunt paternalAunt;
	
	@Before
	public void setUp() throws IOException{
		family = new Family();
		QueryProcessor queryProcessor = new QueryProcessor();
		queryProcessor.processInitCommand(family);
		paternalAunt = new PaternalAunt();
	}
	
	@Test
	public void findDaughterTest() {
		String name = "Vasa";
		Optional<Member> angaOpt = family.searchMemberUtil(name);
		Member member = angaOpt.orElseThrow(() -> new RuntimeException("Member not found."));
		List<String> paternalAunts = Arrays.asList(paternalAunt.of(member).split(" "));
		Assert.assertThat(paternalAunts, CoreMatchers.hasItems("Atya"));
	}
}
