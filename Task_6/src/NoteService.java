public class NoteService {    void addContact(Note note,                    String name,                    String lastname,                    String phoneNumber,                    String email) {        Contact contact = new Contact(name, lastname, phoneNumber, email);        note.noteContacts.add(contact);    }}