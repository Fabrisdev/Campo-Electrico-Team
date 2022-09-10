package consola;

public class CampoElectrico {
    private final double fuerzaElectrica;

    public CampoElectrico(double fuerzaElectrica) {
        this.fuerzaElectrica = fuerzaElectrica;
    }
    
    public double getFuerzaElectrica(){
        return fuerzaElectrica;
    }
    
    public double getCampoElectricoPorCarga(Particula particula){
        double particulaCarga = particula.getCarga();
        return Math.abs(fuerzaElectrica / particulaCarga);
    }
    
    public double getCampoElectricoPorPlaca(Placa placa){
        double placaSigma = placa.getSigma();
        double e0 = 8.8541878176;
        return Math.abs(placaSigma / (2*e0));
    }
}
