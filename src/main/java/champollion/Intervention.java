package champollion;

import java.util.Date;

public class Intervention {
    private Date debut;
    private int duree;
    private boolean annulee = false;
    private int heureDebut;
    private UE ue;
    private Salle salle;
    private Enseignant enseignant;
    private TypeIntervention type;



    public Intervention(Date debut, int duree, boolean annulee, int heureDebut,UE ue, Salle salle,Enseignant enseignant,
                        TypeIntervention type)
    {
        this.debut = debut;
        this.duree = duree;
        this.annulee = annulee;
        this.heureDebut = heureDebut;
        this.ue = ue;
        this.salle = salle;
        this.enseignant = enseignant;
        this.type=type;
    }

    public void annuler(){
        this.annulee = true;
    }

    public Date getDebut() {
        return debut;
    }

    public UE getUe() {
        return ue;
    }
    public int getDuree() {
        return duree;
    }

    public boolean isAnnulee() {
        return annulee;
    }

    public TypeIntervention getType() {
        return type;
    }

}