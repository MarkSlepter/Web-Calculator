package project.service;

import project.model.Operation;
import project.storage.InMemoryOperationStorage;

public class OperationService {

	private final InMemoryOperationStorage operationStorage = new InMemoryOperationStorage();

	public Operation calculate(Operation operation) {

		switch (operation.getOperation()) {

			case "sum":

				double sumResult = operation.getNum1() + operation.getNum2();
				operation.setResult(sumResult);
				return operation;

			case "min":

				double minResult = operation.getNum1() - operation.getNum2();
				operation.setResult(minResult);
				return operation;

			case "multi":

				double multiResult = operation.getNum1() * operation.getNum2();
				operation.setResult(multiResult);
				return operation;

			case "div":

				if (operation.getNum2() != 0) {

					double divResult = operation.getNum1() / operation.getNum2();
					operation.setResult(divResult);
					return operation;

				} else {

					throw new IllegalArgumentException();

				}

		}

		throw new IllegalArgumentException();

	}

}
