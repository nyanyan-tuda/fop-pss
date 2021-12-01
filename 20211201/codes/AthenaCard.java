public class AthenaCard {
  private static long ID = 0;

  private final UniversityMember member;
  private final long cardID;

  public AthenaCard(final UniversityMember member) {
    this.member = member;
    this.cardID = ID++;
  }

  public UniversityMember getMember() { return member; }

  public String getCardID() { return String.format("%17d", id); }

  public String getFirstName() { return member.getFirstName(); }

  public String getLastName() { return member.getLastName(); }

  public String getID() { return member.getId(); }
}
