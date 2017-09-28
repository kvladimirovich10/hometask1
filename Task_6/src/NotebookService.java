import java.io.BufferedReader;import java.io.IOException;import java.util.List;public class NotebookService {    static void addNote(List<Note> notes,                        String title,                        String text,                        BufferedReader reader) throws IOException {        Note note = new Note(title, text);        notes.add(note);        System.out.println();        System.out.format("%nWould you like to add a contact? Type 1 if want or 0 if you don't%n");        int choice = Integer.parseInt(reader.readLine());        if (choice == 1) {            System.out.print("name: ");            String name = reader.readLine();            System.out.print("last name: ");            String lastName = reader.readLine();            System.out.print("phone: ");            String phoneNumber = reader.readLine();            System.out.print("email: ");            String email = reader.readLine();            NoteService.addContact(note, name, lastName, phoneNumber, email);        }        System.out.println("note '" + title + "' is added");        return;    }    static void deleteNote(List<Note> notes,                           int index) throws IOException {        String title = notes.get(index).title;        notes.remove(index);        System.out.println("note '" + title + "' is deleted");        return;    }    static int printAllNotes(List<Note> notes, BufferedReader reader) throws IOException {        int i = 1;        if (notes.size() == 0) {            System.out.println("No notes are added yet");            return 0;        } else {            for (Note note : notes) {                System.out.println(i++ + " '" + note.title + "' " + note.creationDate);            }        }        return 1;    }    static void chooseNote(List<Note> notes, BufferedReader reader) throws IOException {        System.out.format("%nType the note number to look through the note or 0 to back to the menu%n");        int n = Integer.parseInt(reader.readLine());        while (n < 1 || n >= notes.size()) {            if (n == 0)                return;            System.out.println("Can't find this note, try again");            n = Integer.parseInt(reader.readLine());        }        printNote(notes, n - 1);    }    private static void printNote(List<Note> notes, int index) throws IOException {        System.out.println("'" + notes.get(index).title + "'      Dated: " + notes.get(index).creationDate);        System.out.println("¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨");        System.out.println(notes.get(index).text);        if (notes.get(index).noteContacts.size() != 0) {            System.out.format("¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨%nContacts:%n");            for (Contact contact : notes.get(index).noteContacts) {                System.out.println("name: " + contact.name);                System.out.println("last name: " + contact.lastname);                System.out.println("phone: " + contact.phoneNumber);                System.out.println("email: " + contact.email);            }        }        System.out.println("¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨");        return;    }}