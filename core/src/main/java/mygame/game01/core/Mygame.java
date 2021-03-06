package mygame.game01.core;

import static playn.core.PlayN.*;

import mygame.game01.core.screen.HomeScreen;
import playn.core.*;
import playn.core.util.Clock;
import tripleplay.game.Screen;
import tripleplay.game.ScreenStack;

public class Mygame extends Game.Default {

    private ScreenStack ss = new ScreenStack();
    private Clock.Source clock = new Clock.Source(33);

    public Mygame() {
        super(150); // call update every 33ms (30 times per second)
    }

    @Override
    public void init() {
        final Screen home = new HomeScreen(ss);
        ss.push(home);
        PlayN.keyboard().setListener(new Keyboard.Listener() {
            @Override
            public void onKeyDown(Keyboard.Event event) {

            }

            @Override
            public void onKeyTyped(Keyboard.TypedEvent event) {

            }

            @Override
            public void onKeyUp(Keyboard.Event event) {
                if(event.key()==Key.ESCAPE){
                    ss.popTo(home);
                }
            }
        });

    }

    @Override
    public void update(int delta) {
        ss.update(delta);
    }

    @Override
    public void paint(float alpha) {
        clock.paint(alpha);
        ss.paint(clock);
    }
}
