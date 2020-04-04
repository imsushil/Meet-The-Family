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

import java.util.HashMap;

import geektrust.family.relations.relationsImpl.BrotherInLaw;
import geektrust.family.relations.relationsImpl.Daughter;
import geektrust.family.relations.relationsImpl.MaternalAunt;
import geektrust.family.relations.relationsImpl.MaternalUncle;
import geektrust.family.relations.relationsImpl.PaternalAunt;
import geektrust.family.relations.relationsImpl.PaternalUncle;
import geektrust.family.relations.relationsImpl.Siblings;
import geektrust.family.relations.relationsImpl.SisterInLaw;
import geektrust.family.relations.relationsImpl.Son;

public class RelationshipMap {
	static private HashMap<String, Relationship> relations = new HashMap<>();
	
	public static void init() {
		relations.put(SIBLING, new Siblings());
		relations.put(SON, new Son());
		relations.put(DAUGHTER, new Daughter());
		relations.put(PATERNAL_AUNT, new PaternalAunt());
		relations.put(PATERNAL_UNCLE, new PaternalUncle());
		relations.put(MATERNAL_AUNT, new MaternalAunt());
		relations.put(MATERNAL_UNCLE, new MaternalUncle());
		relations.put(BROTHER_IN_LAW, new BrotherInLaw());
		relations.put(SISTER_IN_LAW, new SisterInLaw());
	}
	
	public static Relationship get(String relationship){
		return relations.get(relationship);
	}
	
	public static boolean contains(String relationship) {
		return relations.containsKey(relationship);
	}
}
