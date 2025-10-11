package fr.uvsq.cprog.collex;

import fr.uvsq.cprog.collex.commande.*;
import java.util.Scanner;

public class DnsTUI {
    private final Dns dns;
    private final Scanner sc = new Scanner(System.in);

    public DnsTUI(Dns dns) { 
        this.dns = dns; 
    }

    public Commande nextCommande() {
        System.out.print("> ");
        String ligne = sc.nextLine().trim();
        if (ligne.equals("quit")) return new CmdQuit();

        try {
            if (ligne.startsWith("ls")) {
                String[] parts = ligne.split(" ");
                boolean triIp = parts.length > 2 && parts[1].equals("-a");
                String domaine = parts[parts.length - 1];
                return new CmdListeDomaine(dns, domaine, triIp);
            } else if (ligne.startsWith("add")) {
                String[] parts = ligne.split(" ");
                return new CmdAddItem(dns, new DnsItem( new NomMachine(parts[2]),new AdresseIP(parts[1])));
            } else if (ligne.matches("\\d{1,3}(\\.\\d{1,3}){3}")) {
                return new CmdRechercheNom(dns, new AdresseIP(ligne));
            } else if (ligne.contains(".")) {
                return new CmdRechercheIP(dns, new NomMachine(ligne));
            }
        } catch (Exception e) {
            return () -> "ERREUR : " + e.getMessage();
        }

        return () -> "Commande inconnue.";
    }

    public void affiche(String resultat) {
        System.out.println(resultat);
    }
}
