package rs.kostakuu.todo.contracts.services;

import rs.kostakuu.todo.payloads.RequestPayload;
import rs.kostakuu.todo.payloads.ResponsePayload;

import java.util.List;

public interface ItemServiceContract {

    List<ResponsePayload> findAll();

    ResponsePayload add(RequestPayload requestPayload);

    ResponsePayload toggle(Integer id);

    ResponsePayload delete(Integer id);

}
