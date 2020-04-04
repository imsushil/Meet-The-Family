package geektrust.family.commands;

import static geektrust.family.pojo.Constants.ADD_CHILD;
import static geektrust.family.pojo.Constants.ADD_FAMILY_HEAD;
import static geektrust.family.pojo.Constants.ADD_SPOUSE;
import static geektrust.family.pojo.Constants.GET_RELATIONSHIP;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CommandMapTest {
	
	@Before
	public void setUp() {
		CommandsMap.init();
	}
	
	@Test
	public void containsAddChildCommandTest() {
		String relationship = ADD_CHILD;
		Assert.assertTrue(CommandsMap.contains(relationship));
	}
	
	@Test
	public void containsAddSpouseCommandTest() {
		String relationship = ADD_SPOUSE;
		Assert.assertTrue(CommandsMap.contains(relationship));
	}
	
	@Test
	public void containsAddFamilyHeadCommandTest() {
		String relationship = ADD_FAMILY_HEAD;
		Assert.assertTrue(CommandsMap.contains(relationship));
	}
	
	@Test
	public void containsGetRelationshipCommandTest() {
		String relationship = GET_RELATIONSHIP;
		Assert.assertTrue(CommandsMap.contains(relationship));
	}
}