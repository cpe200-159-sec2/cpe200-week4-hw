# Week 4 - Homework: Course Enrollment

This homework will help you learn how to solve problem with multiple Java classes.

The objectives of this week are following:
* Programming abstraction of simple enrollment system.
* Learn more about class composition relationship.
* Reusing PList and PNode classes with other types of data.
* Using constructor to initialized class data type.
* Using "this" keyword as parameter.

##PNode Class
* Modify the PNode class from your previous work to store "Object" data instead of "char".

##PList Class
* Modify the PList class from your previous work to be able to handle "Object" data instead of "char".
* Make sure all the methods work correctly with "Object".
* Rename the method "search(char i)" to "found(Object data)" which search the list for the specified data
    * Return True if the data is found in the list, otherwise returns False.
* Add the "remove(Object data)" which removes the first node containing the "data" from the list.
    * Returns True if data is removed successfully, otherwise returns False.
* Add the "elementAt(int index)" which returns an "Object" data stored at location "index". 
    * "index" value of a list starts from 0 to (size-1)
    * Returns "null" if "i" is invalid.

##Student Class
From your previous work:
* Add a list of courses that a student has enrolled successfully. Implement using "PList".

Methods:
* Modify constructors so that they can initialized the "courses" attribute properly.
* Add the "addCourse(Course c)" method to add a course that a student wants to enroll.
* Add the "dropCourse(Course c)" method to drop a course that a student wants to drop.
* Modify the "toString()" method : for printing the student object's state:
    * Also printing "course id" and "course name" of all courses that a student has enrolled.

##Course Class
From your previous work:
* Modify the default maximum number of students to 3 (instead of 10).
* Add a list of students that has already enrolled in this course. Implement using "Plist".

Methods:
* Modify constructors so that they can initialized the "students" attribute properly.
* Add the "enrollStudent(Student s)" method to add a student to a course.
    * Need to check if the course is FULL or not?
    * Need to check if the student is ALREADY ENROLLED to the course or not?
    * Return TRUE, if the student is enrolled successfully.
    * Otherwise, print error message, and return FALSE.
* Add the "removeStudent(Student s)" method to remove a student from a course.
    * Need to check if the course has NO STUDENT or not?
    * Need to check if the student is ALREADY ENROLLED to the course or not?
    * Return TRUE, if the student is removed successfully. 
    * Otherwise, print error message, and return FALSE.
* Modify the "toString()" method : for printing the course object's state: 
    * Also printing "student id" and "student name" of all students who are studying this course.

To complete the homework you need to meet following requirements:
* Pass all unit tests: PListTest.java, StudentTest.java, CourseTest.java
* Output from the "TestEnrollment.java" program should be the same as or very similar to the output stored in the "TestEnrollment-output.txt".
* Draw a class diagram showing the relationship among the classes: PNode, PList, Student, and Course
