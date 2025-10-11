package fr.uvsq.cprog.collex.commande;

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
        DnsItem item = dns.addItem(item);
        return item.toString() +"ajouté";
    }
}