package com.mrash.studentinfocenter;

public class Student {

    int stdId;             // #01
    String stdName;        // #02
    String fatherName;     // #03
    int stdSemester;       // #04
    String stdEmail;       // #05
    String stdDob;         // #06
    String stdAddress;     // #07

    /**
     * Constructor
     */
    public Student() {
    }

    /**
     * Overloaded Constructor
     *
     * @param stdId
     * @param stdName
     * @param fatherName
     * @param stdSemester
     * @param stdEmail
     * @param stdDob
     * @param stdAddress
     */
    public Student(int stdId, String stdName, String fatherName,
                   int stdSemester, String stdEmail, String stdDob, String stdAddress) {
        this.stdId = stdId;
        this.stdName = stdName;
        this.fatherName = fatherName;
        this.stdSemester = stdSemester;
        this.stdEmail = stdEmail;
        this.stdDob = stdDob;
        this.stdAddress = stdAddress;
    }

    /**
     * getter and Setter of Student ID
     *
     * @return
     */
    public int getStdId() {
        return stdId;
    }

    public void setStdId(int stdId) {
        this.stdId = stdId;
    }

    /**
     * getter and Setter of Student Name
     *
     * @return
     */
    public String getStdName() {
        return stdName;
    }

    public void setStdName(String stdName) {
        this.stdName = stdName;
    }

    /**
     * getter and Setter of Student Father Name
     *
     * @return
     */
    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    /**
     * getter and Setter of Student Semester
     *
     * @return
     */
    public int getStdSemester() {
        return stdSemester;
    }

    public void setStdSemester(int stdSemester) {
        this.stdSemester = stdSemester;
    }

    /**
     * getter and Setter of Student Email
     *
     * @return
     */
    public String getStdEmail() {
        return stdEmail;
    }

    public void setStdEmail(String stdEmail) {
        this.stdEmail = stdEmail;
    }

    /**
     * getter and Setter of Student DOB
     *
     * @return
     */
    public String getStdDob() {
        return stdDob;
    }

    public void setStdDob(String stdDob) {
        this.stdDob = stdDob;
    }

    /**
     * getter and Setter of Student Address
     *
     * @return
     */
    public String getStdAddress() {
        return stdAddress;
    }

    public void setStdAddress(String stdAddress) {
        this.stdAddress = stdAddress;
    }

    @Override
    public String toString() {
        return "Student{" +
                "stdId=" + stdId +
                ", stdName='" + stdName + '\'' +
                ", fatherName='" + fatherName + '\'' +
                ", stdSemester=" + stdSemester +
                ", stdEmail='" + stdEmail + '\'' +
                ", stdDob='" + stdDob + '\'' +
                ", stdAddress='" + stdAddress + '\'' +
                '}';
    }
}
