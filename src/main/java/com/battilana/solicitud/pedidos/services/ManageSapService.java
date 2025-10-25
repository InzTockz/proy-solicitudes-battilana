package com.battilana.solicitud.pedidos.services;

import com.battilana.solicitud.pedidos.dtos.ClientesResponse;
import com.battilana.solicitud.pedidos.dtos.DraftRequest;
import com.battilana.solicitud.pedidos.dtos.DraftResponse;
import com.battilana.solicitud.pedidos.dtos.VendedoresResponse;

import java.util.List;

public interface ManageSapService {

    //SECCION DE DRAFTS
    DraftResponse findDraftById(Integer idDraft, Long idUsuarioSap);
    DraftResponse saveDraft(DraftRequest draftRequest, Long idUsuarioSap);
    List<ClientesResponse> listadoClientesPorVendedor(Integer idVendedor);
    VendedoresResponse buscarVendedorPorId(Integer idVendedor);
}
