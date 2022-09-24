package logica;

public class Vector {
    private double modulo;
    private double angulo;

    public Vector() {
    }

    public Vector(double modulo, double angulo) {
        this.modulo = Math.abs(modulo);
        this.angulo = angulo;
    }

    public double getModulo() {
        return this.modulo;
    }

    public void setModulo(double modulo) {
        this.modulo = Math.abs(modulo);
    }

    public double getAngulo() {
        return this.angulo;
    }

    public void setAngulo(double angulo) {
        this.angulo = angulo;
    }

    public Vector sumarVectores(Vector v2) {
        double a1 = getAngulo();
        double m1 = getModulo();
        double a2 = v2.getAngulo();
        double m2 = v2.getModulo();

        double mod = Math.sqrt(Math.pow(m1, 2.0D) + Math.pow(m2, 2.0D) + 2.0D * m1 * m2 * Math.cos(a2 - a1));
        double ang = a1 + Math.atan2(m2 * Math.sin(a2 - a1), m1 + m2 * Math.cos(a2 - a1));

        while (Math.abs(ang) > Math.PI) {
            if (ang > 0.0D) {
                ang -= 6.283185307179586D;
                continue;
            }
            ang += 6.283185307179586D;
        }
        return new Vector(mod, ang);
    }

    public double productoEscalar(Vector v2) {
        double x1 = getModulo() * Math.cos(getAngulo());
        double y1 = getModulo() * Math.sin(getAngulo());
        double x2 = v2.getModulo() * Math.cos(v2.getAngulo());
        double y2 = v2.getModulo() * Math.sin(v2.getAngulo());
        return x1 * x2 + y1 * y2;
    }
}