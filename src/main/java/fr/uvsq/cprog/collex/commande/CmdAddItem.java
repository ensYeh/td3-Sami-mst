package fr.uvsq.cprog.collex.commande;

import java.io.IOException;

import fr.uvsq.cprog.collex.*;

public class CmdAddItem implements Commande {
    private final Dns dns;
    private final DnsItem item;

    public CmdAddItem(Dns dns, DnsItem item) {
        this.dns = dns;
        this.item = item;
    }

    @Override
    public String execute() {
        try {
        dns.addItem(item.getIp(),item.getNom());
        return item.toString() +"ajouté";
    } catch (java.io.IOException e) {
        return "Erreur d'accès au fichier DNS : " + e.getMessage();
    }
    catch (IllegalArgumentException e) {
        return e.getMessage();
    }
    
}
}