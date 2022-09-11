package com.backsoul.move.dataseed;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.backsoul.move.model.Move;
//import com.backsoul.category.model.Category;
import com.backsoul.move.repository.MoveRepository;

@Component
public class MoveSeed implements CommandLineRunner {

    @Autowired
    MoveRepository moveRepository;

    @Override
    public void run(String... args) throws Exception {
        loadUserData();
    }

    private void loadUserData() {
        if (moveRepository.count() == 0) {
            Move move1 = new Move();
            move1.setName("Egreso");
            moveRepository.save(move1);

            Move move2 = new Move();
            move2.setName("Ingreso");
            moveRepository.save(move2);

            Move move3 = new Move();
            move3.setName("Retiro");
            moveRepository.save(move3);

            Move move4 = new Move();
            move4.setName("Transferencia");
            moveRepository.save(move4);
        }
        System.out.println(moveRepository.count());
    }
}