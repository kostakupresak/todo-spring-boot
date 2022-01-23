package rs.kostakuu.todo.services;

import org.springframework.stereotype.Service;
import rs.kostakuu.todo.contracts.mappers.ItemMapperContract;
import rs.kostakuu.todo.contracts.repositories.ItemRepositoryContract;
import rs.kostakuu.todo.contracts.services.ItemServiceContract;
import rs.kostakuu.todo.entities.Item;
import rs.kostakuu.todo.payloads.RequestPayload;
import rs.kostakuu.todo.payloads.ResponsePayload;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ItemService implements ItemServiceContract {

    private final ItemRepositoryContract itemRepository;
    private final ItemMapperContract itemMapper;

    public ItemService(ItemRepositoryContract itemRepository, ItemMapperContract itemMapper) {
        this.itemRepository = itemRepository;
        this.itemMapper = itemMapper;
    }

    @Override
    public List<ResponsePayload> findAll() {
        return this.itemRepository
                .findAll()
                .stream()
                .map(this.itemMapper::map)
                .collect(Collectors.toList());
    }

    @Override
    public ResponsePayload add(RequestPayload requestPayload) {
        Item item = this.itemMapper.map(requestPayload);
        Item savedItem = this.itemRepository.save(item);

        return this.itemMapper.map(savedItem);
    }

    @Override
    public ResponsePayload toggle(Integer id) {
        Item item = this.itemRepository.findById(id).orElse(null);

        if (item == null) {
            return null;
        }

        item.setIsToggled(!item.getIsToggled());
        Item toggledItem = this.itemRepository.save(item);

        return this.itemMapper.map(toggledItem);
    }

    @Override
    public ResponsePayload delete(Integer id) {
        Item item = this.itemRepository.findById(id).orElse(null);

        if (item == null) {
            return null;
        }

        this.itemRepository.delete(item);

        return this.itemMapper.map(item);
    }

}
