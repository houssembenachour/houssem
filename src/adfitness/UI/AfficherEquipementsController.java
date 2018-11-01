/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adfitness.UI;

import ADfitnessDb.service.Service;
import static com.sun.org.apache.xml.internal.security.keys.keyresolver.KeyResolver.length;
import equipement.Equipement;
import java.io.IOException;
import static java.lang.System.exit;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import javax.swing.event.UndoableEditListener;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;

import javax.swing.text.Position;
import javax.swing.text.Segment;
import java.io.FileOutputStream;
import java.util.Date;
import com.itextpdf.text.Element;
import com.itextpdf.text.Document;
import com.itextpdf.text.Anchor;
import com.itextpdf.text.BadElementException;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chapter;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.List;
import com.itextpdf.text.ListItem;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.Section;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Color;
import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javafx.scene.layout.Border;
import static javafx.scene.paint.Color.color;
import javax.swing.JOptionPane;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 * FXML Controller class
 *
 * @author pc-dell
 */
public class AfficherEquipementsController implements Initializable {

    @FXML
    private TableView<Equipement> tab;
    @FXML
    private TableColumn<Equipement, String> libelle;
    @FXML
    private TableColumn<Equipement, String> reference;
    @FXML
    private TableColumn<Equipement, String> domaine;
    @FXML
    private TableColumn<Equipement, String> salle;
    @FXML
    private TableColumn<Equipement, String> etat;
    @FXML
    private TableColumn<Equipement, String> date;
     @FXML
    private Button btn_modif;
     @FXML
    private Button btn_supp;
     @FXML
    private Label lab_nom;
     @FXML
    private Label lab_reference;
       @FXML
    private Label lab_domaine;
         @FXML
    private Label lab_salle;
           @FXML
    private Label lab_date;
            @FXML
    private Label lab_err;
            @FXML
    private Button btn_validerm;
            @FXML
    private Button btn_annuler;
            @FXML
    private TextField tf_nom;
            @FXML
    private TextField tf_reference;
    
            @FXML
    private TextField tf_date;
   
            @FXML
    private TextField tf_id;
            @FXML
            private Button btn_validers;
      @FXML
    private Label lab_info;
       @FXML
    private Label lab_ajout_err;
            @FXML
    private TextField tf_ajout_nom;
             @FXML
    private TextField tf_ajout_reference;
    private TextField tf_ajout_domaine;
    private TextField tf_ajout_salle;
               @FXML
            private Button btn_ajouter;
               @FXML
            private Button btn_reset;
    @  FXML
    private Label lab_ajout;
    @FXML
    private ComboBox<String> cb_salle;
    @FXML
    private ComboBox<String> cb_domaine;
    @FXML
    private ComboBox<String> cb_ajout_domaine;
    @FXML
    private ComboBox<String> cb_ajout_salle;
    @FXML
    private Button btn_imprimer;
    @FXML
    private ComboBox<String> cb_etat;
    @FXML
    private Label lab_etat;
    @FXML
    private Button btn_stat;
    @FXML
    private Button btn_dup;
    @FXML
    private Label lab_info_dup;
    
    

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        cb_ajout_salle.getItems().addAll("B1","B2","P","A1","A2","G");
        cb_ajout_domaine.getItems().addAll("Taekwondo","Karate","Natation","Bodybuilding","Gymnastique");
        cb_salle.getItems().addAll("B1","B2","P","A1","A2","G");
        cb_domaine.getItems().addAll("Taekwondo","Karate","Natation","Bodybuilding","Gymnastique");
        cb_etat.getItems().addAll("Fonctionnel","Non Fonctionnel","En maintenance");
        Service s=new Service();
    (lab_nom).setVisible(false);
    (lab_reference).setVisible(false);
    (lab_domaine).setVisible(false);
    (lab_salle).setVisible(false);
    (lab_date).setVisible(false);
    (lab_etat).setVisible(false);
   (tf_nom).setVisible(false);
    (tf_reference).setVisible(false);
    (cb_domaine).setVisible(false);
     (cb_salle).setVisible(false);
   (cb_etat).setVisible(false);
    (tf_date).setVisible(false);
    (tf_id).setVisible(false);
    (btn_validerm).setVisible(false);
    (btn_validers).setVisible(false);
    (btn_annuler).setVisible(false);
    lab_err.setVisible(false);
   lab_ajout_err.setVisible(false);
   lab_info.setVisible(false);
   lab_info_dup.setVisible(false);
        try {
            ArrayList<Equipement> equipements = (ArrayList <Equipement>) s.getAllEquipements();
            ObservableList obs= FXCollections.observableArrayList(equipements);
            tab.setItems(obs);
            libelle.setCellValueFactory(new PropertyValueFactory<>("libelle"));
            reference.setCellValueFactory(new PropertyValueFactory<>("reference"));
            domaine.setCellValueFactory(new PropertyValueFactory<>("domaine"));
            salle.setCellValueFactory(new PropertyValueFactory<>("salle"));
            etat.setCellValueFactory(new PropertyValueFactory<>("etat"));
            date.setCellValueFactory(new PropertyValueFactory<>("date"));
            
        } catch (SQLException ex) {
            Logger.getLogger(AfficherEquipementsController.class.getName()).log(Level.SEVERE, null, ex);
        }
        btn_annuler.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                FXMLLoader loader=new FXMLLoader(getClass().getResource("afficherEquipements.fxml"));
         Parent root;
        try {
            root= loader.load();
            btn_annuler.getScene().setRoot(root);
        } catch (IOException ex) {
            Logger.getLogger(AfficherEquipementsController.class.getName()).log(Level.SEVERE, null, ex);
        } 
            }    
    });
        btn_modif.setOnAction(new EventHandler<ActionEvent>() {
            
             @Override
             public void handle(ActionEvent event) {
                 int x=0;
                  Equipement e=(Equipement) tab.getSelectionModel().getSelectedItem();
        if(tab.getSelectionModel().getSelectedItem()==null)     
       {
           Alert alerta = new Alert(Alert.AlertType.ERROR);               
                         alerta.setTitle("Notification");
                         alerta.setContentText("vous devez choisir un produit pour le modifier !!!");
                         alerta.showAndWait();     
       }
       else
           {
         (lab_nom).setVisible(true);
    (lab_reference).setVisible(true);
    (lab_domaine).setVisible(true);
    (lab_salle).setVisible(true);
    (lab_date).setVisible(true);
    (lab_etat).setVisible(true);
   (tf_nom).setVisible(true);
    (tf_reference).setVisible(true);
    (cb_domaine).setVisible(true);
        (cb_etat).setVisible(true);
        (cb_salle).setVisible(true);
   (cb_domaine).setDisable(false);
        (cb_salle).setDisable(false);
    (tf_date).setVisible(true);
    (btn_validerm).setVisible(true);
    (btn_validers).setVisible(false);
    (btn_annuler).setVisible(true);
    lab_info_dup.setText("");
lab_ajout_err.setText("");
lab_err.setText("");
lab_info.setVisible(true);
lab_info_dup.setVisible(false);
lab_ajout_err.setVisible(false);
lab_err.setVisible(false);
                 Service ps=new Service();     
    String id = String.valueOf(e.getId());
            tf_id.setText(id);
            tf_nom.setText(e.getLibelle());
            tf_reference.setText(e.getReference());
            tf_date.setText(e.getDate());
            lab_info.setText("vous etes entrain de modifier ce produit :");
            (tf_id).setEditable(false);
             (tf_date).setEditable(false);
             (tf_nom).setEditable(true);
            (tf_reference).setEditable(true);
            (cb_salle).setDisable(false);
           (cb_salle).setStyle("-fx-opacity: 1;");
            (cb_domaine).setDisable(false);
           (cb_domaine).setStyle("-fx-opacity: 1;");
           (cb_etat).setDisable(false);
           (cb_etat).setStyle("-fx-opacity: 1;");
            if(e.getSalle().equalsIgnoreCase("B1"))
            {
                cb_salle.getSelectionModel().select(0);  
            }
            else if(e.getSalle().equalsIgnoreCase("B2"))
            {
                cb_salle.getSelectionModel().select(1);  
            }
            else  if(e.getSalle().equalsIgnoreCase("P"))
            {
                cb_salle.getSelectionModel().select(2);  
            }
              else if(e.getSalle().equalsIgnoreCase("A1"))
            {
                cb_salle.getSelectionModel().select(3); 
            }
              else if(e.getSalle().equalsIgnoreCase("A2"))
            {
                cb_salle.getSelectionModel().select(4); 
            }
                else 
            {
                cb_salle.getSelectionModel().select(5);  
            }
             if(e.getDomaine().equalsIgnoreCase("Taekwondo"))
            {
                cb_domaine.getSelectionModel().select(0);  
            }
             else if(e.getDomaine().equalsIgnoreCase("Karate"))
            {
                cb_domaine.getSelectionModel().select(1);  
            }
            else  if(e.getDomaine().equalsIgnoreCase("Natation"))
            {
                cb_domaine.getSelectionModel().select(2);  
            }
              else if(e.getDomaine().equalsIgnoreCase("Bodybuilding"))
            {
                cb_domaine.getSelectionModel().select(3); 
            }
              else 
            {
                cb_domaine.getSelectionModel().select(4); 
            }
              if(e.getEtat().equalsIgnoreCase("Fonctionnel"))
            {
                cb_etat.getSelectionModel().select(0);  
            }
            else if(e.getEtat().equalsIgnoreCase("Non Fonctionnel"))
            {
                cb_etat.getSelectionModel().select(1);  
            }
            else  
            {
                cb_etat.getSelectionModel().select(2);  
            }
             }}
    });
        btn_validerm.setOnAction(new EventHandler<ActionEvent>() {
             @Override
             public void handle(ActionEvent event) {
                 int j ;
                 int x=0;
                 int b= Integer.parseInt(tf_id.getText());
                 String salle=cb_salle.getSelectionModel().getSelectedItem();
                String domaine=cb_domaine.getSelectionModel().getSelectedItem();             
                 Equipement e=new Equipement(b,tf_nom.getText(), tf_reference.getText(), cb_domaine.getValue(), cb_salle.getValue(), cb_etat.getValue(),tf_date.getText());
                  Service s=new Service();              
       if((e.getLibelle().contains("  "))||(e.getReference().contains("  ")))
       {
           x++;
           lab_err.setVisible(true);
           (lab_err).setText("le libelle et la reference de doivents pas contenir\n 2 espaces successives");
       }
         if(e.getLibelle().length()>0)
       {
            char liba=e.getLibelle().charAt(0);
             if((liba<'A')||(liba>'Z'))
             { x++;
                        lab_err.setVisible(true);
                        (lab_err).setText(" Le libelle doit commencer par une lettres\n majuscule");}
       }
         if(e.getReference().length()>0)
       {
            char ref=e.getReference().charAt(0);
             if(((ref<'A')||(ref>'Z'))&&((ref>'9')||(ref<'0')))
             { x++;
                        lab_err.setVisible(true);
                       (lab_err).setText("La reference doit commencer par une lettre\n majuscule ou un chiffre");}
       }
       for(j=1;j<e.getLibelle().length();j++)
                  {
                      char lib=e.getLibelle().charAt(j);
                   if(((lib<'A')||(lib>'Z')&&(lib<'a')||(lib>'z'))&&(lib!=' ')&&(lib!='-')&&(lib!='_')&&(lib!='é')&&(lib!='è'))
                   {  x++;
                       lab_err.setVisible(true);
                      (lab_err).setText(" verifiez votre Libelle");}
                  }
                if(((salle.equalsIgnoreCase("null"))||(domaine.equalsIgnoreCase("null")||(e.getReference().length() <3)||(e.getLibelle().length() <3))))//||(e.getNom().equalsIgnoreCase(""))&&(e.getReference().equalsIgnoreCase("")))&&(e.getSalle().equalsIgnoreCase("")))
                {
                    lab_err.setVisible(true);
                    (lab_err).setText("un ou plusieurs champs vides \nou trop court");
                   x++;
                }       
                 if(x==0) 
                  {
                      lab_info_dup.setText("");
                      lab_ajout_err.setText("");
                      lab_err.setText("");   
                      lab_info_dup.setVisible(false);
                      lab_ajout_err.setVisible(false);
                      lab_err.setVisible(false);   
                  Alert alert = new Alert(Alert.AlertType.CONFIRMATION);        
                         alert.setTitle("Notification");
                         alert.setContentText("Etes vous sure de vouloir modifier ?");
                         Optional<ButtonType> result = alert.showAndWait();
ButtonType button = result.orElse(ButtonType.CANCEL);

if (button == ButtonType.OK) {
                     if (s.modifierEquipement(e)) {
                         lab_info.setText("ce produit a ete modifié ");
                         alert.setTitle("Notification");
                         alert.setContentText("Equipement modifié avec succés");
                         alert.showAndWait();
                     } else {
                         Alert alerta = new Alert(Alert.AlertType.ERROR);                    
                         alerta.setTitle("Notification");
                         alerta.setContentText("ECHEC de la modification");
                         alerta.showAndWait();
                     } 
}
            }}
       
    });
         btn_supp.setOnAction(new EventHandler<ActionEvent>() {
             @Override
             public void handle(ActionEvent event) {
                 Equipement e=(Equipement) tab.getSelectionModel().getSelectedItem();
        if(tab.getSelectionModel().getSelectedItem()==null)
       {
           Alert alerta = new Alert(Alert.AlertType.ERROR);   
                         alerta.setTitle("Notification");
                         alerta.setContentText("vous devez choisir un produit pour le SUPPRIMER !!!");
                         alerta.showAndWait();
       }
       else
           {
         (lab_nom).setVisible(true);
    (lab_reference).setVisible(true);
    (lab_domaine).setVisible(true);
    (lab_salle).setVisible(true);
    (lab_date).setVisible(true);
        (lab_etat).setVisible(true);
   (tf_nom).setVisible(true);
    (tf_reference).setVisible(true);
    (cb_domaine).setVisible(true);
        (cb_etat).setVisible(true);
    (cb_salle).setVisible(true);
    (tf_date).setVisible(true);
    (btn_validers).setVisible(true);
        (btn_validerm).setVisible(false);
    (btn_annuler).setVisible(true);
    lab_info_dup.setText("");
    lab_err.setText("");
    lab_ajout_err.setText("");
    lab_info.setVisible(true);
    lab_info_dup.setVisible(false);
    lab_err.setVisible(false);
    lab_ajout_err.setVisible(false);
     Service ps=new Service();    
    String id = String.valueOf(e.getId());
            tf_id.setText(id);
            tf_nom.setText(e.getLibelle());
            tf_reference.setText(e.getReference());
            tf_date.setText(e.getDate());
            (tf_nom).setEditable(false);
            (tf_date).setEditable(false);
            (tf_reference).setEditable(false);
           (cb_salle).setDisable(true);
           (cb_salle).setStyle("-fx-opacity: 1;");
            (cb_domaine).setDisable(true);
           (cb_domaine).setStyle("-fx-opacity: 1;");
           (cb_etat).setDisable(true);
           (cb_etat).setStyle("-fx-opacity: 1;");
             lab_info.setText("vous etes entrain de supprimer ce produit :");
             if(e.getSalle().equalsIgnoreCase("B1"))
            {
                cb_salle.getSelectionModel().select(0);  
            }
            else if(e.getSalle().equalsIgnoreCase("B2"))
            {
                cb_salle.getSelectionModel().select(1);  
            }
            else  if(e.getSalle().equalsIgnoreCase("P"))
            {
                cb_salle.getSelectionModel().select(2);  
            }
              else if(e.getSalle().equalsIgnoreCase("A1"))
            {
                cb_salle.getSelectionModel().select(3); 
            }
              else if(e.getSalle().equalsIgnoreCase("A2"))
            {
                cb_salle.getSelectionModel().select(4); 
            }
                else 
            {
                cb_salle.getSelectionModel().select(5);  
            }
             if(e.getDomaine().equalsIgnoreCase("Taekwondo"))
            {
                cb_domaine.getSelectionModel().select(0);  
            }
             else if(e.getDomaine().equalsIgnoreCase("Karate"))
            {
                cb_domaine.getSelectionModel().select(1);  
            }
            else  if(e.getDomaine().equalsIgnoreCase("Natation"))
            {
                cb_domaine.getSelectionModel().select(2);  
            }
              else if(e.getDomaine().equalsIgnoreCase("Bodybuilding"))
            {
                cb_domaine.getSelectionModel().select(3); 
            }
              else 
            {
                cb_domaine.getSelectionModel().select(4); 
            }
              if(e.getEtat().equalsIgnoreCase("Fonctionnel"))
            {
                cb_etat.getSelectionModel().select(0);  
            }
            else if(e.getEtat().equalsIgnoreCase("Non Fonctionnel"))
            {
                cb_etat.getSelectionModel().select(1);  
            }
            else  
            {
                cb_etat.getSelectionModel().select(2);  
            }
             }}
    });
          btn_validers.setOnAction(new EventHandler<ActionEvent>() {
             @Override
             public void handle(ActionEvent event) {
                 int b= Integer.parseInt(tf_id.getText());
                  Service s=new Service();
                  Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                         alert.setTitle("Notification");
                         alert.setContentText("Etes vous sure de vouloir supprimer cet equipement  ?");
                         Optional<ButtonType> result = alert.showAndWait();
ButtonType button = result.orElse(ButtonType.CANCEL);

if (button == ButtonType.OK) {
                     try {
                         if (s.supprimerEquipement(b)) {
                             alert.setTitle("Notification");
                             alert.setContentText("Equipement supprimé avec succés");
                             alert.showAndWait();
                         } else {
                             Alert alerta = new Alert(Alert.AlertType.ERROR);
                             alerta.setTitle("Notification");
                             alerta.setContentText("ECHEC de la suppression");
                             alerta.showAndWait();
                         } 
                     } catch (SQLException ex) {
                         Logger.getLogger(AfficherEquipementsController.class.getName()).log(Level.SEVERE, null, ex);
                     }
}
                  FXMLLoader loader=new FXMLLoader(getClass().getResource("AfficherEquipements.fxml"));
         Parent root;
        try {
            root= loader.load();
            btn_validers.getScene().setRoot(root);
        } catch (IOException ex) {
          Logger.getLogger(AfficherEquipementsController.class.getName()).log(Level.SEVERE, null, ex);
        } 
            }
    });
           btn_dup.setOnAction(new EventHandler<ActionEvent>() {
            
             @Override
             public void handle(ActionEvent event) {
                  (lab_nom).setVisible(false);
    (lab_reference).setVisible(false);
    (lab_domaine).setVisible(false);
    (lab_salle).setVisible(false);
    (lab_date).setVisible(false);
    (lab_etat).setVisible(false);
   (tf_nom).setVisible(false);
    (tf_reference).setVisible(false);
    (cb_domaine).setVisible(false);
        (cb_etat).setVisible(false);
        (cb_salle).setVisible(false);
    (tf_date).setVisible(false);
    (btn_validerm).setVisible(false);
    (btn_validers).setVisible(false);
    (btn_annuler).setVisible(false);
    lab_info_dup.setText("");
lab_ajout_err.setText("");
lab_err.setText("");
lab_info.setText("");
lab_info_dup.setVisible(true);
lab_ajout_err.setVisible(false);
lab_err.setVisible(false);
lab_info.setVisible(false);
            (cb_salle).setDisable(false);
            (cb_domaine).setDisable(false);
           (cb_etat).setDisable(false);
                 int x=0;
                  Equipement e=(Equipement) tab.getSelectionModel().getSelectedItem();
        if(tab.getSelectionModel().getSelectedItem()==null)
       {
           Alert alerta = new Alert(Alert.AlertType.ERROR);  
                         alerta.setTitle("Notification");
                         alerta.setContentText("vous devez choisir un produit pour le Dupliquer !!!");
                         alerta.showAndWait();     
       }
       else
           {
                 Service ps=new Service();
            tf_ajout_nom.setText(e.getLibelle());
            tf_ajout_reference.setText(e.getReference());
            lab_info_dup.setText(" Duplication de ce produit :");
             (tf_date).setEditable(false);
            if(e.getSalle().equalsIgnoreCase("B1"))
            {
                cb_ajout_salle.getSelectionModel().select(0);  
            }
            else if(e.getSalle().equalsIgnoreCase("B2"))
            {
                cb_ajout_salle.getSelectionModel().select(1);  
            }
            else  if(e.getSalle().equalsIgnoreCase("P"))
            {
                cb_ajout_salle.getSelectionModel().select(2);  
            }
              else if(e.getSalle().equalsIgnoreCase("A1"))
            {
                cb_ajout_salle.getSelectionModel().select(3); 
            }
              else if(e.getSalle().equalsIgnoreCase("A2"))
            {
                cb_ajout_salle.getSelectionModel().select(4); 
            }
                else 
            {
                cb_ajout_salle.getSelectionModel().select(5);  
            }
             if(e.getDomaine().equalsIgnoreCase("Taekwondo"))
            {
                cb_ajout_domaine.getSelectionModel().select(0);  
            }
             else if(e.getDomaine().equalsIgnoreCase("Karate"))
            {
                cb_ajout_domaine.getSelectionModel().select(1);  
            }
            else  if(e.getDomaine().equalsIgnoreCase("Natation"))
            {
                cb_ajout_domaine.getSelectionModel().select(2);  
            }
              else if(e.getDomaine().equalsIgnoreCase("Bodybuilding"))
            {
                cb_ajout_domaine.getSelectionModel().select(3); 
            }
              else 
            {
                cb_ajout_domaine.getSelectionModel().select(4); 
            }
             }}
    });
    btn_ajouter.setOnAction(new EventHandler<ActionEvent>() {
           @Override
            public void handle(ActionEvent event) {
                try{
                String salle=cb_ajout_salle.getSelectionModel().getSelectedItem();
                String domaine=cb_ajout_domaine.getSelectionModel().getSelectedItem();
                int x=0;
                int j;
               Equipement e = new Equipement (tf_ajout_nom.getText(),tf_ajout_reference.getText(),domaine,salle);
       Service s= new Service();
       if((e.getLibelle().contains("  "))||(e.getLibelle().contains("  ")))
       {
           x++;
           lab_ajout_err.setVisible(true);
                      (lab_ajout_err).setText("le libelle et la reference de doivents pas contenir\n 2 espaces successives");                   
       }
        if(e.getLibelle().length()>0)
       {
            char liba=e.getLibelle().charAt(0);
             if((liba<'A')||(liba>'Z'))
             { x++;
                        lab_ajout_err.setVisible(true);
                        (lab_ajout_err).setText("Le libelle doit commencer par une lettres\n majuscule");}
       }
         if(e.getReference().length()>0)
       {
            char ref=e.getReference().charAt(0);
             if(((ref<'A')||(ref>'Z'))&&((ref>'9')||(ref<'0')))
             { x++;
                 lab_ajout_err.setVisible(true);
                (lab_ajout_err).setText("La reference doit commencer par une lettres\n majuscule ou un chiffre");}
       }
       for(j=1;j<e.getLibelle().length();j++)
                  {
                      char lib=e.getLibelle().charAt(j);
                   if(((lib<'A')||(lib>'Z')&&(lib<'a')||(lib>'z'))&&(lib!=' ')&&(lib!='-')&&(lib!='_')&&(lib!='é')&&(lib!='è'))
                   {  x++;
                              lab_ajout_err.setVisible(true);
                              (lab_ajout_err).setText("verifiez votre Libelle");}
                  }
                if(((salle.equalsIgnoreCase("null"))||(domaine.equalsIgnoreCase("null")||(e.getReference().length() <3)||(e.getLibelle().length() <3))))//||(e.getNom().equalsIgnoreCase(""))&&(e.getReference().equalsIgnoreCase("")))&&(e.getSalle().equalsIgnoreCase("")))
                {
                     lab_ajout_err.setVisible(true);
                    (lab_ajout_err).setText("un ou plusieurs champs vides \nou trop court");
                   x++;
                }
                if (x==0){
                       lab_ajout_err.setVisible(false);
                       lab_ajout_err.setText("");
                    int nbr=s.getEquipementNbr(tf_ajout_nom.getText(), tf_ajout_reference.getText(),salle);
                    System.out.println(nbr);
                    if(nbr==0)
                    { 
                         JOptionPane jop = new JOptionPane();
    String nb = jop.showInputDialog(null, "Vous voulez ajouter cet equipement combient de fois ?", JOptionPane.QUESTION_MESSAGE);
               try{
                   int n = Integer.parseInt(nb);
                   if(n==0)
                   {
                       Alert alerta = new Alert(Alert.AlertType.ERROR);
                             alerta.setTitle("Notification");
                             alerta.setContentText("nombre doit etre supperieur a 0 !!!");
                             alerta.showAndWait();
                   }
                   else{
     for(int i=0;i<n;i++){
 s.ajouterEquipement(e);
     }
                       FXMLLoader loader= new  FXMLLoader(getClass().getResource("afficherEquipements.fxml"));
                       Parent root;
                  root=loader.load();
                         btn_ajouter.getScene().setRoot(root);
                         Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                         alert.setTitle("Notification");
                         alert.setContentText("Equipement ajouté avec succés");
                         alert.showAndWait();
               }}catch(NumberFormatException exp)    {
        Alert alerta = new Alert(Alert.AlertType.ERROR);
                             alerta.setTitle("Notification");
                             alerta.setContentText("nombre de fois invalide !!!");
                             alerta.showAndWait();
    }       
           }
                    else
                    {
                         Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                         alert.setTitle("Notification");
                         alert.setContentText("il en existe deja "+" "+nbr+" "+" de cet equipement dans la salle "+salle+", vous voulez en ajouter un de plus ?");
                         Optional<ButtonType> result = alert.showAndWait();
ButtonType button = result.orElse(ButtonType.CANCEL);

if (button == ButtonType.OK) {
    JOptionPane jop = new JOptionPane();
    String nb = jop.showInputDialog(null, "Vous voulez ajouter cet equipement combient de fois ?", JOptionPane.QUESTION_MESSAGE);
    try{
    int n = Integer.parseInt(nb);
     if(n==0)
                   {
                       Alert alerta = new Alert(Alert.AlertType.ERROR);
                             alerta.setTitle("Notification");
                             alerta.setContentText("nombre doit etre supperieur a 0 !!!");
                             alerta.showAndWait();
                   }
                   else{
     for(int i=0;i<n;i++){
 s.ajouterEquipement(e);
     }                      
                         FXMLLoader loader= new  FXMLLoader(getClass().getResource("afficherEquipements.fxml"));
                       Parent root;
                  root=loader.load();
                         btn_ajouter.getScene().setRoot(root);
                         Alert alerts = new Alert(Alert.AlertType.CONFIRMATION);
                         alerts.setTitle("Notification");
                         alerts.setContentText("Equipement ajouté avec succés");
                         alerts.showAndWait();                    
    }}catch(NumberFormatException exp)    {
        Alert alerta = new Alert(Alert.AlertType.ERROR);
                             alerta.setTitle("Notification");
                             alerta.setContentText("nombre de fois invalide !!!");
                             alerta.showAndWait();
    }       
}
                    }
            }}catch(NullPointerException ex){
           lab_ajout_err.setVisible(true);
         (lab_ajout_err).setText("***un ou plusieurs champs vides\n ou trop court***");
    }          catch (SQLException ex) {
                   Logger.getLogger(AfficherEquipementsController.class.getName()).log(Level.SEVERE, null, ex);
               } catch (IOException ex) {
                   Logger.getLogger(AfficherEquipementsController.class.getName()).log(Level.SEVERE, null, ex);
               }
            }
        }) ;
     btn_reset.setOnAction(new EventHandler<ActionEvent>() {
             @Override
             public void handle(ActionEvent event) {
                 FXMLLoader loader= new  FXMLLoader(getClass().getResource("afficherEquipements.fxml"));
                       Parent root = null;
                 try {
                     root=loader.load();
                 } catch (IOException ex) {
                     Logger.getLogger(AfficherEquipementsController.class.getName()).log(Level.SEVERE, null, ex);
                 }
                         btn_reset.getScene().setRoot(root);
             }
    });
      btn_imprimer.setOnAction(new EventHandler<ActionEvent>() {
           @Override
            public void handle(ActionEvent event) {
          JOptionPane jop = new JOptionPane();
          String link="C:\\Users\\pc-dell\\Desktop\\ad.pdf";
          String ad = jop.showInputDialog("Veuillez saisir l'emplacement du ficher !", link);
                Document doc=new Document();
               try {
                    try {
                        PdfWriter.getInstance(doc, new FileOutputStream(ad));
                    } catch (DocumentException ex) {
                        Logger.getLogger(AfficherEquipementsController.class.getName()).log(Level.SEVERE, null, ex);
                    }
               } catch (FileNotFoundException ex) {
                 Alert alerta = new Alert(Alert.AlertType.ERROR);
                         alerta.setTitle("Notification");
                         alerta.setContentText("veuillez saisir un chemin VALIDE ! ");
                         alerta.showAndWait();
               }
               doc.open();
               try {
                   Font f=new Font(Font.FontFamily.TIMES_ROMAN, 24, Font.UNDERLINE, BaseColor.RED);
                   Paragraph p=new Paragraph("ADFitness\n",f);
                   p.setAlignment(Element.ALIGN_CENTER);
                   doc.add(p);
Font f1=new Font(Font.FontFamily.TIMES_ROMAN, 20, Font.UNDERLINE, BaseColor.RED);
                   Paragraph p1=new Paragraph("Rapport d'equipements et materiels ",f1);
                   p1.setAlignment(Element.ALIGN_CENTER);
                   doc.add(p1);
                   DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
   LocalDateTime now = LocalDateTime.now();  
String d=   dtf.format(now);
 Font f2=new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.UNDERLINE, BaseColor.BLACK);
 Paragraph p2=new Paragraph("\nDate: "+d,f2);
   doc.add(p2);
      doc.add(new Paragraph("Gerant responsable : " ,f2));
      doc.add(new Paragraph(" "));
                   PdfPTable table = new PdfPTable(6);
                   table.setWidthPercentage(100);
        table.setSpacingBefore(0f);
        table.setSpacingAfter(0f);
                   Font f3=new Font(Font.FontFamily.TIMES_ROMAN, 14, Font.UNDEFINED, BaseColor.BLUE);
                   PdfPCell c1=new PdfPCell(new Phrase("Libelle",f3));
                   c1.setPadding(4f);
                   table.addCell(c1);
                     c1=new PdfPCell(new Phrase("Reference ",f3));
                     c1.setPadding(4f);     
                   table.addCell(c1);
                     c1=new PdfPCell(new Phrase("Domaine ",f3));
                     c1.setPadding(4f);
                   table.addCell(c1);
                     c1=new PdfPCell(new Phrase("Salle ",f3));
                     c1.setPadding(4f);
                   table.addCell(c1);
                     c1=new PdfPCell(new Phrase("Date d'ajout",f3));
                     c1.setPadding(4f);
                   table.addCell(c1);
                    c1=new PdfPCell(new Phrase("Etat",f3));
                    c1.setPadding(4f);
                   table.addCell(c1);
                  Service s=new Service();
                    ArrayList<Equipement> e =(ArrayList<Equipement>)s.getAllEquipements();
                    for(int i=0;i<e.size();i++)
                    {
                        String n=e.get(i).getLibelle();
                        Font f4=new Font(Font.FontFamily.TIMES_ROMAN, 10, Font.UNDEFINED, BaseColor.BLACK);
                        c1=new PdfPCell(new Phrase(n,f4));
                        table.addCell(c1);
                        String r=e.get(i).getReference();
                        c1=new PdfPCell(new Phrase(r,f4));
                        table.addCell(c1);
                        String dom=e.get(i).getDomaine();
                        c1=new PdfPCell(new Phrase(dom,f4));
                        table.addCell(c1);
                        String sa=e.get(i).getSalle();
                        c1=new PdfPCell(new Phrase(sa,f4));
                        table.addCell(c1);
                        String da=e.get(i).getDate();
                        c1=new PdfPCell(new Phrase(da,f4));
                        table.addCell(c1);
                        String et=e.get(i).getEtat();
                        c1=new PdfPCell(new Phrase(et,f4));
                        table.addCell(c1);
                    }
                   doc.add(table);
               } catch (DocumentException ex) {
                   Logger.getLogger(AfficherEquipementsController.class.getName()).log(Level.SEVERE, null, ex);
               } catch (SQLException ex) {
                   Logger.getLogger(AfficherEquipementsController.class.getName()).log(Level.SEVERE, null, ex);
               }
               doc.close();
                }
        }) ;
      btn_stat.setOnAction(new EventHandler<ActionEvent>() {
             @Override
             public void handle(ActionEvent event) {
               Service s=new Service();
               int a=0;int b=0;int c=0;
                 try {
              a=s.getNombre("Fonctionnel");
               b=  s.getNombre("Non Fonctionnel");
              c=  s.getNombre("En maintenance");
                 } catch (SQLException ex) {
                     Logger.getLogger(AfficherEquipementsController.class.getName()).log(Level.SEVERE, null, ex);
                 }
                 DefaultCategoryDataset dataset=new DefaultCategoryDataset();
                         dataset.setValue(a, "equipements", "fonctionnel");
                         dataset.setValue(b, "equipements", " non fonctionnel");
                         dataset.setValue(c, "equipements", "en maintenance");
                 JFreeChart chart=ChartFactory.createBarChart3D("etat d'equipements ", "etat", "nombres", dataset);
                 chart.setBackgroundPaint(Color.YELLOW);
                 chart.getTitle().setPaint(Color.red);
                 CategoryPlot p=chart.getCategoryPlot();
                 p.setRangeGridlinePaint(Color.BLUE);
                 ChartFrame frame=new ChartFrame("bar d equipements",chart);
                 frame.setVisible(true);
                 frame.setSize(450, 350);
             }
    });
    }  } 
    

