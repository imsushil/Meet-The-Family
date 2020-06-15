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
import geektrust.family.relations.impl.MaternalUncle;

public class MaternalUncleTest {
	private Family family;
	private MaternalUncle maternalUncle; 
	
	@Before
	public void setUp() throws IOException{
		family = new Family();
		QueryProcessor queryProcessor = new QueryProcessor();
		queryProcessor.processInitCommand(family);
		maternalUncle = new MaternalUncle();
	}
	
	@Test
	public void findMaternalUncleTest() {
		String name = "Yodhan";
		Optional<Member> angaOpt = family.searchMemberUtil(name);
		Member member = angaOpt.orElseThrow(() -> new RuntimeException("Member not found."));
		List<String> maternalAunts = Arrays.asList(maternalUncle.of(member).split(" "));
		Assert.assertThat(maternalAunts, CoreMatchers.hasItems("Vritha"));
	}
	
	@Test
	public void findMaternalUncleNoneTest() {
		String name = "Vasa";
		Optional<Member> angaOpt = family.searchMemberUtil(name);
		Member member = angaOpt.orElseThrow(() -> new RuntimeException("Member not found."));
		String maternalUncles = maternalUncle.of(member);
		Assert.assertTrue(maternalUncles.equalsIgnoreCase(NONE));
	}
}
