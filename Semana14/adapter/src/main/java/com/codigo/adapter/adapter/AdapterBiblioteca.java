package com.codigo.adapter.adapter;

import com.codigo.adapter.antiguo.BibliotecaAntigua;
import org.json.JSONObject;
import org.json.XML;
import org.springframework.stereotype.Component;

@Component
public class AdapterBiblioteca {

    private final BibliotecaAntigua bibliotecaAntigua = new BibliotecaAntigua();

    public String obtenerDetallesLibroJson(int idLibro) {
        String libroXML = bibliotecaAntigua.obtenerDetallesLibro(idLibro);
        JSONObject jsonObject = XML.toJSONObject(libroXML);
        return jsonObject.toString(4);
    }
}
