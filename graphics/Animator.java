package graphics;

import java.awt.image.BufferedImage;

public class Animator {

    private BufferedImage[] frames;
    private int currentFrame;
    private int frameDelay;
    private int tick;

    public Animator(BufferedImage[] frames, int frameDelay) {
        this.frames = frames;
        this.frameDelay = frameDelay;
        this.currentFrame = 0;
        this.tick = 0;
    }

    public void update() {
        if (frames == null || frames.length <= 1) return;
        tick++;
        if (tick >= frameDelay) {
            tick = 0;
            currentFrame = (currentFrame + 1) % frames.length;
        }
    }

    public BufferedImage getCurrentFrame() {
        if (frames == null || frames.length == 0) return null;
        return frames[currentFrame];
    }

    public void reset() {
        currentFrame = 0;
        tick = 0;
    }

    public void setFrames(BufferedImage[] frames) {
        this.frames = frames;
        reset();
    }
}
