package fr.uvsq.cprog.collex;
import fr.uvsq.cprog.collex.commande.*;
import org.junit.Before;

import static org.junit.Assert.*;
import java.io.IOException;
import java.nio.file.*;
import java.util.List;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class CmdAddItemTest {

    private Path tempFile;
    private Dns dns;

    @Before
    public void setup() throws IOException {
        tempFile = Files.createTempFile("dns", ".txt");
        Files.write(tempFile, List.of("www.uvsq.fr 193.51.31.90"));
        dns = new Dns(tempFile.toString());
    }

    @Test
    public void testExecuteAjout() throws IOException {
        CmdAddItem cmd = new CmdAddItem(dns, new DnsItem( new NomMachine("ecampus.uvsq.fr"),new AdresseIP("193.51.25.12")));
        String res = cmd.execute();
        assertTrue(res.contains("ajouté") || res.isEmpty());
    }
}