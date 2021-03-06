package seedu.saveit.logic.commands.report;

import seedu.saveit.logic.commands.ReportCommand;
import seedu.saveit.logic.commands.ReportCommandResult;
import seedu.saveit.model.Model;

/**
 * Help command for report window.
 */
public class ReportWindowHelpCommand extends ReportCommand {

    public static final String SHOWING_HELP_MESSAGE = "view startDate endDate graphtype organise - shows the report\n"
            + "print - prints the current graph\n"
            + "export fileName - exports the current graph\n"
            + "exit - Exits the report window.";

    @Override
    public ReportCommandResult execute(Model model) {
        return new ReportCommandResult(SHOWING_HELP_MESSAGE, true);
    }
}
