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
import geektrust.family.relations.relationsImpl.MaternalAunt;

public class MaternalAuntTest {
	private Family family;
	private QueryProcessor queryProcessor;
	private MaternalAunt maternalAunt; 
	
	@Before
	public void setUp() throws IOException{
		family = new Family();
		queryProcessor = new QueryProcessor();
		queryProcessor.processInitCommand(family);
		maternalAunt = new MaternalAunt();
	}
	
	@Test
	public void findMaternalAuntTest() {
		String name = "Yodhan";
		Optional<Member> angaOpt = family.searchMemberUtil(name);
		Member member = angaOpt.orElseThrow(() -> new RuntimeException("Member not found."));
		List<String> maternalAunts = Arrays.asList(maternalAunt.of(member).split(" "));
		Assert.assertThat(maternalAunts, CoreMatchers.hasItems("Tritha"));
	}
	
	@Test
	public void findMaternalAuntNoneTest() {
		String name = "Vasa";
		Optional<Member> angaOpt = family.searchMemberUtil(name);
		Member member = angaOpt.orElseThrow(() -> new RuntimeException("Member not found."));
		String maternalAunts = maternalAunt.of(member);
		Assert.assertTrue(maternalAunts.equalsIgnoreCase(NONE));
	}
}
