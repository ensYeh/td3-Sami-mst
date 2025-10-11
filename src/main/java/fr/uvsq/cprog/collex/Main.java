package fr.uvsq.cprog.collex;

import fr.uvsq.cprog.collex.commande.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Main {

    public static void main(String[] args) throws Exception {
        new Main().run();
    }

    public void run() throws IOException {
        Properties props = new Properties();
        props.load(new FileInputStream("src/main/resources/config.properties"));
        String fichier = props.getProperty("dns.file");

        Dns dns = new Dns(fichier);
        DnsTUI tui = new DnsTUI(dns);

        while (true) {
            Commande cmd = tui.nextCommande();
            String resultat = cmd.execute();
            if (cmd instanceof CmdQuit) break;
            tui.affiche(resultat);
        }
    }
}
