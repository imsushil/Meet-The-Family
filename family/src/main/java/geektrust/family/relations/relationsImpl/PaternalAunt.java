package geektrust.family.relations.relationsImpl;

import static geektrust.family.pojo.Constants.NONE;

import java.util.stream.Collectors;

import geektrust.family.pojo.Member;
import geektrust.family.relations.Relationship;

public class PaternalAunt implements Relationship {

	@Override
	public String of(Member person) {
		if(person.getFather() == null) return NONE;
		if(person.getFather().getMother() == null) return NONE;
		
		String aunts = person.getFather().getMother().getChildren().stream()
				.filter(e -> e.isFemale())
				.map(e -> e.getName())
				.collect(Collectors.joining(" ")); 
		return aunts.isEmpty() ? NONE : aunts;
	}
	
}