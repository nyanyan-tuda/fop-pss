/**
 * Returns the unique identification of this student. The identification
 * represents the enrollment number of this student.
 *
 * @return the unique identification of this student
 */
@Override
public String getID() {
  return String.format("Enrolment number: %07d", id);
}
