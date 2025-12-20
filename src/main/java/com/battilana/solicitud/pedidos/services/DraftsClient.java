package com.battilana.solicitud.pedidos.services;

import com.battilana.solicitud.pedidos.dtos.DraftSLRequest;
import com.battilana.solicitud.pedidos.dtos.DraftSLResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "drafts", url = "https://192.168.1.2:50000/b1s/v2")
public interface DraftsClient {

    @RequestMapping(method = RequestMethod.POST, value = "/Drafts")
    DraftSLResponse addDraft (@RequestBody DraftSLRequest draftSLRequest);

    @RequestMapping(method = RequestMethod.GET, value = "/Drafts({idDraft})")
    DraftSLResponse listDraftById(@PathVariable Integer idDraft);
}