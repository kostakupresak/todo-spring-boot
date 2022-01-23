package rs.kostakuu.todo.contracts.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rs.kostakuu.todo.entities.Item;

@Repository
public interface ItemRepositoryContract extends JpaRepository<Item, Integer> {
}
