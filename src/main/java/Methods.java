import java.io.*;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class Methods {

   JSONArray array;
   JSONParser parser = new JSONParser();

   private final ArrayList<String> arrayList = new ArrayList<>();
   private final ArrayList<String> arrayList2 = new ArrayList<>();
   private final ArrayList<String> arrayList3 = new ArrayList<>();


    public void cargarBody() {

        try {

            FileReader reader = new FileReader("src/main/resources/requestBody.json");
           Object obj = parser.parse(reader);

            JSONObject jsonObject = (JSONObject) obj;
            array = (JSONArray) jsonObject.get("data");

        } catch (Exception e) {
            System.out.println(e);
        }

    }


    public void buscarUsuario(String op){

        cargarBody();

        for (int i = 0; i < array.size(); i++) {

            JSONObject data = (JSONObject) array.get(i);
            String usuario = (String) data.get("nombreDeUsuario");
            String perfil = (String) data.get("perfilUsuario");
            String correo = (String) data.get("correoElectronico");


            if (usuario.contains(op.trim())) {
                System.out.println("\nperfil: " + perfil + "\n" + "email: " + correo);
                arrayList.add(usuario);
                arrayList2.add(perfil);
                arrayList3.add(correo);
            }

        }

        if (arrayList.size() < 1) {
            System.out.println("\nUsuario no Encontrado");
        }

    }


    public void validarPerfil() {

       if (arrayList.size() == 1){

           if(arrayList2.contains("admin")) {

               System.out.println("\nEs Administrador");

           } else {

                    System.out.println("\nNo es Administrador");
                }

       }

    }

    public void validarCorreo(){

        if(arrayList.size()==1) {

            Pattern pattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
            String cadena = arrayList3.get(0);
            Matcher matcher = pattern.matcher(cadena);

            if(matcher.find()){
                System.out.println("Correo válido");
            }else{
                System.out.println("Correo inválido");
            }

        }

    }


}
