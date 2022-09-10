package excepciones;

public class CargaEsCeroException extends Exception{
    public CargaEsCeroException(){
        super("La carga no puede ser cero.");
    }
}
