package br.com.vs.command;

import java.util.ArrayList;
import java.util.List;

public class ActiveObjectEngine {
    List<Command> itsCommands = new ArrayList<>();

    public void add(Command command) {
        itsCommands.add(command);
    }

    public void run() {
        while (itsCommands.stream().count() > 0) {
            Command command = itsCommands.get(0);
            itsCommands.remove(0);
            command.execute();
        }
    }
}
