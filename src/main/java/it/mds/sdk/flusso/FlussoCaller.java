package it.mds.sdk.flusso;

import it.mds.sdk.aljavalib.exception.AccessLayerException;
import it.mds.sdk.aljavalib.service.FlussoService;
import it.mds.sdk.gestoreesiti.modelli.InfoRun;
import it.mds.sdk.rest.persistence.entity.FlussoRequest;
import it.mds.sdk.rest.persistence.entity.RisultatoInizioValidazione;

public class FlussoCaller {

    private final FlussoService flussoService;

    public FlussoCaller(FlussoService flussoService) {
        this.flussoService = flussoService;
    }

    public RisultatoInizioValidazione lanciaFlusso(FlussoRequest flussoRequest) throws AccessLayerException {
        return flussoService.eseguiFlusso(flussoRequest);
    }

    public InfoRun getInfoRun(String idRun, String idClient) throws AccessLayerException {
        return flussoService.getInfoRun(idRun, idClient);

    }
}
