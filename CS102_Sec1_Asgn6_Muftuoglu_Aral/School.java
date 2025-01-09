package CS102_Sec1_Asgn6_Muftuoglu_Aral;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class School {

    private int numberOfStudents;
    private Student[] students;

    public School() {
        this.students = new Student[10];
        this.numberOfStudents = 0;
    }

    public void addStudent(String schoolID, String name, String surname, int age) {

        // throw exception for duplicated id
        for (int i = 0; i < this.students.length; i++) {

            try {
                if (this.students[i] != null) {
                    if (this.students[i].getStudentId().equals(schoolID)) {
                        throw new IllegalArgumentException("Duplicate ID: " + schoolID);
                    }
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Eror: " + e.getMessage());
                System.out.println();
                return;
            }

        }

        Student newStudent = new Student(name, surname, age, schoolID);

        // insert the correct place
        int correctIndex = 0;
        int z = 0;

        while (z < this.students.length) {

            if (this.students[z] != null) {
                if (Long.parseLong(this.students[z].getStudentId()) > Long.parseLong(schoolID)) {// they are converted
                                                                                                 // to long type becuse
                                                                                                 // they are too big to
                                                                                                 // be intgere
                    correctIndex = z;
                    break;
                } else {
                    correctIndex = numberOfStudents;// last index
                }
            }
            z++;
        }

        Student[] studentsNewPlace = new Student[this.students.length];

        for (int i = 0; i < this.students.length; i++) {
            studentsNewPlace[i] = this.students[i];
        }

        if (correctIndex >= 0) {
            for (int a = 1; a + correctIndex < this.students.length; a++) {
                studentsNewPlace[a + correctIndex] = this.students[a + correctIndex - 1];
            }
        }

        studentsNewPlace[correctIndex] = newStudent;

        this.students = studentsNewPlace;

        numberOfStudents++;

        // new double array of students
        if (this.numberOfStudents > this.students.length / 2) {
            int newStudentsSize = this.students.length * 2;

            Student[] newStudents = new Student[newStudentsSize];

            for (int i = 0; i < this.students.length; i++) {
                newStudents[i] = this.students[i];
            }

            this.students = newStudents;
        }
    }

    // recursive binary search method
    public Student getStudent(String schoolID) {

        int studentIndexWithId;

        studentIndexWithId = getStudentHelper(schoolID, this.students, 0, numberOfStudents - 1);

        try {
            if (studentIndexWithId == -1) {
                throw new IllegalArgumentException("No such student with the id " + schoolID + "!");
            }
        } catch (Exception e) {
            System.out.println("Eror: " + e.getMessage());
            System.out.println();
            return null;
        }

        return this.students[studentIndexWithId];
    }

    // helper
    private int getStudentHelper(String studentId, Student[] studentList, int startIndex, int endIndex) {

        int returnIndex;

        int middleIndex;

        if (endIndex < startIndex) {
            return -1;// in case of there is no student with tihs id number

        }

        middleIndex = startIndex + (endIndex - startIndex) / 2;

        if (this.students[middleIndex].getStudentId().equals(studentId)) {
            returnIndex = middleIndex;

            return returnIndex;
        } else if (Long.parseLong(this.students[middleIndex].getStudentId()) > Long.parseLong(studentId)) {
            return getStudentHelper(studentId, studentList, startIndex, middleIndex - 1);
        } else {
            return getStudentHelper(studentId, studentList, middleIndex + 1, endIndex);
        }

    }

    // name order by quickSort algorithm
    public Student[] getStudentByNameOrder() {
        Student[] sortedSutudents= new Student[this.numberOfStudents];

        for(int i=0;i<sortedSutudents.length;i++)
        {
            sortedSutudents[i]=this.students[i];
        }
        
        sortedSutudents = quickSortHelper(sortedSutudents, 0, sortedSutudents.length-1);

        return sortedSutudents;
    }

    // helper method
    private Student[] quickSortHelper(Student[] studentList, int first, int last) {

         if (first < last) {
            
            Student pivotElement= studentList[first];
            
            int splitPoint;
            
            splitPoint = partition(studentList, pivotElement, first, last);// position

            quickSortHelper(studentList, first, splitPoint-1);// for smaller numbers

            quickSortHelper(studentList, splitPoint + 1, last);// for bigger numbers


        }

        return studentList;
    }

    // partition metho
    private int partition(Student[] studentList,Student pivotElement, int start, int end) {
        
        int newPivotIndex;

        Student pivot = pivotElement;

        String[] pivotNames = { pivot.getStudentName(), pivot.getStudentSurname() };

        int biggestIndex = start + 1;
        int smallestIndex = end;

        while (smallestIndex >= biggestIndex) {
            while (biggestIndex<=smallestIndex&&(studentList[biggestIndex].getStudentName().compareTo(pivotNames[0]) < 0
                    || (studentList[biggestIndex].getStudentName().compareTo(pivotNames[0]) == 0
                            && studentList[biggestIndex].getStudentSurname().compareTo(pivotNames[1]) <= 0))) {
                biggestIndex++;
            }
            while (smallestIndex>=biggestIndex&&(studentList[smallestIndex].getStudentName().compareTo(pivotNames[0]) > 0
                    || (studentList[smallestIndex].getStudentName().compareTo(pivotNames[0]) == 0
                            && studentList[smallestIndex].getStudentSurname().compareTo(pivotNames[1]) >= 0)) ){
                smallestIndex--;
            } 

            if (biggestIndex < smallestIndex) {
                Student tempStudent = studentList[biggestIndex];
                studentList[biggestIndex] = studentList[smallestIndex];
                studentList[smallestIndex] = tempStudent;
            }
        }

        // swap the smallest with pivot
        Student newTempStudent = studentList[smallestIndex];
        studentList[smallestIndex] = pivot;
        studentList[start] = newTempStudent;

        newPivotIndex = smallestIndex;

        return newPivotIndex;
    }

    // print students by name order
    public void printStudentsByNameOrder() {
        Student[] sortedStudents = getStudentByNameOrder();

        for (int i = 0; i < sortedStudents.length; i++) {
            if(sortedStudents[i]!=null)
            {
                System.out.println(sortedStudents[i].toString());

            }
        }

        System.out.println();
    }

    // print students by id number
    public void printStudents() {

        for (int a = 0; a < this.students.length; a++) {

            if (this.students[a] != null) {
                System.out.println(this.students[a].toString());

            }
        }
        System.out.println();
    }

    // grade average method
    public float getGradeAverage(Student s) {

        if (s != null) {
            float averageGrade;
            float totalGrade = 0;
            float totalWeight = 0;

            for (int i = 0; i < s.getStudentGrades().length; i++) {
                totalGrade += s.getStudentGrades()[i].getExamPoint() * s.getStudentGrades()[i].getExamWeight();
                totalWeight += s.getStudentGrades()[i].getExamWeight();
            }
            averageGrade = totalGrade / totalWeight;

            return averageGrade;
        } else {
            return 0;
        }

    }

    // printing the list of students sorted based on grade averages
    public void printStudentGradeAverages() {
        Student[] sortedStudents = new Student[this.students.length];

        for (int i = 0; i < this.students.length; i++) {
            sortedStudents[i] = this.students[i];
        }

        // sorting by selection sort algorithm based on average grades
        for (int i = 0; i < sortedStudents.length; i++) {
            if (sortedStudents[i] != null) {
                int currentMaxIndex = i;

                for (int m = i + 1; m < sortedStudents.length; m++) {
                    if (sortedStudents[m] != null) {
                        if (getGradeAverage(sortedStudents[m]) > getGradeAverage(sortedStudents[i]) ||
                                (getGradeAverage(sortedStudents[m]) == getGradeAverage(sortedStudents[i]) &&
                                        Long.parseLong(sortedStudents[m].getStudentId()) < Long
                                                .parseLong(sortedStudents[i].getStudentId()))) {
                            currentMaxIndex = m;

                            // swap students
                            Student tempStudent = sortedStudents[i];
                            sortedStudents[i] = sortedStudents[currentMaxIndex];
                            sortedStudents[currentMaxIndex] = tempStudent;
                        }

                    }
                }
            }

        }
        // printing students
        for (int i = 0; i < sortedStudents.length; i++) {

            if (sortedStudents[i] != null) {
                if (sortedStudents[i].getStudentGrades().length > 0) {// check that student have at least one grade
                    System.out.println(
                            sortedStudents[i].toString() + " - Average: " + getGradeAverage(sortedStudents[i]));
                }
            }

        }
        System.out.println();
    }

    // student print grades list method
    public void printGradesOf(String schoolId) {
        Student studentToShow = getStudent(schoolId);

        System.out.println("Student: " + studentToShow.toString());
        System.out.println("Grades:");

        for (int i = 0; i < studentToShow.getStudentGrades().length; i++) {
            System.out.println(studentToShow.getStudentGrades()[i].gradeToString());
        }
        System.out.println();

    }

    public void processTextFile(String filename) {

        // try-catch block for eror:unhandled exception file not found
        try {

            File fileToProcess = new File(filename);

            Scanner fileScanner = new Scanner(fileToProcess);

            while (fileScanner.hasNextLine())// checking if the file is finished
            {
                String command = fileScanner.nextLine();

                if (command.contains(":"))// check whether line contains ":" or not ,for first 3 type of command
                {
                    String requestedAction = command.substring(0, command.indexOf(":"));
                    command = command.substring(command.indexOf(":") + 1, command.length());

                    // add student
                    if (requestedAction.equals("Student")) {

                        String studentName;
                        String studentSurname;
                        int studentAge;
                        String studenId;

                        String[] studentDatas = command.split(",");

                        studentName = studentDatas[0].substring(0, studentDatas[0].indexOf(" "));
                        studentSurname = studentDatas[0].substring(studentDatas[0].indexOf(" ") + 1);
                        studentAge = Integer.parseInt(studentDatas[1].trim());
                        studenId = studentDatas[2].trim();

                        addStudent(studenId, studentName, studentSurname, studentAge);

                    }
                    // add grade
                    else if (requestedAction.equals("Grade")) {
                        String studentId;
                        String examName;
                        float weight;
                        float point;

                        String[] gradeDatas = command.split(",");

                        studentId = gradeDatas[0].trim();
                        examName = gradeDatas[1].trim();
                        weight = Float.parseFloat(gradeDatas[2].trim());
                        point = Float.parseFloat(gradeDatas[3].trim());

                        Student addGradeFor = getStudent(studentId);

                        if (addGradeFor != null) {
                            addGradeFor.setGrade(examName, weight, point);
                        }
                    }
                    // print grades
                    else if (requestedAction.equals("GradesOf")) {
                        String studentId;

                        studentId = command.trim();

                        Student printGradeFor = getStudent(studentId);// Check if there is a student with this id number
                        
                        if(printGradeFor!=null)
                        {
                            printGradesOf(studentId);
                        }
                    }
                } else {
                    // print by name order
                    if (command.equals("PrintByNameOrder")) {
                        printStudentsByNameOrder();
                    }
                    // print by grade averages
                    else if (command.equals("PrintByGradeAverages")) {
                        printStudentGradeAverages();
                    }
                    // print students
                    else if (command.equals("PrintStudents")) {
                        printStudents();
                    }
                }
            }

            fileScanner.close();

        } catch (FileNotFoundException e) {
            System.err.println("an eror occured");
            ;
        }

    }

}