# eiStudyTask2
Virtual Classroom Manager Programming Exercise(Java)
# Description
The Virtual Classroom Manager is a terminal-based backend application designed to manage virtual classrooms for an EdTech platform. This system allows you to create virtual classrooms, enroll students, schedule assignments, and handle assignment submissions. The application is written in Java and follows Object-Oriented Programming (OOP) principles, with logging, exception handling, and clean code practices.

# Features

1.Classroom Management:
Create and remove virtual classrooms.
List all available classrooms.
2.Student Management:
Enroll students into classrooms.
List students in each classroom.
3.Assignment Management:
Schedule assignments for classrooms.
Submit assignments for students.
List all assignments for a classroom.

Usage Commands:

# Add a Classroom:
addClassroom("className")

# List Classrooms:
listClassrooms()

# Remove a Classroom:
removeClassroom("className")

# Add a Student:
addStudent("studentId", "className")

# List Students in a Classroom:
listStudents("className")

# Schedule an Assignment:
scheduleAssignment("className", "assignmentDetails")

# Submit an Assignment:
submitAssignment("studentId", "className", "assignmentDetails")

List Assignments in a Classroom:
listAssignments("className")

Example Usage:

Classroom 'Math101' has been created.
Classroom 'History202' has been created.
Number of Classrooms: 2
- Math101
- History202
Student 001 has been enrolled in Math101.
Student 002 has been enrolled in History202.
Number of Students in Math101: 1
- 001
Assignment for Math101 has been scheduled.
Assignment submitted by Student 001 in Math101: Submitted Math Assignment 1.
Number of Assignments in Math101: 1
- Math Assignment 1
