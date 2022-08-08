package com.api.desafio.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.api.desafio.model.ResponseModel;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class CalculoService {

    @Autowired
    private ResponseModel rm;

    public ResponseEntity<?> calcular(Integer numero){
        Date start = new Date();
        if (numero < 1) {
            rm.setMensagem("O número deve ser maior que zero");
            rm.setTempo("0");
            return new ResponseEntity<ResponseModel>(rm, HttpStatus.BAD_REQUEST);
        }
        List<Integer> lista = new ArrayList<>();
        int ocorrencias = 0;
        for (int n = 1; n <= numero; n++) {
            int divisores = 0;
            for (int divisor = 1; divisor <= n/2; divisor++){
                if (n%divisor == 0){
                   divisores ++;
                }
            }
            lista.add(divisores);
            if ((n-1 != 0) && lista.get(n-1).equals(lista.get(n-2))) {
                ocorrencias ++;
            }
        }
        Date end = new Date();
        long diferencaTempo = end.getTime() - start.getTime();
        rm.setMensagem(null);
        rm.setOcorrencias(String.valueOf(ocorrencias));
        rm.setTempo(String.valueOf(diferencaTempo));
        return new ResponseEntity<ResponseModel>(rm, HttpStatus.OK);
    }

}
