import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Line2D;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.prefs.BackingStoreException;

public class Mouse {
    private final int mouseHeight=150;
    private final int mouseWidth=80;

    public int getMouseX() {
        return mouseX;
    }

    public void setMouseX(int mouseX) {
        this.mouseX = mouseX;
    }

    public int getMouseY() {
        return mouseY;
    }

    public void setMouseY(int mouseY) {
        this.mouseY = mouseY;
    }

    int mouseX,mouseY;

    Mouse(int mouseX, int mouseY)
    {
        this.mouseX=mouseX;
        this.mouseY=mouseY;
    }

    public void drawMouse(Graphics g)
    {
        Graphics2D g2d = (Graphics2D) g;
        g.setColor(Color.black);
        g2d.rotate(Math.toRadians(-20), mouseY + mouseWidth/ 2, mouseY + mouseHeight / 2);
        g.fillOval(this.mouseX,this.mouseY,this.mouseWidth,this.mouseHeight);
    }
}
