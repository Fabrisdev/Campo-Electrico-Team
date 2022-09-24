package logica;

public class Placa {

    private double sigma;
    private int xPlaca;

    public Placa() {
    }

    public Placa(double sigma) {
        this.sigma = sigma;
    }

    public Placa(double sigma, int xPlaca) {
        this.sigma = sigma;
        this.xPlaca = xPlaca;
    }

    public double getSigma() {
        return this.sigma;
    }

    public void setSigma(double sigma) {
        this.sigma = sigma;
    }

    public int getxPlaca() {
        return this.xPlaca;
    }

    public void setxPlaca(int xPlaca) {
        this.xPlaca = xPlaca;
    }

    public double campoPlaca(int xCarga) {
        double campo, divisor = 17.7D * Math.pow(10.0D, -12.0D);
        if (xCarga < this.xPlaca) {
            campo = -(this.sigma / divisor);
        } else if (xCarga > this.xPlaca) {
            campo = this.sigma / divisor;
        } else {

            campo = 0.0D;
        }
        return campo;
    }

    public String toString() {
        return this.sigma + "C/m^2";
    }
}