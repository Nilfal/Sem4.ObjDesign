package startUp;

import controller.Controller;
import intergration.SystemCreator;
import intergration.Printer;
import intergration.CatCreator;

import view.View;

import java.io.IOException;

/**
 * Startar up applikationen.
 */

public class Main {

    /**
     * Startar applikationen
     *
     */
    public static void main(String[] args) throws IOException {

    SystemCreator systemCreator =new SystemCreator();
    CatCreator catCreator = new CatCreator();
    Printer printer = new Printer();
    Controller controller = new Controller(systemCreator,catCreator,printer);
    View view = new View(controller);
    view.exampel();




    }


}
