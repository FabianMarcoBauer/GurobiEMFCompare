package emfdiff.runner;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.uml2.uml.UMLPackage;

import ArtificialSource.ArtificialSourcePackage;
import emfdiff.EMFDiff;

public class EMFDiffRunner {
	public static void main(String[] args) throws IOException {
		Resource.Factory.Registry reg = Resource.Factory.Registry.INSTANCE;
		Map<String, Object> m = reg.getExtensionToFactoryMap();
		m.put("xmi", new XMIResourceFactoryImpl());
		UMLPackage.eINSTANCE.getName();
		ArtificialSourcePackage.eINSTANCE.getName();

		ResourceSet rs = new ResourceSetImpl();
		Resource r1 = rs.getResource(URI.createFileURI(new File("instances/ART_1000.xmi").getAbsolutePath()), true);
		Resource r2 = rs.getResource(URI.createFileURI(new File("instances/ART_100.xmi").getAbsolutePath()), true);
//		Resource r1 = rs.getResource(URI.createFileURI(new File("instances/UML_small.xmi").getAbsolutePath()), true);
//		Resource r2 = rs.getResource(URI.createFileURI(new File("instances/UML_small.xmi").getAbsolutePath()), true);

		EObject o = r1.getContents().get(0);
		EObject o2 = r2.getContents().get(0);

		EMFDiff emfDiff = new EMFDiff(o, o2);
		emfDiff.createGurobiModel().optimize();
//		GurobiMappedModel optimizedModel = emfDiff.createGurobiModel().optimize();
//		List<Object> selectedMappings = optimizedModel.getSelectedMappings();
//		selectedMappings.stream().map(NameUtil::getNameString).sorted().forEach(System.out::println);

		Resource d1 = rs.createResource(URI.createFileURI(new File("instances/delta1.xmi").getAbsolutePath()));
		Resource d2 = rs.createResource(URI.createFileURI(new File("instances/delta2.xmi").getAbsolutePath()));
		emfDiff.generateDeltas(d1, d2);
		d1.save(null);
		d2.save(null);
	}

	
}
