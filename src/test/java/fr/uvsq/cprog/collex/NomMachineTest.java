package fr.uvsq.cprog.collex;

import static org.junit.Assert.*;
import fr.uvsq.cprog.collex.commande.*;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class NomMachineTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void testNomValide() {
        NomMachine nm = new NomMachine("www.uvsq.fr");
        assertEquals("www", nm.getMachine());
        assertEquals("uvsq.fr", nm.getDomaine());
    }


    @Test
    public void testToString() {
        NomMachine nm = new NomMachine("mail.uvsq.fr");
        assertEquals("mail.uvsq.fr", nm.toString());
    }
}
