package geektrust.family.relations;

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
import geektrust.family.relations.impl.PaternalUncle;

public class PaternalUncleTest {
	private Family family;
	private PaternalUncle paternalUncle; 
	
	@Before
	public void setUp() throws IOException{
		family = new Family();
		QueryProcessor queryProcessor = new QueryProcessor();
		queryProcessor.processInitCommand(family);
		paternalUncle = new PaternalUncle();
	}
	
	@Test
	public void findDaughterTest() {
		String name = "Vila";
		Optional<Member> angaOpt = family.searchMemberUtil(name);
		Member member = angaOpt.orElseThrow(() -> new RuntimeException("Member not found."));
		List<String> paternalUncles = Arrays.asList(paternalUncle.of(member).split(" "));
		Assert.assertThat(paternalUncles, CoreMatchers.hasItems("Chit", "Ish", "Aras"));
	}
}
