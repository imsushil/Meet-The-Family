package geektrust.family.relations.impl;

import static geektrust.family.pojo.Constants.NONE;

import java.util.stream.Collectors;

import geektrust.family.pojo.Member;
import geektrust.family.relations.Relationship;

public class MaternalAunt implements Relationship {

	@Override
	public String of(Member person) {
		if(person.getMother() == null) return NONE;
		if(person.getMother().getMother() == null) return NONE;
		
		String aunts = person.getMother().getMother().getChildren().stream()
						.filter(e -> e.isFemale() && !e.getName().equals(person.getMother().getName()))
						.map(Member::getName)
						.collect(Collectors.joining(" "));
		return aunts.isEmpty() ? NONE : aunts;
	}

}
