package geektrust.family.relations.impl;

import static geektrust.family.pojo.Constants.NONE;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import geektrust.family.pojo.Member;
import geektrust.family.relations.Relationship;

public class SisterInLaw implements Relationship {

	@Override
	public String of(Member person) {
		List<String> sistersInLaw = new ArrayList<>();
		
		// Add wives of siblings
		if(person.getMother() != null) {
			List<String> sisters = person.getMother().getChildren().stream()
									.filter(m -> m.isMale() 
												 && !m.getName().equalsIgnoreCase(person.getName())
												 && m.getSpouse() != null
									)
									.map(m -> m.getSpouse().getName())
									.collect(Collectors.toList());
			sistersInLaw.addAll(sisters);
		}

		// Add sisters of spouse
		if (person.getSpouse() != null) { // wife
			sistersInLaw.addAll(person.getSpouse().sisters());
		}
		String inLaws = String.join(" ", sistersInLaw);
		return inLaws.isEmpty() ? NONE : inLaws;
	}

}
