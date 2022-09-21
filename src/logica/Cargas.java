package logica;
import java.util.ArrayList;

public class Cargas {
    private ArrayList<CargaFuente> lista = new ArrayList<>();

    public CargaFuente devolver(int indice) {
        return this.lista.get(indice);
    }

    public void agregar(CargaFuente p) {
        this.lista.add(p);
    }

    public void eliminar(int indice) {
        this.lista.remove(indice);
    }

    public int tamano() {
        return this.lista.size();
    }

    public double anguloFuerza(double anguloCampo, double q) {
        double ang = 0.0D;
        if (q > 0.0D) {
            ang = anguloCampo;
        } else if (q < 0.0D) {
            if (anguloCampo > 0.0D) {
                ang = anguloCampo - 180.0D;
            }
            if (anguloCampo < 0.0D) {
                ang = anguloCampo + 180.0D;
            }
        }
        return ang;
    }

    public Vector sumarCampos(double xPunto, double yPunto) {
        Vector resultante = new Vector(0.0D, 0.0D);

        for (CargaFuente actual : this.lista) {
            Vector vectorActual = actual.calcularCampo(xPunto, yPunto);
            resultante = resultante.sumarVectores(vectorActual);
        }
        return resultante;
    }
}