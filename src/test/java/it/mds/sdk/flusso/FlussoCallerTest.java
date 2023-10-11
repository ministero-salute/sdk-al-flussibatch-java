package it.mds.sdk.flusso;


import it.mds.sdk.aljavalib.exception.AccessLayerException;
import it.mds.sdk.aljavalib.service.FlussoService;
import it.mds.sdk.gestoreesiti.modelli.InfoRun;
import it.mds.sdk.gestoreesiti.modelli.ModalitaOperativa;
import it.mds.sdk.gestoreesiti.modelli.StatoRun;
import it.mds.sdk.gestoreesiti.modelli.TipoElaborazione;
import it.mds.sdk.rest.persistence.entity.FlussoRequest;
import it.mds.sdk.rest.persistence.entity.RisultatoInizioValidazione;

import static org.assertj.core.api.Assertions.*;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.mockito.Mockito.*;

class FlussoCallerTest {

    FlussoCaller sut;

    FlussoService service;

    @BeforeEach
    void init() {
        service = mock(FlussoService.class);
        sut = new FlussoCaller(service);
    }

    @Test
    void lanciaFlusso() throws AccessLayerException {
        FlussoRequest request = new FlussoRequest();
        RisultatoInizioValidazione expectedResponse = new RisultatoInizioValidazione(Boolean.TRUE, RandomStringUtils.random(3), RandomStringUtils.random(3), RandomStringUtils.random(3));
        doReturn(expectedResponse).when(service).eseguiFlusso(request);

        RisultatoInizioValidazione response = sut.lanciaFlusso(request);

        verify(service, times(1)).eseguiFlusso(request);
        assertThat(response).isEqualTo(expectedResponse);
    }

    @Test
    void getInfoRun() throws AccessLayerException {
        String idRun = RandomStringUtils.random(3);
        String idClient = RandomStringUtils.random(3);
        InfoRun expectedResponse = new InfoRun(
                RandomStringUtils.random(3), RandomStringUtils.random(3), null, TipoElaborazione.F,
                ModalitaOperativa.P, null, null, StatoRun.IN_ELABORAZIONE,
                RandomStringUtils.random(3), RandomStringUtils.random(3), RandomStringUtils.random(3),
                0, 0, 0, RandomStringUtils.random(3),
                null, RandomStringUtils.random(3), RandomStringUtils.random(3),
                RandomStringUtils.random(3), RandomStringUtils.random(3), RandomStringUtils.random(3),
                null, RandomStringUtils.random(3), RandomStringUtils.random(3),
                RandomStringUtils.random(3), RandomStringUtils.random(3), RandomStringUtils.random(3),
                RandomStringUtils.random(3), RandomStringUtils.random(3)
        );
        doReturn(expectedResponse).when(service).getInfoRun(idRun, idClient);

        InfoRun response = sut.getInfoRun(idRun, idClient);

        verify(service, times(1)).getInfoRun(idRun, idClient);
        assertThat(response).isEqualTo(expectedResponse);
    }
}