package com.inserta.utilidades;

import org.junit.Test;

import static org.junit.Assert.*;

public class DispensadorJabonTest {

    /**
     * La prueba unitaria dará correcto si se cumplen las 3 condiciones. No pasará la prueba si
     * se incumple alguna de las condiciones.
     * <ul>
     *     <li>La marca no es null</li>
     *     <li>Está apagado</li>
     *     <li>El depósito está vacío</li>
     * </ul>
     */
    @Test
    public void creacionPorDefecto(){
        DispensadorJabon dispensadorJabon = new DispensadorJabon();
        System.out.println(dispensadorJabon);
        assertNotNull("Marca es nula", dispensadorJabon.getMarca());
        assertFalse("Está encendido", dispensadorJabon.isEncendido());
        assertEquals("El depósito no está vacío", 0, dispensadorJabon.getDepositoActual());
    }

    /**
     * Hacer una prueba unitaria para comprobar el dispensador se apaga automáticamente al llegar al 0% de batería
     */
    @Test
    public void apagadoAutomaticoModificandoBateria(){
        DispensadorJabon dispensadorJabon = new DispensadorJabon();
        dispensadorJabon.encender();
        System.out.println(dispensadorJabon);
        System.out.println("Le ponemos la batería al 0");
        dispensadorJabon.setBateria(0);
        System.out.println(dispensadorJabon);
        assertFalse("No se apagó automáticamente", dispensadorJabon.isEncendido());
    }

    /**
     * Hacer una prueba unitaria para comprobar el dispensador se apaga automáticamente al encenderlo muchas veces
     */
    @Test
    public void apagadoAutomaticoEncendiendoloMucho(){
        DispensadorJabon jabonera = new DispensadorJabon();
        for (int i = 0; i <= 30000; i++) {
            jabonera.encender();
        }
        assertTrue("Debería estar apagado", jabonera.isApagado());
    }

    /**
     * Hacer una prueba unitaria para comprobar el dispensador se apaga automáticamente si se queda sin batería
     * al dispensar muchas veces.
     */
    @Test
    public void apagadoAutomaticoDispensarMucho(){
        DispensadorJabon dispensadorJabon = new DispensadorJabon();
        dispensadorJabon.encender();
        for (int i = 0; i <= 30000; i++) {
            dispensadorJabon.dispensar();
        }
        assertTrue("Debería estar apagado", dispensadorJabon.isApagado());
    }

    @Test
    public void apagadoManualmenteConElBoton(){
        DispensadorJabon dispensadorJabon = new DispensadorJabon();
        dispensadorJabon.encender();
        dispensadorJabon.apagar();
        assertTrue("Debería estar apagado", dispensadorJabon.isApagado());
    }

}