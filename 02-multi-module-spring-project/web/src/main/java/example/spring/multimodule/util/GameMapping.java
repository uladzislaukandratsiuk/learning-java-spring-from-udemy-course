package example.spring.multimodule.util;

public final class GameMapping {

    public static final String PLAY = "play";
    public static final String REDIRECT_PLAY = "redirect:/" + PLAY;
    public static final String RESTART = "restart";
    public static final String HOME = "/";

    private GameMapping() {}
}
