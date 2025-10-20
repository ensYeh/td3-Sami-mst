package fr.uvsq.cprog.collex;


import java.io.IOException;
import java.nio.file.*;
import java.util.*;
import java.util.stream.Collectors;

public class Dns {
    private final Path fichier;
    private final List<DnsItem> items = new ArrayList<>();

    public Dns(String chemin) throws IOException {
        fichier = Paths.get(chemin);
        charger();
    }

    private void charger() throws IOException {
        for (String ligne : Files.readAllLines(fichier)) {
            String[] parts = ligne.split(" ");
            if (parts.length == 2)
                items.add(new DnsItem(new NomMachine(parts[0]), new AdresseIP(parts[1])));
        }
    }

    private void sauvegarder() throws IOException {
        List<String> lignes = items.stream()
                .map(i -> i.getNom() + " " + i.getIp())
                .collect(Collectors.toList());
        Files.write(fichier, lignes);
    }

    public DnsItem getItem(AdresseIP ip) {
        return items.stream().filter(i -> i.getIp().equals(ip)).findFirst().orElse(null);
    }

    public DnsItem getItem(NomMachine nom) {
        return items.stream().filter(i -> i.getNom().equals(nom)).findFirst().orElse(null);
    }

    public List<DnsItem> getItems(String domaine, boolean sortByIp) {
        return items.stream()
                .filter(i -> i.getNom().getDomaine().equals(domaine))
                .sorted(Comparator.comparing(sortByIp ? i -> i.getNom().getMachine() : i -> i.getIp().getIp()))
                .collect(Collectors.toList());
    }

    public void addItem(AdresseIP ip, NomMachine nom) throws IOException {
        if (getItem(ip) != null)
            throw new IllegalArgumentException("ERREUR : L’adresse IP existe déjà !");
        if (getItem(nom) != null)
            throw new IllegalArgumentException("ERREUR : Le nom de machine existe déjà !");
        items.add(new DnsItem(nom, ip));
        sauvegarder();
    }
}