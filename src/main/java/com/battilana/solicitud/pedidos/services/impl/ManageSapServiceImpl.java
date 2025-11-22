package com.battilana.solicitud.pedidos.services.impl;

import com.battilana.solicitud.pedidos.config.FeignConfig;
import com.battilana.solicitud.pedidos.dtos.*;
import com.battilana.solicitud.pedidos.entities.UsuariosSapEntity;
import com.battilana.solicitud.pedidos.repositorys.UsuarioSapRepository;
import com.battilana.solicitud.pedidos.services.*;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ManageSapServiceImpl implements ManageSapService {

    private final DraftsClient draftsClient;
    private final SapLoginClient sapLoginClient;
    private final UsuarioSapRepository usuarioSapRepository;
    private final ClientesClient clientesClient;
    private final VendedorClient vendedorClient;
    private final ArticuloClient articuloClient;
    private final DraftsSapClient draftsSapClient;

    public ManageSapServiceImpl(DraftsClient draftsClient, SapLoginClient sapLoginClient, UsuarioSapRepository usuarioSapRepository, ClientesClient clientesClient, VendedorClient vendedorClient, ArticuloClient articuloClient, DraftsSapClient draftsSapClient) {
        this.draftsClient = draftsClient;
        this.sapLoginClient = sapLoginClient;
        this.usuarioSapRepository = usuarioSapRepository;
        this.clientesClient = clientesClient;
        this.vendedorClient = vendedorClient;
        this.articuloClient = articuloClient;
        this.draftsSapClient = draftsSapClient;
    }

    @Override
    public DraftResponse findDraftById(Integer idDraft, Long idUsuarioSap) {

        Optional<UsuariosSapEntity> usuariosSapEntity = this.usuarioSapRepository.findById(idUsuarioSap);
        if (usuariosSapEntity.isPresent()) {
            ResponseEntity<SapLoginResponse> sapLoginResponse = this.sapLoginClient.sapLogin(
                    new SapLoginRequest(
                            usuariosSapEntity.get().getCompanyName(),
                            usuariosSapEntity.get().getPassword(),
                            usuariosSapEntity.get().getUsername()
                    )
            );

            List<String> cookie = sapLoginResponse.getHeaders().get("Set-Cookie");
            FeignConfig.setSession(cookie.get(0) + cookie.get(1));

            return this.draftsClient.listDraftById(idDraft);
        } else {
            return null;
        }
    }

    @Override
    public DraftResponse saveDraft(DraftRequest draftRequest, Long idUsuarioSap) {
        Optional<UsuariosSapEntity> usuariosSapEntity = this.usuarioSapRepository.findById(idUsuarioSap);
        if (usuariosSapEntity.isPresent()) {
            ResponseEntity<SapLoginResponse> sapLoginResponse = this.sapLoginClient.sapLogin(new SapLoginRequest(
                    usuariosSapEntity.get().getCompanyName(),
                    usuariosSapEntity.get().getPassword(),
                    usuariosSapEntity.get().getUsername()
            ));

            List<String> cookie = sapLoginResponse.getHeaders().get("Set-Cookie");
            FeignConfig.setSession(cookie.get(0) + cookie.get(1));

            return this.draftsClient.addDraft(draftRequest);
        } else {
            return null;
        }
    }

    @Override
    public List<ClientesResponse> listadoClientesPorVendedor(Integer idVendedor) {
        return this.clientesClient.listadoClientesPorIdVendedor(idVendedor);
    }

    @Override
    public VendedoresResponse buscarVendedorPorId(Integer idVendedor) {
        return this.vendedorClient.buscarVendedorPorId(idVendedor);
    }

    @Override
    public List<ArticulosResponse> listadoArticulosPorAlmacen(String idAlmacen) {
        return this.articuloClient.listadoArticulosPorAlmacen(idAlmacen);
    }

    @Override
    public List<ArticulosResponse> listadoArticulosPorAlmacenYNombre(String idAlmacen, String nombre) {
        return this.articuloClient.listadoArticulosPorAlmacenYNombre(idAlmacen, nombre);
    }

    @Override
    public StockAlmacenResponse stockPorArticuloYAlmacen(String idArticulo, String idAlmacen) {
        return this.articuloClient.stockPorArticuloYAlmacen(idArticulo,idAlmacen);
    }

}
