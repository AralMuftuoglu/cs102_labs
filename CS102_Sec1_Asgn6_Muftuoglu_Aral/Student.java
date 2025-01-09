package CS102_Sec1_Asgn6_Muftuoglu_Aral;

public class Student {

    private Grade[] grades;
    private int age;
    private String schoolId;
    private String surName;
    private String name;

    //constructor
    public Student(String studentName, String studentSurname, int studentAge, String studentId) {
        this.name = studentName;
        this.surName = studentSurname;
        this.age = studentAge;
        this.schoolId = studentId;

        this.grades = new Grade[0];

    }

    // Getter methods
    public String getStudentId() {
        return this.schoolId;
    }

    public String getStudentName() {
        return this.name;
    }

    public String getStudentSurname() {
        return this.surName;
    }

    public Grade[] getStudentGrades() {
        return this.grades;
    }

    public String toString() {
        String result;

        result = this.schoolId + ", " + this.name + " " + this.surName + ", " + this.age;

        return result;
    }

    public void setGrade(String examName, float weight, float points) {
        
        try {
            if (!(examName.length() > 3)) {
                throw new IllegalArgumentException(examName + " must be longer than 3 characters!");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Eror: "+e.getMessage());
            System.out.println();
            return;
        }
        
        int arrayLenght = this.grades.length;

        int a=1;

        for (int i = 0; i < arrayLenght; i++) {
            if (this.grades[i].getExamName().equals(examName)) {
                this.grades[i].setExamPoint(points);
                this.grades[i].setExamWeight(weight);
                a=-1;
                break;
            }
        }

        if(a!=-1)
        {
            Grade newGrade = new Grade(examName, weight, points);

            Grade[] newGradesList = new Grade[this.grades.length + 1];
    
            for (int i = 0; i < this.grades.length; i++) {
                newGradesList[i] = this.grades[i];
            }
    
            newGradesList[this.grades.length ] = newGrade;
    
            this.grades=newGradesList;
        }
        

    }
}
