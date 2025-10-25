package com.battilana.solicitud.pedidos.services;

import com.battilana.solicitud.pedidos.dtos.DraftRequest;
import com.battilana.solicitud.pedidos.dtos.DraftResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "drafts", url = "https://192.168.1.2:50000/b1s/v2")
public interface DraftsClient {

    @RequestMapping(method = RequestMethod.POST, value = "/Drafts")
    DraftResponse addDraft (@RequestBody DraftRequest draftRequest);

    @RequestMapping(method = RequestMethod.GET, value = "/Drafts({idDraft})")
    DraftResponse listDraftById(@PathVariable Integer idDraft);
}