import Commands.*;
import Utilities.ParseJSON;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class CommandHandler {
    private boolean isRunning = true;
    private static final Scanner SCANNER = new Scanner(System.in);

    public CommandHandler() {
    }
    public void message(){
        String str = "Input ID of command: \n" +
                " 1. Get list of students order by name" +
                " 2. Get INFO about student by ID" +
                " 3. Add student to DB" +
                " 4. Delete student by ID from DB" +
                " 5. Exit.";

        System.out.println(str);
    }
    public org.testng.Assert.ThrowingRunnable commandExecuterForTests(String id) throws IOException {
        message();
            try {
                switch (id) {
                    case "1" : {
                        new GetListByNameCommand().execute(new ParseJSON().getStudentList());
                        message();
                        break;
                    }
                    case "2": {
                        System.out.println("Input ID: ");
                        new GetStudentNameByIdCommand().execute(SCANNER.nextInt(), new ParseJSON().getStudentList());
                        break;
                    }
                    case "3": {
                        System.out.println("Input name of student what u want add: ");
                        new AddCommand().execute(SCANNER.next(), new ParseJSON().getStudentList());
                        break;
                    }
                    case "4" : {
                        System.out.println("Input ID of student what u want remove: ");
                        new RemoveCommand().execute(SCANNER.nextInt(), new ParseJSON().getStudentList());
                        break;
                    }
                    case "5" : {
                        new ExitCommand().execute();
                        isRunning = false;
                        SCANNER.close();
                        System.exit(0);
                    }
                    default: {
                        throw new InputMismatchException();
                    }
                }
            } catch (InputMismatchException e){
                System.out.println("Incorrect input, u can choose CommandID from 1 to 5.");
                throw new InputMismatchException();
            }
        return null;
    }
}
