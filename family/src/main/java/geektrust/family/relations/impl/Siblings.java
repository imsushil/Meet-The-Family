package geektrust.family.relations.impl;

import geektrust.family.pojo.Member;
import geektrust.family.relations.Relationship;

import static geektrust.family.pojo.Constants.NONE;

public class Siblings implements Relationship {

    @Override
    public String of(Member person) {
        String siblings = String.join(" ", person.siblings());
        return siblings.isEmpty() ? NONE : siblings;
    }
}
