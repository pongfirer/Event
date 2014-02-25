package mygame.game01.core.screen;

import react.UnitSlot;
import tripleplay.game.ScreenStack;
import tripleplay.game.UIScreen;
import tripleplay.ui.*;
import tripleplay.ui.layout.AxisLayout;

/**
 * Created by THuNDeRs on 2/12/14.
 */
public class ThirdScreen extends UIScreen {

    private ScreenStack ss;

    public ThirdScreen(ScreenStack ss){
        this.ss = ss;
    }
    private Root root;

    @Override
    public void wasShown() {
        super.wasShown();

        root = iface.createRoot(AxisLayout.vertical().gap(15), SimpleStyles.newSheet(),layer);
        root.setSize(width(),height());
        root.add(new Button("Back").onClick(new UnitSlot() {
            @Override
            public void onEmit() {
                ss.remove(ThirdScreen.this);
            }
        }));
    }
}
