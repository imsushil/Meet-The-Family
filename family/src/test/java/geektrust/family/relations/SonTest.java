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
import geektrust.family.relations.relationsImpl.Son;

public class SonTest {
	private Family family;
	private QueryProcessor queryProcessor;
	private Son son; 
	
	@Before
	public void setUp() throws IOException{
		family = new Family();
		queryProcessor = new QueryProcessor();
		queryProcessor.processInitCommand(family);
		son = new Son();
	}
	
	@Test
	public void findSonsTest() {
		String name = "Anga";
		Optional<Member> angaOpt = family.searchMemberUtil(name);
		Member member = angaOpt.orElseThrow(() -> new RuntimeException("Member not found."));
		List<String> sons = Arrays.asList(son.of(member).split(" "));
		Assert.assertThat(sons, CoreMatchers.hasItems("Ish", "Chit", "Vich", "Aras"));
	}
	
	@Test
	public void noSonTest() {
		String name = "Ish";
		Optional<Member> angaOpt = family.searchMemberUtil(name);
		Member member = angaOpt.orElseThrow(() -> new RuntimeException("Member not found."));
		String sons = son.of(member);
		Assert.assertTrue(sons.equalsIgnoreCase(NONE));
	}
}