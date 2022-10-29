package logica;

public class CargaFuente {

    private double valorCarga;
    private double xCarga;
    private double yCarga;

    public CargaFuente() {
    }

    public CargaFuente(double valorCarga, double xCarga, double yCarga) {
        this.valorCarga = valorCarga;
        this.xCarga = xCarga;
        this.yCarga = yCarga;
    }

    public double getValorCarga() {
        return this.valorCarga;
    }

    public void setValorCarga(double valorCarga) {
        this.valorCarga = valorCarga;
    }

    public double getxCarga() {
        return this.xCarga;
    }

    public void setxCarga(double xCarga) {
        this.xCarga = xCarga;
    }

    public double getyCarga() {
        return this.yCarga;
    }

    public void setyCarga(double yCarga) {
        this.yCarga = yCarga;
    }

    public Vector calcularCampo(double xPunto, double yPunto) {
        Vector vectorCampo;
        double angulo, radicando = Math.pow(xPunto - this.xCarga, 2.0D) + Math.pow(yPunto - this.yCarga, 2.0D);
        double distancia = Math.sqrt(radicando);
        double k = 9e9;
        double moduloCampo = k * Math.abs(this.valorCarga) / Math.pow(distancia, 2.0D);

        double signo = Math.signum(this.valorCarga);

        if (signo > 0.0D) {
            angulo = Math.atan2(yPunto - this.yCarga, xPunto - this.xCarga);
        } else {

            angulo = Math.PI + Math.atan2(yPunto - this.yCarga, xPunto - this.xCarga);
        }

        if (xPunto == this.xCarga && yPunto == this.yCarga) {
            vectorCampo = new Vector(0.0D, 0.0D);
        } else {

            vectorCampo = new Vector(moduloCampo, angulo);
        }
        return vectorCampo;
    }
    
    @Override
    public String toString(){
        return "[x: "+xCarga+", y: "+yCarga+"]";
    }
}
