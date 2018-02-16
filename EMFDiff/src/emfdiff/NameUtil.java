package emfdiff;

import org.eclipse.emf.ecore.EObject;

import gurobi.GRB;
import gurobi.GRBException;

public class NameUtil {
	private static final String VAR_MAP_FORMAT = "%-80.80s %s %-80.80s";
	private static final String EDGE_FORMAT = "%-30.30s -%-15.15s-> %-30.30s";

	public static String getNameString(Object o, boolean columns) {
		if (o instanceof EObject) {
			EObject eo = (EObject) o;
			return eo.eClass().getEAllAttributes().stream().filter(e -> "name".equals(e.getName().toLowerCase()))
					.findAny().map(eo::eGet).map(String::valueOf).orElse(eo.toString());
		} else if (o instanceof EEdge) {
			EEdge e = (EEdge) o;
			String sName = getNameString(e.getSource(), columns);
			String eName = e.getType().getName();
			String tName = getNameString(e.getTarget(), columns);
			if (columns) {
				return String.format(EDGE_FORMAT, sName, eName, tName);
			} else {
				return "[" + sName + " -" + eName + "-> " + tName + "]";
			}
		} else if (o instanceof GurobiVariableMapping) {
			GurobiVariableMapping<?> m = (GurobiVariableMapping<?>) o;
			String sel;
			try {
				sel = ((m.getVariable().get(GRB.DoubleAttr.X) > 0) ? "<===>" : "<=/=>");
			} catch (GRBException e) {
				throw new RuntimeException(e);
			}
			String aName = getNameString(m.getaObject(), columns);
			String bName = getNameString(m.getbObject(), columns);
			if (columns) {
				return String.format(VAR_MAP_FORMAT, aName, sel, bName);
			} else {
				return aName + sel + bName;
			}
		} else {
			return String.valueOf(o);
		}
	}
	
	public static String getNameString(Object o) {
		return getNameString(o, true);
	}
}
