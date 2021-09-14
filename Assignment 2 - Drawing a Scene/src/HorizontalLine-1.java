import bridges.base.Color;
import bridges.base.ColorGrid;

public class HorizontalLine extends Mark
{
    private int startPointOnX;
    private int endPointOnX;
    private int yCoordinate;

    public HorizontalLine(int start, int end, int y, Color c)
    {
        this.startPointOnX = start;
        this.endPointOnX = end;
        this.yCoordinate = y;
        this.color = c;
    }

    @Override
    public void draw(ColorGrid cg)
    {
        for (int i=yCoordinate; i<=yCoordinate;i++)
        {
            for (int j=startPointOnX; j<=endPointOnX;j++)
            {
                cg.set(i, j, color);
            }
        }

    }
}
