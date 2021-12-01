public class Professor extends Employee{

  private String room;

  public Professor(String firstName, String lastName,
                   Department department, String room) {
    super(firstName, lastName, department);
    this.room=room;
  }

  public String getRoom() {
    return room;
  }

  public void setRoom(final String room) {
    this.room = room;
  }
}
