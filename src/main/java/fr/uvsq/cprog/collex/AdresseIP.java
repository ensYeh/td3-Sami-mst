package fr.uvsq.cprog.collex;

public class AdresseIP {
    private final String ip;

    public AdresseIP(String ip) {
        if (!ip.matches("\\d{1,3}(\\.\\d{1,3}){3}"))
            throw new IllegalArgumentException("Adresse IP invalide : " + ip);
        this.ip = ip;
    }

    public String getIp() {
        return ip;
    }

    @Override
    public String toString() {
        return ip;
    }

    @Override
    public boolean equals(Object o) {
        return o instanceof AdresseIP && ((AdresseIP) o).ip.equals(this.ip);
    }

}