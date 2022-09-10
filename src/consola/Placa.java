package consola;
import excepciones.CargaEsCeroException;

public class Placa extends Particula{
    private final double area;

    public Placa(double area, double carga) throws CargaEsCeroException {
        super(carga);
        this.area = area;
    }

    public double getSigma(){
        double carga = super.getCarga();
        return carga / area;
    }
}
