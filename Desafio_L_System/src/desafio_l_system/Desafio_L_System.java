package desafio_l_system;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

public class Desafio_L_System {

    static String[] alfabeto = new String[10];
    static int passos;
    static String axioma;
    static Double degree;
    static Map<String, String> regras = new HashMap<String, String>();
    static String novaAxioma;

    public static void main(String[] args) throws Exception { 
        ReadFile();
        System.out.println(Gera_String());
    }

    public static String Gera_String(){
        
        novaAxioma=axioma;
        String retorno = "";
        String retornoVERDADEIRO = "";
        Boolean flag = false;
        int contador=0;
        do {
            for (char ch : novaAxioma.toCharArray()) {

                for (String key : regras.keySet()) {
                    flag = false;
                    if (ch == key.charAt(0)) {
                        retorno += regras.get(key);
                        flag = true;
                        break;
                    }
                }
                if (!flag) {
                    retorno += ch;
                }
            }
            novaAxioma = retorno;
            retornoVERDADEIRO=retorno;
            retorno="";
            contador++;
        } while (contador < passos);
   
        return retornoVERDADEIRO;
    }

    public static String[] ReadFile() throws Exception {        
                
        String auxiliar;
        
        File arquivo = new File("regras.txt");
        if (arquivo.exists()) {
            try {
                BufferedReader in = new BufferedReader(new FileReader(arquivo));
                String dados;
                while (in.ready()) {
                    dados = in.readLine(); // linha a linha do txt
                   if (dados.charAt(0) == 'A') {
                        auxiliar = dados.substring(dados.indexOf('|')+1);
                        alfabeto = auxiliar.split(",");
                    }
                    if (dados.charAt(0) == 'B') {
                        passos = Integer.parseInt(dados.substring(dados.indexOf('|')+1));
                    }
                    if (dados.charAt(0) == 'C') {
                        axioma = dados.substring(dados.indexOf('|')+1);
                    }
                    if (dados.charAt(0) == 'D') {
                        degree = Double.parseDouble(dados.substring(dados.indexOf('|')+1));
                    }
                   
                    if (dados.charAt(0) != 'A' && dados.charAt(0) != 'B' && dados.charAt(0) != 'C' && dados.charAt(0) != 'D') {
                        regras.put(String.valueOf(dados.charAt(0)), dados.substring(dados.indexOf('|')+1));
                    }
                }
                in.close();
                return null;

            } catch (FileNotFoundException e) {
                System.out.println("Erro: " + e);
                throw e;
            }
        } else {
            System.out.println("Erro na leitura do arquivo.");
            throw new Exception();
        }
    }

}
