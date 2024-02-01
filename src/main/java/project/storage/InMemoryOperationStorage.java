package project.storage;

import project.model.Operation;

import java.util.ArrayList;
import java.util.List;

public class InMemoryOperationStorage {

	private final List<Operation> operations = new ArrayList<>();

	public void save(Operation operation) {

		operations.add(operation);

	}

	public List<Operation> findAll() {

		return new ArrayList<>(operations);

	}

}
