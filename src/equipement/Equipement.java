
package equipement;


public class Equipement {
    private int id;
    private String reference;
    private String libelle;
    private String domaine;
    private String salle;
    private String date;
    private String etat;


    public Equipement() {
    }
     public Equipement( int id,String libelle,String ref, String domaine, String salle,String etat,String date) {
        this.reference = ref;
        this.libelle = libelle;
        this.domaine = domaine;
        this.salle = salle;
        this.id = id;
        this.date = date;
        this.etat = etat;
    }

    public Equipement( String libelle,String ref, String domaine, String salle) {
        this.reference = ref;
        this.libelle = libelle;
        this.domaine = domaine;
        this.salle = salle;
    }
    public String getEtat() {
        return etat;
    }
public String getDate() {
        return date;
    }
    public int getId() {
        return id;
    }

    public String getReference() {
        return reference;
    }

    public String getLibelle() {
        return libelle;
    }

    public String getDomaine() {
        return domaine;
    }

    public String getSalle() {
        return salle;
    }

    @Override
    public String toString() {
        return "Equipement{" + "id=" + id + ", reference=" + reference + ", libelle=" + libelle + ", domaine=" + domaine + ", salle=" + salle + ", etat=" + etat + ", date=" + date + '}';
    }

   
    
}
