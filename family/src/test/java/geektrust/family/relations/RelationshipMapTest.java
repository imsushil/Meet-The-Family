package geektrust.family.relations;

import static geektrust.family.pojo.Constants.BROTHER_IN_LAW;
import static geektrust.family.pojo.Constants.DAUGHTER;
import static geektrust.family.pojo.Constants.MATERNAL_AUNT;
import static geektrust.family.pojo.Constants.MATERNAL_UNCLE;
import static geektrust.family.pojo.Constants.PATERNAL_AUNT;
import static geektrust.family.pojo.Constants.PATERNAL_UNCLE;
import static geektrust.family.pojo.Constants.SIBLING;
import static geektrust.family.pojo.Constants.SISTER_IN_LAW;
import static geektrust.family.pojo.Constants.SON;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class RelationshipMapTest {
	@Before
	public void setUp() {
		RelationshipMap.init();
	}
	
	@Test
	public void containsSonRelationshipTest() {
		String relationship = SON;
		Assert.assertTrue(RelationshipMap.contains(relationship));
	}
	
	@Test
	public void containsDaughterRelationshipTest() {
		String relationship = DAUGHTER;
		Assert.assertTrue(RelationshipMap.contains(relationship));
	}
	
	@Test
	public void containsSiblingsRelationshipCommandTest() {
		String relationship = SIBLING;
		Assert.assertTrue(RelationshipMap.contains(relationship));
	}
	
	@Test
	public void containsPaternalUncleRelationshipTest() {
		String relationship = PATERNAL_UNCLE;
		Assert.assertTrue(RelationshipMap.contains(relationship));
	}
	
	@Test
	public void containsPaternalAuntRelationshipTest() {
		String relationship = PATERNAL_AUNT;
		Assert.assertTrue(RelationshipMap.contains(relationship));
	}
	
	@Test
	public void containsMaternalUncleRelationshipTest() {
		String relationship = MATERNAL_UNCLE;
		Assert.assertTrue(RelationshipMap.contains(relationship));
	}
	
	@Test
	public void containsMaternalAuntRelationshipTest() {
		String relationship = MATERNAL_AUNT;
		Assert.assertTrue(RelationshipMap.contains(relationship));
	}
	
	@Test
	public void containsSisterInLawRelationshipTest() {
		String relationship = SISTER_IN_LAW;
		Assert.assertTrue(RelationshipMap.contains(relationship));
	}
	
	@Test
	public void containsBrotherInLawRelationshipTest() {
		String relationship = BROTHER_IN_LAW;
		Assert.assertTrue(RelationshipMap.contains(relationship));
	}
}