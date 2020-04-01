package seedu.address.logic.commands.report;

import java.util.HashMap;

import seedu.address.logic.commands.Command;
import seedu.address.logic.commands.CommandResult;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.logic.parser.report.ReportLevelParser;
import seedu.address.model.Model;
import seedu.address.model.Report;

/**
 * Prints report.
 */
public class PrintReportCommand extends Command {

    public static final String COMMAND_WORD = "print";
    public static final String MESSAGE_SUCCESS = "Printing report.";
    public static final String MESSAGE_USAGE = ReportLevelParser.COMMAND_WORD + " " + COMMAND_WORD
            + ": Prints the report. "
            + "\n" + "Parameters: "
            + "start date : YYYY-MM-DD  "
            + "end date :  YYYY-MM-DD  "
            + "graph type: PIE/BAR" + "\n"
            + "Example: " + ReportLevelParser.COMMAND_WORD + " " + COMMAND_WORD
            + " 2020-03-22 " + "2020-03-25 " + "PIE";


    private final Report toPrint;
    private HashMap statsToPrint;
    private Report.GraphType format;

    public PrintReportCommand(Report toPrint) {
        this.toPrint = toPrint;
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        statsToPrint = new GenerateStats(toPrint, model).generateStatsByTags();
        format = toPrint.getFormat();
        return new CommandResult(MESSAGE_SUCCESS, format, statsToPrint, false, false, true);
    }
}
