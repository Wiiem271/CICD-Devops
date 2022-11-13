/*package com.esprit.examen.controllers;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.esprit.examen.entities.CategorieProduit;
import com.esprit.examen.repositories.CategorieProduitRepository;

@SpringBootTest
class CategorieProduitControllerTest {

	@Autowired
	CategorieProduitRepository categorieProduitRepository;
        @Autowired
	CategorieProduitServiceImpl categorieProduitServiceImpl;

//	@Test
//	void testGetCategorieProduit() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testRetrieveCategorieProduit() {
//		fail("Not yet implemented");
//	}

	@Test
	void testAddCategorieProduit() {
		CategorieProduit s = new CategorieProduit(5L,"h","h",null);
		CategorieProduit savedCategorieProduit= categorieProduitRepository.save(s);
		assertEquals(s.getLibelleCategorie(), savedCategorieProduit.getLibelleCategorie());
                categorieProduitServiceImpl.deleteCategorieProduit(savedCategorieProduit.getIid());

	}

	
	@Test
	@Transactional
	public void testRetrieveCategorieProduit() {
    Optional<CategorieProduit>	 CategorieProduit = categorieProduitRepository.findById(1L);
	
	System.out.println(CategorieProduit);
	
	assertNotNull(CategorieProduit);	
	
	}


}
*/
