package fr.uvsq.cprog.collex;
import fr.uvsq.cprog.collex.commande.*;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AdresseIPTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void testAdresseIPValide() {
        AdresseIP ip = new AdresseIP("192.168.1.1");
        assertEquals("192.168.1.1", ip.toString());
    }

    @Test
    public void testEgaliteAdresseIP() {
        AdresseIP ip1 = new AdresseIP("10.0.0.1");
        AdresseIP ip2 = new AdresseIP("10.0.0.1");
        assertEquals(ip1, ip2);
    }
}
