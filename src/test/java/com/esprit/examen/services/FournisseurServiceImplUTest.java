package com.esprit.examen.services;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.any;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.esprit.examen.entities.DetailFournisseur;
import com.esprit.examen.entities.Fournisseur;
import com.esprit.examen.repositories.DetailFournisseurRepository;
import com.esprit.examen.repositories.FournisseurRepository;
import com.esprit.examen.repositories.ProduitRepository;
import com.esprit.examen.repositories.SecteurActiviteRepository;
import com.esprit.examen.services.FournisseurServiceImpl;
@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class FournisseurServiceImplUTest {

	@InjectMocks
	FournisseurServiceImpl fournisseurServiceImpl;
	
	@Mock
	FournisseurRepository fournisseurRepository;
	@Mock
	DetailFournisseurRepository detailFournisseurRepository;
	@Mock
	ProduitRepository produitRepository;
	@Mock
	SecteurActiviteRepository secteurActiviteRepository;
	
	
	@Test
	void test_retrieveAllFournisseurs_ok() {
		
		when(fournisseurRepository.findAll()).thenReturn(new ArrayList());
		List<Fournisseur> response= fournisseurServiceImpl.retrieveAllFournisseurs();
		assertEquals(0, response.size());
	}
	void test_addFournisseur_ok() {
		DetailFournisseur df= new DetailFournisseur();
		df.setIdDetailFournisseur(1L);
		//mock
		when(fournisseurRepository.save(any())).thenReturn(df);	
		//call function 
		fournisseurServiceImpl.addFournisseur(new Fournisseur());
		//assert
		assertEquals(1L,df.getIdDetailFournisseur());
		}

	
}
