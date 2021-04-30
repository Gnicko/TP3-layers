package ar.unrn.tp3.main;

import ar.unrn.tp3.bd.JdbcParticipantes;
import ar.unrn.tp3.ui.AgregarParticipante;

import java.awt.*;

public class main {
   // Licenciatura en Sistemas
   // Orientación a Objetos II
    public static void main(String[] args)  {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new AgregarParticipante(new JdbcParticipantes());
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        });
    }
}

