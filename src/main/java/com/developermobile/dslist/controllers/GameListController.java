package com.developermobile.dslist.controllers;

import com.developermobile.dslist.dto.GameDTO;
import com.developermobile.dslist.dto.GameListDTO;
import com.developermobile.dslist.dto.GameMinDTO;
import com.developermobile.dslist.dto.ReplacementDTO;
import com.developermobile.dslist.services.GameListService;
import com.developermobile.dslist.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/lists")
public class GameListController {
    @Autowired
    private GameListService service;

    @Autowired
    private GameService gameService;

    @GetMapping
    public ResponseEntity<List<GameListDTO>> findAll() {
        return ResponseEntity.ok().body(service.findAll());
    }

    @GetMapping("/{listId}/games")
    public ResponseEntity<List<GameMinDTO>> findByList(@PathVariable("listId") Long listId) {
        return ResponseEntity.ok().body(gameService.findByList(listId));
    }

    @PostMapping("/{listId}/replacement")
    public void move(@PathVariable Long listId, @RequestBody ReplacementDTO body) {
        service.move(listId, body.getSourceIndex(), body.getDestinationIndex());
    }



}
