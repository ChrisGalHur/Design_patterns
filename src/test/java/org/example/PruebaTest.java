package org.example;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;


class PruebaTest {
    @Test
    void testCalculator() {

        Prueba pruebas = new Prueba();

        int resultado = pruebas.calculator(1, 1);

        assertThat(resultado).isEqualTo(4); // Verifica que el resultado sea 4
        assertThat(pruebas.getNum1()).isEqualTo(1);
        assertThat(pruebas.getNum2()).isEqualTo(1);
    }
}
