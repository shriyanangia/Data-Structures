import bridges.base.Color;
import bridges.base.ColorGrid;

public class Point extends Mark
{
    private int xCoordinate;
    private int yCoordinate;

    public Point(int x, int y, Color c)
    {
       this.xCoordinate = x;
        this.yCoordinate = y;
        this.color = c;
    }
    @Override
    public void draw(ColorGrid cg)
    {
        cg.set(yCoordinate,xCoordinate,color);
    }
}
