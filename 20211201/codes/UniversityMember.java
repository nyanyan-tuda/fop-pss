public abstract class UniversityMember {

  protected final long id;
  private String firstName;
  private String lastName;

  public UniversityMember(String firstName, String lastName, long id) {
    this.id = id;
    this.firstName = firstName;
    this.lastName = lastName;
  }

  public abstract String getID();

  public String getFirstName() {
    return firstName;
  }
  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }
  public void setLastName(String lastName) {
    this.lastName = lastName;
  }
}
