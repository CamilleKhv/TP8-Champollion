package champollion;

import java.util.ArrayList;

public class Enseignant extends Personne {

    ArrayList<ServicePrevu> servicePrevu = new ArrayList<>();
    ArrayList<Intervention> interventions = new ArrayList<>();

    public Enseignant(String nom, String email) {
        super(nom, email);
    }

    /**
     * Calcule le nombre total d'heures prévues pour cet enseignant en "heures équivalent TD" Pour le calcul : 1 heure
     * de cours magistral vaut 1,5 h "équivalent TD" 1 heure de TD vaut 1h "équivalent TD" 1 heure de TP vaut 0,75h
     * "équivalent TD"
     *
     * @return le nombre total d'heures "équivalent TD" prévues pour cet enseignant, arrondi à l'entier le plus proche
     *
     */
    public int heuresPrevues() {
        int equivalentTD = 0;
        for (ServicePrevu servicep : servicePrevu){
            equivalentTD += 1.5 * servicep.getVolumeCM();
            equivalentTD += servicep.getVolumeTD();
            equivalentTD += 0.75 * servicep.getVolumeTP();
        }
        return Math.round(equivalentTD);
    }

    /**
     * Calcule le nombre total d'heures prévues pour cet enseignant dans l'UE spécifiée en "heures équivalent TD" Pour
     * le calcul : 1 heure de cours magistral vaut 1,5 h "équivalent TD" 1 heure de TD vaut 1h "équivalent TD" 1 heure
     * de TP vaut 0,75h "équivalent TD"
     *
     * @param ue l'UE concernée
     * @return le nombre total d'heures "équivalent TD" prévues pour cet enseignant, arrondi à l'entier le plus proche
     *
     */
    public int heuresPrevuesPourUE(UE ue) {
        int equivalentTD_UE = 0;

        for (ServicePrevu servicep : servicePrevu){
            if (servicep.getUe() == ue){
                equivalentTD_UE += 1.5 * servicep.getVolumeCM();
                equivalentTD_UE += servicep.getVolumeTD();
                equivalentTD_UE += 0.75 * servicep.getVolumeTP();
            }
        }
        return Math.round(equivalentTD_UE);
    }

    /**
     * Ajoute un enseignement au service prévu pour cet enseignant
     *
     * @param ue l'UE concernée
     * @param volumeCM le volume d'heures de cours magitral
     * @param volumeTD le volume d'heures de TD
     * @param volumeTP le volume d'heures de TP
     */
    public void ajouteEnseignement(UE ue, int volumeCM, int volumeTD, int volumeTP) {
        ServicePrevu servicep = new ServicePrevu (volumeCM, volumeTD, volumeTP, ue, this);
        servicePrevu.add(servicep);
    }

    public void ajouteIntervention(Intervention inter){
        interventions.add(inter);
    }

    public boolean enSousService(){
        if(heuresPrevues()>= 192){
            return false;
        }else{
            return true;
        }
    }

    public int resteAPlanifier( UE ue, TypeIntervention type){
        int result = 0;
        if(type == TypeIntervention.TD)
        {
            result = 192 - ue.getHeuresTD();
        }
        if(type == TypeIntervention.CM)
        {
            result = 192 - ue.getHeuresCM();
        }
        if(type == TypeIntervention.TP)
        {
            result = 192 - ue.getHeuresTP();
        }
        if(result < 0)
        {
            result = 0;
        }
        return result;
    }

}
