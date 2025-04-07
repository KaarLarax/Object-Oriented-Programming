// Lara Hernandez Carlos Alberto
// So you think, my heart is made of stone.
package pck_fecha;

public class Fecha {
    private int dia;
    private int mes;
    private int anio;

    public Fecha() {
        anio = mes = dia = 0;
    }

    public Fecha(int dia, int mes, int anio) {
        this.dia = dia;
        this.mes = mes;
        this.anio = anio;
    }

    public int getDia() {
        return dia;
    }

    public int getMes() {
        return mes;
    }

    public int getAnio() {
        return anio;
    }

    protected boolean bisiesto() {
        if (anio % 4 != 0) {
            return false;
        }
        if (anio % 100 == 0) {
            return anio % 400 == 0;
        }
        return true;
    }

    public boolean fechaCorrecta() {
        return fechaValida(dia, mes, anio);
    }

    private boolean fechaValida(int dia, int mes, int anio) {
        boolean anioCorrecto = anio >= 1920, mesCorrecto = mes >= 1 && mes <= 12;
        if (!anioCorrecto || !mesCorrecto || dia < 1) return false;
        return switch (mes) {
            case 2 -> (bisiesto() ? dia <= 29: dia <= 28);
            case 1, 3, 5, 7, 8, 10, 12 -> dia <= 31;
            case 4, 6, 9, 11 -> dia <= 30;
            default -> false;
        };
    }

    public boolean setFecha(int dia, int mes, int anio) {
        if (fechaValida(dia, mes, anio)) {
            this.dia = dia;
            this.mes = mes;
            this.anio = anio;
            return true;
        }
        return false;
    }

    public String getFecha() {
        return (String.format("%02d", getDia()) + '/'  + String.format("%02d", getMes()) + '/' + String.format("%04d", getAnio()));
    }
    public boolean convertirFecha(String f) {
        if (f.length() != 10) {
            return false;
        }
        if ( '/' != f.charAt(2) || f.charAt(2) != f.charAt(5)) {
            return false;
        }
        int diaaux, mesaux, anioaux;
        try {
            diaaux = Integer.parseInt(f.substring(0, 2));
            mesaux = Integer.parseInt(f.substring(3, 5));
            anioaux = Integer.parseInt(f.substring(6));
        } catch (NumberFormatException e) {
            return false;
        }
        return setFecha(diaaux, mesaux, anioaux);
    }
}
