import java.io.BufferedReader;import java.io.IOException;import java.util.List;class NotebookService {    private static String readLine;    static void addNote(List<Note> notes,                        String title,                        String text,                        BufferedReader reader) throws IOException {        Note note = new Note(title, text);        notes.add(note);        System.out.format("%n* would you like to add a contact? 1 YES | 0 NO%n");        int choice = enterInt(reader, readLine);        if (choice == 1) {            System.out.print("name: ");            String name = reader.readLine();            System.out.print("last name: ");            String lastName = reader.readLine();            System.out.print("phone: ");            String phoneNumber = reader.readLine();            System.out.print("email: ");            String email = reader.readLine();            NoteService.addContact(note, name, lastName, phoneNumber, email);            System.out.println();        }        System.out.format("%n* note '" + title + "' is added%n");    }    static void deleteNote(List<Note> notes, int index) throws IOException {        String title = notes.get(index).getTitle();        notes.remove(index);        System.out.format("%n* note '" + title + "' is deleted%n");    }    static int printAllNotes(List<Note> notes) throws IOException {        int i = 1;        if (notes.size() == 0) {            System.out.format("%n* no notes are added yet%n");            return 0;        } else {            for (Note note : notes) {                System.out.println(i++ + " '" + note.getTitle() + "' " + note.getCreationDate());            }        }        return 1;    }    static void chooseNote(List<Note> notes, BufferedReader reader) throws IOException {        System.out.format("%n* type the note number to look through the note | 0 - back to the menu%n");        int n = enterInt(reader, readLine);        if (n == 0)            return;        while (n < 0 || n > notes.size()) {            System.out.format("%n* can't find this note, try again!%n");            n = Integer.parseInt(reader.readLine());        }        printNote(notes, n - 1);    }    private static void printNote(List<Note> notes, int index) throws IOException {        System.out.println("'" + notes.get(index).getTitle() + "'      Dated: " + notes.get(index).getCreationDate());        System.out.println("¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨");        System.out.println(notes.get(index).getText());        if (notes.get(index).getNoteContacts().size() != 0) {            System.out.format("¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨%nContact:%n");            for (Contact contact : notes.get(index).getNoteContacts()) {                System.out.println("name: " + contact.getName());                System.out.println("last name: " + contact.getLastName());                System.out.println("phone: " + contact.getPhoneNumber());                System.out.println("email: " + contact.getEmail());            }        }        System.out.format("¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨%n");    }    static int enterInt(BufferedReader reader, String readLine) throws IOException {        readLine = reader.readLine();        while (!isInteger(readLine)) {            System.out.println("Enter a valid number!");            readLine = reader.readLine();        }        return Integer.parseInt(readLine);    }    private static boolean isInteger(String s) {        try {            Integer.parseInt(s);        } catch (NumberFormatException e) {            return false;        } catch (NullPointerException e) {            return false;        }        return true;    }}