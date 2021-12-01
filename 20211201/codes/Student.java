public class Student extends UniversityMember {

  private static long ID = 0;
  private int semester;

  public Student(String firstName, String lastName) {
    super(firstName, lastName, ID++);
    this.semester = 1;
  }

  @Override
  public String getID() {
    return String.format("Enrolment number: %07d", id);
  }

  public int getSemester() {
    return semester;
  }

  public void setSemester(final int semester) {
    this.semester = semester;
  }
}
