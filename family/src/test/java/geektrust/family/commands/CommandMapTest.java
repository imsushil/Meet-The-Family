package geektrust.family.commands;

import geektrust.family.commands.impl.AddChild;
import geektrust.family.commands.impl.AddFamilyHead;
import geektrust.family.commands.impl.AddSpouse;
import geektrust.family.commands.impl.GetRelationship;
import org.junit.Assert;
import org.junit.Test;

import static geektrust.family.pojo.Constants.*;

public class CommandMapTest {
	
	@Test
	public void containsAddChildCommandTest() {
		String relationship = ADD_CHILD;
		Assert.assertTrue(CommandsMap.get(relationship) instanceof AddChild);
	}
	
	@Test
	public void containsAddSpouseCommandTest() {
		String relationship = ADD_SPOUSE;
		Assert.assertTrue(CommandsMap.get(relationship) instanceof AddSpouse);
	}
	
	@Test
	public void containsAddFamilyHeadCommandTest() {
		String relationship = ADD_FAMILY_HEAD;
		Assert.assertTrue(CommandsMap.get(relationship)  instanceof AddFamilyHead);
	}
	
	@Test
	public void containsGetRelationshipCommandTest() {
		String relationship = GET_RELATIONSHIP;
		Assert.assertTrue(CommandsMap.get(relationship)  instanceof GetRelationship);
	}
}