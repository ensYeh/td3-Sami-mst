package fr.uvsq.cprog.collex;

import static org.junit.Assert.*;
import java.io.IOException;
import java.nio.file.*;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import fr.uvsq.cprog.collex.commande.*;

/**
 * Unit test for simple App.
 */

 public class CmdListeDomaineTest {

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
    public void testListeDomaine() throws IOException {
        CmdListeDomaine cmd = new CmdListeDomaine(dns, "uvsq.fr", false);
        String result = cmd.execute();
        assertTrue(result.contains("www.uvsq.fr"));
    }
}