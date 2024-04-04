public class BeverageInputValidator {
    // Método para validar la entrada completa
    public static boolean validateInput(String input)
    {
        // No se aceptan cadenas vacias o nulas
        if (input == null || input.isEmpty())
        {
            return false; // Si la entrada es nula o vacía, la validación falla
        }

        // Eliminar espacios en blanco
        input = input.replaceAll("\\s", ""); // Eliminar todos los espacios en blanco de la entrada

        // Separar el nombre del artículo de los tamaños
        String[] parts = input.split(","); // Separar la entrada en partes usando ',' como delimitador
        if (parts.length < 2 || parts.length > 6)
        {
            // Nombre + 1 a 5 tamaños
            return false; // Si hay menos de 2 partes o más de 6 partes, la validación falla
        }

        // Validar el nombre del artículo
        if (!parts[0].matches("[a-zA-Z]{2,15}"))
        {
            return false; // Si el primer elemento no coincide con el patrón [a-zA-Z]{2,15}, la validación falla
        }
        // Validar cada tamaño
        int previousSize = 0; // Inicializar el tamaño anterior como 0
        for (int i = 1; i < parts.length; i++)
        {
            try
            {
                int size = Integer.parseInt(parts[i]); // Convertir el elemento actual en un entero
                if (size < 1 || size > 48 || size <= previousSize)
                {
                    return false; // Si el tamaño está fuera de rango o es menor o igual al tamaño anterior, la validación falla
                }
                previousSize = size; // Actualizar el tamaño anterior
            }
            catch (NumberFormatException e)
            {
                return false; // Si no se puede convertir el elemento en un entero, la validación falla
            }
        }
        return true; // Si pasa todas las validaciones anteriores, la entrada es válida
    }
}
