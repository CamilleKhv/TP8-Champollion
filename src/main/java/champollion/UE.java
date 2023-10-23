package champollion;

public class UE {
    private final String myIntitule;
    private int heuresCM;
    private int heuresTD;
    private int heuresTP;

    public UE(String intitule, int heuresCM, int HeuresTD, int heuresTP) {

        myIntitule = intitule;
        this.heuresCM = heuresCM;
        this.heuresTD = heuresTD;
        this.heuresTP = heuresTP;
    }

    public UE(String intitule) {
        myIntitule = intitule;

    }

    public String getIntitule() {
        return myIntitule;
    }

    public int getHeuresCM() {
        return heuresCM;
    }

    public int getHeuresTD() {
        return heuresTP;
    }

    public int getHeuresTP() {
        return heuresTP;
    }
}
