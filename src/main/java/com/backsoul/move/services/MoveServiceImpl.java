package com.backsoul.move.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.backsoul.move.model.Move;
import com.backsoul.move.repository.MoveRepository;

@Service
public class MoveServiceImpl implements MoveService {

    private final MoveRepository moveRepository;

    MoveServiceImpl(MoveRepository moveRepository) {
        this.moveRepository = moveRepository;
    }

    @Override
    public List<Move> getMoves() {
        return (List<Move>) moveRepository.findAll();
    }
}
