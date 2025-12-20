package com.battilana.solicitud.pedidos.services;

import com.battilana.solicitud.pedidos.dtos.*;

import java.util.List;

public interface ManageSapService {

    //SECCION DE DRAFTS
    DraftSLResponse findDraftById(Integer idDraft, Long idUsuarioSap);
    DraftSLResponse saveDraft(DraftSLRequest draftSLRequest, Long idUsuarioSap);
    List<ClientesResponse> listadoClientesPorVendedor(Integer idVendedor);
    List<ClientesResponse> listadoClientesPorVendedorYCardName(Integer idVendedor, String cardName);
    VendedoresResponse buscarVendedorPorId(Integer idVendedor);
    List<ArticulosResponse> listadoArticulosPorAlmacen(String idAlmacen);
    List<ArticulosResponse> listadoArticulosPorAlmacenYNombre(String idAlmacen, String nombre);
    StockAlmacenResponse stockPorArticuloYAlmacen(String idArticulo, String idAlmacen);
}
