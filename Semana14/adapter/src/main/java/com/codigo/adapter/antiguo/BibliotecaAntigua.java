package com.codigo.adapter.antiguo;

public class BibliotecaAntigua {
    public String obtenerDetallesLibro(int idLibro) {
        return "<libro><id>" + idLibro + "</id><titulo>El principito</titulo><autor>Antoine de " +
                "Saint-Exupéry</autor></libro>";
    }
}
