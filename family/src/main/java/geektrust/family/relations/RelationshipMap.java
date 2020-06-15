package geektrust.family.relations;

import geektrust.family.relations.impl.*;

import java.util.HashMap;
import java.util.Map;

import static geektrust.family.pojo.Constants.*;

public class RelationshipMap {
	private static Map<String, Relationship> relations = new HashMap<>();
	
	private RelationshipMap() {}
	
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
		if(relations.isEmpty()) {
			init();
		}
		return relations.get(relationship);
	}
	
	public static boolean contains(String relationship) {
		return relations.containsKey(relationship);
	}
}
