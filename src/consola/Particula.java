package consola;
import excepciones.CargaEsCeroException;

public class Particula {
    private double carga;
    
    public Particula(double carga) throws CargaEsCeroException {
        revisarCarga(carga);
    }

    private void revisarCarga(double carga) throws CargaEsCeroException{
        if(carga == 0){
            throw new CargaEsCeroException();
        }
        this.carga = carga;
    }
    
    public double getCarga() {
        return carga;
    }

    public void setCarga(double carga) {
        this.carga = carga;
    }
    
    public String getSigno(){
        String signo = "+";
        if(carga < 0){
            signo = "-";
        }
        return signo;
    }
}
