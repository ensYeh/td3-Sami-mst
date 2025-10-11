package fr.uvsq.cprog.collex;

public class NomMachine {
    private final String nom;

    public NomMachine(String nom) {
        if (!nom.contains("."))
            throw new IllegalArgumentException("Nom qualifié invalide : " + nom);
        this.nom = nom;
    }

    public String getNom() { 
        return nom; 
    }

    public String getMachine() {
        return nom.split("\\.")[0];
    }

    public String getDomaine() {
        return nom.substring(nom.indexOf('.') + 1);
    }

    @Override
    public String toString() { 
        return nom; 
    }

    @Override
    public boolean equals(Object o) {
        return o instanceof NomMachine && ((NomMachine) o).nom.equals(this.nom);
    }

    @Override
    public int hashCode() {
        return nom.hashCode();
    }
}