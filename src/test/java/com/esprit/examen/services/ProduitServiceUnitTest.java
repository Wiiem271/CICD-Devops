package com.esprit.examen.services;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import com.esprit.examen.services.ProduitServiceImpl;
import com.esprit.examen.entities.CategorieProduit;
import com.esprit.examen.entities.Produit;
import com.esprit.examen.entities.Stock;
import com.esprit.examen.repositories.ProduitRepository;
import com.esprit.examen.services.IProduitService;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Date;
import java.util.HashSet;

@ExtendWith({SpringExtension.class})
@SpringBootTest
 public class ProduitServiceUnitTest {

	@Autowired 
	private ProduitRepository produitRepository;
    @Test
    public void testCreateProduit() {
    Produit prod = new Produit((long)3, "asus","11", (float) 2200.500, new Date(),new Date(), new Stock(), new HashSet<>(), new CategorieProduit());
    assertThat(prod.getCodeProduit()).isEqualTo("asus");
    produitRepository.save(prod);
       
	}
    @Test 
    public void testFindProduit(){
    Produit p = produitRepository.findById((long)3).get(); 
    assertNotNull(p);
    System.out.println(p);
    }
    
    @Test
    public void testDeleteProduit(){
    
    produitRepository.deleteById((long)3);
 
    
    }

    
    
    

}
