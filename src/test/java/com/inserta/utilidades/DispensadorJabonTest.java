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
    public void apagadoAutomatico(){

        fail("No implementado todavía");
    }


}