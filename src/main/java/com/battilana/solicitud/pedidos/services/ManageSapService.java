package com.battilana.solicitud.pedidos.services;

import com.battilana.solicitud.pedidos.dtos.*;

import java.util.List;

public interface ManageSapService {

    //SECCION DE DRAFTS
    DraftResponse findDraftById(Integer idDraft, Long idUsuarioSap);
    DraftResponse saveDraft(DraftRequest draftRequest, Long idUsuarioSap);
    List<ClientesResponse> listadoClientesPorVendedor(Integer idVendedor);
    VendedoresResponse buscarVendedorPorId(Integer idVendedor);
    List<ArticulosResponse> listadoArticulosPorAlmacen(String idAlmacen);
    List<ArticulosResponse> listadoArticulosPorAlmacenYNombre(String idAlmacen, String nombre);
    StockAlmacenResponse stockPorArticuloYAlmacen(String idArticulo, String idAlmacen);
}
