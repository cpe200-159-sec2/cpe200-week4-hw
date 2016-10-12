package cpe200;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Course {

    public Course() {
        this("", "", "", DMAX);
    }

    public Course(String n, String cid) {
        this(n, cid, "", DMAX);
    }

    public Course(String n, String cid, String l) {
        this(n, cid, l, DMAX);
    }

    public Course(String n, String cid, String l, int max) {
        this.courseName = !n.equalsIgnoreCase("") ? n : "TBA";
        this.courseID = isValidCourse_id(cid) ? cid : "000000";
        this.lecturer = !l.equalsIgnoreCase("") ? l : "TBA";
        this.studentMax = max < DMAX ? DMAX : max;
        this.studentNo = 0;

    }

    public boolean enrollStudent(Student s) {
        if (this.studentNo < this.studentMax) {
            if (studentList.found(s)){
                System.out.println("student has ALREADY enrolled in this course.");
                return false;
            }else {
                studentList.pushToTail(s);
                studentNo++;
                System.out.println("student is enrolled successfully.");
                return true;
            }
        } else{
            System.out.println("Full.");
            return false;
        }
    }

    public boolean removeStudent(Student s) {
        if (studentList.remove(s)){
            studentNo--;
            return true;
        }
        return false;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = !courseName.equalsIgnoreCase("")? courseName :this.courseName;
    }

    public String getCourseID() {
        return courseID;
    }

    public void setCourseID(String courseID) {
        this.courseID = isValidCourse_id(courseID)? courseID :this.courseID;
    }

    public String getLecturer() {
        return lecturer;
    }

    public void setLecturer(String lecturer) {
        this.lecturer = !lecturer.equalsIgnoreCase("")?lecturer:this.lecturer;
    }

    public int getMaxStudents() {
        return studentMax;
    }

    public void setMaxStudents(int studentMax) {
        this.studentMax = studentMax <10?this.studentMax : studentMax;
    }

    public int getStudentNo() {
        return studentNo;
    }

    public void setStudentNo(int studentNo) {
        this.studentNo = (studentNo >=0 && studentNo <= studentMax)? studentNo :this.studentNo;
    }

    @Override
    public String toString() {
        String o = this.courseName + " ("
                + this.courseID + "), Teacher: "
                + this.lecturer + ", has ";

        if (this.studentNo < 1)
            o += "NO student, ";
        else if (this.studentNo == 1)
            o += "ONE student, ";
        else if (this.studentNo > 1)
            o += this.studentNo + " students, ";

        o += "[maximum: " + this.studentMax + "]";

        for (int i = 0; i < this.studentList.getSize(); i++) {
            Student s = (Student) studentList.elementAt(i);
            o += "\n\t" + s.getStudent_id() + " - " + s.getName();
        }
        return o;

    }

    private boolean isValidCourse_id(String id) {
        Pattern p = Pattern.compile(idREGEX);
        Matcher m = p.matcher(id);

        return m.matches();
    }

    private static final String idREGEX = "\\d{6}";
    private static final int DMAX = 3;

    private String courseName;
    private String courseID;
    private String lecturer;
    private int studentMax;
    private int studentNo;

    private PList studentList = new PList();

}