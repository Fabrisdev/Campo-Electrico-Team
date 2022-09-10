package consola;
import java.util.Scanner;
import excepciones.CargaEsCeroException;

public class Principal {
    public static void main(String[] args){
        Scanner entrada = new Scanner(System.in);
        int opcion = 0;
        CampoElectrico campoElectrico = new CampoElectrico(1.0e2);
        do{ 
            System.out.println("Campo eléctrico...");
            System.out.println("1- Generado por una carga");
            System.out.println("2- Generado por una línea de carga");
            System.out.println("3- Generado por una placa");
            System.out.println("0- Salir");
            System.out.print("> ");
            opcion = entrada.nextInt();
            switch(opcion){
                case 1:
                        try{
                            Particula proton = new Particula(-4.0e-6);
                            System.out.println("El campo eléctrico generado por una carga es: " + campoElectrico.getCampoElectricoPorCarga(proton));
                        }catch(CargaEsCeroException e){
                            System.out.println("La carga no puede ser cero.");
                        }
                    break;
                case 2:
                    break;
                case 3:
                        try{
                            Placa placa = new Placa(2.0e2, 3.0e-5);
                            System.out.println("El campo eléctrico generado por una placa es: " + campoElectrico.getCampoElectricoPorPlaca(placa));
                        }catch(CargaEsCeroException e){
                            System.out.println("La carga no puede ser cero.");
                        }
                    break;
            }
        }while(opcion != 0);
    }
}
