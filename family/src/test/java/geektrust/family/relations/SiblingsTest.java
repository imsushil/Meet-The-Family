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
import geektrust.family.relations.relationsImpl.Siblings;

public class SiblingsTest {
	private Family family;
	private QueryProcessor queryProcessor;
	private Siblings siblings; 
	
	@Before
	public void setUp() throws IOException{
		family = new Family();
		queryProcessor = new QueryProcessor();
		queryProcessor.processInitCommand(family);
		siblings = new Siblings();
	}
	
	@Test
	public void siblingsTest() {
		String name = "Vich";
		Optional<Member> angaOpt = family.searchMemberUtil(name);
		Member member = angaOpt.orElseThrow(() -> new RuntimeException("Member not found."));
		List<String> sibling = Arrays.asList(siblings.of(member).split(" "));
		Assert.assertThat(sibling, CoreMatchers.hasItems("Chit", "Ish", "Aras", "Satya"));
	}
	
	@Test
	public void NoSiblingsTest() {
		String name = "Yodhan";
		Optional<Member> angaOpt = family.searchMemberUtil(name);
		Member member = angaOpt.orElseThrow(() -> new RuntimeException("Member not found."));
		String sibling = siblings.of(member);
		Assert.assertTrue(sibling.equalsIgnoreCase(NONE));
	}
}
