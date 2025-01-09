import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Ship {

    public final  int ship_width = 20;
    public final  int ship_height = 10;

    public static int shipLeft_x;
    public static int shipTop_y;

    public static int life = 3;
    public static int score = 0;

    private String shipName;

    private Rectangle ship;

    public Ship(String name) {
        this.shipName = name;

        ship = new Rectangle(shipLeft_x, shipTop_y, ship_width, ship_height);
    }

    public void draw(Graphics g) {
        g.setColor(Color.RED);
        g.fillRect(shipLeft_x, shipTop_y, ship_width, ship_height);
        g.setColor(Color.WHITE);
        g.drawString(shipName, shipLeft_x, shipTop_y + ship_height);
        ship = new Rectangle(shipLeft_x, shipTop_y, ship_width, ship_height);

    }

    public Rectangle getRectangle() {
        return ship;
    }

}
