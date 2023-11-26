package com.pw.movielist.principal.controller;

import com.pw.movielist.principal.model.Log;
import com.pw.movielist.principal.model.dto.ListaDTO;
import com.pw.movielist.principal.service.LogService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins= "*", maxAge = 36)
@RequestMapping("log")
public class LogController {
    private LogService logService;

    public LogController(LogService logService) {
        this.logService = logService;
    }

    @GetMapping("/{idLog}")
    @Operation(summary = "Visualiza um log")
    public Log visualizarLog(@PathVariable Long idLog){

        return logService.encontrarLog(idLog);
    }

    @GetMapping("/usuario/{idUsuario}")
    @Operation(summary = "Visualiza logs de um usuario")
    public List<Log> visualizarLogUsuario(@PathVariable Long idUsuario){
        return logService.encontrarLogsUsuario(idUsuario);
    }
}
