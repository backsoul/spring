package com.backsoul.move.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.backsoul.move.model.Move;

@Repository
public interface MoveRepository extends CrudRepository<Move, String> {
    @Query(value = "SELECT id, name FROM moves", nativeQuery = true)
    Iterable<Move> findAll();

    Move findFirstById(String move_id);
}
