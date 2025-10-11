package fr.uvsq.cprog.collex;
import fr.uvsq.cprog.collex.commande.*;

import static org.junit.Assert.*;
import java.io.IOException;
import java.nio.file.*;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class DnsTest {

    private Path tempFile;
    private Dns dns;

    @Before
    public void setup() throws IOException {
        tempFile = Files.createTempFile("dns", ".txt");
        Files.write(tempFile, List.of(
                "www.uvsq.fr 193.51.31.90",
                "ecampus.uvsq.fr 193.51.25.12"
        ));
        dns = new Dns(tempFile.toString());
    }

    @Test
    public void testGetItemByNom() throws IOException {
        DnsItem item = dns.getItem(new NomMachine("www.uvsq.fr"));
        assertEquals("193.51.31.90", item.getIp().toString());
    }

    @Test
    public void testGetItemByIP() throws IOException {
        DnsItem item = dns.getItem(new AdresseIP("193.51.25.12"));
        assertEquals("ecampus.uvsq.fr", item.getNom().toString());
    }

    @Test
    public void testAddItem() throws IOException {
        dns.addItem(new AdresseIP("193.51.31.154"), new NomMachine("poste.uvsq.fr"));
        assertEquals(3, dns.getItems("uvsq.fr",true).size());
    }

}