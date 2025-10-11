package fr.uvsq.cprog.collex.commande;

import fr.uvsq.cprog.collex.*;

import java.util.List;

public class CmdListeDomaine implements Commande {

    private final Dns dns;
    private final String domaine;
    private final boolean triParAdresse;

    public CmdListeDomaine(Dns dns, String domaine, boolean triParAdresse) {
        this.dns = dns;
        this.domaine = domaine;
        this.triParAdresse = triParAdresse;
    }

    @Override
    public String execute() {
        List<DnsItem> items = dns.getItems(domaine, triParAdresse);
        if (items.isEmpty()) {
            return "Aucune machine trouvée pour le domaine " + domaine;
        }

        StringBuilder sb = new StringBuilder();
        for (DnsItem item : items) {
            sb.append(item.getIp())
              .append(" ")
              .append(item.getNom())
              .append("\n");
        }
        return sb.toString().trim();
    }
}