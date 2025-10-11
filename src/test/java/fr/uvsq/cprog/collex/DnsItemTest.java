package fr.uvsq.cprog.collex;
import fr.uvsq.cprog.collex.commande.*;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class DnsItemTest 
{
    /**
     * Rigorous Test :-)
     */

        @Test
        public void testCreationDnsItem() {
            AdresseIP ip = new AdresseIP("193.51.31.90");
            NomMachine nm = new NomMachine("www.uvsq.fr");
            DnsItem item = new DnsItem(nm, ip);
    
            assertEquals(nm, item.getNom());
            assertEquals(ip, item.getIp());
        }
    
        @Test
        public void testToString() {
            DnsItem item = new DnsItem(new NomMachine("ecampus.uvsq.fr"), new AdresseIP("193.51.25.12"));
            assertTrue(item.toString().contains("193.51.25.12"));
            assertTrue(item.toString().contains("ecampus.uvsq.fr"));
        }
    
}