package com.esprit.examen.services;

import java.util.Arrays;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.doReturn;
import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import com.esprit.examen.entities.Produit;
import com.esprit.examen.repositories.ProduitRepository;
import com.esprit.examen.services.ProduitServiceImpl;

/**
 * Tests the ProduitService.
 */
@ExtendWith(MockitoExtension.class)
@SpringBootTest
class ProduitServiceMockitoTest {

    /**
     * A mock version of the ProductRepository for  use in our tests.
     */
    @Mock
    private ProduitRepository produitRepository;
    
    @InjectMocks
    ProduitServiceImpl produitService;
     
    @Test
    void testretrieveAllProduits() {
    	 // given
        Produit produit = Produit.builder()
                .idProduit( (long) 10)
                .codeProduit("11")
                .libelleProduit("10")
                .prix(142123)
                .build();
        List<Produit> expectedProduits = Arrays.asList(produit);

        doReturn(expectedProduits).when(produitRepository).findAll();

        // when
        List<Produit> actualProduits = produitService.retrieveAllProduits();

        // then
        assertThat(actualProduits).isEqualTo(expectedProduits);
        
    }
    @Test
    void testretrieveProduit() {
    	
        // Setup our mock
        Produit mockProduit = new Produit();
        doReturn(Optional.of(mockProduit)).when(produitRepository).findById((long) 1);

        // Execute the service call
        Optional<Produit> returnedProduit = produitService.retrieveProduit((long) 1);
         
        // Assert the response
        Assertions.assertTrue(returnedProduit.isPresent(), "Product was not found");
        Assertions.assertSame( returnedProduit.get(), mockProduit, "Products should be the same");
    }
    @Test
    public void testSaveProduit() throws Exception{
    	
    	Produit input1 = Produit.builder()
                .idProduit( (long) 9)
                .codeProduit("9")
                .libelleProduit("9")
                .prix(99999)
                .build();
    	
    	Produit input2 = Produit.builder()
                .idProduit( (long) 7)
                .codeProduit("7")
                .libelleProduit("7")
                .prix(777777)
                .build();
                
        Produit returned1 = Produit.builder()
                .idProduit( (long) 9)
                .codeProduit("9")
                .libelleProduit("9")
                .prix(99999)
                .build();
        
        Produit returned2 = Produit.builder()
                .idProduit( (long) 7)
                .codeProduit("7")
                .libelleProduit("7")
                .prix(777777)
                .build();            


        //stub the data
        Mockito.when(produitRepository.save(input1)).thenReturn(returned1);
        Mockito.when(produitRepository.save(input2)).thenReturn(returned2);

        //actual method call
        Produit result1 = produitService.updateProduit(input1);
        Produit result2 = produitService.updateProduit(input2);

        Assertions.assertEquals("9", result1.getCodeProduit());
        Assertions.assertEquals("7", result2.getCodeProduit());
    }
 
       
}
