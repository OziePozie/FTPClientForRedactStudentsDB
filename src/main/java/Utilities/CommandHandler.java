package Utilities;

import Commands.*;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class CommandHandler {
    private boolean isRunning = true;
    private static final Scanner SCANNER = new Scanner(System.in);

    public CommandHandler() {
    }

    public void commandExecuter() throws IOException {
        message();
        while (isRunning) {
                switch (SCANNER.next()) {
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

        }
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

}
