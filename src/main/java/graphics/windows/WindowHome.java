package graphics.windows;

import game.controller.GameController;
import game.controller.HomeController;
import graphics.gui.GuiGameManager;
import graphics.gui.GuiHomeManager;
import javafx.util.Pair;
import org.lwjgl.Sys;
import org.newdawn.slick.*;
import org.newdawn.slick.state.StateBasedGame;

import java.util.Observable;

public class WindowHome extends Window {

    private GameContainer container;
    private Image background;

    public WindowHome() {
        super(0);
        System.out.println("create windowHome");

        this.controller = new HomeController();
        this.guiManager = new GuiHomeManager();
    }
    @Override
    public void enter(GameContainer container, StateBasedGame game) throws SlickException {
    }

    @Override
    public void init(GameContainer gameContainer, StateBasedGame stateBasedGame) throws SlickException {
        super.init(gameContainer, stateBasedGame);
        this.container = gameContainer;
        this.background = new Image("background/home.jpg");
    }

    @Override
    public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics graphics) throws SlickException {
        background.draw(0, 0, gameContainer.getWidth(), gameContainer.getHeight());
        super.render(gameContainer, stateBasedGame, graphics);
    }

    public void update(Observable o, Object arg) {
        if (arg instanceof Pair) {
            Pair<String, Integer> task = (Pair<String, Integer>) arg;

            System.out.println("its a pair");
            if (task.getKey().equals("redirect")) {
                System.out.println("change screen");
                this.stateBasedGame.enterState(task.getValue());
            }
        }
    }

    @Override
    public void keyReleased(int key, char c) {
        if (Input.KEY_ESCAPE == key) {
            this.container.exit();
        }
    }
}