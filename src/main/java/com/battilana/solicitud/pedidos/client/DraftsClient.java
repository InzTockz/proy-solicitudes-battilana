package com.battilana.solicitud.pedidos.client;

import com.battilana.solicitud.pedidos.client.dto.DraftRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "drafts", url = "https://192.168.1.2:50000/b1s/v2/Drafts")
public interface DraftsClient {

    @RequestMapping(method = RequestMethod.POST)
    DraftRequest addDraft (@RequestBody DraftRequest draftRequest);

}