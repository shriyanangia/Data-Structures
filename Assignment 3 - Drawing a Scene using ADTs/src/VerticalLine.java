import bridges.base.Color;
import bridges.base.ColorGrid;

public class VerticalLine extends Mark
{
    private int startPointOnY;
    private int endPointOnY;
    private int xCoordinate;

    public VerticalLine(int start, int end, int x, Color c)
    {
        this.startPointOnY = start;
        this.endPointOnY = end;
        this.xCoordinate = x;
        this.color = c;
    }

    @Override
    public void draw(ColorGrid cg)
    {
        for (int i=xCoordinate; i<=xCoordinate;i++)
        {
            for (int j=startPointOnY; j<=endPointOnY;j++)
            {
                cg.set(j, i, color);
            }
        }

    }
}
