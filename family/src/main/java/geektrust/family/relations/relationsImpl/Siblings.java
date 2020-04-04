package geektrust.family.relations.relationsImpl;

import static geektrust.family.pojo.Constants.NONE;

import geektrust.family.pojo.Member;
import geektrust.family.relations.Relationship;

public class Siblings implements Relationship {

	@Override
	public String of(Member person) {
		String siblings = String.join(" ", person.siblings());
		return siblings.isEmpty() ? NONE : siblings; 
	}

}
