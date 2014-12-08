
package bigws.servidor;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the bigws.servidor package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _AddNoteResponse_QNAME = new QName("http://Servidor.bigws/", "addNoteResponse");
    private final static QName _DeleteNote_QNAME = new QName("http://Servidor.bigws/", "deleteNote");
    private final static QName _ShowAllResponse_QNAME = new QName("http://Servidor.bigws/", "showAllResponse");
    private final static QName _ListaNotas_QNAME = new QName("http://Servidor.bigws/", "listaNotas");
    private final static QName _ListaNotasFilterResponse_QNAME = new QName("http://Servidor.bigws/", "listaNotasFilterResponse");
    private final static QName _DeleteNoteResponse_QNAME = new QName("http://Servidor.bigws/", "deleteNoteResponse");
    private final static QName _ListaNotasFilter_QNAME = new QName("http://Servidor.bigws/", "listaNotasFilter");
    private final static QName _ListaNotasResponse_QNAME = new QName("http://Servidor.bigws/", "listaNotasResponse");
    private final static QName _ShowAll_QNAME = new QName("http://Servidor.bigws/", "showAll");
    private final static QName _AddNote_QNAME = new QName("http://Servidor.bigws/", "addNote");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: bigws.servidor
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ListaNotasFilterResponse }
     * 
     */
    public ListaNotasFilterResponse createListaNotasFilterResponse() {
        return new ListaNotasFilterResponse();
    }

    /**
     * Create an instance of {@link ShowAllResponse }
     * 
     */
    public ShowAllResponse createShowAllResponse() {
        return new ShowAllResponse();
    }

    /**
     * Create an instance of {@link DeleteNote }
     * 
     */
    public DeleteNote createDeleteNote() {
        return new DeleteNote();
    }

    /**
     * Create an instance of {@link AddNoteResponse }
     * 
     */
    public AddNoteResponse createAddNoteResponse() {
        return new AddNoteResponse();
    }

    /**
     * Create an instance of {@link ListaNotas }
     * 
     */
    public ListaNotas createListaNotas() {
        return new ListaNotas();
    }

    /**
     * Create an instance of {@link ListaNotasFilter }
     * 
     */
    public ListaNotasFilter createListaNotasFilter() {
        return new ListaNotasFilter();
    }

    /**
     * Create an instance of {@link DeleteNoteResponse }
     * 
     */
    public DeleteNoteResponse createDeleteNoteResponse() {
        return new DeleteNoteResponse();
    }

    /**
     * Create an instance of {@link ShowAll }
     * 
     */
    public ShowAll createShowAll() {
        return new ShowAll();
    }

    /**
     * Create an instance of {@link ListaNotasResponse }
     * 
     */
    public ListaNotasResponse createListaNotasResponse() {
        return new ListaNotasResponse();
    }

    /**
     * Create an instance of {@link AddNote }
     * 
     */
    public AddNote createAddNote() {
        return new AddNote();
    }

    /**
     * Create an instance of {@link NoteBook }
     * 
     */
    public NoteBook createNoteBook() {
        return new NoteBook();
    }

    /**
     * Create an instance of {@link Note }
     * 
     */
    public Note createNote() {
        return new Note();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddNoteResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Servidor.bigws/", name = "addNoteResponse")
    public JAXBElement<AddNoteResponse> createAddNoteResponse(AddNoteResponse value) {
        return new JAXBElement<AddNoteResponse>(_AddNoteResponse_QNAME, AddNoteResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteNote }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Servidor.bigws/", name = "deleteNote")
    public JAXBElement<DeleteNote> createDeleteNote(DeleteNote value) {
        return new JAXBElement<DeleteNote>(_DeleteNote_QNAME, DeleteNote.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ShowAllResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Servidor.bigws/", name = "showAllResponse")
    public JAXBElement<ShowAllResponse> createShowAllResponse(ShowAllResponse value) {
        return new JAXBElement<ShowAllResponse>(_ShowAllResponse_QNAME, ShowAllResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListaNotas }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Servidor.bigws/", name = "listaNotas")
    public JAXBElement<ListaNotas> createListaNotas(ListaNotas value) {
        return new JAXBElement<ListaNotas>(_ListaNotas_QNAME, ListaNotas.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListaNotasFilterResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Servidor.bigws/", name = "listaNotasFilterResponse")
    public JAXBElement<ListaNotasFilterResponse> createListaNotasFilterResponse(ListaNotasFilterResponse value) {
        return new JAXBElement<ListaNotasFilterResponse>(_ListaNotasFilterResponse_QNAME, ListaNotasFilterResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteNoteResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Servidor.bigws/", name = "deleteNoteResponse")
    public JAXBElement<DeleteNoteResponse> createDeleteNoteResponse(DeleteNoteResponse value) {
        return new JAXBElement<DeleteNoteResponse>(_DeleteNoteResponse_QNAME, DeleteNoteResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListaNotasFilter }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Servidor.bigws/", name = "listaNotasFilter")
    public JAXBElement<ListaNotasFilter> createListaNotasFilter(ListaNotasFilter value) {
        return new JAXBElement<ListaNotasFilter>(_ListaNotasFilter_QNAME, ListaNotasFilter.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListaNotasResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Servidor.bigws/", name = "listaNotasResponse")
    public JAXBElement<ListaNotasResponse> createListaNotasResponse(ListaNotasResponse value) {
        return new JAXBElement<ListaNotasResponse>(_ListaNotasResponse_QNAME, ListaNotasResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ShowAll }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Servidor.bigws/", name = "showAll")
    public JAXBElement<ShowAll> createShowAll(ShowAll value) {
        return new JAXBElement<ShowAll>(_ShowAll_QNAME, ShowAll.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddNote }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Servidor.bigws/", name = "addNote")
    public JAXBElement<AddNote> createAddNote(AddNote value) {
        return new JAXBElement<AddNote>(_AddNote_QNAME, AddNote.class, null, value);
    }

}
