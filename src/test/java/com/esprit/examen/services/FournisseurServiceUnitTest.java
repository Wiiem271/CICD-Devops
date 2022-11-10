 package com.esprit.examen.services;

//import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
//import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertNull;

import java.util.HashSet;
//import java.util.List;

import org.junit.Test;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.test.context.junit4.SpringRunner;

import com.esprit.examen.entities.CategorieFournisseur;
import com.esprit.examen.entities.DetailFournisseur;
import com.esprit.examen.entities.Fournisseur;
import com.esprit.examen.repositories.FournisseurRepository;



/*@ExtendWith({SpringExtension.class})
@SpringBootTest*/

@RunWith(SpringRunner.class)
@SpringBootTest
 public class FournisseurServiceUnitTest {

	@Autowired 
     FournisseurRepository fournisseurRepository;
	@Autowired 
    IFournisseurService  fournisseurService ;
	
	//private  Fournisseur test_model= new Fournisseur();

   /* @Test
    public void testAddStock() {
    	//	List<Fournisseur> fournisseurs = fournisseurRepository.findAll();
    	//	int expected=fournisseurs.size();
    		Fournisseur f = new Fournisseur((long)2,"salah","123", (CategorieFournisseur.ORDINAIRE) ,new HashSet<>(),new HashSet<>(), new DetailFournisseur());
            Fournisseur savedFournisseur= fournisseurRepository.save(f);
    		
    	  //  assertEquals(expected+1, fournisseurRepository.findAll().size());
    		assertNotNull(savedFournisseur.getLibelleFournisseur());
    		fournisseurRepository.deleteById(savedFournisseur.getIdFournisseur());
    		
    	} 
  */
	@Test
    public void testAddFournisseur() {
    	//	List<Fournisseur> fournisseurs = fournisseurRepository.findAll();
    	//	int expected=fournisseurs.size();
    		Fournisseur f = new Fournisseur((long)2,"mohammed","123", (CategorieFournisseur.ORDINAIRE) ,new HashSet<>(),new HashSet<>(), new DetailFournisseur());
            Fournisseur savedFournisseur= fournisseurService.addFournisseur(f);
    		
    	  //  assertEquals(expected+1, fournisseurRepository.findAll().size());
    		assertNotNull(savedFournisseur.getLibelleFournisseur());
    		// fournisseurService.deleteFournisseur(savedFournisseur.getIdFournisseur());
    		
    	} 
    
    
    @Test
	public void testDeleteFournisseur() {
		Fournisseur f = new Fournisseur((long)17,"mohammed","456", (CategorieFournisseur.ORDINAIRE) ,new HashSet<>(),new HashSet<>(), new DetailFournisseur());

		Fournisseur savedFournisseur= fournisseurRepository.save(f);
		fournisseurService.deleteFournisseur(savedFournisseur.getIdFournisseur());
		assertNull( fournisseurService.retrieveFournisseur(savedFournisseur.getIdFournisseur()));
	}

    
    
    

}

