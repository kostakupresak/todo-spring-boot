package rs.kostakuu.todo.mapper;

import org.springframework.stereotype.Component;
import rs.kostakuu.todo.contracts.mappers.ItemMapperContract;
import rs.kostakuu.todo.entities.Item;
import rs.kostakuu.todo.payloads.RequestPayload;
import rs.kostakuu.todo.payloads.ResponsePayload;

@Component
public class ItemMapper implements ItemMapperContract {

    public ResponsePayload map(Item item) {
        return item != null
                ? new ResponsePayload(item.getId(), item.getText(), item.getIsToggled())
                : null;
    }

    public Item map(RequestPayload requestPayload) {
        return requestPayload != null
                ? new Item(null, requestPayload.getText(), false)
                : null;
    }

}
