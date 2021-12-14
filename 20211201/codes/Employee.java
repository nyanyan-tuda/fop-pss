public class Employee extends UniversityMember {
    private static long ID = 0;

    private Department department;

    public Employee(String firstName, String lastName, Department department) {
        super(firstName, lastName, ID++);
        this.department = department;
    }

    @Override
    public String getID() {
        return String.format("Person number: %07d", id);
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(final Department department) {
        this.department = department;
    }
}
