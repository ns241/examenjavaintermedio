import  java.util.*;
public class Ejecucion{

    public static void main (String [] args){

        Methods a = new Methods();
        String op;
        Scanner sc = new Scanner(System.in);

        System.out.println("Ingresa el nombre a buscar:\n");
        op = sc.nextLine();

        if(op.isEmpty()){
            System.out.println("Vuelve a Intentar");

        }else {

            a.buscarUsuario(op);
            a.validarPerfil();
            a.validarCorreo();

        }

    }
}
