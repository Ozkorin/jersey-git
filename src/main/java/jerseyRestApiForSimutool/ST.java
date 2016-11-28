package jerseyRestApiForSimutool;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

//Harshit: Additional Import
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.semanticweb.owlapi.apibinding.OWLManager;
import org.semanticweb.owlapi.model.AddAxiom;
import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLAnnotation;
import org.semanticweb.owlapi.model.OWLAxiom;
import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLClassAssertionAxiom;
import org.semanticweb.owlapi.model.OWLClassExpression;
import org.semanticweb.owlapi.model.OWLDataFactory;
import org.semanticweb.owlapi.model.OWLIndividual;
import org.semanticweb.owlapi.model.OWLNamedIndividual;
import org.semanticweb.owlapi.model.OWLObjectProperty;
import org.semanticweb.owlapi.model.OWLObjectPropertyAssertionAxiom;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLOntologyCreationException;
import org.semanticweb.owlapi.model.OWLOntologyManager;
import org.semanticweb.owlapi.model.OWLOntologyStorageException;
import org.semanticweb.owlapi.model.OWLSubClassOfAxiom;
import org.semanticweb.owlapi.model.PrefixManager;
import org.semanticweb.owlapi.util.DefaultPrefixManager;
import org.semanticweb.owlapi.vocab.OWL2Datatype;

public class ST {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	 private static OWLOntology o;
	 private static OWLOntologyManager m;
	 private static OWLDataFactory f;
	 private static PrefixManager pm = new DefaultPrefixManager("urn:test#");

	// Harshit: Code Start
	private String uploader = null;
	private String purpose = null;
	private String description = null;
	private String attachment = null;
	private String visibility = null;
	private String upload_date = null;
	private List<String> tags = new ArrayList<String>();
	private String linearTag = null;

	int x = 10;
	// Harshit: Code End

	// Harshit: Code Start
	public ST(String uploader, String purpose, String description, String attachment, String visibility,
			String upload_date, List<String> tags) {

		this.uploader = uploader;
		this.purpose = purpose;
		this.description = description;
		this.attachment = attachment;
		this.visibility = visibility;
		this.upload_date = upload_date;
		this.tags = tags;

		// Converting List of Tags to String type linearTag

		StringBuilder sb = new StringBuilder();

		for (String tag : tags) {
			sb.append(tag);
			sb.append(" ");
		}

		this.linearTag = sb.toString();

	}
	
	public String getLinearTag() {
		return linearTag;
	}
	// Harshit: Code End

	protected void doGet() {

		// Harshit: Removed previous variable declaration from here.

		OWLOntologyManager m = OWLManager.createOWLOntologyManager();
		File file = new File("Simutool_km.owl");

		OWLDataFactory f = OWLManager.getOWLDataFactory();

		PrefixManager pm = new DefaultPrefixManager("http://www.uni-bamberg.de/mobi#");

		String ir = "http://www.uni-bamberg.de/mobi/";

		// String ir =
		// "file:/C:/Users/Haya%20Majid%20Qureshi/Desktop/www.simutool-km.org";

		OWLClass document = f.getOWLClass(IRI.create(ir + "#Document"));
		OWLClass user = f.getOWLClass(IRI.create(ir + "#User"));
		OWLClass simu = f.getOWLClass(IRI.create(ir + "#SimuToolThing"));
		OWLClass resource = f.getOWLClass(IRI.create(ir + "#Resource"));

		// OWLClass clsN = f.getOWLClass(str, pm);
		// OWLDeclarationAxiom declarationAxiom =
		// f.getOWLDeclarationAxiom(clsN);
		// m.addAxiom(o, declarationAxiom);
		OWLNamedIndividual Uploader = f.getOWLNamedIndividual(uploader, pm);
		OWLNamedIndividual Document = f.getOWLNamedIndividual(attachment, pm);

		OWLClassAssertionAxiom clsD = f.getOWLClassAssertionAxiom(user, Uploader);
		m.addAxiom(o, clsD);
		OWLClassAssertionAxiom clsF = f.getOWLClassAssertionAxiom(document, Document);
		m.addAxiom(o, clsF);

		// New Individual with class

		OWLNamedIndividual Purpose = f.getOWLNamedIndividual(purpose, pm);
		OWLNamedIndividual Visibility = f.getOWLNamedIndividual(visibility, pm);
		// OWLNamedIndividual M13 = f.getOWLNamedIndividual(str13,pm);
		// OWLNamedIndividual M14 = f.getOWLNamedIndividual(str14,pm);
		// OWLNamedIndividual M15 = f.getOWLNamedIndividual(str15,pm);

		OWLClassAssertionAxiom cls11 = f.getOWLClassAssertionAxiom(simu, Purpose);
		m.addAxiom(o, cls11);
		OWLClassAssertionAxiom cls12 = f.getOWLClassAssertionAxiom(resource, Visibility);
		m.addAxiom(o, cls12);
		/*
		 * OWLClassAssertionAxiom cls13 = f.getOWLClassAssertionAxiom(resource,
		 * M13); m.addAxiom(o, cls13); OWLClassAssertionAxiom cls14 =
		 * f.getOWLClassAssertionAxiom(resource, M14); m.addAxiom(o, cls14);
		 * OWLClassAssertionAxiom cls15 = f.getOWLClassAssertionAxiom(resource,
		 * M15); m.addAxiom(o, cls15);
		 */

		// OWLEquivalentObjectPropertiesAxiom je =
		// f.getOWLNamedIndividual(arg0);

		OWLIndividual m1 = f.getOWLNamedIndividual(uploader, pm);
		OWLIndividual p1 = f.getOWLNamedIndividual(attachment, pm);
		OWLObjectProperty hasUploaded = f.getOWLObjectProperty(IRI.create(ir + "#hasUploadedthisDocument"));
		OWLObjectPropertyAssertionAxiom assertion = f.getOWLObjectPropertyAssertionAxiom(hasUploaded, m1, p1);
		AddAxiom addAxiomChange = new AddAxiom(o, assertion);
		m.applyChange(addAxiomChange);

		OWLAnnotation Tag = f.getOWLAnnotation(f.getRDFSSeeAlso(), f.getOWLTypedLiteral(linearTag));
		OWLAxiom a1 = f.getOWLAnnotationAssertionAxiom(Document.getIRI(), Tag);
		m.applyChange(new AddAxiom(o, a1));

		OWLAnnotation Upload_Date = f.getOWLAnnotation(f.getRDFSSeeAlso(),
				f.getOWLTypedLiteral(upload_date, OWL2Datatype.XSD_DATE_TIME));
		OWLAxiom a2 = f.getOWLAnnotationAssertionAxiom(Document.getIRI(), Upload_Date);
		m.applyChange(new AddAxiom(o, a2));

		OWLAnnotation Description = f.getOWLAnnotation(f.getRDFSSeeAlso(), f.getOWLTypedLiteral(description));
		OWLAxiom a3 = f.getOWLAnnotationAssertionAxiom(Document.getIRI(), Description);
		m.applyChange(new AddAxiom(o, a3));

		OWLObjectProperty isUploaded = f.getOWLObjectProperty(IRI.create(ir + "#isUploadedbythisUser"));
		OWLObjectPropertyAssertionAxiom assertion1 = f.getOWLObjectPropertyAssertionAxiom(isUploaded, p1, m1);
		AddAxiom addAxiomChange1 = new AddAxiom(o, assertion1);
		m.applyChange(addAxiomChange1);

		// User-> Contributesto (Activity)
		OWLIndividual m11 = f.getOWLNamedIndividual(uploader, pm);
		OWLIndividual p11 = f.getOWLNamedIndividual(purpose, pm);
		OWLObjectProperty Contributesto = f.getOWLObjectProperty(IRI.create(ir + "#ContributestothisPurpose"));
		OWLObjectPropertyAssertionAxiom assertion11 = f.getOWLObjectPropertyAssertionAxiom(Contributesto, m11, p11);
		AddAxiom addAxiomChange11 = new AddAxiom(o, assertion11);
		m.applyChange(addAxiomChange11);

		// Component-> usedin (Activity)
		OWLIndividual m12 = f.getOWLNamedIndividual(visibility, pm);
		OWLIndividual p12 = f.getOWLNamedIndividual(purpose, pm);
		OWLObjectProperty usedin = f.getOWLObjectProperty(IRI.create(ir + "#visibleTo"));
		OWLObjectPropertyAssertionAxiom assertion12 = f.getOWLObjectPropertyAssertionAxiom(usedin, Visibility, p12);
		AddAxiom addAxiomChange12 = new AddAxiom(o, assertion12);
		m.applyChange(addAxiomChange12);

		// Data producing system-> alsousedin (Activity)
		/*
		 * OWLIndividual m13 = f.getOWLNamedIndividual(str14, pm); OWLIndividual
		 * p13 = f.getOWLNamedIndividual(str11, pm); OWLObjectProperty
		 * alsousedin = f.getOWLObjectProperty(IRI.create(ir +
		 * "#usedinthisActivity")); OWLObjectPropertyAssertionAxiom assertion13
		 * =f.getOWLObjectPropertyAssertionAxiom(alsousedin, m13, p13); AddAxiom
		 * addAxiomChange13 = new AddAxiom(o, assertion13);
		 * m.applyChange(addAxiomChange13);
		 */

		// Installation-> relevantto (Activity)
		/*
		 * OWLIndividual m14 = f.getOWLNamedIndividual(str12, pm); OWLIndividual
		 * p14 = f.getOWLNamedIndividual(str11, pm); OWLObjectProperty
		 * relevantto = f.getOWLObjectProperty(IRI.create(ir +
		 * "#relevanttothisActivity")); OWLObjectPropertyAssertionAxiom
		 * assertion14 =f.getOWLObjectPropertyAssertionAxiom(relevantto, m14,
		 * p14); AddAxiom addAxiomChange14 = new AddAxiom(o, assertion14);
		 * m.applyChange(addAxiomChange14);
		 */

		// Document -> belongsto (Activity)
		OWLIndividual m15 = f.getOWLNamedIndividual(attachment, pm);
		OWLIndividual p15 = f.getOWLNamedIndividual(purpose, pm);
		OWLObjectProperty belongsto = f.getOWLObjectProperty(IRI.create(ir + "#belongstothisPurpose"));
		OWLObjectPropertyAssertionAxiom assertion15 = f.getOWLObjectPropertyAssertionAxiom(belongsto, m15, p15);
		AddAxiom addAxiomChange15 = new AddAxiom(o, assertion15);
		m.applyChange(addAxiomChange15);

		// Sensor-> againusedin (Installation)
		/*
		 * OWLIndividual m16 = f.getOWLNamedIndividual(str13, pm); OWLIndividual
		 * p16 = f.getOWLNamedIndividual(str12, pm); OWLObjectProperty
		 * againusedin = f.getOWLObjectProperty(IRI.create(ir +
		 * "#usedinthisInstallation")); OWLObjectPropertyAssertionAxiom
		 * assertion16 =f.getOWLObjectPropertyAssertionAxiom(againusedin, m16,
		 * p16); AddAxiom addAxiomChange16 = new AddAxiom(o, assertion16);
		 * m.applyChange(addAxiomChange16);
		 */

		// Activity-> ispartof (Simutool Thing)
		/*
		 * OWLObjectProperty rist = f.getOWLObjectProperty(IRI.create(ir +
		 * "#ispartof")); OWLClass sim = f.getOWLClass(IRI.create(ir +
		 * "#SimulToolThing")); OWLClassExpression ispartof =
		 * f.getOWLObjectSomeValuesFrom(rist,sim); OWLClass thing =
		 * f.getOWLClass(IRI.create(pm + "#Thing")); OWLSubClassOfAxiom axt =
		 * f.getOWLSubClassOfAxiom(thing, ispartof); AddAxiom addAxt = new
		 * AddAxiom(o, axt); m.applyChange(addAxt);
		 */

		File fileformated = new File("Simutool_km.owl");

		/*
		 * try { m.saveOntology(o, new SystemOutDocumentTarget()); } catch
		 * (OWLOntologyStorageException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); }
		 */
		/*
		 * for (OWLClass cls : o.getClassesInSignature()) {
		 * System.out.println(cls.getIRI()); }
		 */

		// }

	}

}
