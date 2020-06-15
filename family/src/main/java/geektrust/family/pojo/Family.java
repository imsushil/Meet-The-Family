package geektrust.family.pojo;

import java.util.Optional;

/**
 * @author sushil
 */
public class Family {
    private Member familyHead;

    /* ====================================
     * PRIVATE METHODS
     * ====================================
     */

    /**
     * This method searches the family of the specified name of the person
     *
     * @param family
     * @param name
     * @return Optional of Member, otherwise Optional.empty()
     */
    private Optional<Member> searchMember(Member member, String name) {
        if (member == null) return Optional.empty();

        if (member.getName().equalsIgnoreCase(name)) {
            return Optional.of(member);
        }

        Member spouse = new Member();
        if (member.getSpouse() != null) {
            spouse = member.getSpouse();
            if (spouse.getName().equalsIgnoreCase(name)) {
                return Optional.of(spouse);
            }
        }

        Member mother;
        if (member.isFemale()) mother = member;
        else mother = spouse;

        if (mother.children().isEmpty()) return Optional.empty();

        Optional<Member> person = Optional.empty();
        for (Member child : mother.children()) {
            person = searchMember(child, name);
            if (person.isPresent()) {
                break;
            }
        }
        return person;
    }

    /* ====================================
     * PUBLIC METHODS
     * ====================================
     */

    /**
     * This method searches the specified name in the family tree and returns it.
     *
     * @param name
     * @return Optional of Member if found, otherwise Optional.empty()
     */
    public Optional<Member> searchMemberUtil(String name) {
        return searchMember(familyHead, name);
    }

    /**
     * Adds family head
     *
     * @param name
     * @param gender
     */
    public void addFamilyHead(String name, String gender) {
        familyHead = new Member(name, gender);
    }

}