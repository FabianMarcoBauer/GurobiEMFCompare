package emfdiff;

import gurobi.GRB;
import gurobi.GRBException;
import gurobi.GRBVar;

public class GurobiVariableMapping<T> {
	private final GRBVar variable;
	private final T aObject;
	private final T bObject;

	public GurobiVariableMapping(GRBVar variable, T aObject, T bObject) {
		super();
		this.variable = variable;
		this.aObject = aObject;
		this.bObject = bObject;
	}

	public GRBVar getVariable() {
		return variable;
	}

	public T getaObject() {
		return aObject;
	}

	public T getbObject() {
		return bObject;
	}

	@Override
	public String toString() {
		try {
			return aObject + ((variable.get(GRB.DoubleAttr.X)>0)?"<===>":"<=/=>") + bObject;
		} catch (GRBException e) {
			throw new RuntimeException(e);
		}
	}

}
