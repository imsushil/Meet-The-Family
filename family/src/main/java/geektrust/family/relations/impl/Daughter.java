package geektrust.family.relations.impl;

import geektrust.family.pojo.Member;
import geektrust.family.relations.Relationship;

import static geektrust.family.pojo.Constants.NONE;

public class Daughter implements Relationship {

	@Override
	public String of(Member person) {
		String daughters = String.join(" ", person.daughters());
		return daughters.isEmpty() ? NONE : daughters;
	}

}
