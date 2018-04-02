package EndtoEndTest;

import Canvas.CommandManager;
import Canvas.CommandParser;
import Canvas.Commands.ICommand;
import Canvas.Renderer.IConsole;
import Canvas.Renderer.Renderer;
import Canvas.Shapes.IShape;
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
public class CanvasSpecs {
    {

        describe("Validate Problem spec", () -> {

            IConsole mockConsole = mock(IConsole.class);
            CommandParser commandParser = new CommandParser();
            CommandManager commandManager = new CommandManager(new Renderer(mockConsole));

            it("Draw canvas 20x4", () -> {


                Optional<ICommand> optionalICommand = commandParser.parseCommand("C 20 4");
                ICommand command = optionalICommand.get();

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

            it("Draw Horizontal Line", () -> {


                Optional<ICommand> optionalICommand = commandParser.parseCommand("L 1 2 6 2");
                ICommand command = optionalICommand.get();

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

            it("Draw Vertical Line", () -> {


                Optional<ICommand> optionalICommand = commandParser.parseCommand("L 6 3 6 4");
                ICommand command = optionalICommand.get();

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

            it("Draw Rectangle", () -> {


                Optional<ICommand> optionalICommand = commandParser.parseCommand("R 14 1 18 3");
                ICommand command = optionalICommand.get();

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


                Optional<ICommand> optionalICommand = commandParser.parseCommand("B 10 3 o");
                ICommand command = optionalICommand.get();

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
