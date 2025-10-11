package fr.uvsq.cprog.collex.commande;

import fr.uvsq.cprog.collex.*;

public class CmdRechercheIP implements Commande {
    private final Dns dns;
    private final NomMachine nom;

    public CmdRechercheIP(Dns dns, NomMachine nom) {
        this.dns = dns;
        this.nom = nom;
    }

    @Override
    public String execute() {
        DnsItem item = dns.getItem(nom);
        return (item != null) ? item.getIp().toString() : "Domaine non trouvée.";
    }
}
