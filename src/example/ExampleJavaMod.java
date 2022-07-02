package example;

import arc.*;
import arc.util.*;
import mindustry.*;
import mindustry.content.*;
import mindustry.game.EventType.*;
import mindustry.gen.*;
import mindustry.mod.*;
import mindustry.ui.dialogs.*;

import org.luaj.vm2.*;
import org.luaj.vm2.lib.jse.*;

public class ExampleJavaMod extends Mod{

    public ExampleJavaMod(){
        Log.info("Loaded lualoader.");

        //listen for game load event
        Events.on(ClientLoadEvent.class, e -> {
            Globals globals = JsePlatform.standardGlobals();
            LuaValue chunk = globals.loadfile("hello.lua");
            chunk.call();
            //show dialog upon startup
            //Time.runTask(10f, () -> {
                //BaseDialog dialog = new BaseDialog("frog");
                //dialog.cont.add("behold").row();
                //mod sprites are prefixed with the mod name (this mod is called 'example-java-mod' in its config)
                //dialog.cont.image(Core.atlas.find("example-java-mod-frog")).pad(20f).row();
                //dialog.cont.button("I see", dialog::hide).size(100f, 50f);
                //dialog.show();
            //});
        });
    }

    @Override
    public void loadContent(){
        Log.info("Loading some example content.");
    }

}
