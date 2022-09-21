package logica;

import java.awt.Point;
import java.util.ArrayList;

public class Placas {

    private ArrayList<Placa> lista = new ArrayList<>();

    public Placa devolver(int indice) {
        return this.lista.get(indice);
    }

    public void agregar(Placa p) {
        this.lista.add(p);
    }

    public void eliminar(int indice) {
        this.lista.remove(indice);
    }

    public int tamano() {
        return this.lista.size();
    }

    public double sumarCampos(int xPunto) {
        double campoResultante = 0.0D;
        for (Placa actual : this.lista) {
            double campoActual = actual.campoPlaca(xPunto);
            campoResultante += campoActual;
        }
        return campoResultante;
    }

    public void determinarXPlacas(int anchoVentana) {
        int incremento = anchoVentana / (tamano() + 1);
        int contador = 0;
        int j;
        for (j = incremento; j <= tamano() * incremento; j += incremento) {
            devolver(contador).setxPlaca(j);
            contador++;
        }
    }

    public static double anguloDespl(Point puntoA, Point puntoB) {
        double x1 = puntoA.getX();
        double y1 = puntoA.getY();
        double x2 = puntoB.getX();
        double y2 = puntoB.getY();
        return Math.atan2(y2 - y1, x2 - x1);
    }

    public double anguloCampo(double campo) {
        double anguloCampo = 0.0D;
        if (campo > 0.0D) {
            anguloCampo = 0.0D;
        } else {

            anguloCampo = Math.PI;
        }
        return anguloCampo;
    }

    public double anguloFuerza(double anguloCampo, double valorCarga) {
        double anguloFuerza = 0.0D;
        if (valorCarga > 0.0D) {
            anguloFuerza = anguloCampo;
        } else {

            anguloFuerza = Math.abs(anguloCampo - Math.PI);
        }
        return anguloFuerza;
    }

    public String toString() {
        return "Placas: " + this.lista;
    }
}