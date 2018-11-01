
package ADmain;

import ADfitnessDb.service.Service;
import equipement.Equipement;
import java.sql.SQLException;
import javax.swing.JOptionPane;


/**
 *
 * @author pc-dell
 */
public class ADEquip  {
    public static void main(String[] args)  throws SQLException{
        Service s=new Service();
        Equipement e=new Equipement("aze", "zdfFfz", "rt","fg");
               Equipement e1=new Equipement("7amdi", "foulen", "falten","absent");
                              Equipement e2=new Equipement("7amdi", "foulen", "falten","absent");


        //System.out.println(e);
    // s.ajouterEquipement(e);
       //  s.ajouterEquipement(e1);
 //  s.supprimerEquipement(1);
   //s.modifierNom(5, "zakareya");
   //s.modifierReference(5, "1");
     // s.modifierDomaine(6, "2");
       //  s.modifierEmplacement(7, "3");
     //  s.remplacerEquipement(7, e);
//s.afficherEquipements();
//String a=e2.getDate();
       // System.out.println(e);
      //  int x=s.getNombre("Fonctionnel");
       // System.out.println(x);
     //  int n=s.getEquipementNbr("hamdi", "foulen");
        //System.out.println(n);
      JOptionPane jop = new JOptionPane(), jop2 = new JOptionPane();
    //String nom = jop.showInputDialog(null, "Veuillez décliner votre identité !", "Gendarmerie nationale !", JOptionPane.QUESTION_MESSAGE);
    String nom = jop.showInputDialog("aaa!dddddddddddddddddddd d","ddddddddddddddddddddddddddddddd");
//   //jop2.showMessageDialog(null, "Votre nom est " + nom, "Identité", JOptionPane.INFORMATION_MESSAGE);
       System.out.println(nom);
//        if(nom.equals(""))
//            System.out.println("chaine vide");
// int n = Integer.parseInt("1m");
      //  System.out.println(n);
//      String nom="";
//      char ref=nom.charAt(0);
//        System.out.println(ref);
    }
    
}
