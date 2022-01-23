package rs.kostakuu.todo.contracts.mappers;

import rs.kostakuu.todo.entities.Item;
import rs.kostakuu.todo.payloads.RequestPayload;
import rs.kostakuu.todo.payloads.ResponsePayload;

public interface ItemMapperContract {

    ResponsePayload map(Item item);

    Item map(RequestPayload requestPayload);

}
