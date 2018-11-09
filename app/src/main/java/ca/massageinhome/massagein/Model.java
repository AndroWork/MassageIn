package ca.massageinhome.massagein;

public class Model {

    private String massageType;
    private String duration;
    private String therapist;


    public Model(String massageType,String duration, String therapist) {
        this.massageType = massageType;
        this.duration = duration;
        this.therapist = therapist;
    }

    public String getMassageType() {
        return massageType;
    }

    public void setMassageType(String massageType) {
        this.massageType = massageType;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getTherapist() {return therapist;}

    public void setTherapist(String therapist) {this.therapist = therapist;}

}
