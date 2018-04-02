package Canvas.Commands;

import java.util.regex.Pattern;

public class SupportedCommands {

    public final static Pattern LINE_COMMAND = Pattern.compile("^[L|l]\\s(?<X1>\\d+)\\s(?<Y1>\\d+)\\s(?<X2>\\d+)\\s(?<Y2>\\d+)$");
    public final static Pattern RECTANGLE_COMMAND = Pattern.compile("^[R|r]\\s(?<X1>\\d+)\\s(?<Y1>\\d+)\\s(?<X2>\\d+)\\s(?<Y2>\\d+)$");
    public final static Pattern BUCKET_FILL_COMMAND = Pattern.compile("^[B|b]\\s(?<X1>\\d+)\\s(?<Y1>\\d+)\\s(?<C>.)$");
    public final static Pattern CANVAS_COMMAND = Pattern.compile("^[C|c]\\s(?<Length>\\d+)\\s(?<Height>\\d+)$");
    public final static Pattern HELP_COMMAND = Pattern.compile("^[h|H]");
    public final static Pattern QUIT_COMMAND = Pattern.compile("^[q|Q]");
    public final static Pattern UNDO_COMMAND = Pattern.compile("^[u|U]");
    public final static Pattern REDO_COMMAND = Pattern.compile("^[r|R]");
}
