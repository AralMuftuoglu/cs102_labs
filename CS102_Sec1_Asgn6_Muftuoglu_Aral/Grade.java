package CS102_Sec1_Asgn6_Muftuoglu_Aral;

public class Grade {

    // Variables
    private String examName;
    private float weight;
    private float point;

    // Constructor
    public Grade(String name, float examWeight, float examPoint) {
        this.examName = name;
        this.weight = examWeight;
        this.point = examPoint;
    }

    // Getter methods
    public String getExamName() {
        return this.examName;
    }

    public float getExamWeight() {
        return this.weight;
    }

    public float getExamPoint() {
        return this.point;
    }

    // Setter methods
    public void setExamName(String newName) {
        this.examName = newName;
    }

    public void setExamWeight(float newWeight) {
        this.weight = newWeight;
    }

    public void setExamPoint(float newPoint) {
        this.point = newPoint;
    }

    public String gradeToString() {
        String gradeOutput;

        gradeOutput = this.examName + " (Weight: " + this.weight + " ) " + this.point;

        return gradeOutput;
    }

}
