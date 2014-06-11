/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.saludtec.utilidades;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 *
 * @author saintec
 */
public class Consola {
    public String exec(String comando) {
        String respuesta = "";
        try {
            String line;
//            Process p = Runtime.getRuntime().exec("mysql -h localhost -u root -p");
            Process p = Runtime.getRuntime().exec(comando);
            BufferedReader input = new BufferedReader(new InputStreamReader(p.getInputStream()));
            while ((line = input.readLine()) != null) {
                System.out.println(line);
                respuesta+=line+"\n";
            }
            input.close();
        } catch (Exception err) {
            err.printStackTrace();
        }
        return respuesta;
    }
}
