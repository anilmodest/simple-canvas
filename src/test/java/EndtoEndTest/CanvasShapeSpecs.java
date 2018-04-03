package EndtoEndTest;

import Canvas.CommandManager;
import Canvas.CommandParser;
import Canvas.Commands.CommandWrapper;
import Canvas.Renderer.Console;
import Canvas.Renderer.TextRenderer;
import com.greghaskins.spectrum.Spectrum;
import org.junit.Assert;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;

import java.util.Optional;

import static com.greghaskins.spectrum.Spectrum.describe;
import static com.greghaskins.spectrum.dsl.specification.Specification.it;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(Spectrum.class)
public class CanvasShapeSpecs {
    {

        describe("Validate Problem spec", () -> {

            Console mockConsole = mock(Console.class);
            CommandParser commandParser = new CommandParser();
            CommandManager commandManager = new CommandManager(new TextRenderer(mockConsole));

            it("Draw canvas 20x4", () -> {


                Optional<CommandWrapper> optionalICommand = commandParser.parseCommand("C 20 4");
                CommandWrapper command = optionalICommand.get();

                ArgumentCaptor<String> argsCaptor = ArgumentCaptor.forClass(String.class);
                commandManager.execute(command);
                verify(mockConsole).print(argsCaptor.capture());
                Assert.assertEquals("----------------------\n" +
                                             "|                    |\n" +
                                             "|                    |\n" +
                                             "|                    |\n" +
                                             "|                    |\n" +
                                             "----------------------", argsCaptor.getValue());
            });

            it("Draw Horizontal LineShape", () -> {


                Optional<CommandWrapper> optionalICommand = commandParser.parseCommand("L 1 2 6 2");
                CommandWrapper command = optionalICommand.get();

                ArgumentCaptor<String> argsCaptor = ArgumentCaptor.forClass(String.class);
                commandManager.execute(command);
                verify(mockConsole, times(2)).print(argsCaptor.capture());
                Assert.assertEquals("----------------------\n" +
                                             "|                    |\n" +
                                             "|xxxxxx              |\n" +
                                             "|                    |\n" +
                                             "|                    |\n" +
                                             "----------------------", argsCaptor.getValue());
            });

            it("Draw Vertical LineShape", () -> {


                Optional<CommandWrapper> optionalICommand = commandParser.parseCommand("L 6 3 6 4");
                CommandWrapper command = optionalICommand.get();

                ArgumentCaptor<String> argsCaptor = ArgumentCaptor.forClass(String.class);
                commandManager.execute(command);
                verify(mockConsole, times(3)).print(argsCaptor.capture());
                Assert.assertEquals("----------------------\n" +
                                             "|                    |\n" +
                                             "|xxxxxx              |\n" +
                                             "|     x              |\n" +
                                             "|     x              |\n" +
                                             "----------------------", argsCaptor.getValue());
            });

            it("Draw RectangleShape", () -> {


                Optional<CommandWrapper> optionalICommand = commandParser.parseCommand("R 14 1 18 3");
                CommandWrapper command = optionalICommand.get();

                ArgumentCaptor<String> argsCaptor = ArgumentCaptor.forClass(String.class);
                commandManager.execute(command);
                verify(mockConsole, times(4)).print(argsCaptor.capture());
                Assert.assertEquals("----------------------\n" +
                                             "|             xxxxx  |\n" +
                                             "|xxxxxx       x   x  |\n" +
                                             "|     x       xxxxx  |\n" +
                                             "|     x              |\n" +
                                             "----------------------", argsCaptor.getValue());
            });

            it("Execute Bucket Fill", () -> {


                Optional<CommandWrapper> optionalICommand = commandParser.parseCommand("B 10 3 o");
                CommandWrapper command = optionalICommand.get();

                ArgumentCaptor<String> argsCaptor = ArgumentCaptor.forClass(String.class);
                commandManager.execute(command);
                verify(mockConsole, times(5)).print(argsCaptor.capture());
                Assert.assertEquals("----------------------\n" +
                                             "|oooooooooooooxxxxxoo|\n" +
                                             "|xxxxxxooooooox   xoo|\n" +
                                             "|     xoooooooxxxxxoo|\n" +
                                             "|     xoooooooooooooo|\n" +
                                             "----------------------", argsCaptor.getValue());
            });


        });
    }
}
