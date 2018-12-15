package providers;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileProvider {

    public BufferedImage getSpacecraftImg() throws IOException {
        return ImageIO.read(new FileInputStream("VausSpacecraftLarge.png"));
    }

    public BufferedImage getEnergyBallImg() throws IOException {
        return ImageIO.read(new FileInputStream("EnergyBall.png"));
    }

    public BufferedImage getBorderImg() throws IOException {
        return ImageIO.read(new FileInputStream("wall.png"));
    }

    public BufferedImage getBrickImg() throws IOException {
        return ImageIO.read(new FileInputStream("BlueWall.png"));
    }

    public BufferedImage getBrickGoldImg() throws IOException {
        return ImageIO.read(new FileInputStream("GoldWall.png"));
    }
}
