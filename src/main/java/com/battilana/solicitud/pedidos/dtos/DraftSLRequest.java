package com.battilana.solicitud.pedidos.dtos;

import java.time.LocalDate;
import java.util.List;

public record DraftSLRequest(
        //CODIGO DEL CLIENTE
        String CardCode,
        //TIPO DE DOCUMENTO
        String DocObjectCode,
        //COMENTARIOS
        String Comments,
        //TIPO DE VENTA
        String U_SYP_TVENTA,
        //FECHA,
        LocalDate DocDueDate,
        //CODIGO DEL AGENTE VENDEDOR
        String SalesPersonCode,
        //ARREGLO DE LOS PRODUCTOS
        List<DraftDocumentLineRequest> DocumentLines
) {
}
