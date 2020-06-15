package geektrust.family.commands;

import static geektrust.family.pojo.Constants.NONE;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import geektrust.family.QueryProcessor;
import geektrust.family.commands.impl.GetRelationship;
import geektrust.family.pojo.Family;

public class GetRelationshipTest {
	private Family family;
	private GetRelationship getRelationship;

	@Before
	public void getRelationship() throws IOException {
		family = new Family();
		QueryProcessor queryProcessor = new QueryProcessor();
		queryProcessor.processInitCommand(family);
		getRelationship = new GetRelationship();
	}
	
	@Test
	public void findSonTest() {
		String command = "GET_RELATIONSHIP Anga Son";
		
		String result = getRelationship.execute(command.split(" "), family);
		System.out.println(result);
		List<String> sons = Arrays.asList(result.split(" "));
		Assert.assertThat(sons, CoreMatchers.hasItems("Ish", "Chit", "Vich", "Aras"));
	}
	
	@Test
	public void findSonNegativeTest() {
		String command = "GET_RELATIONSHIP Vich Son";
		
		String result = getRelationship.execute(command.split(" "), family);
		Assert.assertTrue(result.equalsIgnoreCase(NONE));
	}
	
	@Test
	public void findDaughterTest() {
		String command = "GET_RELATIONSHIP Anga Daughter";
		
		String result = getRelationship.execute(command.split(" "), family);
		List<String> daughters = Arrays.asList(result.split(" "));
		Assert.assertThat(daughters, CoreMatchers.hasItems("Satya"));
	}
	
	@Test
	public void findDaughterNegativeTest() {
		String command = "GET_RELATIONSHIP Jaya Daughter";
		
		String result = getRelationship.execute(command.split(" "), family);
		Assert.assertTrue(result.equalsIgnoreCase(NONE));
	}
	
	@Test
	public void findSiblingsTest() {
		String command = "GET_RELATIONSHIP Asva Siblings";
		
		String result = getRelationship.execute(command.split(" "), family);
		List<String> siblings = Arrays.asList(result.split(" "));
		Assert.assertThat(siblings, CoreMatchers.hasItems("Vyas", "Atya"));
	}

	@Test
	public void findSiblingsNegativeTest() {
		String command = "GET_RELATIONSHIP Yodhan Siblings";
		
		String result = getRelationship.execute(command.split(" "), family);
		Assert.assertTrue(result.equalsIgnoreCase(NONE));
	}
	
	@Test
	public void findPaternalUncleTest() {
		String command = "GET_RELATIONSHIP Tritha Paternal-Uncle";
		
		String result = getRelationship.execute(command.split(" "), family);
		List<String> paternalUncles = Arrays.asList(result.split(" "));
		Assert.assertThat(paternalUncles, CoreMatchers.hasItems("Ish", "Vich", "Aras"));
	}
	
	@Test
	public void findPaternalUncleNegativeTest() {
		String command = "GET_RELATIONSHIP Laki Paternal-Uncle";
		
		String result = getRelationship.execute(command.split(" "), family);
		Assert.assertTrue(result.equalsIgnoreCase(NONE));
	}
	
	@Test
	public void findPaternalAuntTest() {
		String command = "GET_RELATIONSHIP Vritha Paternal-Aunt";
		
		String result = getRelationship.execute(command.split(" "), family);
		List<String> paternalAunts = Arrays.asList(result.split(" "));
		Assert.assertThat(paternalAunts, CoreMatchers.hasItems("Satya"));
	}
	
	@Test
	public void findPaternalAuntNegativeTest() {
		String command = "GET_RELATIONSHIP Laki Paternal-Aunt";
		
		String result = getRelationship.execute(command.split(" "), family);
		Assert.assertTrue(result.equalsIgnoreCase(NONE));
	}
	
	@Test
	public void findMaternalUncleTest() {
		String command = "GET_RELATIONSHIP Atya Maternal-Uncle";
		
		String result = getRelationship.execute(command.split(" "), family);
		List<String> maternalUncles = Arrays.asList(result.split(" "));
		Assert.assertThat(maternalUncles, CoreMatchers.hasItems("Chit", "Ish", "Vich", "Aras"));
	}
	
	@Test
	public void findMaternalUncleNegativeTest() {
		String command = "GET_RELATIONSHIP Kriya Maternal-Uncle";
		
		String result = getRelationship.execute(command.split(" "), family);
		Assert.assertTrue(result.equalsIgnoreCase(NONE));
	}
	
	@Test
	public void findMaternalAuntTest() {
		String command = "GET_RELATIONSHIP Yodhan Maternal-Aunt";
		
		String result = getRelationship.execute(command.split(" "), family);
		List<String> maternalAunts = Arrays.asList(result.split(" "));
		Assert.assertThat(maternalAunts, CoreMatchers.hasItems("Tritha"));
	}
	
	@Test
	public void findMaternalAuntNegativeTest() {
		String command = "GET_RELATIONSHIP Vasa Maternal-Aunt";
		
		String result = getRelationship.execute(command.split(" "), family);
		Assert.assertTrue(result.equalsIgnoreCase(NONE));
	}
	
	@Test
	public void findBrotherInLawTest() {
		String command = "GET_RELATIONSHIP Jaya Brother-In-Law";
		
		String result = getRelationship.execute(command.split(" "), family);
		List<String> maternalAunts = Arrays.asList(result.split(" "));
		Assert.assertThat(maternalAunts, CoreMatchers.hasItems("Vritha"));
	}
	
	@Test
	public void findBrotherInLawNegativeTest() {
		String command = "GET_RELATIONSHIP Asva Brother-In-Law";
		
		String result = getRelationship.execute(command.split(" "), family);
		Assert.assertTrue(result.equalsIgnoreCase(NONE));
	}
	
	@Test
	public void findSisterInLawTest() {
		String command = "GET_RELATIONSHIP Jaya Sister-In-Law";
		
		String result = getRelationship.execute(command.split(" "), family);
		List<String> maternalAunts = Arrays.asList(result.split(" "));
		Assert.assertThat(maternalAunts, CoreMatchers.hasItems("Tritha"));
	}
	
	@Test
	public void findSisterInLawNegativeTest() {
		String command = "GET_RELATIONSHIP Arit Sister-In-Law";
		
		String result = getRelationship.execute(command.split(" "), family);
		Assert.assertTrue(result.equalsIgnoreCase(NONE));
	}
}
