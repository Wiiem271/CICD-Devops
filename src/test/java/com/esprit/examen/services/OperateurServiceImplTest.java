package com.esprit.examen.services;

import com.esprit.examen.entities.Operateur;
import java.text.ParseException;

import java.util.List;
import static org.junit.Assert.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class OperateurServiceImplTest {
    @Autowired
       IOperateurService operateurService;
       private static final Logger l = LogManager.getLogger(OperateurServiceImpl.class);

       @Test
       public void testRetrieveAllOperateur() throws ParseException {

         List<Operateur> operateur = operateurService.retrieveAllOperateurs();
         Operateur op = new Operateur("testnom","testprenom","testpassword");
         Operateur savedOperateur = operateurService.addOperateur(op);
         l.info(" Operateur : " + op);

         assertNotNull(op.getIdOperateur());

         operateurService.retrieveOperateur(op.getIdOperateur());

         List<Operateur> Operateurs = operateurService.retrieveAllOperateurs();
         l.info("Les  Operateurs : " + Operateurs);
       }
       
       
       @Test
       public void testDeleteOperateur() throws ParseException {

    	   /* List<Operateur> Operateurs = operateurService.retrieveAllOperateurs();
    	   int expected = Operateurs.size();
    	   Long idFour=(long) 2;
    	   assertEquals(expected + 1, operateurService.retrieveAllOperateurs().size());
    	   System.out.print("size "+Operateurs.size());
    	   l.info(" count" + Operateurs.size());
    	   operateurService.deleteOperateur(1L);
    	   l.info("size2 "+operateurService.retrieveAllOperateurs().size());*/

       }
   
   
       @Test
       public void testAddOperateur() throws ParseException{
    	   
    	   List<Operateur> Operateurs = operateurService.retrieveAllOperateurs();
    	   Operateur op = new Operateur("testnom2","testprenom2","testpassword2");
    	   l.info("operateur \n "+op);

    	   Operateur savedOperateur= operateurService.addOperateur(op);
    	   l.info("size1 "+Operateurs.size());
    	   System.out.print("size1 "+Operateurs.size());
    	   operateurService.deleteOperateur(savedOperateur.getIdOperateur());
    	   List<Operateur> Operateurs1 = operateurService.retrieveAllOperateurs();

    	   l.info("size2 "+Operateurs1.size());
       }
}