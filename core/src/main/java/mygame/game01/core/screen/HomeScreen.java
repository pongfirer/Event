package mygame.game01.core.screen;

import playn.core.Font;
import static playn.core.PlayN.*;

import react.UnitSlot;
import tripleplay.game.ScreenStack;
import tripleplay.game.UIScreen;
import tripleplay.ui.*;
import tripleplay.ui.layout.AxisLayout;

public class HomeScreen extends UIScreen {

    private ScreenStack ss;
    private Root root;

    public static final Font TITLE_FONT =
            graphics().createFont(
                    "Helvetica",
                    Font.Style.PLAIN,
                    24);

    public HomeScreen(ScreenStack ss){
        this.ss = ss;
    }
    @Override
    public void wasShown() {
        super.wasShown();
        root = iface.createRoot(
                AxisLayout.vertical().gap(15),
                SimpleStyles.newSheet(), layer);
        root.addStyles(Style.BACKGROUND
                .is(Background.bordered(0xFFCCCCCC, 0xFF99CCFF, 5)
                        .inset(5, 10)));
        root.setSize(width(),height());
        root.add(new Label("Event Driven Programming")
                .addStyles(Style.FONT.is(HomeScreen.TITLE_FONT)));
        root.add(new Button("START").onClick((new UnitSlot() {
            public void onEmit() {
                ss.push(new TestScreen(ss));
            }
        })));

    }
}
