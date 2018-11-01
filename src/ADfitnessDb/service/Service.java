
package ADfitnessDb.service;

import adfitness.utils.ADfitnessDb;
import equipement.Equipement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;




public class Service {
    private Connection cnx;

    public Service() {
        cnx=ADfitnessDb.getInstance().getCnx();
    }
    public boolean ajouterEquipement(Equipement e) throws SQLException{
        String req="insert into equipements (libelle,reference,domaine,salle) values('"+e.getLibelle()+"','"+e.getReference()+"','"+e.getDomaine()+"','"+e.getSalle()+"')";
        Statement st=cnx.createStatement();
        int a=st.executeUpdate(req);
        if(a>0)
        {
            System.out.println("l'equipement e ete inseré avec succé");
            return true;
        }
        else
            System.out.println("echec de l'insertion");
        return false;
    }
    public boolean supprimerEquipement(int id) throws SQLException{
        String req="DELETE FROM equipements WHERE id= "+id;
        Statement st=cnx.createStatement();
        int a = st.executeUpdate(req);
         if(a>0)
        {
            System.out.println("l'equipement e ete supprimé de la base de données");
            return true;
        }
        else
            System.out.println("echec de la suppression ");
         return false;
    }
    
    public boolean modifierEquipement(Equipement e) {
         
        try {
            String requete = "UPDATE `equipements` SET `libelle`=?,`reference`=?,`domaine`=?,`salle`=?,`etat`=?,`date`=?  WHERE id=?";
            PreparedStatement pst = cnx.prepareStatement(requete);
            pst.setString(1, e.getLibelle());
            pst.setString(2, e.getReference());
             pst.setString(3, e.getDomaine());
            pst.setString(4, e.getSalle());
            pst.setString(5, e.getEtat());
            pst.setString(6, e.getDate());
            pst.setInt(7, e.getId());
            int a=pst.executeUpdate();
             if(a>0)
        {
            System.out.println("la modification a ete affectué avec succé");
            return true;
        }
        else
            System.out.println("echec de la modification");
         return false;
             
       
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            
        }
        return false;
       
    }
  // public void afficherEquipements() throws SQLException
//    {
//        String req="select * from equipements ";
//        Statement st=cnx.createStatement();
//        ResultSet rs=st.executeQuery(req);
//        while(rs.next()){
//            System.out.println("id :"+" "+rs.getInt("id")+" "+"nom  :"+" "+rs.getString("nom")+" "+"reference :"+" "+rs.getString("reference")+" "+"domaine :"+" "+rs.getString("domaine")+" "+"salle :"+" "+rs.getString("salle")+" "+"date :"+" "+rs.getString("date"));
//        }
//    }
    public List<Equipement> getAllEquipements() throws SQLException
    {   
        List <Equipement> equipements= new ArrayList<>();
        String req="SELECT * FROM equipements";
        Statement stm=cnx.createStatement();
        ResultSet rst=stm.executeQuery(req);
        while (rst.next()){
            Equipement p=new Equipement(rst.getInt("id"),rst.getString("libelle"),rst.getString("reference"),rst.getString("domaine"),rst.getString("salle"),rst.getString("etat"),rst.getString("date"));
            equipements.add(p);
        }
        return equipements;
    }    
    public int getNombre(String s) throws SQLException{
        int x=0;
        String req="SELECT * FROM equipements WHERE etat='"+s+"'";
        Statement st=cnx.createStatement();
        ResultSet rst=st.executeQuery(req);
         while (rst.next()){
            x++;
        }
         return x;
    }
    public int getEquipementNbr (String a,String b,String c) throws SQLException
    {
        String req="SELECT COUNT(*) as nb FROM equipements WHERE libelle=? and reference=? and salle=?";
         PreparedStatement pst = cnx.prepareStatement(req);
            pst.setString(1, a);
            pst.setString(2, b);
            pst.setString(3, c);
             ResultSet rs=pst.executeQuery();
             if(rs.next())
             return (rs.getInt("nb"));
             else
                 return -3;
    }
}

