import static org.junit.Assert.*;
import org.junit.Test;

public class BeverageInputValidatorTest {

    // Prueba: Nombre corto
    @Test
    public void pruebaNombreCorto() {
        assertFalse(BeverageInputValidator.validateInput("C,1,2,3"));
    }

    // Prueba: Nombre válido
    @Test
    public void pruebaNombreValido() {
        assertTrue(BeverageInputValidator.validateInput("LatteMacchiato,1,2,3,4,5"));
    }

    // Prueba: Rango de tamaño válido
    @Test
    public void pruebaRangoTamañoValido() {
        assertTrue(BeverageInputValidator.validateInput("Espresso,1,24,48"));
    }

    // Prueba: Tamaño no entero
    @Test
    public void pruebaTamañoNoEntero() {
        assertFalse(BeverageInputValidator.validateInput("Mocha,1,2.5,3"));
    }

    // Prueba: Tamaños no ordenados
    @Test
    public void pruebaTamañosNoOrdenados() {
        assertFalse(BeverageInputValidator.validateInput("Americano,3,2,1"));
    }

    // Prueba: Múltiples tamaños dentro del rango
    @Test
    public void pruebaMultiplesTamañosEnRango() {
        assertTrue(BeverageInputValidator.validateInput("Cappuccino,5"));
        assertTrue(BeverageInputValidator.validateInput("Cappuccino,1,2,3,4,5"));
        assertFalse(BeverageInputValidator.validateInput("Cappuccino,1,2,3,4,5,6"));
    }

    // Prueba: Parámetros de entrada válidos
    @Test
    public void pruebaParametrosEntradaValidos() {
        assertTrue(BeverageInputValidator.validateInput("Latte,6,12,24"));
    }

    // Prueba: String de entrada vacío
    @Test
    public void pruebaStringEntradaVacio() {
        assertFalse(BeverageInputValidator.validateInput(""));
    }

    // Prueba: Entrada nula
    @Test
    public void pruebaEntradaNula() {
        assertFalse(BeverageInputValidator.validateInput(null));
    }

    // Prueba: Caracteres especiales en nombre
    @Test
    public void pruebaCaracteresEspecialesEnNombre() {
        assertFalse(BeverageInputValidator.validateInput("Chai!Latte,6,12,24"));
    }

    // Prueba: Longitud de nombre excedida
    @Test
    public void pruebaLongitudNombreExcedida() {
        assertFalse(BeverageInputValidator.validateInput("VanillaCaramelLatte,6,12,24"));
    }

    // Prueba: Tamaños repetidos
    @Test
    public void pruebaTamañosRepetidos() {
        assertFalse(BeverageInputValidator.validateInput("Mocha,8,8,12"));
    }

    // Prueba: Tamaño máximo excedido
    @Test
    public void pruebaExcedidoTamañoMax() {
        assertFalse(BeverageInputValidator.validateInput("Tea,6,24,49"));
    }

    // Prueba: Tamaño negativo
    @Test
    public void pruebaTamañoNegativo() {
        assertFalse(BeverageInputValidator.validateInput("Tea,6,-12,24"));
    }

    // Prueba: Tamaño no numérico
    @Test
    public void pruebaTamañoNoNumerico() {
        assertFalse(BeverageInputValidator.validateInput("Juice,6,12a,24"));
    }

    // Prueba: Espacios al inicio del nombre
    @Test
    public void pruebaEspaciosInicio() {
        assertTrue(BeverageInputValidator.validateInput(" Green Tea,6,12,24"));
    }

    // Prueba: Espacios alrededor del nombre y tamaños
    @Test
    public void pruebaEspaciosAlrededorNombreYTamaños() {
        assertTrue(BeverageInputValidator.validateInput(" Black Tea , 1 , 2, 3 "));
    }

    // Prueba: Sin tamaños repetidos
    @Test
    public void pruebaSinTamañosRepetidos() {
        assertFalse(BeverageInputValidator.validateInput("Tea,6,6,12,24"));
    }

    // Prueba: Recibir lista de tamaños
    @Test
    public void pruebaRecibirLista() {
        assertTrue(BeverageInputValidator.validateInput("Smoothie,12,24,36"));
    }

    // Prueba: Lista de tamaños no vacía
    @Test
    public void pruebaListaNoVacia() {
        assertTrue(BeverageInputValidator.validateInput("Latte,8"));
    }

    // Prueba: Múltiples tamaños de bebida
    @Test
    public void pruebaMultiplesTamañosBebida() {
        assertTrue(BeverageInputValidator.validateInput("Iced Tea,6,12"));
    }

    // Prueba: Nombre de bebida demasiado largo
    @Test
    public void pruebaNombreLargo() {
        assertFalse(BeverageInputValidator.validateInput("EsteEsUnNombreDeBebidaMuyLargo,1,2,3"));
    }

    // Prueba: Tamaño máximo permitido
    @Test
    public void pruebaTamañoMaximo() {
        assertTrue(BeverageInputValidator.validateInput("Chai,1,2,3,4,48"));
    }

    // Prueba: Tamaño fuera de rango
    @Test
    public void pruebaTamañoFueraDeRango() {
        assertFalse(BeverageInputValidator.validateInput("Chocolate,50"));
    }

    // Prueba: Caracteres especiales en los tamaños
    @Test
    public void pruebaCaracteresEspecialesEnTamaños() {
        assertFalse(BeverageInputValidator.validateInput("Café,6,@,12,24"));
    }
}