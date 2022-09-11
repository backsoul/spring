package com.backsoul.move.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backsoul.MainApplication;
import com.backsoul.move.model.Move;
import com.backsoul.move.services.MoveServiceImpl;

@RestController
@RequestMapping(MainApplication.BASE_API_URL + "/move")
public class MoveController {
    @Autowired
    MoveServiceImpl moveServiceImpl;

    @GetMapping()
    public List<Move> getWallet() {
        return moveServiceImpl.getMoves();
    }
}
