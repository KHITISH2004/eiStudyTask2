import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

class VirtualClassroomManager {
    private static final Logger logger = Logger.getLogger(VirtualClassroomManager.class.getName());
    private List<Classroom> classrooms = new ArrayList<>();

    // Add a new classroom
    public void addClassroom(String className) {
        classrooms.add(new Classroom(className));
        logger.info("Classroom '" + className + "' has been created.");
    }

    // List all classrooms
    public void listClassrooms() {
        if (classrooms.isEmpty()) {
            logger.info("No classrooms available.");
        } else {
            logger.info("Number of Classrooms: " + classrooms.size());
            classrooms.forEach(classroom -> logger.info("- " + classroom.getName()));
        }
    }

    // Remove a classroom
    public void removeClassroom(String className) {
        Optional<Classroom> classroomToRemove = classrooms.stream()
                .filter(c -> c.getName().equals(className))
                .findFirst();
        if (classroomToRemove.isPresent()) {
            classrooms.remove(classroomToRemove.get());
            logger.info("Classroom '" + className + "' has been removed.");
        } else {
            logger.warning("Classroom '" + className + "' not found.");
        }
    }

    // Enroll student in a classroom
    public void addStudent(String studentId, String className) {
        Optional<Classroom> classroom = getClassroomByName(className);
        if (classroom.isPresent()) {
            classroom.get().addStudent(new Student(studentId));
        } else {
            logger.warning("Classroom '" + className + "' not found.");
        }
    }

    // List all students in a classroom
    public void listStudents(String className) {
        Optional<Classroom> classroom = getClassroomByName(className);
        if (classroom.isPresent()) {
            classroom.get().listStudents();
        } else {
            logger.warning("Classroom '" + className + "' not found.");
        }
    }

    // Schedule an assignment in a classroom
    public void scheduleAssignment(String className, String assignmentDetails) {
        Optional<Classroom> classroom = getClassroomByName(className);
        if (classroom.isPresent()) {
            classroom.get().scheduleAssignment(new Assignment(assignmentDetails));
        } else {
            logger.warning("Classroom '" + className + "' not found.");
        }
    }

    // List assignments in a classroom
    public void listAssignments(String className) {
        Optional<Classroom> classroom = getClassroomByName(className);
        if (classroom.isPresent()) {
            classroom.get().listAssignments();
        } else {
            logger.warning("Classroom '" + className + "' not found.");
        }
    }

    // Submit an assignment
    public void submitAssignment(String studentId, String className, String assignmentDetails) {
        Optional<Classroom> classroom = getClassroomByName(className);
        if (classroom.isPresent()) {
            classroom.get().submitAssignment(studentId, assignmentDetails);
        } else {
            logger.warning("Classroom '" + className + "' not found.");
        }
    }

    // Helper method to get classroom by name
    private Optional<Classroom> getClassroomByName(String className) {
        return classrooms.stream()
                .filter(c -> c.getName().equals(className))
                .findFirst();
    }

    public static void main(String[] args) {
        VirtualClassroomManager manager = new VirtualClassroomManager();

        // Example usage
        manager.addClassroom("Math101");
        manager.addClassroom("History202");
        manager.listClassrooms();
        manager.addStudent("001", "Math101");
        manager.addStudent("002", "History202");
        manager.listStudents("Math101");
        manager.scheduleAssignment("Math101", "Math Assignment 1");
        manager.submitAssignment("001", "Math101", "Submitted Math Assignment 1");
        manager.listAssignments("Math101");
    }
}

// Classroom class
class Classroom {
    private String name;
    private List<Student> students = new ArrayList<>();
    private List<Assignment> assignments = new ArrayList<>();

    public Classroom(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addStudent(Student student) {
        students.add(student);
        Logger.getLogger(Classroom.class.getName()).info("Student " + student.getId() + " has been enrolled in " + name + ".");
    }

    public void listStudents() {
        Logger.getLogger(Classroom.class.getName()).info("Number of Students in " + name + ": " + students.size());
        students.forEach(student -> Logger.getLogger(Classroom.class.getName()).info("- " + student.getId()));
    }

    public void scheduleAssignment(Assignment assignment) {
        assignments.add(assignment);
        Logger.getLogger(Classroom.class.getName()).info("Assignment for " + name + " has been scheduled.");
    }

    public void listAssignments() {
        Logger.getLogger(Classroom.class.getName()).info("Number of Assignments in " + name + ": " + assignments.size());
        assignments.forEach(assignment -> Logger.getLogger(Classroom.class.getName()).info("- " + assignment.getDetails()));
    }

    public void submitAssignment(String studentId, String assignmentDetails) {
        boolean studentFound = students.stream().anyMatch(student -> student.getId().equals(studentId));
        if (studentFound) {
            Logger.getLogger(Classroom.class.getName()).info("Assignment submitted by Student " + studentId + " in " + name + ": " + assignmentDetails);
        } else {
            Logger.getLogger(Classroom.class.getName()).warning("Student " + studentId + " not found in " + name + ".");
        }
    }
}

// Student class
class Student {
    private String id;

    public Student(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}

// Assignment class
class Assignment {
    private String details;

    public Assignment(String details) {
        this.details = details;
    }

    public String getDetails() {
        return details;
    }
}